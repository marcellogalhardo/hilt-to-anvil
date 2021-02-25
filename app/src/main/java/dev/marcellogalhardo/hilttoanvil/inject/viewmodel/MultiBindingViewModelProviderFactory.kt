package dev.marcellogalhardo.hilttoanvil.inject.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.squareup.anvil.annotations.ContributesBinding
import dev.marcellogalhardo.hilttoanvil.inject.InternalInjectApi
import dev.marcellogalhardo.hilttoanvil.inject.component.ViewModelComponent
import dev.marcellogalhardo.hilttoanvil.inject.fragment.FragmentHolder
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import javax.inject.Inject
import javax.inject.Provider

typealias ViewModelMap = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

@OptIn(InternalInjectApi::class)
@ContributesBinding(Fragment::class)
@SingleIn(Fragment::class)
class MultiBindingViewModelProviderFactory @Inject constructor(
    private val viewModelComponentFactory: ViewModelComponent.Factory,
    private val fragmentHolder: FragmentHolder,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val fragment = fragmentHolder.fragment
        val viewModelFactory = SavedStateViewModelFactory(fragment, fragment.arguments) { handle ->
            val viewModelComponent = viewModelComponentFactory.create(handle)
            val viewModelMap = viewModelComponent.getViewModelMap()
            viewModelMap[modelClass]?.get()
        }
        return viewModelFactory.create(modelClass)
    }
}

private fun <VM : ViewModel> SavedStateViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
    createViewModel: (handle: SavedStateHandle) -> VM?
) = object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return createViewModel(handle) as? T
            ?: throw IllegalStateException("${modelClass.name} cannot be provided without an @Inject constructor or from an @Provides-annotated method. Check your @IntoMap and @ClassKey provider.")
    }
}

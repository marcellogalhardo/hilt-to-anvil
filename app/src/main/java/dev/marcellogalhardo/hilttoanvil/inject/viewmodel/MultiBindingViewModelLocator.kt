package dev.marcellogalhardo.hilttoanvil.inject.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.squareup.anvil.annotations.ContributesBinding
import dev.marcellogalhardo.hilttoanvil.inject.InternalInjectApi
import dev.marcellogalhardo.hilttoanvil.inject.component.ViewModelComponent
import dev.marcellogalhardo.hilttoanvil.inject.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Provider

typealias ViewModelMap = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

@OptIn(InternalInjectApi::class)
@ContributesBinding(ActivityScope::class)
class MultiBindingViewModelLocator @Inject constructor(
    private val viewModelComponentFactory: ViewModelComponent.Factory,
) : ViewModelLocator() {

    override fun onCreateViewModelProviderFactory(
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle?
    ): ViewModelProvider.Factory {
        return object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                val viewModelComponent = viewModelComponentFactory.create(handle)
                val viewModelMap = viewModelComponent.getViewModelMap()
                return viewModelMap[modelClass]?.get() as T
            }
        }
    }
}

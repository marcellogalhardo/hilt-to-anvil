package dev.marcellogalhardo.hilttoanvil.inject.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

abstract class ViewModelLocator {

    @PublishedApi
    internal fun createViewModelFactory(
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle? = null,
    ): ViewModelProvider.Factory = onCreateViewModelProviderFactory(owner, defaultArgs)

    protected abstract fun onCreateViewModelProviderFactory(
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle? = null,
    ): ViewModelProvider.Factory

    inline fun <reified T : ViewModel> getViewModel(
        fragment: Fragment,
    ): Lazy<T> {
        return fragment.viewModels {
            createViewModelFactory(fragment, fragment.arguments ?: bundleOf())
        }
    }

    inline fun <reified T : ViewModel> getViewModelForParentFragment(
        fragment: Fragment,
        defaultArgs: Bundle? = null,
    ): Lazy<T> {
        return fragment.viewModels(
            ownerProducer = { fragment.requireParentFragment() },
            factoryProducer = {
                val parentFragment = fragment.requireParentFragment()
                val args = defaultArgs ?: parentFragment.arguments ?: bundleOf()
                createViewModelFactory(parentFragment, args)
            }
        )
    }

    inline fun <reified T : ViewModel> getViewModelForActivity(
        fragment: Fragment,
        defaultArgs: Bundle? = null,
    ): Lazy<T> {
        return fragment.viewModels(
            ownerProducer = { fragment.requireActivity() },
            factoryProducer = {
                val activity = fragment.requireActivity()
                val args = defaultArgs ?: activity.intent?.extras ?: bundleOf()
                createViewModelFactory(activity, args)
            }
        )
    }

    inline fun <reified T : ViewModel> getViewModel(activity: ComponentActivity): Lazy<T> {
        return activity.viewModels {
            createViewModelFactory(activity, activity.intent?.extras ?: bundleOf())
        }
    }
}

// Useful for tests.
fun ViewModelLocator(vararg viewModels: ViewModel): ViewModelLocator {
    return object : ViewModelLocator() {

        private val viewModelMap = viewModels.associateBy { viewModel -> viewModel::class.java }

        @Suppress("UNCHECKED_CAST")
        override fun onCreateViewModelProviderFactory(
            owner: SavedStateRegistryOwner,
            defaultArgs: Bundle?
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return viewModelMap[modelClass] as T
                }

            }
        }

    }
}

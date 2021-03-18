package dev.marcellogalhardo.hilttoanvil.inject.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.squareup.anvil.annotations.ContributesBinding
import dev.marcellogalhardo.hilttoanvil.inject.InternalInjectApi
import dev.marcellogalhardo.hilttoanvil.inject.component.FragmentComponent
import dev.marcellogalhardo.hilttoanvil.inject.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Provider

typealias FragmentMap = Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>

/**
 * A [FragmentFactory] that can hold onto multiple other FragmentFactory [Provider]'s.
 *
 * Note this was designed to be used with [FragmentKey].
 */
@ContributesBinding(ActivityScope::class, FragmentFactory::class)
class MultiBindingFragmentFactory @Inject constructor(
    private val fragmentComponentFactory: FragmentComponent.Factory
) : FragmentFactory() {

    @OptIn(InternalInjectApi::class)
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentComponent = fragmentComponentFactory.create()
        val fragmentClass = loadFragmentClass(classLoader, className)
        val fragmentMap = fragmentComponent.getFragmentMap()
        val fragment = fragmentMap[fragmentClass]?.get()
            ?: super.instantiate(classLoader, className)
        fragmentComponent.getFragmentHolder().atomicReference.set(fragment)
        return fragment
    }
}

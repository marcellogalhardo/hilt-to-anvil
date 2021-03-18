package dev.marcellogalhardo.hilttoanvil.inject.component

import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent
import dev.marcellogalhardo.hilttoanvil.inject.InternalInjectApi
import dev.marcellogalhardo.hilttoanvil.inject.fragment.FragmentMap
import dev.marcellogalhardo.hilttoanvil.inject.fragment.MainFragmentHolder
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import dev.marcellogalhardo.hilttoanvil.inject.scope.FragmentScope

@MergeSubcomponent(FragmentScope::class)
@SingleIn(FragmentScope::class)
interface FragmentComponent {

    fun getFragmentMap(): FragmentMap

    @InternalInjectApi
    fun getFragmentHolder(): MainFragmentHolder

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentComponent
    }
}

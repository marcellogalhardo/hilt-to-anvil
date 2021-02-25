package dev.marcellogalhardo.hilttoanvil.inject.component

import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent
import dev.marcellogalhardo.hilttoanvil.inject.InternalInjectApi
import dev.marcellogalhardo.hilttoanvil.inject.fragment.FragmentMap
import dev.marcellogalhardo.hilttoanvil.inject.fragment.MainFragmentHolder
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn

@MergeSubcomponent(Fragment::class)
@SingleIn(Fragment::class)
interface FragmentComponent {

    fun getFragmentMap(): FragmentMap

    @InternalInjectApi
    fun getFragmentHolder(): MainFragmentHolder

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentComponent
    }
}

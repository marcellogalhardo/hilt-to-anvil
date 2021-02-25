package dev.marcellogalhardo.hilttoanvil.sample

import android.app.Activity
import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.marcellogalhardo.hilttoanvil.inject.fragment.FragmentKey

@ContributesTo(Activity::class)
@Module
interface SampleFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(SampleFragment::class)
    fun bindFragment(impl: SampleFragment): Fragment
}

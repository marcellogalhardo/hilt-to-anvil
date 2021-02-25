package dev.marcellogalhardo.hilttoanvil.sample

import android.app.Application
import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.marcellogalhardo.hilttoanvil.inject.viewmodel.ViewModelKey

@ContributesTo(Application::class)
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    fun bindViewModel(impl: SampleViewModel): ViewModel
}
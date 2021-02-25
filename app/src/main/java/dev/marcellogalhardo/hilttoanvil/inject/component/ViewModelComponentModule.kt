package dev.marcellogalhardo.hilttoanvil.inject.component

import android.app.Application
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module

@ContributesTo(Application::class)
@Module(subcomponents = [ViewModelComponent::class])
interface ViewModelComponentModule

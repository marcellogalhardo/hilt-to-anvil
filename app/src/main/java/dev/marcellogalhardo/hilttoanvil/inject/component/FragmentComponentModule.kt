package dev.marcellogalhardo.hilttoanvil.inject.component

import android.app.Activity
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module

@ContributesTo(Activity::class)
@Module(subcomponents = [FragmentComponent::class])
interface FragmentComponentModule

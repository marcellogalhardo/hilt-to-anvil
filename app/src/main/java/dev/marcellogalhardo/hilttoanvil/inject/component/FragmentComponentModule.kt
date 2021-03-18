package dev.marcellogalhardo.hilttoanvil.inject.component

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dev.marcellogalhardo.hilttoanvil.inject.scope.ActivityScope

@ContributesTo(ActivityScope::class)
@Module(subcomponents = [FragmentComponent::class])
interface FragmentComponentModule

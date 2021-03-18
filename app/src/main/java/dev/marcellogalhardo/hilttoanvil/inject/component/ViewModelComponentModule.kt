package dev.marcellogalhardo.hilttoanvil.inject.component

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dev.marcellogalhardo.hilttoanvil.inject.scope.ApplicationScope

@ContributesTo(ApplicationScope::class)
@Module(subcomponents = [ViewModelComponent::class])
interface ViewModelComponentModule

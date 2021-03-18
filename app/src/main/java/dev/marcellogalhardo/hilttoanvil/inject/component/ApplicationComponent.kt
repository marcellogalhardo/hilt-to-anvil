package dev.marcellogalhardo.hilttoanvil.inject.component

import android.app.Application
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import dev.marcellogalhardo.hilttoanvil.inject.scope.ApplicationScope

@MergeComponent(ApplicationScope::class)
@SingleIn(ApplicationScope::class)
interface ApplicationComponent {

    fun getActivityComponentFactory(): ActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent

        companion object Default : Factory by DaggerApplicationComponent.factory()
    }
}

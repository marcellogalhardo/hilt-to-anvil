package dev.marcellogalhardo.hilttoanvil.inject.component

import android.app.Activity
import androidx.fragment.app.FragmentFactory
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.BindsInstance
import dagger.Subcomponent
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import dev.marcellogalhardo.hilttoanvil.inject.scope.ActivityScope

@MergeSubcomponent(ActivityScope::class)
@SingleIn(ActivityScope::class)
interface ActivityComponent {

    fun getFragmentFactory(): FragmentFactory

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: Activity): ActivityComponent
    }
}

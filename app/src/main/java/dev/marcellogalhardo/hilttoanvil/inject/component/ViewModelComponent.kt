package dev.marcellogalhardo.hilttoanvil.inject.component

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.BindsInstance
import dagger.Subcomponent
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import dev.marcellogalhardo.hilttoanvil.inject.scope.ViewModelScope
import dev.marcellogalhardo.hilttoanvil.inject.viewmodel.ViewModelMap

@MergeSubcomponent(ViewModelScope::class)
@SingleIn(ViewModelScope::class)
interface ViewModelComponent {

    fun getViewModelMap(): ViewModelMap

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance savedStateHandle: SavedStateHandle): ViewModelComponent
    }
}

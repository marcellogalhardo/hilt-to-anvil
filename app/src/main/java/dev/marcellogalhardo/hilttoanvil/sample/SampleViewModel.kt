package dev.marcellogalhardo.hilttoanvil.sample

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesMultibinding
import dev.marcellogalhardo.hilttoanvil.inject.scope.ViewModelScope
import dev.marcellogalhardo.hilttoanvil.inject.viewmodel.ViewModelKey
import dev.marcellogalhardo.hilttoanvil.sample.scope_example.DecreaseCount
import dev.marcellogalhardo.hilttoanvil.sample.scope_example.GetCount
import dev.marcellogalhardo.hilttoanvil.sample.scope_example.IncreaseCount
import javax.inject.Inject

@ContributesMultibinding(ViewModelScope::class)
@ViewModelKey(SampleViewModel::class)
class SampleViewModel @Inject constructor(
    val handle: SavedStateHandle,
    val increaseCount: IncreaseCount,
    val decreaseCount: DecreaseCount,
    val getCount: GetCount,
) : ViewModel()

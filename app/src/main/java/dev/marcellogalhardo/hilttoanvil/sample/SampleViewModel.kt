package dev.marcellogalhardo.hilttoanvil.sample

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dev.marcellogalhardo.hilttoanvil.sample.scope_example.DecreaseCount
import dev.marcellogalhardo.hilttoanvil.sample.scope_example.GetCount
import dev.marcellogalhardo.hilttoanvil.sample.scope_example.IncreaseCount
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    val handle: SavedStateHandle,
    val increaseCount: IncreaseCount,
    val decreaseCount: DecreaseCount,
    val getCount: GetCount,
) : ViewModel()

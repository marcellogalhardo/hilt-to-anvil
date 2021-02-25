package dev.marcellogalhardo.hilttoanvil.sample.scope_example

import androidx.lifecycle.ViewModel
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import javax.inject.Inject

@SingleIn(ViewModel::class)
class DataSource @Inject constructor() {
    var count = 0
}
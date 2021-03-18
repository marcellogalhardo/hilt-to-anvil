package dev.marcellogalhardo.hilttoanvil.sample.scope_example

import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import dev.marcellogalhardo.hilttoanvil.inject.scope.ViewModelScope
import javax.inject.Inject

@SingleIn(ViewModelScope::class)
class DataSource @Inject constructor() {
    var count = 0
}
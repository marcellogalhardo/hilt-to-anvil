package dev.marcellogalhardo.hilttoanvil.sample.scope_example

import javax.inject.Inject

class IncreaseCount @Inject constructor(
    val dataSource: DataSource,
) {
    fun increaseCount() {
        dataSource.count++
    }
}
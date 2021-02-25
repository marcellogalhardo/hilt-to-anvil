package dev.marcellogalhardo.hilttoanvil.sample.scope_example

import javax.inject.Inject

class DecreaseCount @Inject constructor(
    val dataSource: DataSource,
) {
    fun decreaseCount() {
        dataSource.count--
    }
}
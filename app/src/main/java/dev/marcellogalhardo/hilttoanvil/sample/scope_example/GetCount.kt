package dev.marcellogalhardo.hilttoanvil.sample.scope_example

import javax.inject.Inject

class GetCount @Inject constructor(
    val dataSource: DataSource,
) {
    fun get(): Int = dataSource.count
}
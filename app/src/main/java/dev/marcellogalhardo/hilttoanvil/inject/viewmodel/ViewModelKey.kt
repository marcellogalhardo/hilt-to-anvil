package dev.marcellogalhardo.hilttoanvil.inject.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * A [MapKey] annotation for maps with [KClass] of [ViewModel] keys.
 *
 * Note this was designed to be used only with [CompositeViewModelFactory].
 */
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
)
@Retention(value = AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

package dev.marcellogalhardo.hilttoanvil.inject.fragment

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * A [MapKey] annotation for maps with [KClass] of [Fragment] keys.
 *
 * Note this was designed to be used only with [MultiBindingFragmentFactory].
 */
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
)
@Retention(value = AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)

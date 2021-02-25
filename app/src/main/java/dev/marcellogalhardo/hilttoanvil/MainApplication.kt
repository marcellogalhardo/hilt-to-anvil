package dev.marcellogalhardo.hilttoanvil

import android.app.Application
import android.content.Context
import dev.marcellogalhardo.hilttoanvil.inject.component.ApplicationComponent

class MainApplication : Application() {

    val component = ApplicationComponent.Factory.create(this)

    companion object {

        fun from(context: Context): MainApplication = context.applicationContext as MainApplication
    }
}

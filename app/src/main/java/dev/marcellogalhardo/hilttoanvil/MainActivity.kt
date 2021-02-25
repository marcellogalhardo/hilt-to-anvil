package dev.marcellogalhardo.hilttoanvil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.getSystemService
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commitNow
import androidx.lifecycle.ViewModelProvider
import dev.marcellogalhardo.hilttoanvil.inject.component.ApplicationComponent
import dev.marcellogalhardo.hilttoanvil.sample.SampleFragment

class MainActivity: AppCompatActivity() {

    private val component by lazy(LazyThreadSafetyMode.NONE) {
        val applicationComponent = MainApplication.from(this).component
        applicationComponent.getActivityComponentFactory().create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = component.getFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.container, SampleFragment::class.java, null)
            }
        }
    }
}
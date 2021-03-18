package dev.marcellogalhardo.hilttoanvil.inject.fragment

import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.ContributesBinding
import dev.marcellogalhardo.hilttoanvil.inject.InternalInjectApi
import dev.marcellogalhardo.hilttoanvil.inject.qualifier.SingleIn
import dev.marcellogalhardo.hilttoanvil.inject.scope.FragmentScope
import java.util.concurrent.atomic.AtomicReference
import javax.inject.Inject

interface FragmentHolder {
    val fragment: Fragment
}

@OptIn(InternalInjectApi::class)
@ContributesBinding(FragmentScope::class)
@SingleIn(FragmentScope::class)
class MainFragmentHolder @Inject constructor() : FragmentHolder {

    @InternalInjectApi
    val atomicReference = AtomicReference<Fragment>()

    override val fragment: Fragment
        get() = requireNotNull(atomicReference.get()) {
            "A Fragment can only be requested lazily after its creation."
        }
}

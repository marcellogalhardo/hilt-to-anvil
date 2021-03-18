package dev.marcellogalhardo.hilttoanvil.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.ContributesMultibinding
import dev.marcellogalhardo.hilttoanvil.R
import dev.marcellogalhardo.hilttoanvil.inject.fragment.FragmentKey
import dev.marcellogalhardo.hilttoanvil.inject.scope.FragmentScope
import dev.marcellogalhardo.hilttoanvil.inject.viewmodel.ViewModelLocator
import javax.inject.Inject

@ContributesMultibinding(FragmentScope::class)
@FragmentKey(SampleFragment::class)
class SampleFragment @Inject constructor(
    viewModelLocator: ViewModelLocator,
) : Fragment(R.layout.fragment_sample) {

    private val viewModel by viewModelLocator.getViewModel<SampleViewModel>(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.buttonIncrease).setOnClickListener {
            viewModel.increaseCount.increaseCount()
        }
        view.findViewById<Button>(R.id.buttonDecrease).setOnClickListener {
            viewModel.decreaseCount.decreaseCount()
        }
        view.findViewById<Button>(R.id.buttonPrint).setOnClickListener {
            Toast.makeText(
                requireContext(),
                viewModel.getCount.get().toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
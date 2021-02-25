package dev.marcellogalhardo.hilttoanvil.sample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dev.marcellogalhardo.hilttoanvil.R
import javax.inject.Inject

class SampleFragment @Inject constructor(
    viewModelProviderFactory: ViewModelProvider.Factory,
) : Fragment(R.layout.fragment_sample) {

    private val viewModel by viewModels<SampleViewModel> { viewModelProviderFactory }

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
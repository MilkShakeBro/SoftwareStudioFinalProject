package com.example.finalprojecttemplate.ui.timer

import android.R
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.TimerFragmentBinding


class TimerPageFragment: Fragment() {

    private var binding: TimerFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = TimerFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAllPicker()

        binding?.apply {
            start.setOnClickListener {
                val hour = numPickerH.value
                val minute = numPickerM.value
                val second = numPickerS.value

                Log.d("Hour", hour.toString())
                Log.d("Minute", minute.toString())
                Log.d("Second", second.toString())

                val action = TimerPageFragmentDirections.actionTimerPageFragmentToFlashcardPageFragment()
                findNavController().navigate(action)
            }

            skip.setOnClickListener {
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToGamePageFragment()
                findNavController().navigate(action)
            }

        }
    }

    private fun initPicker(min: Int, max: Int, p: NumberPicker) {
        p.minValue = min
        p.maxValue = max
        p.setFormatter { i -> String.format("%02d", i) }
    }

    private fun initAllPicker() {
        binding?.let { initPicker(0, 59, it.numPickerH) }
        binding?.let { initPicker(0, 59, it.numPickerM) }
        binding?.let { initPicker(0, 59, it.numPickerS) }
    }
}
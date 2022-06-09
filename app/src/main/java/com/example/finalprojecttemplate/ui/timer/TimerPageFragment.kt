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
import androidx.navigation.fragment.navArgs
import com.example.finalprojecttemplate.databinding.TimerFragmentBinding
import com.example.finalprojecttemplate.ui.flashcard.FlashcardPageFragmentArgs


class TimerPageFragment: Fragment() {

    private var binding: TimerFragmentBinding? = null
    private val args: TimerPageFragmentArgs by navArgs()
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
        Log.d("args", args.toString())
        val id = arguments?.getInt("vocabularySetId") ?:0
        initAllPicker()

        binding?.apply {
            start.setOnClickListener {
                val hour = numPickerH.value
                val minute = numPickerM.value
                val second = numPickerS.value
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToFlashcardPageFragment(id, hour, minute, second)
                findNavController().navigate(action)
            }

            skip.setOnClickListener {
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToGamePageFragment(
                    vocabularySetId = id
                )
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToGamePageFragment(id)
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
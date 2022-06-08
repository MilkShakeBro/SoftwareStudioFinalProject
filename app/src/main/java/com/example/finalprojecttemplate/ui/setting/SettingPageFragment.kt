package com.example.finalprojecttemplate.ui.setting

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.finalprojecttemplate.databinding.SettingFragmentBinding
import com.example.finalprojecttemplate.ui.profile.ShowAchievementViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.profile.*
import kotlinx.android.synthetic.main.setting_fragment.*

@AndroidEntryPoint
class SettingPageFragment: Fragment()  {

    private var binding: SettingFragmentBinding? = null
    private val showDarkModeViewModel: ShowDarkModeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    
    ): View? {
        val fragmentBinding = SettingFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            Log.d("AAA",showDarkModeViewModel.darkMode().toString())
            if(showDarkModeViewModel.darkMode()==true){
                DarkTheme.setChecked(false)
            }
            else{
                DarkTheme.setChecked(true)
            }
            DarkTheme.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    showDarkModeViewModel.setdarkMode(false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                else{
                    showDarkModeViewModel.setdarkMode(true)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            })
        }

    }

}



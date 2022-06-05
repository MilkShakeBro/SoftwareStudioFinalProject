package com.example.finalprojecttemplate.ui.profile

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.ProfileBinding
import com.example.finalprojecttemplate.databinding.AchievementPopupBinding
import com.example.finalprojecttemplate.ui.homepage.HomePageFragmentDirections
import com.example.finalprojecttemplate.ui.setting.SettingPageFragmentDirections
import kotlinx.android.synthetic.main.profile.*

class ProfilePageFragment: Fragment()  {

    private var binding: ProfileBinding? = null
    private var achievementPopupBinding : AchievementPopupBinding? = null
    private var achievementpopup: PopupWindow? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = ProfileBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            settingButton.setOnClickListener{
                val action = ProfilePageFragmentDirections.actionProfilePageFragmentToSettingPageFragment()
                findNavController().navigate(action)
            }
            achievementButton1.setOnClickListener{
                initializeAchievementPopupWindow()
            }
        }
    }

    private fun initializeAchievementPopupWindow() {
        achievementPopupBinding = AchievementPopupBinding.inflate(layoutInflater, null, false)
        achievementpopup = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true)

        achievementpopup?.apply {
            contentView = achievementPopupBinding!!.root


            setBackgroundDrawable(ColorDrawable(Color.argb(220, 0, 0, 0)))

            showAtLocation(view, Gravity.CENTER, 0, 0)

            achievementPopupBinding?.apply {
//                screenshotImage.setImageBitmap(viewModel.resultBitmap)
                close.setOnClickListener {
                    achievementpopup?.dismiss()
                }
            }
        }
    }
}
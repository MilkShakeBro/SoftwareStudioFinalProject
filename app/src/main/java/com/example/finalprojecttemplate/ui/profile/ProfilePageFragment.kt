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
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.ProfileBinding
import com.example.finalprojecttemplate.databinding.AchievementPopupBinding
import com.example.finalprojecttemplate.domain.models.AchievementSetModel
import com.example.finalprojecttemplate.domain.utils.bindImage
import com.example.finalprojecttemplate.ui.article.ShowArticleViewModel
import com.example.finalprojecttemplate.ui.homepage.HomePageFragmentDirections
import com.example.finalprojecttemplate.ui.setting.SettingPageFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.achievement_popup.*
import kotlinx.android.synthetic.main.profile.*

@AndroidEntryPoint
class ProfilePageFragment: Fragment()  {

    private val showAchievementViewModel: ShowAchievementViewModel by viewModels()
    private var binding: ProfileBinding? = null
    private var achievementPopupBinding : AchievementPopupBinding? = null
    private var achievementpopup: PopupWindow? = null
    private var achievementdata: AchievementSetModel? = null

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
        showAchievementViewModel.onEvent()
        binding?.apply {
            settingButton.setOnClickListener{
                val action = ProfilePageFragmentDirections.actionProfilePageFragmentToSettingPageFragment()
                findNavController().navigate(action)
            }
            achievementButton1.setOnClickListener {
                initializeAchievementPopupWindow(0)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(0)?.description
            }
            achievementButton2.setOnClickListener {
                initializeAchievementPopupWindow(1)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(1)?.description
            }
            achievementButton3.setOnClickListener {
                initializeAchievementPopupWindow(2)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(2)?.description
            }
            achievementButton4.setOnClickListener {
                initializeAchievementPopupWindow(3)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(3)?.description
            }
            achievementButton5.setOnClickListener {
                initializeAchievementPopupWindow(4)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(4)?.description
            }
            achievementButton6.setOnClickListener {
                initializeAchievementPopupWindow(5)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(5)?.description
            }
            achievementButton7.setOnClickListener {
                initializeAchievementPopupWindow(6)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(6)?.description
            }
            achievementButton8.setOnClickListener {
                initializeAchievementPopupWindow(7)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(7)?.description
            }
            achievementButton9.setOnClickListener {
                initializeAchievementPopupWindow(8)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(8)?.description
            }
            achievementButton10.setOnClickListener {
                initializeAchievementPopupWindow(9)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(9)?.description
            }
            achievementButton11.setOnClickListener {
                initializeAchievementPopupWindow(10)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(10)?.description
            }
            achievementButton12.setOnClickListener {
                initializeAchievementPopupWindow(11)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(11)?.description
            }
            achievementButton13.setOnClickListener {
                initializeAchievementPopupWindow(12)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(12)?.description
            }
            achievementButton14.setOnClickListener {
                initializeAchievementPopupWindow(13)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(13)?.description
            }
            achievementButton15.setOnClickListener {
                initializeAchievementPopupWindow(14)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(14)?.description
            }
            achievementButton16.setOnClickListener {
                initializeAchievementPopupWindow(15)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(15)?.description
            }
        }
        showAchievementViewModel.displayedAchievement.observe(viewLifecycleOwner){ newachievement->
            achievementdata = newachievement
            bindImage(achievement_button1,newachievement.achievement[0].img)
            bindImage(achievement_button2,newachievement.achievement[1].img)
            bindImage(achievement_button3,newachievement.achievement[2].img)
            bindImage(achievement_button4,newachievement.achievement[3].img)
            bindImage(achievement_button5,newachievement.achievement[4].img)
            bindImage(achievement_button6,newachievement.achievement[5].img)
            bindImage(achievement_button7,newachievement.achievement[6].img)
            bindImage(achievement_button8,newachievement.achievement[7].img)
            bindImage(achievement_button9,newachievement.achievement[8].img)
            bindImage(achievement_button10,newachievement.achievement[9].img)
            bindImage(achievement_button11,newachievement.achievement[10].img)
            bindImage(achievement_button12,newachievement.achievement[11].img)
            bindImage(achievement_button13,newachievement.achievement[12].img)
            bindImage(achievement_button14,newachievement.achievement[13].img)
            bindImage(achievement_button15,newachievement.achievement[14].img)
            bindImage(achievement_button16,newachievement.achievement[15].img)
        }
    }

    private fun initializeAchievementPopupWindow(index: Int) {
        achievementPopupBinding = AchievementPopupBinding.inflate(layoutInflater, null, false)
        achievementpopup = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true)
        achievementpopup?.apply {
            contentView = achievementPopupBinding!!.root
            setBackgroundDrawable(ColorDrawable(Color.argb(220, 0, 0, 0)))
            showAtLocation(view, Gravity.CENTER, 0, 0)
            achievementPopupBinding?.apply {
//                screenshotImage.setImageBitmap(viewModel.resultBitmap)
                bindImage(pic,achievementdata?.achievement?.get(index)?.img)
                close.setOnClickListener {
                    achievementpopup?.dismiss()
                }
            }
        }
    }
}
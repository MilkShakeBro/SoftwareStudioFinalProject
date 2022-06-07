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
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(0)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(0)?.description
            }
            achievementButton2.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(1)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(1)?.description
            }
            achievementButton3.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(2)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(2)?.description
            }
            achievementButton4.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(3)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(3)?.description
            }
            achievementButton5.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(4)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(4)?.description
            }
            achievementButton6.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(5)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(5)?.description
            }
            achievementButton7.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(6)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(6)?.description
            }
            achievementButton8.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(7)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(7)?.description
            }
            achievementButton9.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(8)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(8)?.description
            }
            achievementButton10.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(9)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(9)?.description
            }
            achievementButton11.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(10)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(10)?.description
            }
            achievementButton12.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(11)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(11)?.description
            }
            achievementButton13.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(12)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(12)?.description
            }
            achievementButton14.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(13)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(13)?.description
            }
            achievementButton15.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(14)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(14)?.description
            }
            achievementButton16.setOnClickListener {
                initializeAchievementPopupWindow()
                achievementPopupBinding?.pic?.setImageURI(achievementdata?.achievement?.get(15)?.img)
                achievementPopupBinding?.descrip?.text = achievementdata?.achievement?.get(15)?.description
            }
        }
        showAchievementViewModel.displayedAchievement.observe(viewLifecycleOwner){ newachievement->
            achievementdata = newachievement
            Log.d("AAAA",newachievement.achievement[0].img.toString())
            Log.d("AAA",newachievement.achievement[1].img.toString())
            binding?.achievementButton1?.setImageURI(newachievement.achievement[0].img)
            binding?.achievementButton2?.setImageURI(newachievement.achievement[1].img)
            binding?.achievementButton3?.setImageURI(newachievement.achievement[2].img)
            binding?.achievementButton4?.setImageURI(newachievement.achievement[3].img)
            binding?.achievementButton5?.setImageURI(newachievement.achievement[4].img)
            binding?.achievementButton6?.setImageURI(newachievement.achievement[5].img)
            binding?.achievementButton7?.setImageURI(newachievement.achievement[6].img)
            binding?.achievementButton8?.setImageURI(newachievement.achievement[7].img)
            binding?.achievementButton9?.setImageURI(newachievement.achievement[8].img)
            binding?.achievementButton10?.setImageURI(newachievement.achievement[9].img)
            binding?.achievementButton11?.setImageURI(newachievement.achievement[10].img)
            binding?.achievementButton12?.setImageURI(newachievement.achievement[11].img)
            binding?.achievementButton13?.setImageURI(newachievement.achievement[12].img)
            binding?.achievementButton14?.setImageURI(newachievement.achievement[13].img)
            binding?.achievementButton15?.setImageURI(newachievement.achievement[14].img)
            binding?.achievementButton16?.setImageURI(newachievement.achievement[15].img)
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
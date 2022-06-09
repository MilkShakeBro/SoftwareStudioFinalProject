package com.example.finalprojecttemplate.ui.game_tutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.viewpager.widget.PagerAdapter
import com.example.finalprojecttemplate.R

class GameTutorialAdapter(
    private val ctx: Context?,
    private val vocabularyId: Int
    ): PagerAdapter() {

    var index = 0
    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater =
            ctx!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View = layoutInflater.inflate(R.layout.game_tutorial_fragment, container, false)
        val explanation: TextView = view.findViewById(R.id.explanation)
        val page1Button: ImageView = view.findViewById(R.id.page1)
        val page2Button: ImageView = view.findViewById(R.id.page2)
        val page3Button: ImageView = view.findViewById(R.id.page3)
        val page4Button: ImageView = view.findViewById(R.id.page4)
        val page5Button: ImageView = view.findViewById(R.id.page5)
        val enterButton: Button = view.findViewById(R.id.enter)

        when (position) {
            0 -> {
                page1Button.setImageResource(R.drawable.selected)
                page2Button.setImageResource(R.drawable.unselected)
                page3Button.setImageResource(R.drawable.unselected)
                page4Button.setImageResource(R.drawable.unselected)
                page5Button.setImageResource(R.drawable.unselected)
                explanation.text = "Move up and down to match the word."
                enterButton.visibility = View.INVISIBLE
            }
            1 -> {
                page1Button.setImageResource(R.drawable.unselected)
                page2Button.setImageResource(R.drawable.selected)
                page3Button.setImageResource(R.drawable.unselected)
                page4Button.setImageResource(R.drawable.unselected)
                page5Button.setImageResource(R.drawable.unselected)
                explanation.text = "Press left arrow to match the word."
                enterButton.visibility = View.INVISIBLE
            }
            2 -> {
                page1Button.setImageResource(R.drawable.unselected)
                page2Button.setImageResource(R.drawable.unselected)
                page3Button.setImageResource(R.drawable.selected)
                page4Button.setImageResource(R.drawable.unselected)
                page5Button.setImageResource(R.drawable.unselected)
                explanation.text = "Press skip button to skip the game."
                enterButton.visibility = View.INVISIBLE
            }
            3 -> {
                page1Button.setImageResource(R.drawable.unselected)
                page2Button.setImageResource(R.drawable.unselected)
                page3Button.setImageResource(R.drawable.unselected)
                page4Button.setImageResource(R.drawable.selected)
                page5Button.setImageResource(R.drawable.unselected)
                explanation.text = "Chinese meaning is given on top right."
                enterButton.visibility = View.INVISIBLE
            }
            4 -> {
                page1Button.setImageResource(R.drawable.unselected)
                page2Button.setImageResource(R.drawable.unselected)
                page3Button.setImageResource(R.drawable.unselected)
                page4Button.setImageResource(R.drawable.unselected)
                page5Button.setImageResource(R.drawable.selected)
                explanation.text = "Earn the score as high as possible."
                enterButton.visibility = View.VISIBLE
                enterButton.setOnClickListener { view ->
                    val action = GameTutorialFragmentDirections.actionGameTutorialFragmentToGamePageFragment(
                        vocabularySetId = vocabularyId
                    )
                    view.findNavController().navigate(action)
                }
            }
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}
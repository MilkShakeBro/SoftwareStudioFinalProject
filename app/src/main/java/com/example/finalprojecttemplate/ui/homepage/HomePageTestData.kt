package com.example.finalprojecttemplate.ui.homepage

import android.content.res.Resources
import androidx.core.graphics.drawable.toBitmap
import com.example.finalprojecttemplate.R

@Deprecated("")
data class HomePageTestData(
    val resources: Resources
) {
    private val imagePlaceholder = resources.getDrawable(R.drawable.ic_launcher_background).toBitmap()
    val articlesTestCases : List<HomePageListItem> = listOf(
        HomePageListItem(
            id = 0,
            displayedImage = imagePlaceholder,
            displayedName = "Art Museum"
        ),
        HomePageListItem(
            id = 1,
            displayedImage = imagePlaceholder,
            displayedName = "Zebrafish"
        ),
        HomePageListItem(
            id = 2,
            displayedImage = imagePlaceholder,
            displayedName = "Teenager Problems"
        ),
        HomePageListItem(
            id = 3,
            displayedImage = imagePlaceholder,
            displayedName = "Movies"
        ),
        HomePageListItem(
            id = 4,
            displayedImage = imagePlaceholder,
            displayedName = "Medicines"
        )
    )

    val vocabulariesTestCases : List<HomePageListItem> = listOf(
        HomePageListItem(
            id = 0,
            displayedImage = imagePlaceholder,
            displayedName = "Cosmetics"
        ),
        HomePageListItem(
            id = 1,
            displayedImage = imagePlaceholder,
            displayedName = "Fruits"
        ),
        HomePageListItem(
            id = 2,
            displayedImage = imagePlaceholder,
            displayedName = "Sports"
        ),
        HomePageListItem(
            id = 3,
            displayedImage = imagePlaceholder,
            displayedName = "Household Appliances"
        ),
        HomePageListItem(
            id = 4,
            displayedImage = imagePlaceholder,
            displayedName = "Animals"
        )
    )

    val themeTestCases : List<HomePageListItem> = listOf(
        HomePageListItem(
            id = 0,
            displayedImage = imagePlaceholder,
            displayedName = "Classroom"
        ),
        HomePageListItem(
            id = 1,
            displayedImage = imagePlaceholder,
            displayedName = "Living Room"
        ),
        HomePageListItem(
            id = 2,
            displayedImage = imagePlaceholder,
            displayedName = "Emergency Room"
        ),
        HomePageListItem(
            id = 3,
            displayedImage = imagePlaceholder,
            displayedName = "Police Station"
        ),
        HomePageListItem(
            id = 4,
            displayedImage = imagePlaceholder,
            displayedName = "Shopping Mall"
        )
    )
}

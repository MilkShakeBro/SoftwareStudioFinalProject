package com.example.finalprojecttemplate.data.data_source

import android.net.Uri
import com.example.finalprojecttemplate.domain.models.*
import kotlinx.coroutines.delay
import java.lang.Thread.sleep

class FakeDatabase {
    private val vocabularySets: List<VocabularySetModel> = listOf(
        VocabularySetModel(
            id = 0,
            name = "裝飾",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "ornament",
                    chinese = "n.[C] 裝飾品",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "stylish",
                    chinese = "adj. 時髦的，流行的",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "vogue",
                    chinese = "n.[U] 流行，時尚，時髦",
                    breakpoint = 4
                ),
                Vocabulary(
                    id = 3,
                    word = "accessory",
                    chinese = "n.[C] 附加物件，衣物配件",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "ribbon",
                    chinese = "n.[C] 彩帶，緞帶",
                    breakpoint = 5
                ),
                Vocabulary(
                    id = 5,
                    word = "brooch",
                    chinese = "n.[C] 女用胸針",
                    breakpoint = 4
                ),
                Vocabulary(
                    id = 6,
                    word = "jewel",
                    chinese = "n.[C] 珠寶",
                    breakpoint = 2
                ),
                Vocabulary(
                    id = 7,
                    word = "bracelet",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "cosmetic",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "lipstick",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "wig",
                    chinese = "觀眾",
                    breakpoint = 1
                ),
                Vocabulary(
                    id = 11,
                    word = "hairdo",
                    chinese = "觀眾",
                    breakpoint = 2
                ),
                Vocabulary(
                    id = 12,
                    word = "wreath",
                    chinese = "觀眾",
                    breakpoint = 2
                ),
                Vocabulary(
                    id = 13,
                    word = "bouquet",
                    chinese = "觀眾",
                    breakpoint = 4
                ),
            ),
        ),
        VocabularySetModel(
            id = 1,
            name = "di",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
            ),
        ),
        VocabularySetModel(
            id = 2,
            name = "en",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
            ),
        ),
        VocabularySetModel(
            id = 3,
            name = "ce",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
            ),
        ),
        VocabularySetModel(
            id = 4,
            name = "s",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "audience",
                    chinese = "觀眾",
                    breakpoint = 6
                ),
            ),
        ),
    )
    private val articles: List<ArticleModel> = listOf(
        ArticleModel(
            id = 0,
            name = "Zebrafish",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C",
                4 to "D"
            ),
            image = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/330px-Image_created_with_a_mobile_phone.png"),
            content = "Zebrafish, named for their characteristic stripes, have been a popular test subject for researchers. Only " +
                    "a few centimeters in length, the fish breed easily in captivity, grow quickly, and their transparent body " +
                    "makes it easy to study their organs. Above all, they possess some amazing “self-healing” power. When part " +
                    "of their heart is removed, they can grow it back in a matter of weeks. When blinded, they can quickly regain " +
                    "the ability to see.\n" +
                    "Recent studies show that humans and zebrafish have the same major organs and share 70 percent of " +
                    "the genes. Moreover, 84 percent of human genes associated with disease find a counterpart in zebrafish. " +
                    "Scientists thus hope that understanding the self-healing mystery of the fish may one day allow humans to " +
                    "regenerate such organs as eyes, hearts, and spines.\n" +
                    "Researchers at Vanderbilt University are particularly interested in zebrafish retina regeneration. They " +
                    "have learned that damage of retina can cause blindness in zebrafish, yet it only takes about three to four " +
                    "weeks before vision is restored. The structure and cell types of zebrafish retinas are almost identical to those " +
                    "of humans. If the process can be replicated in humans, it may give rise to new treatments for blindness " +
                    "caused by retinal damage.\n" +
                    "In order to know exactly how zebrafish retina is regenerated, the team looked at the neurotransmitter " +
                    "gamma-aminobutyric acid (GABA), a chemical messenger in the brain that reduces the activity of neurons. " +
                    "They found that lowering GABA levels in zebrafish can trigger retina regeneration, while a high level of " +
                    "GABA concentration will suppress the regeneration process. This suggested that GABA plays an important " +
                    "role in the fish’s ability to regain their sight.\n" +
                    "The team is beginning to test the GABA theory on mice. If that works, human trials will be next on " +
                    "the agenda. If the research proves successful in humans, some of the nearly 40 million blind people " +
                    "worldwide may one day have a tiny, striped fish to thank."
        ),
        ArticleModel(
            id = 1,
            name = "Lorem",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C",
                4 to "D"
            ),
            image = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/330px-Image_created_with_a_mobile_phone.png"),
            content = "Zebrafish, named for their characteristic stripes, have been a popular test subject for researchers. Only " +
                    "a few centimeters in length, the fish breed easily in captivity, grow quickly, and their transparent body " +
                    "makes it easy to study their organs. Above all, they possess some amazing “self-healing” power. When part " +
                    "of their heart is removed, they can grow it back in a matter of weeks. When blinded, they can quickly regain " +
                    "the ability to see.\n" +
                    "Recent studies show that humans and zebrafish have the same major organs and share 70 percent of " +
                    "the genes. Moreover, 84 percent of human genes associated with disease find a counterpart in zebrafish. " +
                    "Scientists thus hope that understanding the self-healing mystery of the fish may one day allow humans to " +
                    "regenerate such organs as eyes, hearts, and spines.\n" +
                    "Researchers at Vanderbilt University are particularly interested in zebrafish retina regeneration. They " +
                    "have learned that damage of retina can cause blindness in zebrafish, yet it only takes about three to four " +
                    "weeks before vision is restored. The structure and cell types of zebrafish retinas are almost identical to those " +
                    "of humans. If the process can be replicated in humans, it may give rise to new treatments for blindness " +
                    "caused by retinal damage.\n" +
                    "In order to know exactly how zebrafish retina is regenerated, the team looked at the neurotransmitter " +
                    "gamma-aminobutyric acid (GABA), a chemical messenger in the brain that reduces the activity of neurons. " +
                    "They found that lowering GABA levels in zebrafish can trigger retina regeneration, while a high level of " +
                    "GABA concentration will suppress the regeneration process. This suggested that GABA plays an important " +
                    "role in the fish’s ability to regain their sight.\n" +
                    "The team is beginning to test the GABA theory on mice. If that works, human trials will be next on " +
                    "the agenda. If the research proves successful in humans, some of the nearly 40 million blind people " +
                    "worldwide may one day have a tiny, striped fish to thank."
        ),
        ArticleModel(
            id = 2,
            name = "Cras",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C",
                4 to "D"
            ),
            image = Uri.parse("https://www.google.com"),
            content = "Cras accumsan tristique ultricies. Vivamus quis tincidunt metus, sed interdum augue. Nulla facilisi. Aliquam viverra, sem in pharetra fringilla, quam justo fermentum neque, et hendrerit justo purus nec lectus. Praesent posuere varius nulla, vel efficitur lacus dapibus non. Mauris pharetra mi sit amet turpis dignissim, et maximus nibh euismod. Curabitur iaculis tristique elit, sit amet maximus libero varius non. Donec molestie nunc est, id elementum quam ultrices vel. Morbi rhoncus turpis massa, quis mollis lorem blandit vel. Proin eu arcu tortor. Fusce nunc eros, luctus faucibus magna nec, tristique elementum felis. Cras consequat facilisis mauris sed volutpat. Sed egestas odio id neque aliquam venenatis."
        ),
        ArticleModel(
            id = 3,
            name = "Nam",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C",
                4 to "D"
            ),
            image = Uri.parse("https://www.google.com"),
            content = "Nam vitae euismod neque, eget imperdiet diam. Praesent a ultrices sem. Suspendisse semper, purus eu dictum iaculis, arcu neque posuere augue, eget tristique mi metus vitae orci. Duis metus est, tempus nec porta id, mattis ac dui. Mauris in lorem ac mi placerat accumsan non ut odio. In ultricies ultricies risus id elementum. Proin iaculis lacus at velit consectetur gravida nec ut nibh."
        ),
        ArticleModel(
            id = 4,
            name = "Vivamus",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C",
                4 to "D"
            ),
            image = Uri.parse("https://www.google.com"),
            content = "Vivamus faucibus tortor non nunc viverra tempor vitae id nibh. Praesent mattis id nibh vitae sodales. Suspendisse euismod hendrerit elit, quis vulputate sem imperdiet eget. Nam in maximus est. Etiam consectetur lorem et ligula euismod, in maximus eros pulvinar. Nulla mollis elementum consequat. Nulla luctus tristique ex ut blandit. Sed ut eros eleifend, molestie mi vitae, hendrerit velit. Nunc a vulputate turpis. Curabitur mattis ultrices sem, at laoreet leo efficitur et. Etiam eu velit magna. Proin interdum mi enim, eu hendrerit neque scelerisque eu. Cras molestie sodales eros in ultricies. Duis scelerisque malesuada nisl ullamcorper semper."
        )
    )
    private val historyData: List<HistoryDataModel> = listOf(
        HistoryDataModel(
            historyVocabularySetRecord = HistoryVocabularySetRecord (
                lastVocabularySet = vocabularySets[0].vocabularySet,
                lastVocabularyId = 3,
                score = 10,
                time = 15
            )
        ),
        HistoryDataModel(
            historyVocabularySetRecord = HistoryVocabularySetRecord (
                lastVocabularySet = vocabularySets[1].vocabularySet,
                lastVocabularyId = 3,
                score = 20,
                time = 14
            )
        ),
        HistoryDataModel(
            historyVocabularySetRecord = HistoryVocabularySetRecord (
                lastVocabularySet = vocabularySets[2].vocabularySet,
                lastVocabularyId = 3,
                score = 30,
                time = 13
            )
        ),
        HistoryDataModel(
            historyVocabularySetRecord = HistoryVocabularySetRecord (
                lastVocabularySet = vocabularySets[3].vocabularySet,
                lastVocabularyId = 3,
                score = 40,
                time = 12
            )
        ),
        HistoryDataModel(
            historyVocabularySetRecord = HistoryVocabularySetRecord (
                lastVocabularySet = vocabularySets[4].vocabularySet,
                lastVocabularyId = 3,
                score = 50,
                time = 11
            )
        ),
    )
    private val themeData: List<ThemeDataModel> = listOf(
        ThemeDataModel(
            id = 0,
            image = Uri.parse("https://www.google.com"),
            flashcard = listOf(
                VocabularyForTheme(
                    id = 0,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(150.0f, 150.5f)
                ),
                VocabularyForTheme(
                    id = 1,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(120.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 2,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(130.0f, 130.0f)
                ),
                VocabularyForTheme(
                    id = 3,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(100.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 4,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(50.0f, 150.0f)
                ),
            ),
        ),
        ThemeDataModel(
            id = 1,
            image = Uri.parse("https://www.google.com"),
            flashcard = listOf(
                VocabularyForTheme(
                    id = 0,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(150.0f, 150.5f)
                ),
                VocabularyForTheme(
                    id = 1,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(120.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 2,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(130.0f, 130.0f)
                ),
                VocabularyForTheme(
                    id = 3,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(100.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 4,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(50.0f, 150.0f)
                ),
            )
        ),
        ThemeDataModel(
            id = 2,
            image = Uri.parse("https://www.google.com"),
            flashcard = listOf(
                VocabularyForTheme(
                    id = 0,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(150.0f, 150.5f)
                ),
                VocabularyForTheme(
                    id = 1,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(120.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 2,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(130.0f, 130.0f)
                ),
                VocabularyForTheme(
                    id = 3,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(100.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 4,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(50.0f, 150.0f)
                ),
        ),
        ),
        ThemeDataModel(
            id = 3,
            image = Uri.parse("https://www.google.com"),
            flashcard = listOf(
                VocabularyForTheme(
                    id = 0,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(150.0f, 150.5f)
                ),
                VocabularyForTheme(
                    id = 1,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(120.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 2,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(130.0f, 130.0f)
                ),
                VocabularyForTheme(
                    id = 3,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(100.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 4,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(50.0f, 150.0f)
                ),
            )
        ),
        ThemeDataModel(
            id = 4,
            image = Uri.parse("https://www.google.com"),
            flashcard = listOf(
                VocabularyForTheme(
                    id = 0,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(150.0f, 150.5f)
                ),
                VocabularyForTheme(
                    id = 1,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(120.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 2,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(130.0f, 130.0f)
                ),
                VocabularyForTheme(
                    id = 3,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(100.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 4,
                    word = "lamp",
                    chinese = "檯燈",
                    positionForClickButton = Coordinate(50.0f, 150.0f)
                ),
            )
        ),
    )
    private val achievementSet: List<AchievementSetModel> = listOf(
        AchievementSetModel(
            id = 0,
            achievement = listOf(
                Achievement(
                    id = 0,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 1,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 2,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 3,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 4,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                )
            ),
        ),
        AchievementSetModel(
            id = 1,
            achievement = listOf(
                Achievement(
                    id = 0,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 1,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 2,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 3,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 4,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                )
            ),
        ),
        AchievementSetModel(
            id = 2,
            achievement = listOf(
                Achievement(
                    id = 0,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 1,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 2,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 3,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 4,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                )
            ),
        ),
        AchievementSetModel(
            id = 3,
            achievement = listOf(
                Achievement(
                    id = 0,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 1,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 2,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 3,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 4,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                )
            ),
        ),
        AchievementSetModel(
            id = 4,
            achievement = listOf(
                Achievement(
                    id = 0,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 1,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 2,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 3,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = true
                ),
                Achievement(
                    id = 4,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                )
            ),
        ),
    )
    private val personalInfo: List<PersonalInfoModel> = listOf(
        PersonalInfoModel(
            id = 0,
            name = "Chris"
        ),
        PersonalInfoModel(
            id = 1,
            name = "Luna"
        ),
        PersonalInfoModel(
            id = 2,
            name = "Angela"
        ),
        PersonalInfoModel(
            id = 3,
            name = "Steven"
        ),
        PersonalInfoModel(
            id = 4,
            name = "Howard"
        )
    )

    fun getArticleByIndex(index: Int): ArticleModel {
        return if (index in 0 until 5) articles[index]
        else ArticleModel(
            id = -1,
            name = "null",
            answer = mapOf(
                1 to "-1",
                2 to "-1",
                3 to "-1",
                4 to "-1"
            ),
            image = Uri.parse("null"),
            content = "Article not found"
        )
    }

    fun getVocabularySetByIndex(index: Int): VocabularySetModel {
        return if (index in 0 until 5) vocabularySets[index]
        else VocabularySetModel(
            id = -1,
            name = "null",
            image = Uri.parse("null"),
            vocabularySet = listOf()
        )
    }

    fun getHistoryData(userid: Int): HistoryDataModel {
        return if (userid in 0 until 5) historyData[userid]
        else HistoryDataModel(
            historyVocabularySetRecord = HistoryVocabularySetRecord (
                lastVocabularySet = listOf(),
                lastVocabularyId = -1,
                score = -1,
                time = -1
            )
        )
    }

    suspend fun getHomePageInfo(userid: Int): HomePageInfoModel {
        var articleInfo: MutableList<HomePageInfo> = mutableListOf()
        var vocabularySetInfo: MutableList<HomePageInfo> = mutableListOf()
        var themeInfo: MutableList<HomePageInfo> = mutableListOf()

        articles.forEach{ item->articleInfo.add(HomePageInfo(item.id, item.image, item.name)) }
        vocabularySets.forEach{ item->vocabularySetInfo.add(HomePageInfo(item.id, item.image, item.name)) }
        themeData.forEach{ item->themeInfo.add(HomePageInfo(item.id, item.image, "item.name???")) }

        delay(1000)

        return if (userid in 0 until 5) HomePageInfoModel(articleInfo, vocabularySetInfo, themeInfo)
        else HomePageInfoModel(
            mutableListOf(),
            mutableListOf(),
            mutableListOf()
        )
    }

    fun getThemeData(index: Int): ThemeDataModel {
        return if (index in 0 until 5) themeData[index]
        else ThemeDataModel(
            id = -1,
            image = Uri.parse("null"),
            flashcard = listOf(),
        )
    }

    fun getAchievement(userid: Int): AchievementSetModel {
        return if (userid in 0 until 5) achievementSet[userid]
        else AchievementSetModel(
            id = -1,
            achievement = listOf(
                Achievement(
                    id = 0,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 1,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 2,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 3,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                ),
                Achievement(
                    id = 4,
                    img = Uri.parse("https://www.google.com"),
                    description = "This is a description.",
                    obtained = false
                )
            ),
        )
    }
    fun getPersonalInfo(userid: Int): PersonalInfoModel {
        return if (userid in 0 until 5) personalInfo[userid]
        else PersonalInfoModel(
            id = -1,
            name = "poopoo"
        )
    }
}
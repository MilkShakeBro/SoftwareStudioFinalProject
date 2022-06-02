package com.example.finalprojecttemplate.data.data_source

import android.net.Uri
import androidx.core.net.toUri
import com.example.finalprojecttemplate.domain.models.*
import com.example.finalprojecttemplate.ui.homepage.HomePageListItem

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
                    breakpoint = 6
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
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "brooch",
                    chinese = "n.[C] 女用胸針",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "jewel",
                    chinese = "n.[C] 珠寶",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "bracelet",
                    chinese = "n.[C] 手鐲",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "cosmetic",
                    chinese = "n.[C] 化妝品，美容品",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "lipstick",
                    chinese = "n.[C/U] 口紅",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "wig",
                    chinese = "n.[C] （女用）假髮",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "hairdo",
                    chinese = "n.[C] 髮型",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "wreath",
                    chinese = "n.[C] 花環",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "bouquet",
                    chinese = "n.[C] 花束",
                    breakpoint = 6
                ),
            ),
        ),
        VocabularySetModel(
            id = 1,
            name = "烹飪",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "broil",
                    chinese = "vt.（直接在熱源上）烤",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "roast",
                    chinese = "vt./vi. 烘，烤",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "grill",
                    chinese = "vt.（用烤架）烤（食物）",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "simmer",
                    chinese = "vt./vi. 用小火煮",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "stew",
                    chinese = "vt. 燉",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "grind",
                    chinese = "vt./vi. 研磨，磨碎",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "mill",
                    chinese = "vt. 碾碎",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "mash",
                    chinese = "vt. 搗碎",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "whisk",
                    chinese = "vt. 攪拌",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "scramble",
                    chinese = "vt. 炒蛋",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "marinate",
                    chinese = "vt. 醃漬(用油、香料、酒)",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "pickle",
                    chinese = "vt. 醃漬(用鹽巴、醋)",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "ferment",
                    chinese = "vt./vi. 發酵",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "braise",
                    chinese = "vt. 燉",
                    breakpoint = 6
                ),
            ),
        ),
        VocabularySetModel(
            id = 2,
            name = "農牧",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "agriculture",
                    chinese = "n.[U] 農業",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "rural",
                    chinese = "adj. 鄉村的",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "peasant",
                    chinese = "n.[C]（較為貧窮的）農夫，佃農",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "plow",
                    chinese = "n.[C] 犁",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "barn",
                    chinese = "n.[C] 穀倉",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "greenhouse",
                    chinese = "n.[C] 溫室",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "organic",
                    chinese = "adj. 有機的",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "fertilizer",
                    chinese = "n.[C] 肥料",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "barren",
                    chinese = "adj. 荒蕪的",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "pesticide",
                    chinese = "n.[C] 殺蟲劑",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "harvest",
                    chinese = "n.[C] 收成",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "ranch",
                    chinese = "n.[C] 大農場，大牧場",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "dairy",
                    chinese = "n.[U] 酪農",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "shepherd",
                    chinese = "n.[C] 牧羊人",
                    breakpoint = 6
                ),
            ),
        ),
        VocabularySetModel(
            id = 3,
            name = "運動",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "badminton",
                    chinese = "n.[U] 羽毛球",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "hike",
                    chinese = "n./vi. 健行",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "dive",
                    chinese = "vi. 跳水，潛水",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "surf",
                    chinese = "vi. 衝浪",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "marathon",
                    chinese = "n.[C] 馬拉松",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "relay",
                    chinese = "n.[C] 接力賽",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "yoga",
                    chinese = "n.[U] 瑜珈",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "boxing",
                    chinese = "n.[U] 拳擊",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "wrestle",
                    chinese = "vi. 摔角，角力",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "stunt",
                    chinese = "n.[C] 特技",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "football",
                    chinese = "n.[U] 美式足球",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "hockey",
                    chinese = "n.[U] 曲棍球",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "volleyball",
                    chinese = "n.[U] 排球",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "ballet",
                    chinese = "n.[U] 籃球",
                    breakpoint = 6
                ),
            ),
        ),
        VocabularySetModel(
            id = 4,
            name = "生病",
            image = Uri.parse("https://www.google.com"),
            vocabularySet = listOf(
                Vocabulary(
                    id = 0,
                    word = "stroke",
                    chinese = "n.[C] 中風",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 1,
                    word = "tumor",
                    chinese = "n.[C] 腫瘤",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 2,
                    word = "measles",
                    chinese = "n.[pl] 麻疹",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 3,
                    word = "asthma",
                    chinese = "n.[U] 氣喘",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 4,
                    word = "allergy",
                    chinese = "n.[C] 過敏",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 5,
                    word = "malaria",
                    chinese = "n.[U] 瘧疾",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 6,
                    word = "trauma",
                    chinese = "n.[U/C] 心理創傷",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 7,
                    word = "paralyze",
                    chinese = "vt. 使癱瘓",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 8,
                    word = "irritation",
                    chinese = "n.[U] 發炎",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 9,
                    word = "deteriorate",
                    chinese = "vi. 惡化",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 10,
                    word = "disorder",
                    chinese = "n.[U] (身體功能）失調",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 11,
                    word = "upset",
                    chinese = "adj. 腸胃不適的",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 12,
                    word = "shortsighted",
                    chinese = "adj. 近視的",
                    breakpoint = 6
                ),
                Vocabulary(
                    id = 13,
                    word = "Diarrhea",
                    chinese = "n. 腹瀉",
                    breakpoint = 6
                ),
            ),
        ),
    )
    private val articles: List<ArticleModel> = listOf(
        ArticleModel(
            id = 0,
            name = "Lorem",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C"
            ),
            image = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/330px-Image_created_with_a_mobile_phone.png"),
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac arcu ac lorem vulputate consequat a ut lectus. Vivamus tincidunt purus vel nulla egestas, a semper erat hendrerit. Morbi blandit, diam eget interdum porta, velit eros placerat massa, vitae suscipit magna ante quis magna. In suscipit libero nunc, tincidunt aliquet orci luctus in. Vivamus quis venenatis ligula. Fusce iaculis nisi eget tellus maximus pharetra. Praesent nec justo a felis elementum pharetra. Nulla dui dolor, hendrerit rhoncus blandit ut, blandit nec nisi. Vivamus at facilisis augue. Suspendisse molestie finibus risus, sed pharetra arcu gravida eu. Praesent et pretium urna, et hendrerit nibh. Vestibulum in auctor velit, id luctus lorem. Phasellus accumsan eros gravida massa placerat, iaculis mattis turpis pharetra. Mauris porttitor elit neque, et pellentesque metus mattis ut. In nisi felis, bibendum sit amet tellus id, tempus finibus nulla. Quisque fringilla urna ipsum, sit amet pellentesque metus fringilla eu."
        ),
        ArticleModel(
            id = 1,
            name = "Morbi",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C"
            ),
            image = Uri.parse("https://www.google.com"),
            content = "Morbi tincidunt nunc non elit tempus accumsan. Donec rutrum mollis lacinia. Suspendisse ut ante at tortor rutrum dapibus. Suspendisse porta nisi vel magna sollicitudin, in fermentum sem convallis. Quisque luctus justo eu varius pulvinar. Nullam finibus pellentesque maximus. Nullam sollicitudin elit vitae cursus dignissim. Sed quam nisl, ullamcorper et lorem eget, aliquam interdum quam. Ut sed erat non libero placerat lobortis. Nunc porttitor dui ac eros varius luctus."
        ),
        ArticleModel(
            id = 2,
            name = "Cras",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C"
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
                3 to "C"
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
                3 to "C"
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
                3 to "-1"
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

    fun getHomePageInfo(userid: Int): HomePageInfoModel {
        var articleInfo: MutableList<HomePageInfo> = mutableListOf()
        var vocabularySetInfo: MutableList<HomePageInfo> = mutableListOf()
        var themeInfo: MutableList<HomePageInfo> = mutableListOf()

        articles.forEach{ item->articleInfo.add(HomePageInfo(item.id, item.image, item.name)) }
        vocabularySets.forEach{ item->vocabularySetInfo.add(HomePageInfo(item.id, item.image, item.name)) }
        themeData.forEach{ item->themeInfo.add(HomePageInfo(item.id, item.image, "item.name???")) }

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
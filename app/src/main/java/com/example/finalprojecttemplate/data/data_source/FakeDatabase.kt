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
            name = "Zebrafish",
            answer = mapOf(
                1 to "D",
                2 to "C",
                3 to "A",
                4 to "D"
            ),
            question= mapOf<Int, List<String>>(
                1 to listOf<String>(
                    "1. What can we learn about zebrafish from the passage?",
                    "(A) How they should be studied in labs.",
                    "(B) Where they derive their regenerative ability.",
                    "(C) Why they share humans’ genetic code.",
                    "(D) What they may offer in medical advancements."),
                2 to listOf<String>(
                    "2. Which of the following statements is true regarding GABA in zebrafish?",
                    "(A) Increasing GABA level facilitates neuron activities.",
                    "(B) There is a high level of GABA in the brain of zebrafish.",
                    "(C) Lowering GABA levels in the brain can stimulate retina regrowth.",
                    "(D) GABA contains chemical elements that trigger the growth of neurons."),
                3 to listOf<String>(
                    "3. Which of the following is closest in meaning to “replicated” in the third paragraph?",
                    "(A) Reproduced.",
                    "(B) Reassembled.",
                    "(C) Recycled.",
                    "(D) Restored."),
                4 to listOf<String>(
                    "4. According to the passage, which of the following is an opinion, but NOT a fact?",
                    "(A) Humans and zebrafish have 70 percent of genes in common.",
                    "(B) Zebrafish can quickly recover vision after damage to the retina.",
                    "(C) Scientists are testing if the GABA theory works on mice as it does on zebrafish.",
                    "(D) Understanding regeneration in zebrafish may allow humans to regrow their organs.")
            ),
            image = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/330px-Image_created_with_a_mobile_phone.png"),
            content = "     Zebrafish, named for their characteristic stripes, have been a popular test subject for researchers. Only " +
                    "a few centimeters in length, the fish breed easily in captivity, grow quickly, and their transparent body " +
                    "makes it easy to study their organs. Above all, they possess some amazing “self-healing” power. When part " +
                    "of their heart is removed, they can grow it back in a matter of weeks. When blinded, they can quickly regain " +
                    "the ability to see.\n" +
                    "       Recent studies show that humans and zebrafish have the same major organs and share 70 percent of " +
                    "the genes. Moreover, 84 percent of human genes associated with disease find a counterpart in zebrafish. " +
                    "Scientists thus hope that understanding the self-healing mystery of the fish may one day allow humans to " +
                    "regenerate such organs as eyes, hearts, and spines.\n" +
                    "       Researchers at Vanderbilt University are particularly interested in zebrafish retina regeneration. They " +
                    "have learned that damage of retina can cause blindness in zebrafish, yet it only takes about three to four " +
                    "weeks before vision is restored. The structure and cell types of zebrafish retinas are almost identical to those " +
                    "of humans. If the process can be replicated in humans, it may give rise to new treatments for blindness " +
                    "caused by retinal damage.\n" +
                    "       In order to know exactly how zebrafish retina is regenerated, the team looked at the neurotransmitter " +
                    "gamma-aminobutyric acid (GABA), a chemical messenger in the brain that reduces the activity of neurons. " +
                    "They found that lowering GABA levels in zebrafish can trigger retina regeneration, while a high level of " +
                    "GABA concentration will suppress the regeneration process. This suggested that GABA plays an important " +
                    "role in the fish’s ability to regain their sight.\n" +
                    "       The team is beginning to test the GABA theory on mice. If that works, human trials will be next on " +
                    "the agenda. If the research proves successful in humans, some of the nearly 40 million blind people " +
                    "worldwide may one day have a tiny, striped fish to thank."
        ),
        ArticleModel(
            id = 1,
            name = "Hard Hat",
            answer = mapOf(
                1 to "D",
                2 to "A",
                3 to "B",
                4 to "B"
            ),
            question= mapOf<Int, List<String>>(
                1 to listOf<String>(
                    "1. Which of the following aspects about hard hats is NOT discussed in the passage?",
                    "(A) Their functions.",
                    "(B) Their appearances.",
                    "(C) Their materials.",
                    "(D) Their limitations."),
                2 to listOf<String>(
                    "2. In what order did the following protective hats appear?\n"+
                    "a. fiberglass hats\n"+
                    "b. hats with see-through shields\n"+
                    "c. hats with canvas and leather\n"+
                    "d. hats with tar over them",
                    "(A) d\uF0E0c\uF0E0a\uF0E0b ",
                    "(B) c\uF0E0d\uF0E0b\uF0E0a",
                    "(C) c\uF0E0b\uF0E0a\uF0E0d",
                    "(D) d\uF0E0c\uF0E0b\uF0E0a"),
                3 to listOf<String>(
                    "3. According to the passage, which of the following statements is true about the hard hat?\n",
                    "(A) Global sales have doubled every ten years.",
                    "(B) The inspiration came from the inventor’s wartime experience.",
                    "(C) It was standard equipment for construction workers in the 1920s.",
                    "(D) Different colors are used in different industries to signal the roles of people on site."),
                4 to listOf<String>(
                    "4. Which of the following words are used in the passage to refer to the hard hat?\n"+
                    "a. tool b. code c. device d. helmet e. accessory f. headgear",
                    "(A) a, b, d, e ",
                    "(B) a, c, d, f ",
                    "(C) c, d, e, f ",
                    "(D) a, d, e, f ")
            ),
            image = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/330px-Image_created_with_a_mobile_phone.png"),
            content = "     A hard hat is a helmet used mostly at worksites to protect the head from injuries due to falling objects." +
                    "Since its introduction in the early 20th century, the headgear has saved countless lives and is considered the" +
                    "number one safety tool for construction workers.\n" +
                    "       The hard hat was invented in 1919 by Edward W. Bullard, who had just returned from World War I." +
                    "Before the war, workers used to smear their hats with coal tar for protection of their head. Bullard, having" +
                    "witnessed the life-saving power of the metal helmet in the War, decided to produce a head protection device" +
                    "that was affordable for every worker and lightweight enough to be worn all day long. The Hard Boiled Hat" +
                    "was thus born, using steamed canvas and leather, covered with black paint, and featuring a suspension" +
                    "system to reduce impact. Soon, hard hats became widely used. The headgear was later made mandatory at" +
                    "construction sites in major construction projects, such as the Hoover Dam in 1931 and the Golden Gate" +
                    "Bridge in 1933.\n" +
                    "       Over the past century, hard hats have advanced considerably, evolving from canvas and leather to" +
                    "aluminum, fiberglass, and, eventually, to thermoplastic. Recently, new models have been introduced and" +
                    "accessories added to meet the needs of laborers working on various job sites. For instance, a ventilated hard" +
                    "hat was developed to keep wearers cooler, and see-through face shields were attached to better see the" +
                    "hazards lurking above. Today, attachments include radios, sensors, cameras, and a lot more. A common" +
                    "color code has also been developed for recognizing people and their roles on site. Yellow is used for general" +
                    "laborers and contractors, white (or sometimes black) for supervisors and managers, and green for inspectors" +
                    "and new workers.\n" +
                    "       New products continue to expand the market. Global sales of hard hats totaled USD 2.1 billion in 2016," +
                    "and are expected to reach USD 3.19 billion in 2025."
        ),
        ArticleModel(
            id = 2,
            name = "Cactus",
            answer = mapOf(
                1 to "B",
                2 to "D",
                3 to "D",
                4 to "B"
            ),
            question= mapOf<Int, List<String>>(
                1 to listOf<String>(
                    "1. What is the purpose of this passage?",
                    "(A) To argue for the benefits of nopales.",
                    "(B) To introduce a new source of energy.",
                    "(C) To predict the future agriculture policy of Mexico.",
                    "(D) To change people’s ideas about energy consumption."),
                2 to listOf<String>(
                    "2. Which of the following is NOT mentioned as a function of the prickly pear?",
                    "(A) For treating illnesses.",
                    "(B) For personal hygiene.",
                    "(C) For food and beverage.",
                    "(D) For gardening and landscaping."),
                3 to listOf<String>(
                    "3. Which of the following statements about the prickly pear cactus is true?",
                    "(A) Its soft inner part is often discarded.",
                    "(B) It was not discovered until the modern era.",
                    "(C) It turns into 200,000 tons of waste in Mexico each year.",
                    "(D) It appears in a prominent place on Mexico’s national flag."),
                4 to listOf<String>(
                    "4. What advantage does the prickly pear cactus have over other biofuel crops?",
                    "(A) It generates more energy.",
                    "(B) It will not influence food prices.",
                    "(C) It may replace feed for livestock.",
                    "(D) It can increase global food production.")
            ),
            image = Uri.parse("https://www.google.com"),
            content = "     The prickly pear cactus is such a powerful symbol in Mexico that it occupies a prime spot on Mexico’s" +
                    "national flag. The plant was considered sacred by the ancient Aztecs, and modern-day Mexicans eat it," +
                    "drink it, and even use it in medicines and shampoos. Now scientists have come up with a new use for the" +
                    "bright green plant: producing renewable energy.\n" +
                    "       Known locally as nopal, the prickly pear is farmed on a massive scale in Mexico. Over the years, only" +
                    "the edible soft inner flesh has been used. The cactus’s thick outer layer (i.e., husk), with all those spines," +
                    "had always been viewed as a waste product until researchers developed a biogas generator to turn the husks" +
                    "into electricity.\n" +
                    "       The pilot project dedicated to developing the cactus biogas generator began in the south of Mexico" +
                    "City. The area produces 200,000 tons a year of prickly pear cactus—up to 10 tons of which ends up as" +
                    "waste on the floor of the cactus market each day. Then, a local green energy startup company got the idea" +
                    "to turn that waste into energy. The generator is now in place at the cactus market, where the vendors are" +
                    "enthusiastic about this new way to utilize the tons of cactus husks that once went directly into the trash.\n" +
                    "       The prickly pear has a number of advantages over other biofuel crops, such as wheat, sugarcane, and" +
                    "soybeans. For one thing, only the husk of the cactus is used for generating biofuel, while its inner flesh is" +
                    "still preserved for food. Therefore, using the plant as a fuel source will not put pressure on food prices." +
                    "Moreover, the cactus requires minimum water, and thus is not grown on traditional agricultural pasture." +
                    "This means that no increased competition arises for the water or land presently used for food production." +
                    "The project in Mexico City has brought new hope to reducing the use of fossil fuels. If it can be" +
                    "expanded, the prickly pear could be the key to Mexico’s energy future"
        ),
        ArticleModel(
            id = 3,
            name = "Travel Document",
            answer = mapOf(
                1 to "A",
                2 to "B",
                3 to "C",
                4 to "D"
            ),
            question= mapOf<Int, List<String>>(
                1 to listOf<String>(
                    "1. How is the information in the passage organized?",
                    "(A) In order of time.",
                    "(B) By cause and effect.",
                    "(C) In order of importance",
                    "(D) By definition and illustration."),
                2 to listOf<String>(
                    "2. Which of the following statements is true about the earliest travel document?",
                    "(A) It was issued by the king of Judah.",
                    "(B) It was given to an official of Persia",
                    "(C) It appeared more than three thousand years ago.",
                    "(D) It served to invite people to travel beyond the river."),
                3 to listOf<String>(
                    "3. When did the term “passport” start being used?",
                    "(A) In about 450 B.C.",
                    "(B) During World War I",
                    "(C)  In the 16th century",
                    "(D) During King Henry V’s reign."),
                4 to listOf<String>(
                    "4. Which of the following is NOT mentioned in the passage as a form of passport?",
                    "(A) A letter",
                    "(B) A receipt. ",
                    "(C) A proof of identity.",
                    "(D) A list of seaports.")
            ),
            image = Uri.parse("https://www.google.com"),
            content = "     The concept of a travel document, which shows a person is under a ruler’s protection while in a foreign" +
                    "land, has probably existed since rulers and states were first invented. But the earliest mention of an object" +
                    "which we might recognize as a passport appeared in about 450 B.C. The Hebrew Bible states that Nehemiah," +
                    "an official serving King Artaxerxes of ancient Persia, asked permission to travel to Judah. The King agreed" +
                    "and gave Nehemiah a letter “to the governors of the province beyond the river,” requesting safe passage for" +
                    "him as he travelled through their lands.\n" +
                    "       Later, in the medieval Islamic Caliphate, a form of passport was the bara’a, a receipt for taxes paid." +
                    "Only people who paid their taxes were permitted to travel to different regions of the Caliphate. In medieval" +
                    "Europe, on the other hand, travel documents were issued by local authorities, and generally contained a list" +
                    "of towns and cities which the document holder was permitted to enter or pass through. On the whole," +
                    "documents were not required for travel to seaports, which were considered open trading points, but" +
                    "documents were required to travel inland from seaports.\n" +
                    "       King Henry V of England is credited with having invented the first true passport, as a way of helping" +
                    "his subjects prove who they were in foreign lands. The earliest reference to these documents is found in a" +
                    "15th-century Act of Parliament, while the term “passport” came into use about a century later. Nevertheless," +
                    "passports were not generally required for international travel until the First World War. It was at this time" +
                    "that passports as we would recognize them today began to be used."
        ),
        ArticleModel(
            id = 4,
            name = "Olive Oil",
            answer = mapOf(
                1 to "D",
                2 to "D",
                3 to "C",
                4 to "B"
            ),
            question= mapOf<Int, List<String>>(
                1 to listOf<String>(
                    "1. What is the passage mainly about?",
                    "(A) The flavor of olive oil.",
                    "(B) The trade of olive oil.",
                    "(C) The promotion of olive oil.",
                    "(D) The quality of olive oil."),
                2 to listOf<String>(
                    "2.  Which of the following statements is true about extra virgin olive oil?",
                    "(A) It is free from any bitter flavor.",
                    "(B) It is refined to remove its impurities.",
                    "(C) It requires mixing of more than one kind of oil.",
                    "(D) It has a lower acidity rate than virgin olive oil."),
                3 to listOf<String>(
                    "3. According to the passage, what is the best way to store olive oil?",
                    "(A) In a plastic container in a damp cellar.",
                    "(B) In a clear glass bottle near the kitchen stove.",
                    "(C) In an airtight glass bottle in a kitchen cupboard.",
                    "(D) In an airproof bottle next to a well-lighted window."),
                4 to listOf<String>(
                    "4. What is the IOC trying to do?",
                    "(A) Train more qualified olive oil tasters.",
                    "(B) Improve the ways of grading olive oil.",
                    "(C) Look for new techniques to boost production.",
                    "(D) Build better connections among industry members.")
            ),
            image = Uri.parse("https://www.google.com"),
            content = "     Probably the most widely used oil in cooking, olive oil is made by crushing olives with stone or steel" +
                    "blades to release the oil. Extra virgin oil, the finest grade, is made from the first pressing of the olives and" +
                    "has a very low acidity rate (under 1%). To be qualified as “extra virgin,” the oil must also pass both an" +
                    "official test in a laboratory and a sensory evaluation by a trained tasting panel. It must be free from impurity," +
                    "while exhibiting some fruitiness and creating a pleasant bitter flavor along with a peppery sensation in the" +
                    "mouth. Second on the ranking is virgin olive oil. It is also a first pressing, but has a slightly higher acidity" +
                    "level (under 2%). Lastly, pure olive oil is the cheapest olive oil. It is refined to remove its impurities and" +
                    "blended to improve flavor, and is recommended for all-purpose cooking.\n" +
                    "       Packaging and storage also have an impact on the quality of olive oil. Olive oil spoils quickly when" +
                    "exposed to direct sunlight, so it should be stored in the dark at 16-18°C. Moisture and oxygen promote" +
                    "oxidation and therefore limit its shelf life. Plastic containers usually do not provide adequate protection" +
                    "from light, heat, or moisture; additionally, small particles in plastics can leak into the oil, which further" +
                    "reduces its quality.\n" +
                    "   Olive oil tasters have long adopted descriptive terms such as “pure” and “light” to evaluate the quality" +
                    "of olive oil. Recently, however, the International Olive Council (IOC) is seeking input on test methods to" +
                    "improve the transparency of the testing process and boost the accuracy of the results. A redefinition of the" +
                    "term “olive oil” is also proposed to make a clear distinction between virgin olive oil and pure olive oil." +
                    "Industry members of the IOC hope to promote the trade of olive oil by initiating these changes."
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
                    word = "artwork",
                    chinese = "藝術品",
                    positionForClickButton = Coordinate(150.0f, 150.5f)
                ),
                VocabularyForTheme(
                    id = 1,
                    word = "artwork",
                    chinese = "藝術品",
                    positionForClickButton = Coordinate(120.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 2,
                    word = "floor lamp",
                    chinese = "落地燈",
                    positionForClickButton = Coordinate(130.0f, 130.0f)
                ),
                VocabularyForTheme(
                    id = 3,
                    word = "sofa",
                    chinese = "沙發",
                    positionForClickButton = Coordinate(100.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 4,
                    word = "potted houseplants",
                    chinese = "室內盆栽植物",
                    positionForClickButton = Coordinate(50.0f, 150.0f)
                ),
                VocabularyForTheme(
                    id = 5,
                    word = "rug",
                    chinese = "小地毯",
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

    suspend fun getArticleByIndex(index: Int): ArticleModel {
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
            question = mapOf<Int, List<String>>(
                1 to listOf<String>("-1", "-1", "-1", "-1", "-1"),
                2 to listOf<String>("-1", "-1", "-1", "-1", "-1"),
                3 to listOf<String>("-1", "-1", "-1", "-1", "-1"),
                4 to listOf<String>("-1", "-1", "-1", "-1", "-1")
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

    suspend fun getThemeData(index: Int): ThemeDataModel {
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
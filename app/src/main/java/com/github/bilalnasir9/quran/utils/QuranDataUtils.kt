package com.github.bilalnasir9.quran.utils

import com.github.bilalnasir9.quran.models.QuranModel


object QuranDataUtils {

    fun allSurah():ArrayList<QuranModel>{
        val list = ArrayList<QuranModel>()
        list.add(QuranModel(englishName = "Fatiha", pageNumber = "2", arabicName = "الفاتحة"))
        list.add(QuranModel(englishName = "Al-Baqarah", pageNumber = "3", arabicName = "اﻟﺒﻘﺮﺓ"))
        list.add(QuranModel(englishName = "Aale-Imran", pageNumber = "51", arabicName = "اۤل عمران"))
        list.add(QuranModel(englishName = "An-Nisa", pageNumber = "78", arabicName = "اﻟﻨﺴﺄ"))
        list.add(QuranModel(englishName = "Al-Maidah", pageNumber = "107", arabicName = "المائدة"))
        list.add(QuranModel(englishName = "Al-Anam", pageNumber = "129", arabicName = "الأنعام"))
        list.add(QuranModel(englishName = "Al-Araf", pageNumber = "152", arabicName = "الأعراف"))
        list.add(QuranModel(englishName = "Al-Anfal", pageNumber = "178", arabicName = "الأنفال"))
        list.add(QuranModel(englishName = "At-Tawbah", pageNumber = "188", arabicName = "التوبة"))
        list.add(QuranModel(englishName = "Yunus", pageNumber = "209", arabicName = "يونس"))
        list.add(QuranModel(englishName = "Hud", pageNumber = "222", arabicName = "هود"))
        list.add(QuranModel(englishName = "Yusuf",  pageNumber = "236", arabicName = "يوسف "))
        list.add(QuranModel(englishName = "Ar-Rad", pageNumber = "(250)", arabicName = "الرعد"))
        list.add(QuranModel(englishName = "Ibrahim", pageNumber = "(256)",arabicName = "ابراهيم"))
        list.add(QuranModel(englishName = "Al-Hijr", pageNumber = "(262)", arabicName = "الحجر"))
        list.add(QuranModel(englishName = "An-Nahl", pageNumber = "(268)", arabicName = "النحل"))
        list.add(QuranModel(englishName = "Al-Isra", pageNumber = "(283)", arabicName = "الإسرﺃ"))
        list.add(QuranModel(englishName = "Al-Kahf", pageNumber = "(294)", arabicName = "الكهف"))
        list.add(QuranModel(englishName = "Maryam", pageNumber = "(306)", arabicName = "مريم"))
        list.add(QuranModel(englishName = "Taha", pageNumber = "(313)", arabicName = "طه"))
        list.add(QuranModel(englishName = "Al-Anbiya", pageNumber = "(323)", arabicName = "اﻷﻧﺒﻴﺄ"))
        list.add(QuranModel(englishName = "Al-Hajj", pageNumber = "(332)", arabicName = "الحج"))
        list.add(QuranModel(englishName = "Al-Muminun", pageNumber = "(343)", arabicName = "المؤمنون"))
        list.add(QuranModel(englishName = "An-Nur", pageNumber = "(351)", arabicName = "النور"))
        list.add(QuranModel(englishName = "Al-Furqan", pageNumber = "(360)", arabicName = "الفرقان"))
        list.add(QuranModel(englishName = "Ash-Shuara", pageNumber = "(367)", arabicName = "الشعرﺃ"))
        list.add(QuranModel(englishName = "An-Naml", pageNumber = "(377)", arabicName = "النمل"))
        list.add(QuranModel(englishName = "Al-Qasas", pageNumber = "(386)", arabicName = "القصص"))
        list.add(QuranModel(englishName = "Al-Ankabut", pageNumber = "(397)", arabicName = "العنكبوت"))
        list.add(QuranModel(englishName = "Ar-Rum", pageNumber = "(405)", arabicName = "الروم"))
        list.add(QuranModel(englishName = "Luqman", pageNumber = "(412)", arabicName = "لقمان"))
        list.add(QuranModel(englishName = "As-Sajdah", pageNumber = "(416)", arabicName = "السجدة"))
        list.add(QuranModel(englishName = "Al-Ahzab", pageNumber = "(419)", arabicName = "الأحزاب"))
        list.add(QuranModel(englishName = "Saba", pageNumber = "(429)", arabicName = "ﺳﺒﺄ"))
        list.add(QuranModel(englishName = "Fatir", pageNumber = "(435)",arabicName = "الفاطر"))
        list.add(QuranModel(englishName = "Yaseen", pageNumber = "(441)",arabicName = "يٰسن"))
        list.add(QuranModel(englishName = "As-Saffat", pageNumber = "(446)", arabicName = "الصافات"))
        list.add(QuranModel(englishName = "Saad", pageNumber = "(453)",arabicName = "صۤ"))
        list.add(QuranModel(englishName = "Az-Zumar", pageNumber = "(459)", arabicName = "الزمر"))
        list.add(QuranModel(englishName = "Al-Ghafir", pageNumber = "(468)", arabicName = "غافر"))
        list.add(QuranModel(englishName = "Fussilat", pageNumber = "(478)",arabicName = "فصلت"))
        list.add(QuranModel(englishName = "Ash-Shura", pageNumber = "(484)", arabicName = "الشورى"))
        list.add(QuranModel(englishName = "Az-Zukhruf", pageNumber = "(490)", arabicName = "الزخرف"))
        list.add(QuranModel(englishName = "Ad-Dukhan", pageNumber = "(496)", arabicName = "الدخان"))
        list.add(QuranModel(englishName = "Al-Jathiyah", pageNumber = "(499)", arabicName = "الجاثية"))
        list.add(QuranModel(englishName = "Al-Ahqaf", pageNumber = "(503)", arabicName = "الأحقاف"))
        list.add(QuranModel(englishName = "Al-Muhammad", pageNumber = "(507)", arabicName = "محمد"))
        list.add(QuranModel(englishName = "Al-Fath", pageNumber = "(512)", arabicName = "الفتح"))
        list.add(QuranModel(englishName = "Al-Hujurat", pageNumber = "(516)", arabicName = "الحجرات"))
        list.add(QuranModel(englishName = "Qaf", pageNumber = "(519)",arabicName = "ق"))
        list.add(QuranModel(englishName = "Adh-Dhariyat", pageNumber = "(521)", arabicName = "الذاريات"))
        list.add(QuranModel(englishName = "At-Tur", pageNumber = "(524)", arabicName = "الطور"))
        list.add(QuranModel(englishName = "An-Najm", pageNumber = "(527)", arabicName = "النجم"))
        list.add(QuranModel(englishName = "Al-Qamar", pageNumber = "(529)", arabicName = "القمر"))
        list.add(QuranModel(englishName = "Ar-Rahman", pageNumber = "(532)", arabicName = "الرحمن"))
        list.add(QuranModel(englishName = "Al-Waqiah", pageNumber = "(535)", arabicName = "الواقعة"))
        list.add(QuranModel(englishName = "Al-Hadid", pageNumber = "(538)", arabicName = "الحديد"))
        list.add(QuranModel(englishName = "Al-Mujadilah", pageNumber = "(543)", arabicName = "المجادلة"))
        list.add(QuranModel(englishName = "Al-Hashr", pageNumber = "(546)", arabicName = "الحشر"))
        list.add(QuranModel(englishName = "Al-Mumtahinah", pageNumber = "(550)", arabicName = "الممتحنة"))
        list.add(QuranModel(englishName = "As-Saf", pageNumber = "(552)", arabicName = "الصف"))
        list.add(QuranModel(englishName = "Al-Jumuah", pageNumber = "(554)", arabicName = "الجمعة"))
        list.add(QuranModel(englishName = "Al-Munafiqun", pageNumber = "(555)", arabicName = "المنافقون"))
        list.add(QuranModel(englishName = "At-Taghabun", pageNumber = "(557)", arabicName = "التغابن"))
        list.add(QuranModel(englishName = "Al-Talaq", pageNumber = "(559)", arabicName = "الطلاق"))
        list.add(QuranModel(englishName = "Al-Tahrim", pageNumber = "(561)", arabicName = "التحريم"))
        list.add(QuranModel(englishName = "Al-Mulk", pageNumber = "(563)", arabicName = "الملك"))
        list.add(QuranModel(englishName = "Al-Qalam", pageNumber = "(565)", arabicName = "القلم"))
        list.add(QuranModel(englishName = "Al-Haqqah", pageNumber = "(568)", arabicName = "الحاقة"))
        list.add(QuranModel(englishName = "Al-Maarij", pageNumber = "(570)", arabicName = "المعارج"))
        list.add(QuranModel(englishName = "Nuh", pageNumber = "(572)", arabicName = "نوح"))
        list.add(QuranModel(englishName = "Al-Jinn", pageNumber = "(574)", arabicName = "الجن"))
        list.add(QuranModel(englishName = "Al-Muzzammil", pageNumber = "(577)", arabicName = "المزمل"))
        list.add(QuranModel(englishName = "Al-Muddaththir", pageNumber = "(579)", arabicName = "المدثر"))
        list.add(QuranModel(englishName = "Al-Qiyamah", pageNumber = "(581)", arabicName = "القيامة"))
        list.add(QuranModel(englishName = "Al-Dahr", pageNumber = "(583)", arabicName = "الإنسان"))
        list.add(QuranModel(englishName = "Al-Mursalat", pageNumber = "(585)", arabicName = "المرسلات"))
        list.add(QuranModel(englishName = "Al-Naba", pageNumber = "(587)", arabicName = "النبأ"))
        list.add(QuranModel(englishName = "Al-Naziat", pageNumber = "(588)", arabicName = "النازعات"))
        list.add(QuranModel(englishName = "Al-Abasa", pageNumber = "(590)", arabicName = "عبس"))
        list.add(QuranModel(englishName = "Al-Takwir", pageNumber = "(591)", arabicName = "التكوير"))
        list.add(QuranModel(englishName = "Al-Infitar", pageNumber = "(592)", arabicName = "لإنفتار"))
        list.add(QuranModel(englishName = "Al-Mutaffifin", pageNumber = "(593)", arabicName = "المطففين"))
        list.add(QuranModel(englishName = "Al-Inshiqaq", pageNumber = "(595)", arabicName = "اﻹنشقاق"))
        list.add(QuranModel(englishName = "Al-Buruj", pageNumber = "(596)", arabicName = "البروج"))
        list.add(QuranModel(englishName = "Al-Tariq", pageNumber = "(597)", arabicName = "الطارق"))
        list.add(QuranModel(englishName = "Al-Aala", pageNumber = "(598)", arabicName = "الأعلى"))
        list.add(QuranModel(englishName = "Al-Ghashiyah", pageNumber = "(598)", arabicName = "الغاشية"))
        list.add(QuranModel(englishName = "Al-Fajr", pageNumber = "(599)", arabicName = "الفجر"))
        list.add(QuranModel(englishName = "Al-Balad", pageNumber = "(601)", arabicName = "البلد"))
        list.add(QuranModel(englishName = "Al-Shams", pageNumber = "(601)", arabicName = "الشمس"))
        list.add(QuranModel(englishName = "Al-Layl", pageNumber = "(602)", arabicName = "الليل"))
        list.add(QuranModel(englishName = "Al-Duha", pageNumber = "(603)", arabicName = "الضحى"))
        list.add(QuranModel(englishName = "Al-Inshirah", pageNumber = "(603)", arabicName = "اﻹﻧﺸﺮﺡ"))
        list.add(QuranModel(englishName = "Al-Tin", pageNumber = "(604)", arabicName = "التين"))
        list.add(QuranModel(englishName = "Al-Alaq", pageNumber = "(604)", arabicName = "العلق"))
        list.add(QuranModel(englishName = "Al-Qadr", pageNumber = "(605)", arabicName = "القدر"))
        list.add(QuranModel(englishName = "Al-Bayyinah", pageNumber = "(605)", arabicName = "البينة"))
        list.add(QuranModel(englishName = "Al-Zalzalah", pageNumber = "(606)", arabicName = "الزلزلة"))
        list.add(QuranModel(englishName = "Al-Adiyat", pageNumber = "(606)", arabicName = "العاديات"))
        list.add(QuranModel(englishName = "Al-Qariah", pageNumber = "(607)", arabicName = "القارعة"))
        list.add(QuranModel(englishName = "Al-Takathur", pageNumber = "(607)", arabicName = "التكاثر"))
        list.add(QuranModel(englishName = "Al-Asr", pageNumber = "(608)", arabicName = "العصر"))
        list.add(QuranModel(englishName = "Al-Humazah", pageNumber = "(608)", arabicName = "الهمزة"))
        list.add(QuranModel(englishName = "Al-Fil", pageNumber = "(608)", arabicName = "الفيل"))
        list.add(QuranModel(englishName = "Al-Quraysh", pageNumber = "(609)", arabicName = "قريش"))
        list.add(QuranModel(englishName = "Al-Maun", pageNumber = "(609)", arabicName = "الماعون"))
        list.add(QuranModel(englishName = "Al-Kawthar", pageNumber = "(609)", arabicName = "الكوثر"))
        list.add(QuranModel(englishName = "Al-Kafirun", pageNumber = "(609)", arabicName = "الكافرون"))
        list.add(QuranModel(englishName = "Al-Nasr", pageNumber = "(610)", arabicName = "النصر"))
        list.add(QuranModel(englishName = "Al-Masad", pageNumber = "(610)", arabicName = "المسد"))
        list.add(QuranModel(englishName = "Al-Ikhlas", pageNumber = "(610)", arabicName = "الإخلاص"))
        list.add(QuranModel(englishName = "Al-Falaq", pageNumber = "(611)", arabicName = "الفلق"))
        list.add(QuranModel(englishName = "Al-Nas", pageNumber = "(611)", arabicName = "الناس"))



        return list
    }


    fun allParas():ArrayList<QuranModel>{
        val list = ArrayList<QuranModel>()
        list.add(QuranModel(englishName = "Alif Laam Meem", pageNumber = "3", arabicName = "آلم"))
        list.add(QuranModel(englishName = "Sayaqūl", pageNumber = "(23)",arabicName = "سيقول السفهاء"))
        list.add(QuranModel(englishName = "Tilka -r-rusul", pageNumber = "(43)",arabicName = "تلك الرسل"))
        list.add(QuranModel(englishName = "Lan Tana Lu", pageNumber = "(63)",arabicName = "لن تنالوا"))
        list.add(QuranModel(englishName = "W-al-muḥṣanāt", pageNumber = "(83)" , arabicName = "والمحصنات"))
        list.add(QuranModel(englishName = "Lā yuẖibbu-llāh", pageNumber = "(103)", arabicName = "لا يحب الله"))
        list.add(QuranModel(englishName = "Wa ʾidha samiʿū", pageNumber = "(123)",arabicName = "وإذا سمعوا"))
        list.add(QuranModel(englishName = "Wa law ʾannanā", pageNumber = "(143)",arabicName = "ولو أننا"))
        list.add(QuranModel(englishName = "Qāl al-malāʾ", pageNumber = "(163)",arabicName = "قال الملأ"))
        list.add(QuranModel(englishName = "W-aʿlamū", pageNumber = "(183)", arabicName = "واعلموا"))
        list.add(QuranModel(englishName = "Yaʾtadhirūna", pageNumber = "(203)", arabicName = "يعتذرون"))
        list.add(QuranModel(englishName = "Wa mā min dābbah", pageNumber = "(223)",arabicName = "ومامن دابة"))
        list.add(QuranModel(englishName = "Wa mā ʾubarriʾu", pageNumber = "(243)", arabicName = "وما أبرئ "))
        list.add(QuranModel(englishName = "Ruba Maʾ", pageNumber = "(263)", arabicName = "ربما"))
        list.add(QuranModel(englishName = "Subḥāna -lladh", pageNumber = "(283)",arabicName = "سبحٰن     الذیٓ"))
        list.add(QuranModel(englishName = "Qāla ʾa-lam", pageNumber = "(303)",arabicName = "قال ألم"))
        list.add(QuranModel(englishName = "Iqtaraba li-n-nās", pageNumber = "(323)",arabicName = "اقترب للناس"))
        list.add(QuranModel(englishName = "Qad ʾaflaḥa", pageNumber = "(343)",arabicName = "قد أفلح"))
        list.add(QuranModel(englishName = "Wa-qāla -lladhīna", pageNumber = "(363)",arabicName = "وقال الذين"))
        list.add(QuranModel(englishName = "Amman khalaqa", pageNumber = "(383)",arabicName = "امن خلق"))
        list.add(QuranModel(englishName = "Otlu maa oohiya", pageNumber = "(403)", arabicName = "اتل مآ اوحی"))
        list.add(QuranModel(englishName = "Wa-man yaqnut", pageNumber = "(423)",arabicName = "ومن يقنت"))
        list.add(QuranModel(englishName = "Wama liya", pageNumber = "(443)", arabicName = "ومالی"))
        list.add(QuranModel(englishName = "Fa-man ʾaẓlamu", pageNumber = "(463)",arabicName = "فمن أظلم"))
        list.add(QuranModel(englishName = "Ilaihi yuraddu", pageNumber = "(483)",arabicName = "إليه يرد"))
        list.add(QuranModel(englishName = "Ḥāʾ Mīm", pageNumber = "(503)", arabicName = "حـم"))
        list.add(QuranModel(englishName = "Qāla fa-mā khatbukum", pageNumber = "(523)", arabicName = "قال فما خطبكم"))
        list.add(QuranModel(englishName = "Qad samiʿa -llāhu", pageNumber = "(543)", arabicName = "قد سمع اللہ"))
        list.add(QuranModel(englishName = "Tabāraka -lladhi", pageNumber = "(563)",arabicName = "تبٰرک الذی"))
        list.add(QuranModel(englishName = "Amma", pageNumber = "(587)", arabicName = "عمّ"))


        return list

    }


//    fun findParaName(pageNo:Int):QuranModel?{
//        val list= allParas()
//        list.forEach {
//            val pageNum = it.pageNumber.replace("[()]".toRegex(), "").toInt()
//            showlogD(message = "findParaName: $pageNum")
//            if (pageNum == pageNo){
//                return it
//            }
//        }
//        return null
//    }
//    fun findSurahName(pageNo:Int):QuranModel? {
//        val list = allSurah()
//        list.forEach {
//            val pageNum = it.pageNumber.replace("[()]".toRegex(), "").toInt()
//            if (pageNum == pageNo) {
//                return it
//            }
//        }
//        return null
//    }

}
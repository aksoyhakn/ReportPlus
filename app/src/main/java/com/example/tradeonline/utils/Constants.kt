package com.example.tradeonline.utils

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


object Constants {

    object App {
        const val TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
        const val DB_NAME = "trend-line"
        const val PREF_NAME = "trend-line-pref"
        val REQ_USER_CONSENT = 2020

        enum class LoggedInMode constructor(val type: Int) {
            LOGGED_IN_MODE_LOGGED_OUT(0),
            LOGGED_IN_MODE_PROFILE(1),
            LOGGED_IN_MODE_SERVER(2)
        }
    }


    object Main {
        val EXPERT_DETAIL_USER_FOLLOW = "expert_detail_user_follow"
        val EXPERT_DETAIL_USER_FOLLOW_DETAIL = "expert_detail_user_follow_detail"
        val JOURNAL_DETAIL = "journal_detail"
        val TECHNICAL_ANALYSIS_DETAIL = "technical_analysis_detail"
        val INDICATOR_DETAIL = "indicator_detail"
        val YOUTUBE_URL = "youtube_url"
    }

}
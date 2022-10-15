package com.example.tradeonline.data.preference

import com.example.tradeonline.utils.Constants

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

interface PreferenceHelper {

    fun getLanguage(): String?
    fun setLanguage(languageCode: String?)

    fun getBaseURL(): String?
    fun setBaseURL(languageCode: String?)

    fun getInit(): String?
    fun setInit(init: String?)

    fun getAccessToken(): String?
    fun setAccessToken(languageCode: String?)

    fun getUserInfo(): String?
    fun setUserInfo(userInfo: String?)

    fun getUserID(): String?
    fun setUserID(userID: String?)

    fun getCurrentUserLoggedInMode(): Int
    fun setCurrentUserLoggedInMode(mode: Constants.App.LoggedInMode)

    fun setOpenOnboarding(isOpen: Boolean?)
    fun getOpenOnboarding(): Boolean?
}
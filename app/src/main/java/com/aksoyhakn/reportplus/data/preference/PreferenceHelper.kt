package com.aksoyhakn.reportplus.data.preference

import com.aksoyhakn.reportplus.utils.Constants

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

interface PreferenceHelper {

    fun getAccessToken(): String?
    fun setAccessToken(languageCode: String?)

}
package com.aksoyhakn.reportplus.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.securepreferences.SecurePreferences
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

class PreferenceHelperImp @Inject constructor(
    context: Context,
    prefFileName: String
) : PreferenceHelper {

    companion object {
        const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }

    private val mPrefs: SharedPreferences = SecurePreferences(context, "reportplus", prefFileName)

    override fun getAccessToken(): String? = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "")

    override fun setAccessToken(accessToken: String?) =
        mPrefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }

}
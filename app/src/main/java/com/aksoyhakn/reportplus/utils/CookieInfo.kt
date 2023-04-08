package com.aksoyhakn.reportplus.utils

import java.util.*

object CookieInfo {

    var acceptEncoding: String = "gzip, deflate, br"
    var acceptLanguage: String = "en-US"
    var cacheControl: String = "no-cache"
    var cookie: String = ""
    var contentType: String = "application/json"
    var vary: String = "Cookie,Accept-Language"
    var userAgent: String =
        "Mozilla/5.0 (iPhone; CPU iPhone OS 12_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 Instagram 105.0.0.11.118 (iPhone11,8; iOS 12_3_1; en_US; en-US; scale=2.00; 828x1792; 165586599)"

    fun getHeaders(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        //map["accept-encoding"] = acceptEncoding
        map["accept-language"] = Locale.getDefault().toLanguageTag()
        map["control"] = cacheControl
        map["cookie"] = cookie
        map["Content-Type"] = contentType
        map["Vary"] = vary
        map["user-agent"] = userAgent

        return map
    }

}
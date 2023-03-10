package com.aksoyhakn.reportplus.data.service

import com.aksoyhakn.reportplus.data.preference.PreferenceHelperImp
import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException
import java.net.ProtocolException
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

class LoggingInterceptor @Inject constructor(var preferenceHelperImp: PreferenceHelperImp) :
    Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()


        val requestBuilder = request.newBuilder().method(request.method, request.body)

        if (!preferenceHelperImp.getAccessToken().isNullOrEmpty()) {
            requestBuilder.header(
                "Authorization",
                "Bearer ${preferenceHelperImp.getAccessToken()!!}"
            )
        }

        val newRequest = requestBuilder.build()

        val response: Response
        response = try {
            chain.proceed(newRequest)
        } catch (e: ProtocolException) {
            Response.Builder()
                .request(request)
                .code(204)
                .protocol(Protocol.HTTP_1_1)
                .build()
        }

        var rawJson: String? = null
        try {
            rawJson = response.body?.string()
            Logger.json(rawJson)
        } catch (e: Exception) {
            Logger.e("Null response body")
        }

        return response.newBuilder()
            .body(rawJson.toString().toResponseBody(response.body?.contentType())).build()
    }
}
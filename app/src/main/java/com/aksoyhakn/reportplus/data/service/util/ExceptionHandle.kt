package com.aksoyhakn.reportplus.data.service.util

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

class ExceptionHandle {

    companion object {

        enum class ERROR {
            CONNECT_ERROR,
            SOCKET_TIMEOUT,
            GENERAL_ERROR
        }

        var error: ERROR? = ERROR.GENERAL_ERROR

        fun handleException(e: Throwable?): ERROR? {
            when (e) {

                is SocketTimeoutException -> {
                    error = ERROR.SOCKET_TIMEOUT
                }

                is ConnectException -> {
                    error = ERROR.CONNECT_ERROR
                }

                is UnknownHostException -> {
                    error = ERROR.CONNECT_ERROR
                }
            }
            return error
        }
    }
}

data class ErrorModel(
    var icon: Drawable,
    var title: String?,
    var desription: String?,
    var buttonName: String? = null
)

@Parcelize
data class CategoryModel(
    var id: String?,
    var icon: Int,
    var title: String?,
    var hint: String?
) : Parcelable


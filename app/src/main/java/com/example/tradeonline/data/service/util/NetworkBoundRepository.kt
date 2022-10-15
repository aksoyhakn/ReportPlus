package com.example.tradeonline.data.service.util

import androidx.annotation.MainThread
import com.example.tradeonline.data.service.model.BaseResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

abstract class NetworkBoundRepository<RESULT, REQUEST> {

    fun asFlow() = flow<State<RESULT>> {

        emit(State.loading(true))

        val apiResponse = fetchFromRemote()
        val remotePosts = apiResponse.body()

        if (apiResponse.isSuccessful && remotePosts != null) {
            if (apiResponse.body() is BaseResponse && (
                        (apiResponse.body() as BaseResponse).isBadRequest ||
                                (apiResponse.body() as BaseResponse).isNotFound ||
                                (apiResponse.body() as BaseResponse).isError
                        )
            ) {
                emit(
                    State.apiFail(
                        BaseResponse(
                            (apiResponse.body() as BaseResponse).processStatus,
                            (apiResponse.body() as BaseResponse).friendlyMessage
                        )
                    )
                )
            } else {
                emit(State.success(apiResponse))
            }

        } else {
            if (apiResponse.raw().request.url.toString().contains("connect/token")) {
                emit(State.apiIdentity(apiResponse.errorBody()?.string()!!))
            } else {
                emit(State.apiFail(BaseResponse(apiResponse.message())))
            }
        }
    }.catch { e ->
        emit(State.error(e))
    }

    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<RESULT>
}
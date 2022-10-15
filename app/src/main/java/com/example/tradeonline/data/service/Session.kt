package com.example.tradeonline.data.service

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

class Session {
    companion object {

        private var currentSession: Session? = Session()
        val current: Session
            get() {
                if (currentSession == null) {
                    currentSession = Session()
                }
                return currentSession as Session
            }
    }

    fun clearSession() {
        currentSession = null
    }
}
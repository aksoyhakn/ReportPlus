package com.aksoyhakn.reportplus.ui.main.indicator

import androidx.lifecycle.MutableLiveData
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.ui.main.indicator.model.IndicatorResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class IndicatorViewModel : BaseViewModel() {

    init {
        getIndicator()
    }

    val indicatorList = MutableLiveData<ArrayList<IndicatorResponse>>()

    private fun getIndicator() {

        Firebase.firestore
            .collection("Indicators")
            .get()
            .addOnSuccessListener { result ->

                val itemList: ArrayList<IndicatorResponse> = arrayListOf()
                for (document in result) {
                    document?.let {
                        itemList.add(it.toObject(IndicatorResponse::class.java))
                    }
                }

                indicatorList.value = itemList
            }
            .addOnFailureListener { exception ->

            }
    }
}
package com.example.trendline.ui.main.technicalAnalysis

import androidx.lifecycle.MutableLiveData
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class TechnicalAnalysisViewModel : BaseViewModel() {

    init {
        getTechnicalAnalysis()
    }

    val technicalAnalysisList = MutableLiveData<ArrayList<TechnicalAnalysisResponse>>()

    private fun getTechnicalAnalysis() {

        Firebase.firestore
            .collection("TechnicalAnalysis")
            .get()
            .addOnSuccessListener { result ->

                val itemList: ArrayList<TechnicalAnalysisResponse> = arrayListOf()
                for (document in result) {
                    document?.let {
                        itemList.add(it.toObject(TechnicalAnalysisResponse::class.java))
                    }
                }

                technicalAnalysisList.value = itemList

            }
            .addOnFailureListener { exception -> }
    }
}
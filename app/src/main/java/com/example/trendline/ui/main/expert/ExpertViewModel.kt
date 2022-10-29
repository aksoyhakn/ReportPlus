package com.example.trendline.ui.main.expert

import androidx.lifecycle.MutableLiveData
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.ui.main.expert.model.ExpertResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class ExpertViewModel : BaseViewModel() {

    init {
        getExpert()
    }

    val expertList = MutableLiveData<ArrayList<ExpertResponse>>()

    private fun getExpert() {
        Firebase.firestore
            .collection("Users")
            .get()
            .addOnSuccessListener { result ->

                val itemList: ArrayList<ExpertResponse> = arrayListOf()
                for (document in result) {
                    document?.let {
                        itemList.add(it.toObject(ExpertResponse::class.java))
                    }
                }

                expertList.value = itemList
            }
            .addOnFailureListener { exception ->
            }
    }
}
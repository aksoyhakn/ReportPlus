package com.example.trendline.ui.main.journal

import androidx.lifecycle.MutableLiveData
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.ui.main.journal.model.JournalResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class JournalViewModel : BaseViewModel() {

    init {
        getJournal()
    }

    val journalList = MutableLiveData<ArrayList<JournalResponse>>()

    private fun getJournal() {

        Firebase.firestore
            .collection("Journals")
            .get()
            .addOnSuccessListener { result ->

                val itemList: ArrayList<JournalResponse> = arrayListOf()
                for (document in result) {
                    document?.let {
                        itemList.add(it.toObject(JournalResponse::class.java))
                    }
                }

                journalList.value = itemList

            }
            .addOnFailureListener { exception -> }
    }
}
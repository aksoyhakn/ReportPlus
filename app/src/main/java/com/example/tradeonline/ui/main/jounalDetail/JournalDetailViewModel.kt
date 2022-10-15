package com.example.tradeonline.ui.main.jounalDetail

import androidx.lifecycle.MutableLiveData
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.ui.main.journal.model.JournalResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class JournalDetailViewModel : BaseViewModel() {

    val journalDetail = MutableLiveData<JournalResponse>()

}
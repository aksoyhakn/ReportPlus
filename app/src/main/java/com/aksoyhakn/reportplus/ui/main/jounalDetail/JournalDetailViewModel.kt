package com.aksoyhakn.reportplus.ui.main.jounalDetail

import androidx.lifecycle.MutableLiveData
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.ui.main.journal.model.JournalResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class JournalDetailViewModel : BaseViewModel() {

    val journalDetail = MutableLiveData<JournalResponse>()

}
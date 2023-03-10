package com.aksoyhakn.reportplus.ui.main.technicalAnalysisDetail

import androidx.lifecycle.MutableLiveData
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class TechnicalAnalysisDetailViewModel : BaseViewModel() {

    val technicalAnalysisDetail = MutableLiveData<TechnicalAnalysisResponse>()

}
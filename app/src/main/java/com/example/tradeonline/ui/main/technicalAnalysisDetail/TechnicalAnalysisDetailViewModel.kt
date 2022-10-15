package com.example.tradeonline.ui.main.technicalAnalysisDetail

import androidx.lifecycle.MutableLiveData
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class TechnicalAnalysisDetailViewModel : BaseViewModel() {

    val technicalAnalysisDetail = MutableLiveData<TechnicalAnalysisResponse>()

}
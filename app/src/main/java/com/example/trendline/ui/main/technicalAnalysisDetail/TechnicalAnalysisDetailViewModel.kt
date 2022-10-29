package com.example.trendline.ui.main.technicalAnalysisDetail

import androidx.lifecycle.MutableLiveData
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class TechnicalAnalysisDetailViewModel : BaseViewModel() {

    val technicalAnalysisDetail = MutableLiveData<TechnicalAnalysisResponse>()

}
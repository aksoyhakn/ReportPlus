package com.example.tradeonline.ui.main.indicatorDetails

import androidx.lifecycle.MutableLiveData
import com.example.tradeonline.base.viewmodel.BaseViewModel
import com.example.tradeonline.ui.main.indicator.model.IndicatorResponse
import com.example.tradeonline.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse

class IndicatorDetailViewModel : BaseViewModel() {

    val indicatorDetailResponse = MutableLiveData<IndicatorResponse>()

}
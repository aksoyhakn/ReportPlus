package com.example.trendline.ui.main.indicatorDetails

import androidx.lifecycle.MutableLiveData
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.ui.main.indicator.model.IndicatorResponse
import com.example.trendline.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse

class IndicatorDetailViewModel : BaseViewModel() {

    val indicatorDetailResponse = MutableLiveData<IndicatorResponse>()

}
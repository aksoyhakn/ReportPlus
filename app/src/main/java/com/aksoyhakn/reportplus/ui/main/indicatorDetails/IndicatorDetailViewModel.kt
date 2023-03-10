package com.aksoyhakn.reportplus.ui.main.indicatorDetails

import androidx.lifecycle.MutableLiveData
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.ui.main.indicator.model.IndicatorResponse
import com.aksoyhakn.reportplus.ui.main.technicalAnalysis.model.TechnicalAnalysisResponse

class IndicatorDetailViewModel : BaseViewModel() {

    val indicatorDetailResponse = MutableLiveData<IndicatorResponse>()

}
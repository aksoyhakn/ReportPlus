package com.aksoyhakn.reportplus.base.viewmodel

import androidx.lifecycle.ViewModel
import com.aksoyhakn.reportplus.data.preference.PreferenceHelperImp
import com.aksoyhakn.reportplus.utils.SingleLiveData
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

open class BaseViewModel : ViewModel() {

    var fragmentLoading = SingleLiveData<Boolean>()
    protected fun toogleFragmentLoading(status: Boolean) {
        fragmentLoading.value = status
    }

    var fragmentErrorOrFail = SingleLiveData<Any>()
    protected fun fragmentErrorOrFail(status: Any) {
        fragmentErrorOrFail.value = status
    }

}

package com.aksoyhakn.reportplus.extensions

import android.os.Bundle
import androidx.core.os.bundleOf

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


fun Bundle.putAny(key: String, value: Any?) {
    putAll(bundleOf(key to value))
}
package com.aksoyhakn.reportplus.ui.common

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import com.aksoyhakn.reportplus.R

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class LottieProgressDialog(context: Context) :
    Dialog(context, R.style.LottieProgressDialog) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.component_lottieprogress)
        this.setCancelable(false)
        this.setCanceledOnTouchOutside(false)
    }

    private fun clearOverlay() {
        this.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    override fun show() {
        if (!isShowing) {
            super.show()
        }
    }

    override fun dismiss() {
        if (isShowing) {
            super.dismiss()
        }
    }


    override fun cancel() {
        if (isShowing) {
            super.cancel()
        }
    }
}
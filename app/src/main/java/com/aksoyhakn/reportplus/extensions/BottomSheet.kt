package com.aksoyhakn.reportplus.extensions

import android.app.Dialog
import android.view.View
import android.view.WindowManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


internal fun <V : View> BottomSheetDialogFragment.getBottomSheetBehavior(dialog: Dialog? = getDialog()): BottomSheetBehavior<V>? {
    return dialog
        ?.findViewById<V>(com.google.android.material.R.id.design_bottom_sheet)
        ?.let { BottomSheetBehavior.from(it) }
}

internal fun BottomSheetDialogFragment.setBottomSheetState(state: Int) {
    getBottomSheetBehavior<View>()?.state = state
}

internal fun BottomSheetDialogFragment.setBottomSheetStateChanged() {

    getBottomSheetBehavior<View>()?.addBottomSheetCallback(object :
        BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState != BottomSheetBehavior.STATE_EXPANDED) {
            }
        }
    })
}

internal fun BottomSheetDialogFragment.getBottomSheetDialog(): View? {
    return dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
}

internal fun BottomSheetDialogFragment.setBottomSheetScreenHeight() {
    var bottomsheet = getBottomSheetDialog()
    val layoutParams = bottomsheet?.layoutParams
    layoutParams?.height = WindowManager.LayoutParams.MATCH_PARENT
    bottomsheet?.layoutParams = layoutParams
}
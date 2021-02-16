package com.uala.test.extension

import androidx.fragment.app.FragmentActivity
import com.uala.test.common.LoadingDialog

fun FragmentActivity.showLoadingDialog(title: String? = null, message: String? = null) {
    LoadingDialog.showLoadingDialog(supportFragmentManager, title, message)
}
fun FragmentActivity.hideLoadingDialog() {
    LoadingDialog.hideLoadingDialog(supportFragmentManager)
}
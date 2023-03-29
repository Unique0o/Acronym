package com.manager.app.ui.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.manager.app.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    private var alertDialogProgressBar: AlertDialog? = null
    private var isActivityPaused: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /*--Loader Functions--*/
    protected open fun showLoadingProgressBar(message: String?, cancelable: Boolean) {
        if (isActivityPaused!!) return
        val adb = AlertDialog.Builder(this)
        val view: View = layoutInflater.inflate(R.layout.alert_dialog_progressbar_layout, null)
        view.findViewById<TextView>(R.id.idTextViewMessage).text = message
        adb.setView(view)
        alertDialogProgressBar = adb.create()
        alertDialogProgressBar!!.setCancelable(cancelable)
        alertDialogProgressBar!!.show()
    }

    protected open fun closeProgressBar() {
        if (alertDialogProgressBar == null) {
            return
        }
        alertDialogProgressBar!!.hide()
    }


    override fun onPause() {
        super.onPause()
        isActivityPaused = true
    }

    override fun onResume() {
        super.onResume()
        isActivityPaused = false
    }
}
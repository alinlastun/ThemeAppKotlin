package com.theme.junky.themeskotlin.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.widget.Button
import com.theme.junky.themeskotlin.utils.Tools


class MotherIsNotActive private constructor() {

    companion object {
        private val mInstance: MotherIsNotActive = MotherIsNotActive()
        @Synchronized
        fun getInstance(): MotherIsNotActive {
            return mInstance
        }
    }

    fun init(nContext : Activity) : MotherIsNotActive {
        val dialogBuilder = AlertDialog.Builder(nContext)
        val inflater = nContext.layoutInflater
        val dialogView = inflater.inflate(com.theme.junky.themeskotlin.R.layout.dialog_mother_is_not_active, null)
        dialogBuilder.setView(dialogView)
        val mDialog = dialogBuilder.create()
        val button1 = dialogView.findViewById(com.theme.junky.themeskotlin.R.id.nView1) as Button
        val button2 = dialogView.findViewById(com.theme.junky.themeskotlin.R.id.nView2) as Button
        button1.setOnClickListener {mDialog.dismiss()  }
        button2.setOnClickListener {
            Tools().directApply(nContext)
          mDialog.dismiss() }
        mDialog.show()
        return this
    }
}
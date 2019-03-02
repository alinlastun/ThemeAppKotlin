package com.theme.junky.themeskotlin.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import com.theme.junky.themeskotlin.R
import com.theme.junky.themeskotlin.utils.Tools


class MotherIsNotInstalled private constructor() {

    companion object {
        private val mInstance: MotherIsNotInstalled = MotherIsNotInstalled()
        @Synchronized
        fun getInstance(): MotherIsNotInstalled {
            return mInstance
        }
    }

    fun init(nActivity : Activity) : MotherIsNotInstalled {

        val dialogBuilder = AlertDialog.Builder(nActivity)
        val inflater = nActivity.layoutInflater
        val dialogView = inflater.inflate(com.theme.junky.themeskotlin.R.layout.dialog_mother_is_not_installed, null)
        dialogBuilder.setView(dialogView)
        val mDialog = dialogBuilder.create()
        val button1 = dialogView.findViewById(com.theme.junky.themeskotlin.R.id.nView1) as Button
        val button2 = dialogView.findViewById(com.theme.junky.themeskotlin.R.id.nView2) as Button
        button1.setOnClickListener {mDialog.dismiss()  }
        button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse(nActivity.getString(R.string.mother_url))
            nActivity.startActivity(intent)

            mDialog.dismiss()}
        mDialog.show()
        return this

    }
}
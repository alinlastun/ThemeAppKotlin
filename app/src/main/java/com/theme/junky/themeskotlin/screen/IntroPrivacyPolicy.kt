package com.theme.junky.themeskotlin.screen

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.theme.junky.themeskotlin.MainApplication
import com.theme.junky.themeskotlin.R
import com.theme.junky.themeskotlin.utils.Tools


class IntroPrivacyPolicy : AppCompatActivity(), View.OnClickListener {
    lateinit var prefs: SharedPreferences
    var nrOfEntries = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_privacy_policy)
        init()

         prefs = getSharedPreferences("my_app", Context.MODE_PRIVATE)

       if(prefs.getBoolean("first",false)){
           Tools().redirectLayout(this)
           nrOfEntries =  prefs.getInt("nrOfEntries",0)
           nrOfEntries++
           (application as MainApplication).MGAE.getEvents(getString(R.string.layout_event),"Number of Entries","Number of Entries: ${nrOfEntries}")
           prefs.edit().putInt("nrOfEntries", nrOfEntries).apply()
       }
    }

    private fun init() {
        supportActionBar?.hide()
        findViewById<View>(R.id.nView5).setOnClickListener(this)
        findViewById<View>(R.id.nView6).setOnClickListener(this)
        findViewById<View>(R.id.nView7).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.nView5 -> {
                Tools().redirectLayout(this)
                nrOfEntries++
                (application as MainApplication).MGAE.getEvents(getString(R.string.layout_event),"Number of Entries","Number of Entries: ${nrOfEntries}")
                prefs.edit().putBoolean("first", true).apply()
                prefs.edit().putInt("nrOfEntries", nrOfEntries).apply()


            }
            R.id.nView6 -> Tools().showPrivacyPolicy(this)
            R.id.nView7 -> Tools().showPrivacyPolicy(this)
        }
    }
}

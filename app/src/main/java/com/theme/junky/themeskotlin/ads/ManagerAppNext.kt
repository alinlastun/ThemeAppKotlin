package com.keyboard.plus.themekey.digitalsounds.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.appnext.ads.interstitial.Interstitial
import com.appnext.core.callbacks.OnAdError
import com.appnext.core.callbacks.OnAdClosed
import com.appnext.core.callbacks.OnAdClicked
import com.appnext.core.callbacks.OnAdOpened
import com.appnext.core.callbacks.OnAdLoaded

class ManagerAppNext private constructor() : OnAdClicked, OnAdOpened {

    private var nameLog = ""

    interface ManagerAppNextInterface {
        fun onAppNextLoaded(nInterstitialAd : Interstitial,nContext : Activity )
        fun onAppNextClosed(nContext: Activity)
        fun onAppNextFailed(nContext: Activity)
    }

    companion object {
        private val mInstance: ManagerAppNext = ManagerAppNext()
        @Synchronized
        fun getInstance(): ManagerAppNext {
            return mInstance
        }
    }

    fun init(nContext: Activity,nListener : ManagerAppNextInterface,idAppnext:String,nameLog:String) {
        this.nameLog = nameLog
          /*"3cd8839d-7e84-4c69-9899-d0d17485fac8"*/
        val mInterstitialAd = Interstitial(nContext, idAppnext)
        mInterstitialAd.loadAd()
        mInterstitialAd.isBackButtonCanClose = true
        mInterstitialAd.onAdClosedCallback = OnAdClosed {
            Log.d(nameLog,"Appnext - OnAdClosed")
            nListener.onAppNextClosed(nContext)
        }
        mInterstitialAd.onAdErrorCallback = OnAdError {
            Log.d(nameLog,"Appnext - OnAdError: ${it}")
            nListener.onAppNextFailed(nContext)
        }
        mInterstitialAd.onAdLoadedCallback = OnAdLoaded {
            Log.d(nameLog,"Appnext - OnAdLoaded")
            nListener.onAppNextLoaded(mInterstitialAd,nContext)
        }
        mInterstitialAd.onAdOpenedCallback = this
    }

    override fun adClicked() {
        Log.d(nameLog,"Appnext - OnAdLoaded")
    }

    override fun adOpened() {
        Log.d(nameLog,"Appnext - OnAdLoaded")
    }
}
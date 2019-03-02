package com.theme.junky.themeskotlin.screen.mainscreen

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.theme.junky.themeskotlin.screen.mainscreen.repository.Repository

class MainScreenViewModel: ViewModel() {

    private val mRepository = Repository(this)
    var ourBestTheme=""
    var interstitialAdmob=""
    var interstitialAppnext=""

    fun getAdsInfo(){
        mRepository.getAds()
    }

    fun getThemeInfo(){
        mRepository.getTheme()
    }


}
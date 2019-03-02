package com.theme.junky.themeskotlin.screen.moreapps

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.theme.junky.themeskotlin.model.AdsItem
import com.theme.junky.themeskotlin.screen.moreapps.repository.RepositoryMoreApps

class MoreAppsViewModel  : ViewModel() {

    val repository = RepositoryMoreApps(this)
    var moreAppsList :MutableList<AdsItem> = arrayListOf()
    val triggerMoreApps = MutableLiveData<Boolean>()
    val isInternet =  MutableLiveData<Boolean>()

    fun getMoreApps(){
        repository.getMoreApps()
    }
}
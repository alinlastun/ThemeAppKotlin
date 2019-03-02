package com.theme.junky.themeskotlin.screen.wallpapers

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableField
import com.theme.junky.themeskotlin.model.AdsItem
import com.theme.junky.themeskotlin.screen.wallpapers.repository.RepositoryWallpapers

class WallpaperViewModel: ViewModel() {
    val repository = RepositoryWallpapers(this)
    var wallpapersList :MutableList<AdsItem> = arrayListOf()
    val triggerWallapper = MutableLiveData<Boolean>()
    val isInternet =  MutableLiveData<Boolean>()
    fun getWallpapers(){
        repository.getWallpapers()
    }
}
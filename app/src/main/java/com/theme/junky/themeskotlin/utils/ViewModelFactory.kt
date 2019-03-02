package com.theme.junky.themeskotlin.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.theme.junky.themeskotlin.screen.mainscreen.MainScreenViewModel
import com.theme.junky.themeskotlin.screen.moreapps.MoreAppsViewModel
import com.theme.junky.themeskotlin.screen.wallpapers.WallpaperViewModel

class ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainScreenViewModel::class.java)) {
            return MainScreenViewModel() as T
        }else if (modelClass.isAssignableFrom(WallpaperViewModel::class.java)) {
            return WallpaperViewModel() as T
        }else if (modelClass.isAssignableFrom(MoreAppsViewModel::class.java)) {
            return MoreAppsViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }



}

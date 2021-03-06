package com.theme.junky.themeskotlin.screen.wallpapers.repository

import android.util.Log
import com.theme.junky.themeskotlin.model.ThemeItem
import com.theme.junky.themeskotlin.retrofit.RetrofitService
import com.theme.junky.themeskotlin.screen.wallpapers.WallpaperViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException

class RepositoryWallpapers (val mViewModel: WallpaperViewModel){


    private fun getThemeConfig(): Observable<List<ThemeItem>> {
        return RetrofitService().getInstance().interfaces.getThemeConfig("com.keyboard.plus.theme.big")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getWallpapers(): Disposable {
        return getThemeConfig().subscribe(::successeWallpaper, ::erroreWallpaper)
    }
    private fun successeWallpaper(mResult: List<ThemeItem>){

        with (mViewModel){
            wallpapersList.clear()
            mViewModel.isInternet.value = true
            for (mData in mResult[0].account_internal_ads){
                if(mData.text.contains("type_wallpaper",true)){
                    wallpapersList.add(mData)
                    triggerWallapper.value = true

                }
            }
        }


    }
    private fun erroreWallpaper(mError: Throwable){
        if (mError is IOException) {
            mViewModel.isInternet.value = false
        }

    }
}
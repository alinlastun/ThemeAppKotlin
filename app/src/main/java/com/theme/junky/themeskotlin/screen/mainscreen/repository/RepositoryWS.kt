package com.theme.junky.themeskotlin.screen.mainscreen.repository

import com.theme.junky.themeskotlin.model.AdsReceived
import com.theme.junky.themeskotlin.model.ThemeItem
import com.theme.junky.themeskotlin.packageNameApp
import com.theme.junky.themeskotlin.retrofit.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryWS {

    fun getAdsConfig(): Observable<AdsReceived> {

        return RetrofitService().getInstance().interfaces.getAdsConfig(packageNameApp,"regular")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getThemeConfig(): Observable<List<ThemeItem>> {
        return RetrofitService().getInstance().interfaces.getThemeConfig("com.keyboard.plus.theme.big")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


}
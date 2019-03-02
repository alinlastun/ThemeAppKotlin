package com.theme.junky.themeskotlin.retrofit

import com.theme.junky.themeskotlin.model.AdsReceived
import com.theme.junky.themeskotlin.model.ThemeItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/ads")
    fun getAdsConfig(@Query("package_name") packageName: String,@Query("type") type: String): Observable<AdsReceived>

    @GET("/themes")
    fun getThemeConfig(@Query("package_name") packageName: String): Observable<List<ThemeItem>>

}
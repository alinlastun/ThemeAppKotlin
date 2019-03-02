package com.theme.junky.themeskotlin.screen.wallpapers.utils

import android.app.Activity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.theme.junky.themeskotlin.screen.wallpapers.ListenerImage
import com.theme.junky.themeskotlin.screen.wallpapers.Wallpapers


fun RecyclerView.setWallpapersAdapter(listenerImage: ListenerImage){
    adapter = WallpapersAdapter(listenerImage)
    layoutManager = GridLayoutManager(context, 2)
}
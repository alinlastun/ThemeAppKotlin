package com.theme.junky.themeskotlin.screen.wallpapers

import java.text.FieldPosition

interface ListenerImage {
     fun whenClickOnImage(urlString: String,isClicked:Boolean,position: Int)
}
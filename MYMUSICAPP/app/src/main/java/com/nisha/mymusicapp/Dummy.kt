package com.nisha.mymusicapp

import androidx.annotation.DrawableRes

data class Lib(@DrawableRes val icon:Int,val name:String)

val libraries = listOf<Lib>(
    Lib(R.drawable.baseline_library_music_24,"Playlist"),
    Lib(R.drawable.baseline_mic_24,"MicroPhone"),
    Lib(R.drawable.baseline_album_24,"Album"),
    Lib(R.drawable.baseline_music_video_24,"Songs"),
    Lib(R.drawable.ic_account,"Genre"),
)
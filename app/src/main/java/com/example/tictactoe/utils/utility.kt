package com.example.tictactoe.utils

import android.content.Context
import android.media.MediaPlayer
import com.example.tictactoe.R

fun startMusic(mediaPlayer: MediaPlayer){
    mediaPlayer.setVolume(0.1f,0.2f)
    mediaPlayer.isLooping = true
    if(!mediaPlayer.isPlaying) mediaPlayer.start()
}

fun pauseMusic(mediaPlayer: MediaPlayer){
    mediaPlayer.pause()
}

fun stopMusic(mediaPlayer: MediaPlayer){
    mediaPlayer.stop()
}
fun clickSound(context: Context){
    val mediaPlayer:MediaPlayer = MediaPlayer.create(context, R.raw.mixkit_select_click)
    mediaPlayer.setVolume(0.1f,0.2f)
    mediaPlayer.start()
}
fun playerVsPlayerSound(context: Context){
    val mediaPlayer:MediaPlayer = MediaPlayer.create(context,
        R.raw.mixkit_fast_double_click_on_mouse
    )
    mediaPlayer.start()
}
fun playerVsComputerSound(context: Context){
    val mediaPlayer:MediaPlayer = MediaPlayer.create(context,
        R.raw.mixkit_click_error
    )
    mediaPlayer.start()
}
fun winSound(context: Context){
    val mediaPlayer:MediaPlayer = MediaPlayer.create(context,
        R.raw.mixkit_positive_interface_beep
    )
    mediaPlayer.setVolume(0.1f,0.2f)
    mediaPlayer.start()
}

fun checkIfValidInput(string:String):Boolean{
    if (string.isNullOrBlank()) return false
    return true
}
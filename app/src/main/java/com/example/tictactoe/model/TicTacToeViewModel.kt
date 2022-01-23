package com.example.tictactoe.model

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import com.example.tictactoe.R
import com.example.tictactoe.ui.MainActivity

class TicTacToeViewModel: ViewModel() {
   private lateinit var mediaPlayer:MediaPlayer
    fun playAudio(context: Context){
        mediaPlayer = MediaPlayer.create(context,R.raw.mixkit_solitude)
       mediaPlayer.setVolume(0.1f,0.2f)
        mediaPlayer.isLooping = true
        if(!mediaPlayer.isPlaying) mediaPlayer.start()
    }
    fun pauseAudio(){
        mediaPlayer.stop()
    }
    fun stopAudio(){
        mediaPlayer.stop()
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer.stop()
    }
}
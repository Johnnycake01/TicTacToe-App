package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.tictactoe.R
import com.example.tictactoe.ui.MainActivity.Companion.mediaPlayer
import com.example.tictactoe.utils.clickSound
import com.example.tictactoe.utils.pauseMusic
import com.example.tictactoe.utils.startMusic
import com.example.tictactoe.utils.stopMusic

class ChooseGameType : AppCompatActivity() {
    private lateinit var playWithComputerButton: AppCompatButton
    private lateinit var twoPlayer:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_game_type)
        startMusic(mediaPlayer)

        playWithComputerButton = findViewById(R.id.PlayWithComputer)
        twoPlayer = findViewById(R.id.TwoPlayers)

        playWithComputerButton.setOnClickListener {
            clickSound(this)
            val intent = Intent(this, ChooseComputerLevel::class.java)
            startActivity(intent)
        }
        twoPlayer.setOnClickListener {
            clickSound(this)
            val intent = Intent(this, GetUserNames::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        clickSound(this)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    override fun onResume() {
        super.onResume()
    startMusic(mediaPlayer)
    }

    override fun onPause() {
        super.onPause()
        pauseMusic(mediaPlayer)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMusic(mediaPlayer)
    }
}
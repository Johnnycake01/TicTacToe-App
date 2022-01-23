package com.example.tictactoe.ui

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.R
import com.example.tictactoe.model.TicTacToeViewModel
import com.example.tictactoe.ui.MainActivity.Companion.viewModel

class ChooseGameType : AppCompatActivity() {
    private lateinit var playWithComputerButton: AppCompatButton
    private lateinit var twoPlayer:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_game_type)

        playWithComputerButton = findViewById(R.id.PlayWithComputer)
        twoPlayer = findViewById(R.id.TwoPlayers)

        playWithComputerButton.setOnClickListener {
            val intent = Intent(this, ChooseComputerLevel::class.java)
            startActivity(intent)
        }
        twoPlayer.setOnClickListener {
            val intent = Intent(this, GetUserNames::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    override fun onResume() {
        super.onResume()
        viewModel.playAudio(this)
    }
    override fun onStop() {
        super.onStop()
        viewModel.pauseAudio()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.stopAudio()
    }
}
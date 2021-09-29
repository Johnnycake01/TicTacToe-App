package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.tictactoe.R

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
}
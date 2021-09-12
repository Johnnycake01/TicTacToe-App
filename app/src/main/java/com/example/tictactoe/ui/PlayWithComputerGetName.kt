package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.tictactoe.R

class PlayWithComputerGetName : AppCompatActivity() {
    private lateinit var submit: AppCompatButton
    private lateinit var player1Name: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_computer_get_name)
        submit = findViewById(R.id.SinglePlayerNameSubmitButton)
        player1Name = findViewById(R.id.PlayerName)

        submit.setOnClickListener {
            val player1:String = player1Name.text.toString()
            val names:Array<String> = arrayOf(player1,"Computer")
            val intent = Intent(this, ComputerGameBoard::class.java)
            intent.putExtra("PLAYER_NAMES", names)
            startActivity(intent)
        }
    }
}
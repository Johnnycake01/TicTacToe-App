package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tictactoe.R
import com.example.tictactoe.drawable.TicTacToeBoard

class GameBoard : AppCompatActivity() {
    private lateinit var ticTacToeBoard: TicTacToeBoard
    private lateinit var replayButton: Button
    private lateinit var endGame:Button
    private lateinit var displayPlayerName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_board)
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard)
        replayButton = findViewById(R.id.gameReplayButton)
        endGame = findViewById(R.id.gameQuitButton)
        displayPlayerName = findViewById(R.id.tvPlayerName)
        val playerNames:Array<String> = intent.getStringArrayExtra("PLAYER_NAMES")!!
        "${playerNames[0]}'s turn".also { displayPlayerName.text = it }
        replayButton.visibility = View.GONE
        endGame.visibility = View.GONE
        ticTacToeBoard.setUpGame(replayButton,endGame,displayPlayerName,playerNames)

        replayButton.setOnClickListener {
            ticTacToeBoard.resetGame()
            ticTacToeBoard.invalidate()
        }
        endGame.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
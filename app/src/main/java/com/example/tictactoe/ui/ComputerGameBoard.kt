package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tictactoe.R
import com.example.tictactoe.drawable.ComputerTicTacToeBoard


class ComputerGameBoard : AppCompatActivity() {
    private lateinit var ticTacToeBoard: ComputerTicTacToeBoard
    private lateinit var replayButton: Button
    private lateinit var endGame: Button
    private lateinit var displayPlayerName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_game_board)

        ticTacToeBoard = findViewById(R.id.computerTicTacToeBoard)
        replayButton = findViewById(R.id.computerGameReplayButton)
        endGame = findViewById(R.id.computerGameQuitButton)
        displayPlayerName = findViewById(R.id.tvComputerPlayerName)
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
}
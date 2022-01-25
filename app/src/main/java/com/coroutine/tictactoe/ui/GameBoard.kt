package com.coroutine.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.coroutine.tictactoe.R
import com.coroutine.tictactoe.drawable.TicTacToeBoard
import com.coroutine.tictactoe.ui.MainActivity.Companion.mediaPlayer
import com.coroutine.tictactoe.utils.*

class GameBoard : AppCompatActivity() , ClickListenerHelper {
    private lateinit var ticTacToeBoard: TicTacToeBoard
    private lateinit var replayButton: Button
    private lateinit var endGame:Button
    private lateinit var displayPlayerName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_board)
        stopMusic(mediaPlayer)
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard)
        ticTacToeBoard.clickListenerHelper = this
        replayButton = findViewById(R.id.gameReplayButton)
        endGame = findViewById(R.id.gameQuitButton)
        displayPlayerName = findViewById(R.id.tvPlayerName)
        val playerNames:Array<String> = intent.getStringArrayExtra("PLAYER_NAMES")!!
        "${playerNames[0]}'s turn".also { displayPlayerName.text = it }
        replayButton.visibility = View.GONE
        endGame.visibility = View.GONE
        ticTacToeBoard.setUpGame(replayButton,endGame,displayPlayerName,playerNames)

        replayButton.setOnClickListener {
            clickSound(this)
            ticTacToeBoard.resetGame()
            ticTacToeBoard.invalidate()
        }
        endGame.setOnClickListener {
            clickSound(this)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        clickSound(this)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onClickEvent() {
//        playerVsComputerSound(this)
        playerVsPlayerSound(this)
    }

    override fun onWinEvent() {
        winSound(this)
    }
//    override fun onResume() {
//        super.onResume()
//        startMusic(mediaPlayer)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        pauseMusic(mediaPlayer)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        stopMusic(mediaPlayer)
//    }
}
package com.coroutine.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.coroutine.tictactoe.R
import com.coroutine.tictactoe.ui.MainActivity.Companion.mediaPlayer
import com.coroutine.tictactoe.utils.*

class GetUserNames : AppCompatActivity() {
    private lateinit var submit: AppCompatButton
    private lateinit var player1Name:EditText
    private lateinit var player1ErrorName:TextView
    private lateinit var player2Name:EditText
    private lateinit var player2ErrorName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_user_namas)
        startMusic(mediaPlayer)
       submit = findViewById(R.id.homeSubmitButton)
        player1Name = findViewById(R.id.firstPlayerName)
        player2Name = findViewById(R.id.secondPlayerName)
        player1ErrorName = findViewById(R.id.textinput_error1)
        player2ErrorName = findViewById(R.id.textinput_error2)


        submit.setOnClickListener {
            player1ErrorName.visibility = View.GONE
            player2ErrorName.visibility = View.GONE
            if (!checkIfValidInput(player1Name.text.toString())){
                playErrorSound(this)
                player1ErrorName.visibility = View.VISIBLE
                return@setOnClickListener
            }
            if (!checkIfValidInput(player2Name.text.toString())){
                playErrorSound(this)
                player2ErrorName.visibility = View.VISIBLE
                return@setOnClickListener
            }
            clickSound(this)
            val player1:String = player1Name.text.toString()
            val player2:String = player2Name.text.toString()
            val names:Array<String> = arrayOf(player1,player2)
            val intent = Intent(this, GameBoard::class.java)
            intent.putExtra("PLAYER_NAMES", names)
            startActivity(intent)
        }

    }
    override fun onBackPressed() {
        clickSound(this)
        val intent = Intent(this, ChooseGameType::class.java)
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
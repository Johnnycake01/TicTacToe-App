package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.tictactoe.R
import com.example.tictactoe.ui.MainActivity.Companion.mediaPlayer
import com.example.tictactoe.utils.clickSound
import com.example.tictactoe.utils.pauseMusic
import com.example.tictactoe.utils.startMusic
import com.example.tictactoe.utils.stopMusic

class GetUserNames : AppCompatActivity() {
    private lateinit var submit: AppCompatButton
    private lateinit var player1Name:EditText
    private lateinit var player2Name:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_user_namas)
        startMusic(mediaPlayer)
       submit = findViewById(R.id.homeSubmitButton)
        player1Name = findViewById(R.id.firstPlayerName)
        player2Name = findViewById(R.id.secondPlayerName)


        submit.setOnClickListener {
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
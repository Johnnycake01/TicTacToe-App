package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tictactoe.databinding.ActivityPlayWithComputerGetNameBinding
import com.example.tictactoe.ui.MainActivity.Companion.mediaPlayer
import com.example.tictactoe.utils.*

class PlayWithComputerGetName : AppCompatActivity() {
    private lateinit var binding: ActivityPlayWithComputerGetNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayWithComputerGetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startMusic(mediaPlayer)
       val chooseLevel:Int = intent.getStringExtra("value")!!.toInt()

        binding.SinglePlayerNameSubmitButton.setOnClickListener {
            binding.textinputError.visibility = View.GONE
            clickSound(this)
            val player1:String = binding.PlayerName.text.toString()
            if (checkIfValidInput(player1)) {
                val names: Array<String> = arrayOf(player1, "Computer")
                if (chooseLevel == 1) {
                    val intent = Intent(this, ComputerGameBoard::class.java)
                    intent.putExtra("PLAYER_NAMES", names)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, PlayWithComputerHard::class.java)
                    intent.putExtra("PLAYER_NAMES", names)
                    startActivity(intent)
                }
            }else{
                playErrorSound(this)
                binding.textinputError.visibility = View.VISIBLE
            }

        }

    }
    override fun onBackPressed() {
        clickSound(this)
        val intent = Intent(this, ChooseComputerLevel::class.java)
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
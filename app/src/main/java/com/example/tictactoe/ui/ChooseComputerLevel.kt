package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityChooseComputerLevelBinding
import com.example.tictactoe.ui.MainActivity.Companion.mediaPlayer
import com.example.tictactoe.utils.clickSound
import com.example.tictactoe.utils.pauseMusic
import com.example.tictactoe.utils.startMusic
import com.example.tictactoe.utils.stopMusic

class ChooseComputerLevel : AppCompatActivity() {
    private lateinit var binding:ActivityChooseComputerLevelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChooseComputerLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startMusic(mediaPlayer)
        binding.easyLevel.setOnClickListener {
            clickSound(this)
            val intent = Intent(this,PlayWithComputerGetName::class.java)
            intent.putExtra("value", "1")
            startActivity(intent)
        }
        binding.hardLevel.setOnClickListener {
            clickSound(this)
            val intent = Intent(this,PlayWithComputerGetName::class.java)
            intent.putExtra("value", "2")
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
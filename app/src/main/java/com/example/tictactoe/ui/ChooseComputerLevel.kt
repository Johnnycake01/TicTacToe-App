package com.example.tictactoe.ui

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivityChooseComputerLevelBinding
import com.example.tictactoe.model.TicTacToeViewModel
import com.example.tictactoe.ui.MainActivity.Companion.viewModel

class ChooseComputerLevel : AppCompatActivity() {
    private lateinit var binding:ActivityChooseComputerLevelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityChooseComputerLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.easyLevel.setOnClickListener {
            val intent = Intent(this,PlayWithComputerGetName::class.java)
            intent.putExtra("value", "1")
            startActivity(intent)
        }
        binding.hardLevel.setOnClickListener {
            val intent = Intent(this,PlayWithComputerGetName::class.java)
            intent.putExtra("value", "2")
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        val intent = Intent(this, ChooseGameType::class.java)
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
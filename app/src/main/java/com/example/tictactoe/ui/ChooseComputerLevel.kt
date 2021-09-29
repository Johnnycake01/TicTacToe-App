package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityChooseComputerLevelBinding

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
}
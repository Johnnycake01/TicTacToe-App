package com.example.tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivityPlayWithComputerGetNameBinding
import com.example.tictactoe.databinding.ActivityPlayWithComputerHardBinding

class PlayWithComputerGetName : AppCompatActivity() {
    private lateinit var binding: ActivityPlayWithComputerGetNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayWithComputerGetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
       val chooseLevel:Int = intent.getStringExtra("value")!!.toInt()

        binding.SinglePlayerNameSubmitButton.setOnClickListener {
            val player1:String = binding.PlayerName.text.toString()
            val names:Array<String> = arrayOf(player1,"Computer")
            if (chooseLevel == 1){
                val intent = Intent(this, ComputerGameBoard::class.java)
                intent.putExtra("PLAYER_NAMES", names)
                startActivity(intent)
            }else{
                val intent = Intent(this, PlayWithComputerHard::class.java)
                intent.putExtra("PLAYER_NAMES", names)
                startActivity(intent)
            }

        }

    }
    override fun onBackPressed() {
        val intent = Intent(this, ChooseComputerLevel::class.java)
        startActivity(intent)
    }
}
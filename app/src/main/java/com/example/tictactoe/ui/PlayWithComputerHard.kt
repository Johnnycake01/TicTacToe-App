package com.example.tictactoe.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivityPlayWithComputerHardBinding
import com.example.tictactoe.logic.HardGameBoardLogic
import com.example.tictactoe.model.Cell

class PlayWithComputerHard : AppCompatActivity() {
    //Creating a 2D Array of ImageViews
 private lateinit var binding: ActivityPlayWithComputerHardBinding
    private lateinit var board:HardGameBoardLogic

    private val boardCells = Array(3) { arrayOfNulls<ImageView>(3) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayWithComputerHardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        board = HardGameBoardLogic()
        //calling the function to load our tic tac toe board
        loadBoard()

        //restart functionality
        binding.buttonRestart.setOnClickListener {
            //creating a new board instance
            //it will empty every cell
            board = HardGameBoardLogic()

            //setting the result to empty
            binding.textViewResult.text = ""

            //this function will map the internal board
            //to the visual board
            mapBoardToUi()
        }
    }

    //function is mapping
    //the internal board to the ImageView array board
    private fun mapBoardToUi() {
        for (i in board.board.indices) {
            for (j in board.board.indices) {
                when (board.board[i][j]) {
                    HardGameBoardLogic.PLAYER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.circle)
                        boardCells[i][j]?.isEnabled = false
                    }
                    HardGameBoardLogic.COMPUTER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.cross)
                        boardCells[i][j]?.isEnabled = false
                    }
                    else -> {
                        boardCells[i][j]?.setImageResource(0)
                        boardCells[i][j]?.isEnabled = true
                    }
                }
            }
        }
    }

    private fun loadBoard() {
        for (i in boardCells.indices) {
            for (j in boardCells.indices) {
                boardCells[i][j] = ImageView(this)
                boardCells[i][j]?.layoutParams = GridLayout.LayoutParams().apply {
                    rowSpec = GridLayout.spec(i)
                    columnSpec = GridLayout.spec(j)
                    width = 250
                    height = 230
                    bottomMargin = 5
                    topMargin = 5
                    leftMargin = 5
                    rightMargin = 5
                }
                boardCells[i][j]?.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
                //attached a click listener to the board
                boardCells[i][j]?.setOnClickListener(CellClickListener(i, j))
                binding.layoutBoard.addView(boardCells[i][j])
            }
        }
    }
    inner class CellClickListener(
        val i: Int,
        val j: Int
    ) : View.OnClickListener {

        override fun onClick(p0: View?) {
            //checking if the game is not over
            if (!board.isGameOver) {

                //creating a new cell with the clicked index
                val cell = Cell(i, j)

                //placing the move for player
                board.placeMove(cell, HardGameBoardLogic.PLAYER)

                //calling minimax to calculate the computers move
                board.minimax(0, HardGameBoardLogic.COMPUTER)

                //performing the move for computer
                board.computersMove?.let {
                    board.placeMove(it, HardGameBoardLogic.COMPUTER)
                }

                //mapping the internal board to visual board
                mapBoardToUi()
            }

            //Displaying the results
            //according to the game status
            when {
                board.hasComputerWon() -> "Computer Won".also { binding.textViewResult.text = it }
                board.hasPlayerWon() -> "Player Won".also { binding.textViewResult.text = it }
                board.isGameOver -> "Game Tied".also { binding.textViewResult.text = it }
            }

        }

    }
}
package com.usmaan.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var startNewGameButton: Button
    lateinit var ScoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startNewGameButton = findViewById(R.id.startNewGameButton)

       startNewGameButton.setOnClickListener {
            val intent = Intent(MainActivity@this, GameActivity::class.java)
            startActivity(intent)
        }

        ScoreButton = findViewById(R.id.ScoreButton)

        ScoreButton.setOnClickListener {
            val intent2 = Intent(MainActivity@this, ScoreActivity::class.java)
            startActivity(intent2)
        }
    }
}
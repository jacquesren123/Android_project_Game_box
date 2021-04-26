package com.usmaan.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var startNewGameButton: Button
    lateinit var ScoreButton: Button
    lateinit var name: String
    companion object {
        lateinit var nameInput: EditText
    }

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nameInput)
        name = nameInput.toString()

        showToast(name);

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

    private fun showToast(name: String)
    {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
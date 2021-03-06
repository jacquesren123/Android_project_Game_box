package fr.epita.android.game_box

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

public class MainActivity : AppCompatActivity() {

    lateinit var startNewGameButton: Button
    lateinit var ScoreButton: Button
    lateinit var hangmanButton: Button
    companion object {
        lateinit var name: String
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

        hangmanButton = findViewById(R.id.hangmanButton)

        hangmanButton.setOnClickListener {
            val intent3 = Intent(MainActivity@this, HangmanActivity::class.java)
            startActivity(intent3)
        }
    }

    private fun showToast(name: String)
    {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
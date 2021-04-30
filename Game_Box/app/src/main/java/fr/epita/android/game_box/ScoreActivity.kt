package fr.epita.android.game_box

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import fr.epita.android.game_box.R

class ScoreActivity  : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)
    }

    fun imageClick(view: View)
    {
        val browserintent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.epita.fr/"));
        startActivity(browserintent)
    }

}
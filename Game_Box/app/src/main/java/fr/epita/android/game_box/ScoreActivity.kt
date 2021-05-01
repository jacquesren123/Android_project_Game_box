package fr.epita.android.game_box

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import fr.epita.android.game_box.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ScoreActivity  : AppCompatActivity()
{
    private val scores = arrayListOf<Score>()
    private lateinit var jsonscores : ArrayList<Score>
    //private lateinit var listView: ListView
    companion object {
        lateinit var date1: TextView
        lateinit var player1: TextView
        lateinit var game1 : TextView
        lateinit var score1 : TextView
        lateinit var date2: TextView
        lateinit var player2: TextView
        lateinit var game2 : TextView
        lateinit var score2 : TextView
        lateinit var date3 : TextView
        lateinit var player3: TextView
        lateinit var game3 : TextView
        lateinit var score3 : TextView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        scores.addAll(GameManager.tictactoescores)
        scores.addAll(HangmanActivity.hangmanscores)
        jsonscores = scores
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)
        /*listView = findViewById(R.id.scoresList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, scores)
        listView.adapter = adapter*/
        date1 = findViewById(R.id.Date1)
        player1 = findViewById(R.id.Player1)
        game1 = findViewById(R.id.Game1)
        score1 = findViewById(R.id.Score1)
        date2 = findViewById(R.id.Date2)
        player2 = findViewById(R.id.Player2)
        game2 = findViewById(R.id.Game2)
        score2 = findViewById(R.id.Score2)
        date3 = findViewById(R.id.Date3)
        player3 = findViewById(R.id.Player3)
        game3 = findViewById(R.id.Game3)
        score3 = findViewById(R.id.Score3)
        while (scores.size > 3) {
            scores.removeAt(0)
        }
        if (! scores.isEmpty()){
            date1.setText(scores[0].date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            player1.setText(scores[0].player)
            game1.setText(scores[0].game.subSequence(0, 3))
            score1.setText(scores[0].score)
            if (scores.size > 1) {
                date2.setText(scores[1].date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                player2.setText(scores[1].player)
                game2.setText(scores[1].game.subSequence(0, 3))
                score2.setText(scores[1].score)
            }
            if (scores.size > 2){
                date3.setText(scores[2].date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                player3.setText(scores[2].player)
                game3.setText(scores[2].game.subSequence(0, 3))
                score3.setText(scores[2].score)
            }
        }
        /*date1.setText("Date")
        player1.setText("Player")
        game1.setText("Game")
        score1.setText("Score")*/
    }

    fun imageClick(view: View)
    {
        val browserintent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.epita.fr/"));
        startActivity(browserintent)
    }

    class Score(date : LocalDateTime, game_id : Int, game : String, player : String, score: String) {
        @RequiresApi(Build.VERSION_CODES.O)
        var date = date
        var gameid = game_id
        var game = game
        var player = player
        var score = score
    }

}
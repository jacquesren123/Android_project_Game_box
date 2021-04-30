package fr.epita.android.game_box

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class HangmanActivity : AppCompatActivity() {
        lateinit var guessWordList: Array<String>
        var maxError = 11
        lateinit var wordToFind: String
        var letterFound: CharArray = CharArray(8)
        var inputLetters: ArrayList<String> = ArrayList<String>(11)
        var err = 0
        lateinit var wordShowing: TextView
        lateinit var missed: TextView
        lateinit var buttonA: Button
        lateinit var buttonB: Button
        lateinit var buttonC: Button
        lateinit var buttonD: Button
        lateinit var buttonE: Button
        lateinit var buttonF: Button
        lateinit var buttonG: Button
        lateinit var buttonH: Button
        lateinit var buttonI: Button
        lateinit var buttonJ: Button
        lateinit var buttonK: Button
        lateinit var buttonL: Button
        lateinit var buttonM: Button
        lateinit var buttonN: Button
        lateinit var buttonO: Button
        lateinit var buttonP: Button
        lateinit var buttonQ: Button
        lateinit var buttonR: Button
        lateinit var buttonS: Button
        lateinit var buttonT: Button
        lateinit var buttonU: Button
        lateinit var buttonV: Button
        lateinit var buttonW: Button
        lateinit var buttonX: Button
        lateinit var buttonY: Button
        lateinit var buttonZ: Button
        var buttonLetters: ArrayList<Button> = ArrayList(26)
        var l: Char = '\u0000'
        var str: String = "Missed : "


        override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_hangman)

           missed = findViewById(R.id.Missed)
           wordShowing = findViewById(R.id.wordShowing)
           buttonLetters.add(findViewById(R.id.buttonA))
           buttonLetters.add(findViewById(R.id.buttonB))
           buttonLetters.add(findViewById(R.id.buttonC))
           buttonLetters.add(findViewById(R.id.buttonD))
           buttonLetters.add(findViewById(R.id.buttonE))
           buttonLetters.add(findViewById(R.id.buttonF))
           buttonLetters.add(findViewById(R.id.buttonG))
           buttonLetters.add(findViewById(R.id.buttonH))
           buttonLetters.add(findViewById(R.id.buttonI))
           buttonLetters.add(findViewById(R.id.buttonJ))
           buttonLetters.add(findViewById(R.id.buttonK))
           buttonLetters.add(findViewById(R.id.buttonL))
           buttonLetters.add(findViewById(R.id.buttonM))
           buttonLetters.add(findViewById(R.id.buttonN))
           buttonLetters.add(findViewById(R.id.buttonO))
           buttonLetters.add(findViewById(R.id.buttonP))
           buttonLetters.add(findViewById(R.id.buttonQ))
           buttonLetters.add(findViewById(R.id.buttonR))
           buttonLetters.add(findViewById(R.id.buttonS))
           buttonLetters.add(findViewById(R.id.buttonT))
           buttonLetters.add(findViewById(R.id.buttonU))
           buttonLetters.add(findViewById(R.id.buttonV))
           buttonLetters.add(findViewById(R.id.buttonW))
           buttonLetters.add(findViewById(R.id.buttonX))
           buttonLetters.add(findViewById(R.id.buttonY))
           buttonLetters.add(findViewById(R.id.buttonZ))

           newGame()
        }

        private fun newGame() {
           guessWordList = resources.getStringArray(R.array.listWord)

           for (button in buttonLetters) {
               button.setBackgroundColor(resources.getColor(R.color.grey))
           }
           err = 0
            inputLetters.clear()
           wordToFind = guessWordList[Random.nextInt(guessWordList.size)]

           letterFound[0] = wordToFind[0]
           letterFound[7] = wordToFind[7]
           for (i in 1..6) {
               letterFound[i] = '_'
           }

           missed.text = str.plus(err.toString()).plus(" / 11")
           wordShowing.text = currentUpdate()
        }

        private fun enterValue (letter: Char) {
           if (!inputLetters.contains(letter.toString())) {
               if (wordToFind.contains(letter)) {
                   var i = wordToFind.indexOf(letter)
                   while (i >= 0) {
                       letterFound[i] = letter
                       i = wordToFind.indexOf(letter, i + 1)
                   }
                   for (button in buttonLetters) {
                       if (letter == button.text[0]) {
                           button.setBackgroundColor(resources.getColor(R.color.green))
                       }
                   }

               }
               else {
                   err++
                   for (button in buttonLetters) {
                       if (letter == button.text[0]) {
                           button.setBackgroundColor(resources.getColor(R.color.red))
                       }
                   }
               }
           }
           inputLetters.add(letter.toString())
        }

        private fun currentUpdate(): String {
           val builder = StringBuilder()
           for (element in letterFound) {
               builder.append(element)
               builder.append(" ")
           }
           return builder.toString()
        }

        fun selectLetter(view: View) {
           if (err < maxError) {
               for (button in buttonLetters) {
                   if (view == button) {
                       l = button.text[0]
                   }
               }
               enterValue(l)
               wordShowing.text = currentUpdate()
               missed.text = str.plus(err.toString()).plus(" / 11")
               }
           }

        fun launchNewGame(view: View) {
           newGame()
        }
}
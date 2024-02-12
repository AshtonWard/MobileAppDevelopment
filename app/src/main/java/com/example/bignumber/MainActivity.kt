package com.example.bignumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    private var leftNum :Int = 0;
    private var rightNum :Int = 0;
    private var score :Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         // above init our app ui


        pickRandomNumbers();
    }

    fun leftButtonOnClick(view: View)
    {
        pickRandomNumbers();
    }

    fun rightButtonOnClick(view: View)
    {
        pickRandomNumbers();
    }

   private  fun pickRandomNumbers()
    {
        var leftButton = findViewById<Button>(R.id.left_number_button);
        var rightButton = findViewById<Button>(R.id.right_number_button);

        val rand = Random();

        leftNum = rand.nextInt(10);
        rightNum = rand.nextInt(10);

        leftButton.text = "$leftNum";
        rightButton.text = "$rightNum";
    }

    private fun updateScoreText(){
        var scoreText = findViewById<TextView>(R.id.score_text)
        val scoreString: String = scoreText.text.toString(R.id.score_text)
        var winImage =findViewById<ImageView>(R.id.pickachu)
        if(scoreString.toInt()> score){
            Toast.makeText(this, "000 NO", Toast.LENGTH_SHORT).show()
            winImage.visability = View.VISABLE
        }
        else if(scoreString.toInt() < score ){
            Toast.makeText( this, "You got it!!", Toast.LENGTH_SHORT).show()
            winImage.visability = View.INVISABLE
        }

        scoreText.text = "Score = $score"
    }
}
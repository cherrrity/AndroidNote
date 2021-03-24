package com.example.anatomyofbasicandroidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Dice Rolled!"

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener{ resetDice() }
    }

    private fun rollDice(){
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()

        Toast.makeText(this, "button Clicked!", Toast.LENGTH_SHORT).show()
        resultText.text = randomInt.toString()

        val drawableResorce = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResorce)

    }

    private fun resetDice(){
        val resultText: TextView = findViewById(R.id.result_text)

        resultText.text = "0"
    }
}
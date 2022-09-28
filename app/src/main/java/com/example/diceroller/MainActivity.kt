package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// This activity allows the user to roll a dice and view the result on the screen.
class MainActivity : AppCompatActivity() {
    // This method is called when the Activity is created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Salva a referência ao objeto Button na variável rollButton e não no objeto Button
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

     // Roll the dice and update the screen with the result
    private fun rollDice() {
        // Create a new Dice object with 6 sides and roll it
        val dice = Dice(6)
        // Create a dice Roll variable to save the result of the roll function applied to the dice object
        val diceRoll = dice.roll()

         // Create a dice Roll variable to save the result of the roll function applied to the dice 2 object
         val diceRoll2 = dice.roll()

        // Cria a variavel diceImage do tipo ImageView, encontrando-a pelo ID no layout
        val diceImage: ImageView = findViewById(R.id.imageView)

         // Cria a variavel diceImage2 do tipo ImageView, encontrando-a pelo ID no layout
         val diceImage2: ImageView = findViewById(R.id.imageView2)

        // O código chama o método setImageResource() na ImageView, transmitindo o ID de recurso
        // para a imagem dice_2. Isso vai atualizar a ImageView na tela para mostrar a imagem dice_2.
        //diceImage.setImageResource(R.drawable.dice_2)

        // Instrução when que atualiza a imageView com base no valor de diceRoll
        //when (diceRoll) {
          //  1 -> diceImage.setImageResource(R.drawable.dice_1)
        //}

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

         // Determine which drawable resource ID to use based on the dice roll 2
         val drawableResource2 = when (diceRoll2) {
             1 -> R.drawable.dice_1
             2 -> R.drawable.dice_2
             3 -> R.drawable.dice_3
             4 -> R.drawable.dice_4
             5 -> R.drawable.dice_5
             else -> R.drawable.dice_6
         }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

         // Update the ImageView2 with the correct drawable resource ID
         diceImage2.setImageResource(drawableResource2)

         // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

// Dice with a fixed number of sides.
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
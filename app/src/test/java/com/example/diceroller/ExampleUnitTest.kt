package com.example.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun generates_number(){
        // Criando instância do objeto Dice
        val dice = Dice(6)
        // Chamando o método roll() nessa instância e armazenando o valor retornado
        val rollResult = dice.roll()

        // Declarando que o método retornou um valor dentro do limite de número de lados transmitido.
        // Nesse caso, o valor precisa ser maior que 0 e menor que 7
        assertTrue("The value of rollResult was not between 1 and 6", rollResult in 1..6)
    }
}



package application.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var randomNumber : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val <variable_name: <view_type> = findViewById(R.id.<view_Id>)
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.text = "Lets Roll"
        rollButton.setOnClickListener {
            rollDice()  //calling fun rollDice
        }
        diceImage = findViewById(R.id.dice_image)
        randomNumber = findViewById(R.id.random_number)

    }

    private fun rollDice() {


        //generating a random number between 0 to 6.
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when(randomInt){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        randomNumber.text = randomInt.toString()
    }
}
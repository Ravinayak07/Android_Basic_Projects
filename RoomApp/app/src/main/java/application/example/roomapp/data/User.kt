package application.example.roomapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// make this a data class by adding the kewyword data before class
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int
)
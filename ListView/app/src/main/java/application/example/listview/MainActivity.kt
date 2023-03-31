package application.example.listview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //access listview from XMl file by findviewById
        val listView = findViewById<ListView>(R.id.list_view)

        //create an array to display in listview
        val names = arrayOf(
            "Android",
            "XML",
            "Java",
            "Kotlin",
            "C",
            "C++",
            "PHP",
            "Javascript",
            "HTML",
            "CSS"
        )


        //create an array adapter of type string
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item Selected: "+names[i], Toast.LENGTH_LONG).show()
        }
    }
}
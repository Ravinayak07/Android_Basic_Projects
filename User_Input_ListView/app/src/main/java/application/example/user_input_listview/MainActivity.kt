package application.example.user_input_listview

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var edtName: EditText
    lateinit var listView: ListView
    lateinit var btn_add: Button
    //var contact=ArrayList<Contact>()
    var lt=ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edt_name)
        listView = findViewById(R.id.listview)
        btn_add = findViewById(R.id.btn_add)

        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,lt)

        btn_add.setOnClickListener {
            val name = edtName.text.toString()
            edtName.setText("")
            lt.add(name)
            listView.adapter = arrayAdapter
        }

        listView.setOnItemClickListener { adapterView, view, pos, l ->
            var name = adapterView.getItemAtPosition(pos).toString()
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
            alert.setMessage("Do you want to delete $name?")
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                lt.removeAt(pos)
                arrayAdapter.notifyDataSetChanged()
            })
            alert.create().show()
        }
    }
}
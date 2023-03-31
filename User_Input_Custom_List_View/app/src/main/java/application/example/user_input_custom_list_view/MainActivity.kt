package application.example.user_input_custom_list_view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    lateinit var edtName: EditText
    lateinit var edtAge: EditText
    lateinit var btnAdd: Button
    lateinit var listview: ListView
    var contact = ArrayList<Contact>()
    lateinit var arrayAdapter: MyAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edt_name)
        edtAge = findViewById(R.id.edt_age)
        btnAdd = findViewById(R.id.btn_add)
        listview = findViewById(R.id.listview)

        arrayAdapter = MyAdapter(this,contact)
        listview.adapter = arrayAdapter

        btnAdd.setOnClickListener {

            var name:String = edtName.text.toString()
            var age:Int = edtAge.text.toString().toInt()

            edtName.setText("")
            edtAge.setText("")

            contact.add(Contact(name,age))

            arrayAdapter.notifyDataSetChanged()

        }

        listview.setOnItemClickListener { adapterView, view, i, l ->

            //contact.removeAt(i)
            // arrayAdapter.notifyDataSetChanged()
            val name:String = contact[i].name
            val age:Int = contact[i].age

            val fragmentmanager : FragmentManager = supportFragmentManager
            val myDialogFragment = MyDialogFragment()

            val bundle = Bundle()
            bundle.putInt("position",i)
            bundle.putString("name",name)
            bundle.putInt("age",age)


            myDialogFragment.arguments = bundle
            myDialogFragment.show(fragmentmanager , "MyDialogFragment")

        }



    }



}
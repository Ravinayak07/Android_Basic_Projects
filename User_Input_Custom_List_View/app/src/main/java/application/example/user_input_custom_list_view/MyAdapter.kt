package application.example.user_input_custom_list_view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class MyAdapter(val context: Activity, var contact: ArrayList<Contact>):
    ArrayAdapter<Contact>(context , R.layout.item_list , contact) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_list,null)

        val item_name: TextView = view.findViewById(R.id.item_name)
        val item_age: TextView = view.findViewById(R.id.item_age)

        var name:String = contact[position].name.toString()
        var age:String = contact[position].age.toString()

        item_name.text = name
        item_age.text = age

        return view
    }



}
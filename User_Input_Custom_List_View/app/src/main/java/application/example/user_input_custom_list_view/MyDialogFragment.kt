package application.example.user_input_custom_list_view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class MyDialogFragment : Fragment() {

    lateinit var dname: EditText
    lateinit var dage: EditText
    lateinit var dupdate: Button
    lateinit var ddelete: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View = inflater.inflate(R.layout.fragment_my_dialog, container, false)

        dname = view.findViewById(R.id.dname)
        dage = view.findViewById(R.id.dage)
        dupdate = view.findViewById(R.id.dupdate)
        ddelete = view.findViewById(R.id.ddelete)

        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        val position = arguments?.getInt("position")!!.toInt()
        val name = arguments?.getString("name").toString()
        val age = arguments?.getInt("age")!!.toInt()

        dname.setText(""+name)
        dage.setText(""+age)

        val mainActivity  = activity as MainActivity
        val contact = mainActivity.contact
        val arrayAdapter = mainActivity.arrayAdapter

        //delete
        ddelete.setOnClickListener {

            contact.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
            dialog!!.dismiss()
        }

        //update
        dupdate.setOnClickListener {

            val new_name:String = dname.text.toString()
            val new_age:Int = dage.text.toString().toInt()

            contact[position].name = new_name
            contact[position].age = new_age
            arrayAdapter.notifyDataSetChanged()
            dialog!!.dismiss()
        }
        return view
    }


}
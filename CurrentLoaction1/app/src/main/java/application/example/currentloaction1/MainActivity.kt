package application.example.currentloaction1

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task

class MainActivity : AppCompatActivity() {

    //declaring variables
    lateinit var fusedLocationProvderClient : FusedLocationProviderClient
    var latitudeTextView: TextView? = null
    var longitTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        latitudeTextView = findViewById(R.id.latTextView)
        longitTextView = findViewById(R.id.longTextView)

        fusedLocationProvderClient = LocationServices.getFusedLocationProviderClient(this)

        findViewById<Button>(R.id.btn_get_Location).setOnClickListener {
            fetchLocation()
        }

    }

    private fun fetchLocation() {

        val task: Task<Location> = fusedLocationProvderClient.lastLocation

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }
        task.addOnSuccessListener {
            if(it != null){
                 Toast.makeText(applicationContext, "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
                latitudeTextView!!.text = "Latitude: " + it.latitude + ""
                longitTextView!!.text = "Longitude: " + it.longitude + ""
            }
        }

    }
}
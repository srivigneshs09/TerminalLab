package com.example.terminallab

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class LocationActivity : AppCompatActivity() {
    private val LOCATION_PERMISSION_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_location)

        val etLatitude: EditText = findViewById(R.id.etLatitude)
        val etLongitude: EditText = findViewById(R.id.etLongitude)
        val btnFetchAddress: Button = findViewById(R.id.btnFetchAddress)
        val textView: TextView = findViewById(R.id.textView)

        btnFetchAddress.setOnClickListener {
            val latStr = etLatitude.text.toString().trim()
            val lngStr = etLongitude.text.toString().trim()

            if (latStr.isNotEmpty() && lngStr.isNotEmpty()) {
                try {
                    val latitude = latStr.toDouble()
                    val longitude = lngStr.toDouble()
                    if (latitude in -90.0..90.0 && longitude in -180.0..180.0) {
                        val address = getAddressFromLatLng(latitude, longitude)
                        textView.text = address ?: "Address not found"
                    } else {
                        Toast.makeText(this, "Invalid latitude or longitude", Toast.LENGTH_SHORT).show()
                    }

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both latitude and longitude", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getAddressFromLatLng(lat: Double, lng: Double): String? {
        return try {
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses = geocoder.getFromLocation(lat, lng, 1)
            if (!addresses.isNullOrEmpty()) {
                val address = addresses[0]
                "${address.getAddressLine(0)}, ${address.locality}, ${address.countryName}"
            } else {
                "No address found"
            }
        } catch (e: Exception) {
            "Error fetching address"
        }
    }
}
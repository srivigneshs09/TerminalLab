package com.example.terminallab

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WifiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wifi)

        val wifiStateTextView = findViewById<TextView>(R.id.wifiStateTextView)
        val toggleWifiButton = findViewById<Button>(R.id.toggleWifiButton)

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        fun updateWifiStatus() {
            wifiStateTextView.text = if (wifiManager.isWifiEnabled) "Wi-Fi is ON" else "Wi-Fi is OFF"
        }

        updateWifiStatus()

        toggleWifiButton.setOnClickListener {
            wifiManager.isWifiEnabled = !wifiManager.isWifiEnabled
            updateWifiStatus()
        }
    }
}
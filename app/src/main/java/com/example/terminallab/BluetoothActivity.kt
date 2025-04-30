package com.example.terminallab

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BluetoothActivity : AppCompatActivity() {
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bluetooth)

        val bluetoothStatusText = findViewById<TextView>(R.id.bluetoothStatusText)
        val toggleBluetoothButton = findViewById<Button>(R.id.toggleBluetoothButton)

        fun updateBluetoothStatus() {
            bluetoothStatusText.text = when {
                bluetoothAdapter == null -> "Bluetooth not supported"
                bluetoothAdapter.isEnabled -> "Bluetooth is ON"
                else -> "Bluetooth is OFF"
            }
        }

        updateBluetoothStatus()

        toggleBluetoothButton.setOnClickListener {
            if (bluetoothAdapter != null) {
                if (bluetoothAdapter.isEnabled) {
                    bluetoothAdapter.disable()
                } else {
                    val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                    startActivity(enableBtIntent)
                }
                updateBluetoothStatus()
            }
        }
    }
}
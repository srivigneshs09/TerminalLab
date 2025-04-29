package com.example.terminallab

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
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

class SMSActivity : AppCompatActivity() {
    private val SMS_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_smsactivity)

        val phoneNumberEditText: EditText = findViewById(R.id.phno)
        val messageEditText: EditText = findViewById(R.id.msghere)
        val sendSmsButton: Button = findViewById(R.id.smsbtn)
        val statusText: TextView = findViewById(R.id.statusText)

        sendSmsButton.setOnClickListener {
            val phoneNumber = phoneNumberEditText.text.toString()
            val message = messageEditText.text.toString()

            if (phoneNumber.isNotEmpty() && message.isNotEmpty()) {
                sendSms(phoneNumber, message, statusText)
            } else {
                Toast.makeText(
                    this,
                    "Please enter both phone number and message",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun sendSms(phone: String, msg: String, statusText: TextView) {
        try {
            val smsManager: SmsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phone, null, msg, null, null)
            statusText.text = "SMS Sent Successfully!"
            Toast.makeText(this, "SMS Sent!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            statusText.text = "SMS Failed to Send!"
            Toast.makeText(this, "SMS Failed!", Toast.LENGTH_SHORT).show()
        }
    }
}
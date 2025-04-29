package com.example.terminallab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NotificationHelper.createNotificationChannel(this)

        findViewById<Button>(R.id.notify_button).setOnClickListener {
            NotificationHelper.showNotification(
                this,
                "Hello!",
                "This is a test notification."
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.dialog_button -> {
                Toast.makeText(this, "Dialogues Selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DialogActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.send_sms_button -> {
                Toast.makeText(this, "Send SMS Selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SMSActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.location_button -> {
                Toast.makeText(this, "Location Selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LocationActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.sharedpref_button -> {
                Toast.makeText(this, "Shared Prefs Selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SharedPrefActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.firebase -> {
                Toast.makeText(this, "Firebase Selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, FirebaseActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
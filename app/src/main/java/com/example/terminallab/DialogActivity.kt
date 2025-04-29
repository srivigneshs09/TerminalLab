package com.example.terminallab

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dialog)
        showSimpleDialog()
    }
    private fun showSimpleDialog() {
        AlertDialog.Builder(this)
            .setTitle("Welcome to Dialogues")
            .setMessage("This is a simple dialog box for the Dialogues Page.")
            .setPositiveButton("OK") { _, _ ->
                // Action when OK is clicked (e.g., do nothing or add custom logic)
            }
            .setNegativeButton("Cancel") { _, _ ->
                // Action when Cancel is clicked (e.g., finish activity)
                finish()
            }
            .setCancelable(false) // Prevents dismissing the dialog by clicking outside
            .show()
    }
}
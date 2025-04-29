package com.example.terminallab

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import android.widget.Button
import android.widget.TextView

class SharedPrefActivity : AppCompatActivity() {
    private val PREFS_NAME = "MyPrefs"
    private val KEY_TEXT = "savedText"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared_pref)

        val textInputEditText: TextInputEditText = findViewById(R.id.textInputEditText)
        val btnSave: Button = findViewById(R.id.btnSave)
        val savedTextView: TextView = findViewById(R.id.savedTextView)

        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        val savedText = sharedPreferences.getString(KEY_TEXT, "No text saved")
        savedTextView.text = "Saved Text: $savedText"

        btnSave.setOnClickListener {
            val text = textInputEditText.text.toString()
            if (text.isNotEmpty()) {
                sharedPreferences.edit().putString(KEY_TEXT, text).apply()
                savedTextView.text = "Saved Text: $text"
            } else {
                savedTextView.text = "Please enter some text"
            }
        }
    }
}
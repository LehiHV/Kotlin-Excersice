package com.example.alacenamientodatos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b = findViewById<Button>(R.id.button)
        val email = findViewById<EditText>(R.id.edtM)

        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
        email.setText(preferencias.getString("mail", ""))

        b.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString("mail", email.text.toString())
            editor.commit()
            finish()
        }
    }
}
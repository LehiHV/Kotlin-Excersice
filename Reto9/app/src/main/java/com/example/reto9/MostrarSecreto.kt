package com.example.reto9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MostrarSecreto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_secreto)
        val l = findViewById<TextView>(R.id.txv);
        val b = findViewById<Button>(R.id.btn2);
        val secreto = intent.getStringExtra("Secreto")
        l.text = "Tu secreto es: $secreto"

        b.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Mensaje", "Ahora Yo se tu secreto");
            startActivity(intent)
        }
    }
}
package com.example.lanzarsegundaactividad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1=findViewById<Button>(R.id.btn)
        boton1.setOnClickListener {
            val intento1 = Intent(this, AcercaDe::class.java)
            startActivity(intento1)
        }
    }
}
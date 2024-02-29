package com.example.reto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt = findViewById<EditText>(R.id.edt);
        val txt2 = findViewById<EditText>(R.id.edt2)
        val btn = findViewById<Button>(R.id.btn_t);
        val txv = findViewById<TextView>(R.id.tv);

        btn.setOnClickListener {
            txv.text ="Hola " + txt.text.toString()+" "+txt2.text.toString() + " Bienvenido";
        }
    }
}
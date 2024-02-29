package com.example.reto2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.EditText
import android.widget.Button
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn);
        val rdb1 = findViewById<RadioButton>(R.id.rdb1);
        val rdb2 = findViewById<RadioButton>(R.id.rdb2)
        val txv2 = findViewById<TextView>(R.id.txv2);
        val edt1= findViewById<EditText>(R.id.edt1);
        val edt2= findViewById<EditText>(R.id.edt2);

        btn.setOnClickListener {
            if (rdb1.isChecked)
                txv2.text = "Hola "+ edt1.text.toString()+ " "+ edt2.text.toString()+ " Tu eleccion fue: "+ rdb1.text.toString();
            if (rdb2.isChecked)
                txv2.text = "Hola "+ edt1.text.toString()+ " "+ edt2.text.toString()+ " Tu eleccion fue: "+ rdb2.text.toString();
            if(rdb1.isChecked!=true && rdb2.isChecked!=true)
                txv2.text= "Selecciona una opcion";
        }
    }
}
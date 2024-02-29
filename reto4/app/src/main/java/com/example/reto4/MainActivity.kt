package com.example.reto4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt2 = findViewById<EditText>(R.id.edt2)
        val edt1 = findViewById<EditText>(R.id.edt1)
        val btn = findViewById<Button>(R.id.btn);
        val txv2 = findViewById<TextView>(R.id.txv2);
        val spn = findViewById<Spinner>(R.id.spn);
        val list = arrayOf("Japan", "Mexico", "USA", "France");
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list)
        spn.adapter = adapter

        btn.setOnClickListener {
            when(spn.selectedItem.toString()){
                "Japan" -> txv2.text = edt1.text.toString() + " " +edt2.text.toString()+" Means "+"Toyota, Sony Motorola in Japanese"
                "Mexico" -> txv2.text = edt1.text.toString() + " " +edt2.text.toString()+" Means "+"Taco, Burrito, AY CARAMBA in Spanish"
                "USA" -> txv2.text = edt1.text.toString() + " " +edt2.text.toString()+" Means "+"Hamburguer, SchoolShooting, Make America Greate Aganin in English"
                "France" -> txv2.text = edt1.text.toString() + " " +edt2.text.toString()+" Means "+"Wi, Bagette, Noir, Ulala in French"
            }
        }
    }
}
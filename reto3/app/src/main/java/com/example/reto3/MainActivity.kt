package com.example.reto3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        val edt1 = findViewById<EditText>(R.id.edt1)
        val edt2 = findViewById<EditText>(R.id.edt2)
        val txv2 = findViewById<TextView>(R.id.txv2)
        val chk1 = findViewById<CheckBox>(R.id.chk1)
        val chk2 = findViewById<CheckBox>(R.id.chk2)
        val chk3 = findViewById<CheckBox>(R.id.chk3)

        btn.setOnClickListener {
            var texto = edt1.text.toString() + " " + edt2.text.toString() + " tu prefieres: \n";
            if(chk1.isChecked)
                texto = texto + chk1.text.toString() + "\n";
            if(chk2.isChecked)
                texto = texto + chk2.text.toString() + "\n";
            if(chk3.isChecked)
                texto = texto + chk3.text.toString() + "\n";

            txv2.text = texto;
        }
    }
}
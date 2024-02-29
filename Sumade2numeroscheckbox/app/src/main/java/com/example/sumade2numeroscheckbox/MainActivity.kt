package com.example.sumade2numeroscheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.CheckBox
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val n1= findViewById<EditText>(R.id.edt1);
        val n2= findViewById<EditText>(R.id.edt2);
        val chk1 = findViewById<CheckBox>(R.id.chk1);
        val chk2 = findViewById<CheckBox>(R.id.chk2);
        val tv = findViewById<TextView>(R.id.tv3);
        val btn = findViewById<Button>(R.id.btn);

        btn.setOnClickListener{
            if(chk1.isChecked)
                tv.text = "Resultado: ${n1.text.toString().toFloat()+n2.text.toString().toFloat()}";
            if(chk2.isChecked)
                tv.text = "Resultado: ${n1.text.toString().toFloat()-n2.text.toString().toFloat()}";
            if(chk1.isChecked!=true && chk2.isChecked!=true)
                tv.text="Respuesta no valida|"
        }

    }
}
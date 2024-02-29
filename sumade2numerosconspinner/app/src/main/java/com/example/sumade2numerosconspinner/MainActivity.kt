package com.example.sumade2numerosconspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.EditText
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val n1 = findViewById<EditText>(R.id.edt1);
        val n2 = findViewById<EditText>(R.id.edt2);
        val btn = findViewById<Button>(R.id.btn);
        val spn = findViewById<Spinner>(R.id.spn);
        val tv = findViewById<TextView>(R.id.tv3);
        val l = arrayOf("Sumar","Restar");
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,l);
        spn.adapter = adaptador;
        btn.setOnClickListener{
            when(spn.selectedItem.toString()){
                "Sumar" -> tv.text = "Resultado: ${n1.text.toString().toFloat()+n2.text.toString().toFloat()}"
                "Restar" -> tv.text = "Resultado: ${n1.text.toString().toFloat()-n2.text.toString().toFloat()}"
            }
        }
    }
}
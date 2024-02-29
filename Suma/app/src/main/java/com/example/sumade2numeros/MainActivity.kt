package com.example.sumade2numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.n1);
        val num2 = findViewById<EditText>(R.id.n2);
        val tv = findViewById<TextView>(R.id.tv1);
        val boton = findViewById<Button>(R.id.button);
        boton.setOnClickListener{
            val n1 = num1.text.toString().toFloat();
            val n2 = num2.text.toString().toFloat();

            val suma = n1 + n2;
            tv.text = "Resultado : ${suma.toString()}"
        }

    }
}
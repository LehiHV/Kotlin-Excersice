package com.example.sumade2numerosconradiobuttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.RadioGroup
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1 = findViewById<EditText>(R.id.n1);
        val num2 = findViewById<EditText>(R.id.n2);
        val r1 = findViewById<RadioButton>(R.id.rdb1);
        val r2 = findViewById<RadioButton>(R.id.rdb2);
        val txtv= findViewById<TextView>(R.id.tv);
        val button = findViewById<Button>(R.id.button);

        button.setOnClickListener{
            if(r1.isChecked)
                txtv.text = "Resultado: ${num1.text.toString().toFloat()+num2.text.toString().toFloat()}"
            if(r2.isChecked)
                txtv.text = "Resultado: ${num1.text.toString().toFloat()-num2.text.toString().toFloat()}"

        }
    }
}
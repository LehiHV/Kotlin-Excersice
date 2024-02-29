package com.example.reto9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val button: Button by lazy {
        findViewById<Button>(R.id.btn)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val e = findViewById<EditText>(R.id.edt)
        val l = findViewById<TextView>(R.id.txv2)
        val secreto = intent.getStringExtra("Secreto")
        val mensaje = intent.getStringExtra("Mensaje");
        if(mensaje !=null){
            l.text= mensaje.toString();
        }else{
            l.text="";
        }
        button.setOnClickListener {
            val intent = Intent(this, MostrarSecreto::class.java)
            intent.putExtra("Secreto", e.text.toString())
            startActivity(intent)
        }
    }
}
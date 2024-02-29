package com.example.reto10

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt = findViewById<EditText>(R.id.edt)
        val txv = findViewById<TextView>(R.id.txv)
        val txv2 = findViewById<TextView>(R.id.txv2)
        val btn = findViewById<Button>(R.id.btn)
        val numero = ((Math.random()*50).toInt())

        val p = getSharedPreferences("Numero", MODE_PRIVATE)
        txv2.setText(p.getString("N",""))
        Toast.makeText(this,"En numero es: "+numero.toString(),Toast.LENGTH_SHORT).show();

        btn.setOnClickListener {
            if (edt.text.toString() == numero.toString()){
                Toast.makeText(this,"Correcto Acertaste!",Toast.LENGTH_SHORT).show();
                val editor = p.edit();
                val t = (txv2.text.toString()).toInt()+1;
                Toast.makeText(this,t.toString(),Toast.LENGTH_SHORT).show();
                editor.putString("N",t.toString())
                editor.commit()
            }else{
                Toast.makeText(this,"Lo siento Valor incorrecto",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
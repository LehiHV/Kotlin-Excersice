package com.example.reto12

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edt1=findViewById<EditText>(R.id.edt1)
        val edt2=findViewById<EditText>(R.id.edt2)
        val edt3=findViewById<EditText>(R.id.edt3)
        val boton1=findViewById<Button>(R.id.btn1)
        val boton2=findViewById<Button>(R.id.btn2)
        val boton3=findViewById<Button>(R.id.btn3)
        val boton4=findViewById<Button>(R.id.btn4)
        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", edt1.getText().toString())
            registro.put("nombre", edt2.getText().toString())
            registro.put("contra", edt3.getText().toString())
            bd.insert("cliente", null, registro)
            bd.close()
            edt1.setText("")
            edt2.setText("")
            edt3.setText("")
            Toast.makeText(this, "Se cargaron los datos del cliente", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,contra from cliente where codigo=${edt1.text.toString()}", null)
            if (fila.moveToFirst()) {
                edt2.setText(fila.getString(0))
                edt3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un cliente con dicho id",  Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton3.setOnClickListener {

            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", edt2.text.toString())
            registro.put("contra", edt3.text.toString())
            val cant = bd.update("cliente", registro, "codigo=${edt1.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un cliente con el código id", Toast.LENGTH_SHORT).show()
        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("cliente", "codigo=${edt1.text.toString()}", null)
            bd.close()
            edt1.setText("")
            edt2.setText("")
            edt3.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el cliente con dicho id", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un cliente con dicho id", Toast.LENGTH_SHORT).show()
        }
    }
}
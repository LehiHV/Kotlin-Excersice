package com.example.almacenamiento_db_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.content.ContentValues
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edt = findViewById<EditText>(R.id.edt1)
        val edt2 = findViewById<EditText>(R.id.edt2)
        val edt3 = findViewById<EditText>(R.id.edt3)

        val alta = findViewById<Button>(R.id.btn1)
        val busqueda = findViewById<Button>(R.id.btn2)
        val bde = findViewById<Button>(R.id.btn3)
        val baja = findViewById<Button>(R.id.btn4)
        val gc = findViewById<Button>(R.id.btn5)

        alta.setOnClickListener {
            val admin = AdminSQLite(this,"administracion",null,1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("Codigo",edt.text.toString())
            registro.put("Descripcion",edt2.text.toString())
            registro.put("Precio",edt3.text.toString())
            bd.insert("Articulos",null,registro)
            bd.close()
            edt.text.clear();
            edt2.text.clear();
            edt3.text.clear();
            Toast.makeText(this,"Articulo Registrado",Toast.LENGTH_SHORT).show()
        }

        busqueda.setOnClickListener {
            val admin = AdminSQLite(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select Descripcion,Precio from Articulos where Codigo=${edt.text.toString()}", null)
            if (fila.moveToFirst()) {
                edt2.setText(fila.getString(0))
                edt3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un artículo con dicho código",  Toast.LENGTH_SHORT).show()
            bd.close()
        }

        bde.setOnClickListener {
            val admin = AdminSQLite(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select Codigo,Precio from Articulos where Descripcion='${edt2.text.toString()}'", null)
            if (fila.moveToFirst()) {
                edt.setText(fila.getString(0))
                edt3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un artículo con dicha descripción", Toast.LENGTH_SHORT).show()
            bd.close()
        }
        baja.setOnClickListener {
            val admin = AdminSQLite(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("Articulos", "Codigo=${edt.text.toString()}", null)
            bd.close()
            edt.setText("")
            edt2.setText("")
            edt3.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()
        }
        gc.setOnClickListener {
            val admin = AdminSQLite(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("Descripcion", edt2.text.toString())
            registro.put("Precio", edt3.text.toString())
            val cant = bd.update("Articulos", registro, "Codigo=${edt.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un artículo con el código ingresado", Toast.LENGTH_SHORT).show()
        }
    }
}
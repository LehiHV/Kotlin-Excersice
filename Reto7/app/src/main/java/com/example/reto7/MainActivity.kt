package com.example.reto7

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b = findViewById<Button>(R.id.btn)

        b.setOnClickListener {
            showToast()
        }
    }
    private fun showToast() {
        val inflater = layoutInflater
        val layout: View = inflater.inflate(R.layout.toast_layout, findViewById(R.id.toast_root) as ViewGroup?)

        val toastText: TextView = layout.findViewById(R.id.toasttext)
        val toastImage: ImageView = layout.findViewById(R.id.toastimage)

        toastText.text = "!Hola solo queria saludarte¡"
        toastImage.setImageResource(R.drawable.feli)

        val toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout

        toast.show()
    }


}
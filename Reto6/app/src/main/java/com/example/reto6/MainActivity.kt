package com.example.reto6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton.setOnClickListener {
            val indice = pokemon.random()
            imageButton.setImageResource(indice)
        }
    }
    private val imageButton: ImageButton by lazy {
        findViewById<ImageButton>(R.id.imb)
    }

    private val pokemon = listOf(
        R.drawable.dragonite,
        R.drawable.mew,
        R.drawable.pikachu
    )


}
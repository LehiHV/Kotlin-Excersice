package com.example.examen

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
data class L(val name: String, val description: String, val imageResId: Int)


class MainActivity : AppCompatActivity() {



    private lateinit var recyclerView: RecyclerView

    private lateinit var lsAdapter: LSAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        val LS = generateLS()

        lsAdapter = LSAdapter(LS)



        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = lsAdapter

    }



    private fun generateLS(): List<L> {

        // Simulated data

        val El_Santo = L("El_Santo", "Icono mexicano rompedor de huesos", R.drawable.elsanto)

        val BlueDemon = L("Blue Demon", "Luchador aserrimo, poderoso", R.drawable.bludemon)

        val Kemonito = L("Kemonito", "Chikito pero poderoso", R.drawable.kemonito)



        return listOf(El_Santo, BlueDemon, Kemonito)

    }

}



class LSAdapter(private val ls: List<L>) :

    RecyclerView.Adapter<LSAdapter.LViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LViewHolder {

        val view = LayoutInflater.from(parent.context)

            .inflate(R.layout.item_luchador, parent, false)

        return LViewHolder(view)

    }



    override fun onBindViewHolder(holder: LViewHolder, position: Int) {

        val fruit = ls[position]

        holder.imageViewFruit.setImageResource(fruit.imageResId)

        holder.textViewName.text = fruit.name

        holder.textViewDescription.text = fruit.description

    }



    override fun getItemCount(): Int {

        return ls.size

    }



    inner class LViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageViewFruit: ImageView = itemView.findViewById(R.id.imageViewL)

        val textViewName: TextView = itemView.findViewById(R.id.textViewName)

        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)

    }

}
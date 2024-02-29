package com.example.reto5

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTask = findViewById<EditText>(R.id.edt)
        val buttonAddTask = findViewById<Button>(R.id.btn)
        val listViewTasks = findViewById<ListView>(R.id.ltv)

        val tasks = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        listViewTasks.adapter = adapter

        buttonAddTask.setOnClickListener {
            val text = editTextTask.text.toString()
            tasks.add(text)
            editTextTask.text.clear()
            adapter.notifyDataSetChanged()
        }

        // Add a listener to the ListView so that the task is displayed when an item is clicked
        listViewTasks.setOnItemClickListener { parent, view, position, id ->
            // Get the task that was clicked
            val task = tasks[position]

            // Display a message with the task
            Toast.makeText(this,"Elegiste la tarea: " +  task, Toast.LENGTH_SHORT).show()
        }
    }
}
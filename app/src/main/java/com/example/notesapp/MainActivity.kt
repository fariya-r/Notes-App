package com.example.notesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var add: CardView
    private lateinit var rcv:RecyclerView

    //for colorful background
    private lateinit var colorfulNotesRecyclerView: RecyclerView
    private val colorfulNotes = mutableListOf<String>()
    //

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add = findViewById(R.id.add_note_btn)
        add.setOnClickListener {
            val intent = Intent(this, AddNote::class.java)
            startActivity(intent)
        }
        val rcv: RecyclerView = findViewById(R.id.rclview)
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rcv.layoutManager = layoutManager
        val arr = arrayOf("All", "Important", "Lecture", "Shopping", "This Week", "To-Do-List","Later", "Home","Office")
        rcv.adapter = Adapter(arr)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val dateList = mutableListOf<Calendar>()
        val today = Calendar.getInstance()
        val startDate = Calendar.getInstance().apply { add(Calendar.MONTH, 0) }

        for (i in 0 until 30) {
            val date = Calendar.getInstance().apply {
                time = startDate.time
                add(Calendar.DAY_OF_MONTH, i)
            }
            dateList.add(date)
        }

        val adapter = DateAdapter(dateList, today)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        //this below code is for "COLOR BACKGROUND OF SAVED NOTES:
        colorfulNotesRecyclerView = findViewById(R.id.colorfulNotesRecyclerView)

        // Add dummy notes for testing
        colorfulNotes.add("Sample Note 1")
        colorfulNotes.add("Sample Note 2")
        colorfulNotes.add("Sample Note 3")
        colorfulNotes.add("Sample Note 4")

        colorfulNotesRecyclerView.layoutManager = LinearLayoutManager(this)
        colorfulNotesRecyclerView.adapter = NotesAdapter(colorfulNotes)
    }
}
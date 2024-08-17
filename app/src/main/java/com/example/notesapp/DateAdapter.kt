package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class DateAdapter(
    private val dateList: List<Calendar>,
    private val currentDate: Calendar
) : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_date, parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val date = dateList[position]
        val sdfDate = SimpleDateFormat("dd", Locale.getDefault())
        val sdfMonth = SimpleDateFormat("MMM ", Locale.getDefault())
        val sdfyear = SimpleDateFormat("yyyy", Locale.getDefault())

        holder.dateText.text = sdfDate.format(date.time)
        holder.monthText.text = sdfMonth.format(date.time)
        holder.year.text = sdfyear.format(date.time)
    }

    override fun getItemCount(): Int = dateList.size

    private fun isToday(date: Calendar): Boolean {
        val today = Calendar.getInstance()
        return date.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                date.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                date.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)
    }

    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateText: TextView = itemView.findViewById(R.id.dateText)
        val monthText: TextView = itemView.findViewById(R.id.monthText)
        val year:TextView = itemView.findViewById(R.id.year)
    }
}

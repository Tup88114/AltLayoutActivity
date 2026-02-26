package edu.temple.fancyscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.profile_photo).setImageResource(R.drawable.istockphoto)

        findViewById<TextView>(R.id.name).setText(R.string.employee_name)

        with(findViewById<TextView>(R.id.email)) {
            setText(R.string.employee_email)
            setTextColor(Color.BLUE)
        }

        findViewById<TextView>(R.id.extension).setText(R.string.employee_extension)

        findViewById<TextView>(R.id.department).setText(R.string.employee_department)

        findViewById<TextView>(R.id.supervisor).setText(R.string.employee_supervisor)

        with (findViewById<RecyclerView>(R.id.directReportsRecyclerView)) {
            adapter = RecyclerViewAdapter(
                arrayOf(
                    "Kate Sacloff",
                    "Andrew Klein",
                    "Maria Ortega",
                    "Brent Stevenson",
                    "Daniel Cho",
                    "Jorge Gomez"
                )
            )
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}

class RecyclerViewAdapter (private val staffList: Array<String>) : RecyclerView.Adapter<RecyclerViewAdapter.StaffListViewHolder>() {
    class StaffListViewHolder(val textView: TextView) : ViewHolder(textView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffListViewHolder {
        return StaffListViewHolder(
            TextView(parent.context).apply {
                textSize = 22f
                setTextColor(Color.BLUE)
                setPadding(50,8,0,8)
            }
        )
    }

    override fun getItemCount() = staffList.size

    override fun onBindViewHolder(holder: StaffListViewHolder, position: Int) {
        holder.textView.text = staffList[position]
    }
}
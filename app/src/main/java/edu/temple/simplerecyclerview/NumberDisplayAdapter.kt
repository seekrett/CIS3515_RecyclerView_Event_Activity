package edu.temple.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// TODO(Step 1: Implement click behavior)

// TODO (Step 1a: Accept lambda in constructor)
class NumberDisplayAdapter (private val numbers: Array<Int>, private val callBack : (Int) -> Unit) : RecyclerView.Adapter<NumberDisplayAdapter.NumberViewHolder>() {

    // TODO (Step 1b: Invoke lambda via onClickListener)
    // Without "inner", it cannot see the other things in the outer class
    inner class NumberViewHolder (layout: View) : RecyclerView.ViewHolder (layout) {
        // enumerate views inside layout
        val textView = layout.findViewById<TextView>(R.id.textView).apply {
            setOnClickListener {
                //         tells us which item is being touched
                callBack(numbers[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.textview_layout, parent, false)
        return NumberViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numbers[position].toString()
    }

}
package br.com.hyudin.multiple_counter.presentation.MultipleCounterFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.hyudin.multiple_counter.R
import br.com.hyudin.multiple_counter.di.model.Counter

class MultipleCounterAdapter(private val listOfCounters: ArrayList<Counter>, private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<MultipleCounterAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView_name: TextView
        val textView_counter: TextView
        val button_plus: Button
        val button_minus: Button

        init {
            // Define click listener for the ViewHolder's View.
            textView_name = view.findViewById(R.id.textView_countername)
            textView_counter = view.findViewById(R.id.textView_counter)
            button_plus = view.findViewById(R.id.button_plus)
            button_minus = view.findViewById(R.id.button_minus)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_multiplecounter, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val counter = listOfCounters[position]
        holder.textView_counter.text = counter.count.toString()
        holder.textView_name.text = counter.name
        holder.button_minus.setOnClickListener { onClickListener.onClick(counter, position,"plus") }
        holder.button_plus.setOnClickListener { onClickListener.onClick(counter, position,"minus") }
    }

    class OnClickListener(val clickListener: (counter: Counter, position: Int, action: String) -> Unit) {
        fun onClick(counter: Counter,position: Int, action:String) = clickListener(counter,position, action)
    }

}

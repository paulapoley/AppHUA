package com.example.aplicacionhua.Modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionfinal.Modelo.Cita
import com.example.aplicacionfinal.R
import java.text.SimpleDateFormat

class AdaptadorCitas(private val dataSet: List<Cita>, private val clickListener: (Cita)->Unit):
                        RecyclerView.Adapter<AdaptadorCitas.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView_espc: TextView
        val textView_fechahora: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView_espc = view.findViewById(R.id.tv_listmedico)
            textView_fechahora = view.findViewById((R.id.tv_fechahora))
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_cita, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView_espc.text = dataSet[position].listmedico
        viewHolder.textView_fechahora.text = SimpleDateFormat("dd/MM/yyyy - HH:mm")
                                        .format(dataSet[position].fechahora.time)
        viewHolder.itemView.setOnClickListener { clickListener(dataSet[position]) }
    }

    override fun getItemCount():Int {
        return dataSet.size
    }

}
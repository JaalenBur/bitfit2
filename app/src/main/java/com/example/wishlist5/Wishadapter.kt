package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist5.R
import com.example.wishlist5.MainActivity

class Wishadapter(private val wishes: List<Wish>) : RecyclerView.Adapter<Wishadapter.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTV : TextView
        val linkTV: TextView
        val priceTV: TextView

        init {

            itemTV = itemView.findViewById(R.id.itemTV)
            linkTV  = itemView.findViewById(R.id.linkTV)
            priceTV = itemView.findViewById(R.id.priceTV)


        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wish = wishes.get(position)
        // Set item views based on views and data model
        holder.itemTV.text = wish.item
        holder.linkTV.text = wish.link
        holder.priceTV.text = wish.price
    }

    override fun getItemCount(): Int {
        return wishes.size
    }

}
package com.example.guess_the_phrase_sql

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val rv: ArrayList<String>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>()  {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ItemViewHolder {
        return RVAdapter.ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rvlist,parent,false )
        )
    }

    override fun onBindViewHolder(holder: RVAdapter.ItemViewHolder, position: Int) {
        val rvv = rv[position]

        holder.itemView.apply {
            var rvlisting= findViewById<TextView>(R.id.rvlisting)
            rvlisting.text = rvv
            if(rvv.startsWith("found")||rvv.contains("correct")){
                rvlisting.setTextColor(Color.GREEN)
            }else if(rvv.startsWith("no")||rvv.startsWith("wrong")){
                rvlisting.setTextColor(Color.RED)
            }else{
                rvlisting.setTextColor(Color.BLACK)
            }
        }
    }

    override fun getItemCount() = rv.size
}

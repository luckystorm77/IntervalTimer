package com.dropman.android.intervaltimer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.interval_list_row.view.*

class IntarvalAdapter(private val context: Context, private val intarvalList: ArrayList<String>)
    : RecyclerView.Adapter<IntarvalAdapter.IntarvalViewHolder>()
{

    private val inflater = LayoutInflater.from(context)

    class IntarvalViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val intarvalText = view.findViewById<TextView>(R.id.intarvalText)
    }

    override fun getItemCount(): Int
    {
        return intarvalList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntarvalViewHolder
    {
        val view = inflater.inflate(R.layout.interval_list_row, parent, false)
        val viewHolder = IntarvalViewHolder(view)

        view.setOnClickListener {
            //TODO:時間編集用のフラグメント表示
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: IntarvalViewHolder, position: Int)
    {
        val intarval = intarvalList[position]
        holder.intarvalText.text = intarval
    }
}
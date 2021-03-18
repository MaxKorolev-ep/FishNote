package com.example.fishnote

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (listArray:ArrayList<ListItem>,context : Context):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context


    class ViewHolder (view: View):RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val fishPng = view.findViewById<ImageView>(R.id.fishPng)

        fun bind(listItem:ListItem, context: Context) {
            tvTitle.text = listItem.title_text
            var textCon = listItem.content_text.substring(0,50) + "..."
            tvContent.text = textCon
            fishPng.setImageResource(listItem.image_id)
            itemView.setOnClickListener() {
                Toast.makeText(context,"Pressed : ${tvTitle.text}",Toast.LENGTH_SHORT).show()
                val i = Intent(context,Content_activity::class.java).apply {
                    putExtra("title",tvTitle.text.toString())
                    putExtra("content",listItem.content_text)
                    putExtra("image", listItem.image_id)
                }
                context.startActivity(i)


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.itemlayout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem,contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    fun updateAdapter(listArray:List<ListItem>)
    {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }

}
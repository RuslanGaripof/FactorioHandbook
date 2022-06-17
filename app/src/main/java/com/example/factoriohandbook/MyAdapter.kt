package com.example.factoriohandbook

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (listArray:ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context



    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.content_titleee)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val tvImage = view.findViewById<ImageView>(R.id.tvImage)


        fun bind(listItem:ListItem,context: Context, position: Int)
        {
            tvTitle.text = listItem.titleText
            var textCon = listItem.contentText.substring(0,50) + "..."
            tvContent.text = textCon
            tvImage.setImageResource(listItem.image_id)
            itemView.setOnClickListener{

                //Toast.makeText(context,"Pressed : $position",Toast.LENGTH_SHORT).show()
                val i = Intent(context,ContentActivity::class.java).apply {

                    putExtra("index",position)
                    putExtra("cat", listItem.cat)
                }
                context.startActivity(i)




            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem,contextR, position)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listArray: List<ListItem>)
    {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}
package com.example.apilecture

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Context, private val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        // Load image into the ShapeableImageView using Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.productTitle)
        val image: ShapeableImageView = itemView.findViewById(R.id.productImage)
    }
}

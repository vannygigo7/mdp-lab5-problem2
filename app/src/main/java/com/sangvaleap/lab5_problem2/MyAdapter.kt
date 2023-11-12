package com.sangvaleap.lab5_problem2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(private var context: Context, private var itemList: List<Product>, private  var cart: ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {

        Picasso.get().load(itemList[position].imageUrl).into(holder.ivImage)
        holder.tvName.setCompoundDrawablesRelativeWithIntrinsicBounds(itemList[position].logo,0, 0, 0)

        holder.tvName.text = itemList[position].name
        holder.tvDescription.text = itemList[position].description
        holder.tvPrice.text = "$ ${itemList[position].price}"
        holder.btnAdd.setOnClickListener {
            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show()
            cart.add(itemList[position])
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("product", itemList[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val ivImage: ImageView = itemView.findViewById(R.id.imgProduct)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val btnAdd: Button = itemView.findViewById(R.id.btnAdd)
    }
}
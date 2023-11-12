package com.sangvaleap.lab5_problem2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sangvaleap.lab5_problem2.databinding.ActivityProductDetailBinding
import com.squareup.picasso.Picasso

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product = intent.getSerializableExtra("product") as? Product
        println(product)
        if(product != null)
            setProductDetail(product)
        binding.btnHome.setOnClickListener {
            finish()
        }
    }

    private fun setProductDetail(product: Product){
        Picasso.get().load(product.imageUrl).into(binding.imgProduct)
        binding.tvName.text = product.name
        binding.tvDescription.text = product.description
        binding.tvPrice.text = "$${product.price}"
    }
}
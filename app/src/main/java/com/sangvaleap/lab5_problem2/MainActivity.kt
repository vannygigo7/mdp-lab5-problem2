package com.sangvaleap.lab5_problem2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangvaleap.lab5_problem2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var cart: ArrayList<Product> = arrayListOf()
    private var productList: ArrayList<Product> = arrayListOf(
        Product(R.drawable.apple, "iPhone", "https://www.apple.com/newsroom/images/product/iphone/standard/Apple_iphone_11-rosette-family-lineup-091019_big.jpg.large.jpg", "great", 1000.0),
        Product(R.drawable.dell,  "Dell XPS 13", "https://multimedia.bbycastatic.ca/multimedia/products/500x500/155/15572/15572227.jpeg", "very good", 1600.0),
        Product(R.drawable.hp, "HP Laptop 15s", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8GIfcM0buafSwPXpSwi7qvm70XbjbTwDILzUAEwGfdYKRPC6BrsrQoDCBX7B21iPfuIE&usqp=CAU", "excellent", 900.0),
        Product(R.drawable.samsung, "Galaxy A12", "https://www.clove.co.uk/cdn/shop/products/18eb4d72-0e3c-4784-80d2-5348c18d7505_2048x.jpg?v=1644571937", "portable", 1500.0),
        Product(R.drawable.samsung,  "Galaxy Book Pro 15.6", "https://i5.walmartimages.com/asr/d3e7a786-6d39-434e-b69a-2ad352520924.b6639e5a7c0c15d8d1e0b88fb3a721a3.jpeg?odnHeight=768&odnWidth=768&odnBg=FFFFFF", "portable", 1900.0),
        Product(R.drawable.apple, "MacBook Pro 1.7GHz", "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/refurb-mbp13touchbar-space-gallery-2019?wid=1144&hei=1144&fmt=jpeg&qlt=90&.v=1579802951704", "great", 2900.0),
        Product(R.drawable.lg, "LG 65\" 4K UHD LED Smart TV ", "https://6sdkqs0f.media.zesty.site/200037370_LG_1.jpg", "perfect", 1400.0),
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(this, productList, cart)
        binding.btnViewCart.setOnClickListener{onViewCart()}
    }

    private fun onViewCart(){
        val productList = if (cart.size > 0) "\n" + cart.map { p->p.name }.toString() else ""
        Toast.makeText(this, "Total products: ${cart.size} $productList", Toast.LENGTH_SHORT).show()
    }
}

package com.sangvaleap.lab5_problem2

import java.io.Serializable

data class Product(
    val logo: Int, val name: String, val imageUrl: String, val description: String, val price: Double
): Serializable
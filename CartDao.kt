package com.example.acaiStore.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CartDao {
    @Insert
    fun insertItem(item: CartItem)

    @Query("SELECT * FROM cart_items")
    fun getAllItems(): List<CartItem>
}

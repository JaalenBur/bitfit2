package com.example.wishlist5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Wish
import com.example.recyclerview.Wishadapter
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var item: EditText
    lateinit var calories: EditText
    lateinit var button: Button
    lateinit var wishes: MutableList<Wish>
    lateinit var wishRV: RecyclerView
    lateinit var wishlistAdapter: Wishadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        item = findViewById(R.id.Item)
        calories = findViewById(R.id.Calories)
        button = findViewById(R.id.button)
        wishRV = findViewById(R.id.wishRV)

        wishes = ArrayList()

        wishlistAdapter = Wishadapter(wishes)

        wishRV.adapter = wishlistAdapter

        wishRV.layoutManager = LinearLayoutManager (this)


        button.setOnClickListener {
            val wish = Wish(item.text.toString(),calories.text.toString())
            wishes.add(wish)
            wishlistAdapter.notifyDataSetChanged()

            item.text.clear()
            calories.text.clear()

            wishRV.smoothScrollToPosition(wishes.lastIndex)

        }



    }



}
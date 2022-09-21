package com.manjilrawal.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvWishItems.adapter = todoAdapter
        rvWishItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etWishTitle.text.toString()
            val todoUrl = etlink.text.toString()
            val todoPrice = etcost.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle,false,"$$todoPrice",todoUrl)
                todoAdapter.addTodo(todo)
                etWishTitle.text.clear()
                etlink.text.clear()
                etcost.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}
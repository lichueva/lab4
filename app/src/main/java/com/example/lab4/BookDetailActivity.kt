package com.example.lab4

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra("BOOK_NAME")
        val author = intent.getStringExtra("BOOK_AUTHOR")
        val genre = intent.getStringExtra("BOOK_GENRE")
        val year = intent.getIntExtra("BOOK_YEAR", 0)

        findViewById<TextView>(R.id.book_name).text = name
        findViewById<TextView>(R.id.book_author).text = author
        findViewById<TextView>(R.id.book_genre).text = genre
        findViewById<TextView>(R.id.book_year).text = year.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
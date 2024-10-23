package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    //private val books = listOf<Book>() // Порожній список для тестування
    private val books = listOf(
        Book("Кобзар", "Тарас Шевченко", "Поезія", 1840),
        Book("Тіні забутих предків", "Михайло Коцюбинський", "Повість", 1911),
        Book("Захар Беркут", "Іван Франко", "Історична повість", 1883),
        Book("Лісова пісня", "Леся Українка", "Драма-феєрія", 1911),
        Book("Чорна рада", "Пантелеймон Куліш", "Історичний роман", 1857),
        Book("Собор", "Олесь Гончар", "Роман", 1968),
        Book("Маруся", "Григорій Квітка-Основ'яненко", "Повість", 1834),
        Book("Солодка Даруся", "Марія Матіос", "Роман", 2004),
        Book("Ворошиловград", "Сергій Жадан", "Роман", 2010),
        Book("Місто", "Валер'ян Підмогильний", "Роман", 1928)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val emptyMessage: TextView = findViewById(R.id.empty_message)

        if (books.isEmpty()) {
            emptyMessage.apply {
                text = "Список порожній"
                visibility = View.VISIBLE
            }
            recyclerView.visibility = View.GONE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyMessage.visibility = View.GONE

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = BookAdapter(books) { book ->
                val intent = Intent(this, BookDetailActivity::class.java).apply {
                    putExtra("BOOK_NAME", book.name)
                    putExtra("BOOK_AUTHOR", book.author)
                    putExtra("BOOK_GENRE", book.genre)
                    putExtra("BOOK_YEAR", book.year)
                }
                startActivity(intent)
            }
        }
    }
}
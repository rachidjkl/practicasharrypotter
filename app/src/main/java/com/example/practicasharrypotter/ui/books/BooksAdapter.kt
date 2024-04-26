package com.example.practicasharrypotter.ui.books

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicasharrypotter.R
import com.example.practicasharrypotter.data.model.Books


class BooksAdapter(private val context: Context, private val booksList: List<Books>) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_books, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = booksList[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return booksList.size
    }


    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val releaseDateTextView: TextView = itemView.findViewById(R.id.fecha)
        private val img: ImageView = itemView.findViewById(R.id.img)

        fun bind(book: Books) {
            titleTextView.text = book.title
            releaseDateTextView.text = book.releaseDate
            Glide.with(itemView)
                .load(book.cover)
                .into(img)
            itemView.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setOnClickListener
                val book = booksList[position]

                showDescriptionBook(book)
            }

            // Aquí puedes añadir más campos de acuerdo a tu modelo Books
        }
    }

    fun showDescriptionBook(book: Books){
        // Crear el diálogo
        val builder = AlertDialog.Builder(context) // Usar el contexto proporcionado al adaptador
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_book, null)
        val descripcion = dialogView.findViewById<TextView>(R.id.dialogDescripcio)
        descripcion.text = book.description
        builder.setView(dialogView)
            .setTitle(book.title)
            .setPositiveButton("Aceptar", null)
        val dialog = builder.create()

        // Mostrar el diálogo
        dialog.show()
    }
}

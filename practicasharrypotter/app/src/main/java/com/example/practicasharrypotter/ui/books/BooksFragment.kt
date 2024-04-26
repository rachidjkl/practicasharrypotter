package com.example.practicasharrypotter.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicasharrypotter.data.model.Books
import com.example.practicasharrypotter.databinding.FragmentBooksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BooksFragment : Fragment() {

    private var _binding: FragmentBooksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val booksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)

        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        val root: View = binding.root



        booksViewModel.onCreate()

        booksViewModel.booksModel.observe(viewLifecycleOwner, Observer { listBook ->
            val adapter = BooksAdapter(requireContext(), listBook!!)
            val gridLayoutManager = GridLayoutManager(requireContext(), 2) // 2 es el número de columnas en la cuadrícula
            binding.RecyclerView.layoutManager = gridLayoutManager
            binding.RecyclerView.adapter = adapter
        })

        binding.btnOrder.setOnClickListener {
            val ascendente = booksViewModel.obtenerOrdenAscendente()
            var librosOrdenados : List<Books>
            if (ascendente) {
                librosOrdenados = booksViewModel.getAllBooksOrdenadosDesc(booksViewModel.booksModel)
            } else {
                librosOrdenados = booksViewModel.getAllBooksOrdenados(booksViewModel.booksModel)
            }
            booksViewModel.toggleOrden()
            booksViewModel.booksModel.postValue(librosOrdenados)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
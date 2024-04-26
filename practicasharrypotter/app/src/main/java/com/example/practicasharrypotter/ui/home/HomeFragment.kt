package com.example.practicasharrypotter.ui.home

import HomeAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practicasharrypotter.R
import com.example.practicasharrypotter.databinding.FragmentHomeBinding
import com.example.practicasharrypotter.ui.books.BooksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.onCreate()
        homeViewModel.charactersModel.observe(viewLifecycleOwner, Observer { listCharacter ->
            val adapter = HomeAdapter(requireContext(), listCharacter!!)
            val gridLayoutManager = GridLayoutManager(requireContext(), 2) // 2 es el número de columnas en la cuadrícula
            binding.RecyclerView.layoutManager = gridLayoutManager
            binding.RecyclerView.adapter = adapter
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
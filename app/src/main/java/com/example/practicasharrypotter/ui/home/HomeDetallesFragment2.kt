package com.example.practicasharrypotter.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.practicasharrypotter.data.model.Characters
import com.example.practicasharrypotter.databinding.FragmentHomeDetalles2Binding


@Suppress("UNREACHABLE_CODE")
class HomeDetallesFragment2 : Fragment() {

    private var _binding: FragmentHomeDetalles2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeDetalles2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val character: Characters? = arguments?.getParcelable("character")
        if (character != null) {
            binding.fullName.text = character.fullName
            binding.nickname.text = character.nickname
            binding.house.text = character.hogwartsHouse
            binding.interpret.text = character.interpretedBy
            binding.children.text = character.children.toString()
            binding.birth.text = character.birthdate
            binding.fullName.text = character.fullName
            Glide.with(this)
                .load(character.image)
                .into(binding.imageView2)
        }
        // Inflate the layout for this fragment
        return root

    }

}
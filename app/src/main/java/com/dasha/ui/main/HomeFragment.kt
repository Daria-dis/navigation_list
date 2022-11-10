package com.dasha.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.dasha.R
import com.dasha.databinding.HomeFragmentBinding
import com.dasha.model.Music


class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null


    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("HomeFragment onViewCreated")
        val mockedList = listOf(
            Pair(Music("Berserk", 9.2), ""),
            Pair(Music("vendetta!", 9.3), ""),
            Pair(Music("Killka", 8.6), ""),
            Pair(Music("Sahara", 7.8), ""),
            Pair(Music("Zep Teri", 9.0), ""),
            Pair(Music("Dead on arrival", 9.0), null),
            Pair(Music("Murder in my mind", 8.9), ""),
            Pair(Music("Override", 9.7), ""),
            Pair(
                Music("IM BETTER", 9.6),
                "https://cdn-icons-png.flaticon.com/512/1628/1628985.png"
            ),
            Pair(Music("Live another day", 6.6), ""),
            Pair(Music("Why not", 9.5), "")
        )
        val adapter = MusicAdapter(mockedList) { position ->
            findNavController().navigate(
                HomeFragmentDirections
                    .homeToMusicDescription(
                        mockedList.get(position).first,
                        mockedList.get(position).second
                    )
            )
        }
        binding.recyclerView.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

}
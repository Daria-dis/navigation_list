package com.dasha.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.dasha.databinding.ActivityMainBinding.inflate
import com.dasha.databinding.MusicDescriptionFragmentBinding


class MusicDescriptionFragment :Fragment() {

    private var _binding: MusicDescriptionFragmentBinding? = null

    private val binding get() = _binding!!

    val args: MusicDescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MusicDescriptionFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("secondFragment " + args.track.getName())
        binding.musicDescription.setText(args.track.getDescription())
        Glide.with(view)
            .load(args.iconUrl)
            .centerCrop()
            .placeholder(binding.musicIcon.drawable)
            .into(binding.musicIcon)

        binding.backButton.setOnClickListener{
            findNavController().navigate(MusicDescriptionFragmentDirections.navigationHome())
        }
    }
}
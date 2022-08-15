package com.wenger.natifetesttask.ui.fragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.wenger.natifetesttask.R
import com.wenger.natifetesttask.databinding.FragmentSelectedGifBinding
import com.wenger.natifetesttask.utils.ColoredPlaceholderGenerator

class SelectedGifFragment : Fragment(R.layout.fragment_selected_gif) {

    private var binding: FragmentSelectedGifBinding? = null
    private val args: SelectedGifFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSelectedGifBinding.bind(view)
        setupView()
    }

    private fun setupView() {
        binding?.apply {
            val gif = args.gifUrl
            Glide.with(requireContext())
                .asGif()
                .load(gif)
                .apply(
                    RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .placeholder(
                            ColorDrawable(
                                ColoredPlaceholderGenerator.generate(
                                    requireContext()
                                )
                            )
                        )
                        .centerCrop()
                )
                .transition(DrawableTransitionOptions.withCrossFade(250))
                .into(selectedGif)
        }
    }
}
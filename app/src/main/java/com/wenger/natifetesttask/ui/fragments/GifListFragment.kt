package com.wenger.natifetesttask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.wenger.natifetesttask.R
import com.wenger.natifetesttask.databinding.FragmentGifListBinding
import com.wenger.natifetesttask.model.TrendingGifResponse
import com.wenger.natifetesttask.ui.GifsAdapter
import com.wenger.natifetesttask.ui.IOnGifsClickListener
import com.wenger.natifetesttask.utils.ViewState
import com.wenger.natifetesttask.utils.collectWhenStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GifListFragment : Fragment(R.layout.fragment_gif_list) {

    private var gifsAdapter: GifsAdapter? = null
    private var binding: FragmentGifListBinding? = null
    private val viewModel: GifsListViewModel by viewModels()

    private val clickListener = object : IOnGifsClickListener {
        override fun onGifsClick(url: String) {
            val directions = GifListFragmentDirections.goToSelectedGifFragment(url)
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGifListBinding.bind(view)
        gifsAdapter = GifsAdapter(clickListener)
        setupView()
        observeViewModel()
    }

    private fun setupView() {
        binding?.apply {
            gifRecycler.layoutManager = GridLayoutManager(this@GifListFragment.context, 2)
            gifRecycler.adapter = gifsAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.gisList.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    showRandomGifs(it.data)
                }
                is ViewState.Error -> {
                    Toast.makeText(context, R.string.something_went_wrong, Toast.LENGTH_SHORT)
                        .show()
                }
                ViewState.Loading -> {
                    //progress bar
                }
            }
        }
    }

    private fun showRandomGifs(gifs: TrendingGifResponse) {
        gifsAdapter?.submitList(gifs.data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package com.lukninja.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.FragmentEpiBinding
import com.lukninja.safeguardpro.databinding.FragmentEpisBinding

class EpiFragment : Fragment() {

    private var _binding: FragmentEpiBinding? = null
    private val binding: FragmentEpiBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
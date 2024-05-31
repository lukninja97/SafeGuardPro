package com.lukninja.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.FragmentFuncionarioBinding
import com.lukninja.safeguardpro.databinding.FragmentFuncionarioDetailBinding

class FuncionarioDetailFragment : Fragment() {

    private var _binding: FragmentFuncionarioDetailBinding? = null
    private val binding: FragmentFuncionarioDetailBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFuncionarioDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
package com.lukninja.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.FragmentFuncionarioBinding
import com.lukninja.safeguardpro.databinding.FragmentFuncionariosBinding
import com.lukninja.safeguardpro.viewmodel.FuncionarioViewModel


class FuncionarioFragment : Fragment() {
    private val viewModel: FuncionarioViewModel by viewModels()

    private var _binding: FragmentFuncionarioBinding? = null
    private val binding: FragmentFuncionarioBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFuncionarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModel.getFuncionario(it.getInt("funcionarioId"))
        }

        viewModel.funcionario.observe(viewLifecycleOwner) {
            binding.tieNome.setText(it.nome)
            binding.tieCargo.setText(it.cargo)
        }

    }
}
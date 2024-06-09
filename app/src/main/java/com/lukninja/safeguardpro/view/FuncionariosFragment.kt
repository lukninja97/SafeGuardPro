package com.lukninja.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.FragmentFuncionariosBinding
import com.lukninja.safeguardpro.view.adapter.FuncionarioAdapter
import com.lukninja.safeguardpro.viewmodel.FuncionarioViewModel

class FuncionariosFragment : Fragment() {

    private var _binding: FragmentFuncionariosBinding? = null
    private val binding: FragmentFuncionariosBinding get() = _binding!!

    private val viewModel: FuncionarioViewModel by viewModels()
    private lateinit var adapter: FuncionarioAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFuncionariosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Quando clicar em algum item da lista
        adapter = FuncionarioAdapter(viewModel.funcionarioList.value) { funcionario ->
            val pessoaBundle = Bundle()
            pessoaBundle.putInt("funcionarioId", funcionario.id)
            arguments = pessoaBundle
            findNavController().navigate(R.id.funcionarioDetailFragment, arguments)
        }

        // Configura a recycler
        val recycler = binding.rvFuncionarios
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Observa para adicionar um item na lista quando for adicionado
        viewModel.funcionarioList.observe(viewLifecycleOwner) {
            adapter.updateFuncionarios(it)
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.funcionarioFragment)
        }

        //Carrega os funcionarios e popula a lista
        viewModel.load()
    }
}
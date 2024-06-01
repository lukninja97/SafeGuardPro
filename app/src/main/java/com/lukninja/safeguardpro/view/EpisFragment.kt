package com.lukninja.safeguardpro.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.FragmentEpisBinding
import com.lukninja.safeguardpro.view.adapter.EpiAdapter
import com.lukninja.safeguardpro.view.adapter.FuncionarioAdapter
import com.lukninja.safeguardpro.viewmodel.EpisViewModel
import com.lukninja.safeguardpro.viewmodel.FuncionariosViewModel

class EpisFragment : Fragment() {

    private var _binding: FragmentEpisBinding? = null
    private val binding: FragmentEpisBinding get() = _binding!!

    private val viewModel: EpisViewModel by viewModels()
    private lateinit var adapter: EpiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Quando clicar em algum item da lista
        adapter = EpiAdapter(viewModel.epiList.value) { epi ->
            val pessoaBundle = Bundle()
            pessoaBundle.putInt("epiId", epi.id)
            arguments = pessoaBundle
            findNavController().navigate(R.id.epiDetailFragment, arguments)
        }

        // Configura a recycler
        val recycler = binding.rvEpis
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Observa para adicionar um item na lista quando for adicionado
        viewModel.epiList.observe(viewLifecycleOwner) {
            adapter.updateEpis(it)
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.epiFragment)
        }

        //Carrega os epis e popula a lista
        viewModel.load()
    }
}
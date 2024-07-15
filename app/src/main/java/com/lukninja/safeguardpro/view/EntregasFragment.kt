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
import com.lukninja.safeguardpro.databinding.FragmentEntregaBinding
import com.lukninja.safeguardpro.databinding.FragmentEntregasBinding
import com.lukninja.safeguardpro.view.adapter.EntregaAdapter
import com.lukninja.safeguardpro.view.adapter.EpiAdapter
import com.lukninja.safeguardpro.viewmodel.EntregaViewModel
import com.lukninja.safeguardpro.viewmodel.EpiViewModel

class EntregasFragment : Fragment() {

    private var _binding: FragmentEntregasBinding? = null
    private val binding: FragmentEntregasBinding get() = _binding!!

    private val viewModel: EntregaViewModel by viewModels()
    private lateinit var adapter: EntregaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntregasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Quando clicar em algum item da lista
        adapter = EntregaAdapter(viewModel.entregaList.value) { epi ->
            val pessoaBundle = Bundle()
            pessoaBundle.putInt("epiId", epi.id)
            arguments = pessoaBundle
//            findNavController().navigate(R.id.epiDetailFragment, arguments)
        }

        // Configura a recycler
        val recycler = binding.rvEntregas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Observa para adicionar um item na lista quando for adicionado
        viewModel.entregaList.observe(viewLifecycleOwner) {
            adapter.updateEntregas(it)
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.entregaFragment)
        }

        //Carrega os epis e popula a lista
//        viewModel.load()
    }
}
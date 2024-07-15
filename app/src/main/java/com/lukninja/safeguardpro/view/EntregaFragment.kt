package com.lukninja.safeguardpro.view

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import com.lukninja.safeguardpro.databinding.FragmentEntregaBinding
import com.lukninja.safeguardpro.viewmodel.EntregaViewModel
import com.lukninja.safeguardpro.viewmodel.EpiViewModel
import com.lukninja.safeguardpro.viewmodel.FuncionarioViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EntregaFragment : Fragment() {

    private var _binding: FragmentEntregaBinding? = null
    private val binding: FragmentEntregaBinding get() = _binding!!

    private val viewModel: EntregaViewModel by viewModels()
    private val viewModelEpi: EpiViewModel by viewModels()
    private val viewModelFuncionario: FuncionarioViewModel by viewModels()

    private var funcionariosItens =
        mutableListOf("", "Lucas", "Luciano", "Gabriel", "Vinicius", "Gustavo", "Pedro")
    private var episItens =
        mutableListOf("", "Capacete", "Oculos", "Luva", "Mascara", "Protetor Auditivo", "Macacão")

    private val funcionarioSelected = 0
    private val epiSelected = 0

    private val date = LocalDateTime.now()
    private val format = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    private val day = date.dayOfMonth
    private val month = date.month
    private val year = date.year

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntregaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configSpinners()
        observers()

        // carregar a lista para jogar no spinner
        viewModelFuncionario.load()
        viewModelEpi.load()

        binding.btnEntregar.setOnClickListener {
            if (funcionarioSelected != 0 && epiSelected != 0) {

            }
        }

    }

    private fun observers() {
        viewModelFuncionario.funcionarioList.observe(viewLifecycleOwner) { funcionarios ->
            funcionarios.forEach {
                funcionariosItens.add(it.nome)
            }
        }

        viewModelEpi.epiList.observe(viewLifecycleOwner) { epis ->
            epis.forEach {
                episItens.add(it.nome)
            }
        }
    }

    private fun configSpinners() {
        val adapterFuncionario =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, funcionariosItens)
        adapterFuncionario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(binding.spinnerFuncionario) {
            adapter = adapterFuncionario
            onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    showToast(message = "Spinner EPI Position:${position} and language: ${funcionariosItens[position]}")
                    if (position != 0){
                        
                        binding.tvDataEntrega.text = "Entregue em " + format.format(date)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
            prompt = "Selecione o funcionário"
            gravity = Gravity.CENTER
        }

        val adapterEpi = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, episItens)
        adapterEpi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(binding.spinnerEpi) {
            adapter = adapterEpi
            prompt = "Selecione o epi"
            gravity = Gravity.CENTER
            onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    showToast(message = "Spinner EPI Position:${position} and language: ${episItens[position]}")
                    if (position != 0) {
                        binding.tvDataValidade.text = "Expira em " + format.format(date.plusMonths(3L))
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    private fun showToast(
        context: Context = requireContext(),
        message: String,
        duration: Int = Toast.LENGTH_LONG
    ) {
        Toast.makeText(context, message, duration).show()
    }
}
package com.lukninja.safeguardpro.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.FragmentLoginBinding
import com.lukninja.safeguardpro.service.model.Login
import com.lukninja.safeguardpro.viewmodel.FuncionarioViewModel

class LoginFragment : Fragment() {
    private val viewModelFuncionario: FuncionarioViewModel by viewModels()

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var senha = ""
        var cpf = ""

        binding.btnCadastrar.setOnClickListener {
            cpf = binding.tieCpf.editableText.toString()
            senha = binding.tieSenha.editableText.toString()

            if ((cpf.isBlank() || cpf.isEmpty()) || (senha.isBlank() || senha.isEmpty())) {
                Toast.makeText(requireContext(), "Preencha os campos", Toast.LENGTH_LONG).show()
            } else {
                viewModelFuncionario.getFuncionario(cpf.toInt())
            }
        }

        viewModelFuncionario.funcionario.observe(viewLifecycleOwner) {
            if (it.nome == senha && it.id == cpf.toInt()){

                Login.userConected(it.id, it.ctps, it.adm)

                if (it.adm) {
                    findNavController().navigate(R.id.homeSupervisorFragment)
                } else {
                    findNavController().navigate(R.id.homeFragment)
                }
            } else {
                Toast.makeText(requireContext(), "Usuario ou senha inválidos", Toast.LENGTH_LONG).show()
            }
        }

        viewModelFuncionario.erro.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Erro: $it", Toast.LENGTH_LONG).show()
            Log.e("erro", "erro: $it")
        }
    }
}
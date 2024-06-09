package com.lukninja.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.lukninja.safeguardpro.R
import com.lukninja.safeguardpro.databinding.FragmentEpiDetailBinding
import com.lukninja.safeguardpro.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
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

        binding.btnCadastrar.setOnClickListener {
            val cpf = binding.tieCpf.editableText.toString()
            val senha = binding.tieSenha.editableText.toString()

            if ((cpf.isBlank() || cpf.isEmpty()) || (senha.isBlank() || senha.isEmpty())) {
                Toast.makeText(requireContext(), "Preencha os campos", Toast.LENGTH_LONG).show()
            } else {
                if (cpf == "1") {
                    findNavController().navigate(R.id.homeSupervisorFragment)

                } else {
                    findNavController().navigate(R.id.homeFragment)
                }
            }
        }
    }
}
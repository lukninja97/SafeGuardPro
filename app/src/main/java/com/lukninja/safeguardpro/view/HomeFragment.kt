package com.lukninja.safeguardpro.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lukninja.safeguardpro.databinding.FragmentHomeBinding
import com.lukninja.safeguardpro.service.model.Login

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "User conncted: ${Login.userAdm}", Toast.LENGTH_LONG).show()
        Log.e("User", "User conncted: id ${Login.userId}, ctps ${Login.userCtps}, adm ${Login.userAdm}")
    }
}
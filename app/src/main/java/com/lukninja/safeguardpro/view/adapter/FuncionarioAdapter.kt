package com.lukninja.safeguardpro.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukninja.safeguardpro.databinding.ListItemFuncionarioBinding
import com.lukninja.safeguardpro.service.model.Funcionario

class FuncionarioAdapter(funcionarios: List<Funcionario>?, private val clickListListener: (Funcionario) -> Unit) :
    RecyclerView.Adapter<FuncionarioAdapter.FuncionarioViewHolder>() {

    private var funcionarioList: List<Funcionario> = arrayListOf()

    class FuncionarioViewHolder(private val binding: ListItemFuncionarioBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(funcionario: Funcionario, clickListListener: (Funcionario) -> Unit) {
            binding.tvNome.text = funcionario.nome

            binding.root.setOnClickListener {
                clickListListener(funcionario)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuncionarioViewHolder {
        val listItemFuncionarioBinding =
            ListItemFuncionarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FuncionarioViewHolder(listItemFuncionarioBinding)
    }

    override fun getItemCount(): Int {
        return funcionarioList.count()
    }

    override fun onBindViewHolder(holder: FuncionarioViewHolder, position: Int) {
        holder.bind(funcionarioList[position], clickListListener)
    }

    fun updateFuncionarios(list: List<Funcionario>) {
        funcionarioList = list
        notifyDataSetChanged()
    }
}
package com.lukninja.safeguardpro.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukninja.safeguardpro.databinding.ListItemEntregaBinding
import com.lukninja.safeguardpro.service.model.Entrega

class EntregaAdapter(entregas: List<Entrega>?, private val clickListListener: (Entrega) -> Unit) :
    RecyclerView.Adapter<EntregaAdapter.EntregaViewHolder>() {

    private var entregaList: List<Entrega> = arrayListOf()

    class EntregaViewHolder(private val binding: ListItemEntregaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(entrega: Entrega, clickListListener: (Entrega) -> Unit) {
            binding.tvDataEntrega.text = entrega.dataEntrega

            binding.root.setOnClickListener {
                clickListListener(entrega)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntregaViewHolder {
        val listItemEntregaBinding =
            ListItemEntregaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntregaViewHolder(listItemEntregaBinding)
    }

    override fun getItemCount(): Int {
        return entregaList.count()
    }

    override fun onBindViewHolder(holder: EntregaViewHolder, position: Int) {
        holder.bind(entregaList[position], clickListListener)
    }

    fun updateEntregas(list: List<Entrega>) {
        entregaList = list
        notifyDataSetChanged()
    }
}
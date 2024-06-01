package com.lukninja.safeguardpro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lukninja.safeguardpro.service.model.Funcionario
import com.lukninja.safeguardpro.service.repository.FuncionariosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FuncionariosViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = FuncionariosRepository(application)

    private val mFuncionarioList = MutableLiveData<List<Funcionario>>()
    val funcionarioList: LiveData<List<Funcionario>> = mFuncionarioList

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
//            mFuncionarioList.postValue(repository.getPessoas())
        }
    }
}
package com.lukninja.safeguardpro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lukninja.safeguardpro.service.model.Epi
import com.lukninja.safeguardpro.service.model.Funcionario
import com.lukninja.safeguardpro.service.repository.EpisRepository
import com.lukninja.safeguardpro.service.repository.FuncionariosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EpisViewModel (application: Application) : AndroidViewModel(application) {
    private val repository = EpisRepository(application)

    private val mEpiList = MutableLiveData<List<Epi>>()
    val epiList: LiveData<List<Epi>> = mEpiList

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
//            mEpiList.postValue(repository.getPessoas())
        }
    }
}
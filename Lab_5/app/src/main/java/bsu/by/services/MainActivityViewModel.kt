package bsu.by.services

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var isMainServiceBinded: MutableLiveData<Boolean> = MutableLiveData()
    fun Set_isMainServiceBinded(state:Boolean){
        isMainServiceBinded.value=state
    }
    fun Get_isMainServiceBinded():LiveData<Boolean>{
        return isMainServiceBinded
    }
}
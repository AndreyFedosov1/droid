package com.example.myapplication

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Bindable

class MainViewModel : ViewModel(){


    @Bindable
    val editTextContent = MutableLiveData<String>()

    private val _displayedEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
        get()= _displayedEditTextContent

    fun onDisplayEditTextContentClick(){
        _displayedEditTextContent.value=editTextContent.value
    }

}
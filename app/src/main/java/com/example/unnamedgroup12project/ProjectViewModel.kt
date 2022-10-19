package com.example.unnamedgroup12project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProjectViewModel(): ViewModel() {

    private var _id = MutableLiveData<Long>()
    val id: LiveData<Long> = _id
    fun setIdData(passId: Long) {
        _id.value = passId
    }

    private var _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    fun setNameData(passName: String) {
        _name.value = passName
    }

}
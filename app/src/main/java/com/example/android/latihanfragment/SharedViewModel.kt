package com.example.android.latihanfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){
    private val _myData = MutableLiveData<MyData>()
    val myData : LiveData<MyData> = _myData

    private val _eventSimpan = MutableLiveData<Boolean>()
    val eventSimpan: LiveData<Boolean> get() = _eventSimpan

    private val _jk = MutableLiveData<Int>()
    val jk: LiveData<Int> get() = _jk

    init {
        _jk.value = 0
        _myData.value = MyData()
    }

    fun updateJk(jk: Int) {
        _jk.value = jk
    }

    fun updateJkText(jk: String) {
        _myData.value?.jk = jk
    }

    fun updateMyData(nama: String, nik: String, usia: String) {
        _myData.value?.nama = nama
        _myData.value?.nik = nik
        _myData.value?.usia = usia
    }

    fun onSimpan() {
        _eventSimpan.value = true
    }

    fun onSimpanComplete() {
        _eventSimpan.value = false
    }
}
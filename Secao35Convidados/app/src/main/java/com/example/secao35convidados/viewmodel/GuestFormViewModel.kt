package com.example.secao35convidados.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secao35convidados.service.model.GuestModel
import com.example.secao35convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

    fun save(mGuestId: Int, name: String, presence: Boolean) {
        val guest = GuestModel(mGuestId, name, presence)

        if(mGuestId == 0)
            mSaveGuest.value = mGuestRepository.save(guest)
        else
            mSaveGuest.value = mGuestRepository.update(guest)
    }

    fun load(id: Int){
        mGuest.value = mGuestRepository.get(id)
    }
}
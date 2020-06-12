package com.im3.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.im3.conf.model.Speaker
import com.im3.conf.network.Callback
import com.im3.conf.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel {
    val firestoreService = FirestoreService()
    var listSpeaker: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakerFromFirebase()
    }

    fun getSpeakerFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
            }

            override fun onFailed(exception: Exception) {
                TODO("Not yet implemented")
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }
}
package com.im3.conf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.im3.conf.model.Conference
import com.im3.conf.model.Speaker

//import javax.security.auth.callback.Callback

const val CONFERENCES_COLLECTION_NAME = "conference"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance() //Conexión a la base de datos
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build() //Obtención de datos de modo offline

    init {
        firebaseFirestore.firestoreSettings = settings //Descargados los datos quedarán persistentes en modo offline
    }

    fun getSpeakers(callback: Callback<List<Speaker>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>) {
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                }
            }
    }
}
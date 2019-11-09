package br.com.vinimanara.chatboardapp.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
class DatabaseUtil {
    companion object {
        private val firebaseDatabase: FirebaseDatabase =
            FirebaseDatabase.getInstance()
        init {
            firebaseDatabase.setPersistenceEnabled(true)
        }
        fun getDatabase() : FirebaseDatabase {
            return firebaseDatabase
        }
        fun saveToken(token: String?) {
            val user = FirebaseAuth.getInstance().currentUser?.uid ?: ""
            if (user != "") {
                FirebaseDatabase.getInstance().getReference("UsersTokens")
                    .child(FirebaseAuth.getInstance().currentUser?.uid ?: "")
                    .setValue(token)
            }
        }
    }
}
package com.projemanag.firebase

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.projemanag.activities.MainActivity
import com.projemanag.activities.SignInActivity
import com.projemanag.activities.SignUpActivity
import com.projemanag.modules.User
import com.projemanag.utils.Constants

class FirestoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }
            .addOnFailureListener { e ->
                Log.e(activity.javaClass.simpleName, "Error while registering the user.", e)
            }
    }

    fun signInUser(activity: SignInActivity, userInfo: User) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)
                activity.signInSuccess(loggedInUser!!)
            }
            .addOnFailureListener { e ->
                Log.e(activity.javaClass.simpleName, "Error while signing in the user.", e)
            }
    }

    fun getCurrentUserID(): String {
        var currentUser = FirebaseAuth.getInstance().currentUser
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }


}
package com.example.budgetly.presentation.login.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.budgetly.navigation.NavigationItem
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(@ApplicationContext private val context: Context) :
    ViewModel() {
    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _isVisible = MutableLiveData(false)
    val isVisible: LiveData<Boolean> = _isVisible

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun onChangeEmail(emailText: String) {
        _email.value = emailText
    }

    fun onChangePassword(passwordText: String) {
        _password.value = passwordText
    }

    fun changeVisibility() {
        _isVisible.value = !_isVisible.value!!
    }

    fun verifyEmptyInputs(auth: FirebaseAuth, inputsText: String, navController: NavController) {
        if (_email.value!!.isEmpty() || _password.value!!.isEmpty()) {
            Toast.makeText(context, inputsText, Toast.LENGTH_LONG).show()
            return
        }

        _isLoading.value = true
        auth.signInWithEmailAndPassword(_email.value!!, _password.value!!)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navController.navigate(NavigationItem.Home.route)
                } else {
                    Toast.makeText(context, "No se pudo loguear", Toast.LENGTH_LONG).show()
                }
            }
        _isLoading.value = false
    }

}
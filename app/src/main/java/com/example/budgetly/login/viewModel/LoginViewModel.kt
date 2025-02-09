package com.example.budgetly.login.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    fun onChangeEmail(emailText: String) {
        _email.value = emailText
    }

    fun onChangePassword(passwordText: String) {
        _password.value = passwordText
    }

    fun verifyEmptyInputs() {
        if (_email.value!!.isEmpty() || _password.value!!.isEmpty()) {
            return
        }

        Toast.makeText(context, "Iniciando sesion ...", Toast.LENGTH_LONG).show()
    }

}
package com.example.budgetly.register.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.budgetly.navigation.NavigationItem
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.Year
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(@ApplicationContext private val context: Context) :
    ViewModel() {
    private val _step = MutableLiveData(1)
    val step: LiveData<Int> = _step

    //Firs Step
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _lastName = MutableLiveData("")
    val lastName: LiveData<String> = _lastName

    private val _dayValue = MutableLiveData(1)
    val dayValue: LiveData<Int> = _dayValue

    private val _monthValue = MutableLiveData<String>()
    val monthValue: LiveData<String> = _monthValue

    private val _yearValue = MutableLiveData<Int>()
    val yearValue: LiveData<Int> = _yearValue

    //Second Step
    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _repeatPassword = MutableLiveData("")
    val repeatPassword: LiveData<String> = _repeatPassword

    //Third Step
    private val _incomeValue = MutableLiveData("")
    val incomeValue: LiveData<String> = _incomeValue

    private val _moneyType = MutableLiveData("USD")
    val moneyType: LiveData<String> = _moneyType

    private val _incomeConcurrent = MutableLiveData<String>()
    val incomeConcurrent: LiveData<String> = _incomeConcurrent

    fun onBackStep(navController: NavController) {
        if (_step.value == 1) {
            navController.navigate(NavigationItem.Login.route)
            return
        }
        _step.value = _step.value!! - 1
    }

    //First Step
    fun onChangeName(text: String) {
        _name.value = text
    }

    fun onChangeLastName(text: String) {
        _lastName.value = text
    }

    fun getCurrentYear() {
        if (_yearValue.value == null) {
            _yearValue.value = Year.now().value
        }
    }

    fun getNumberDayDependsMonth(monthList: List<String>): IntRange {
        if (_monthValue.value == monthList[1]) {
            return 1..28
        }

        val index = monthList.indexOf(_monthValue.value)

        return if ((index % 2 == 0 && index < 7) || (index % 2 != 0 && index >= 7)) {
            1..31
        } else {
            1..30
        }
    }

    fun onChangeDayValue(day: Int) {
        _dayValue.value = day
    }

    fun onChangeMonthValue(month: String) {
        _monthValue.value = month
    }

    fun onChangeYearValue(year: Int) {
        _yearValue.value = year
    }

    //Second Step
    fun onChangeEmail(email: String) {
        _email.value = email
    }

    fun onChangePassword(password: String) {
        _password.value = password
    }

    fun onChangeRepeatPassword(repeatPassword: String) {
        _repeatPassword.value = repeatPassword
    }

    //Third Step
    fun onChangeIncomeValue(incomeValue: String) {
        _incomeValue.value = incomeValue
    }

    fun onChangeMoneyType(moneyTypeSelected: String) {
        _moneyType.value = moneyTypeSelected
    }

    fun onChangeIncomeConcurrent(incomeConcurrentSelected: String) {
        _incomeConcurrent.value = incomeConcurrentSelected
    }

    //Validate Step
    fun onValidateInputs(
        textToast: String,
        textToastRepeat: String,
        navController: NavController,
        auth: FirebaseAuth
    ) {
        when (_step.value) {
            1 -> {
                if (_name.value!!.isEmpty() || _lastName.value!!.isEmpty()) {
                    Toast.makeText(context, textToast, Toast.LENGTH_LONG).show()
                    return
                }

                _step.value = _step.value!! + 1
            }

            2 -> {
                if (_incomeValue.value!!.isEmpty()) {
                    Toast.makeText(context, textToast, Toast.LENGTH_LONG).show()
                    return
                }

                _step.value = _step.value!! + 1
            }

            3 -> {
                if (_email.value!!.isEmpty() || _password.value!!.isEmpty() || _repeatPassword.value!!.isEmpty()) {
                    Toast.makeText(context, textToast, Toast.LENGTH_LONG).show()
                    return
                }

                if (_password.value != _repeatPassword.value) {
                    Toast.makeText(context, textToastRepeat, Toast.LENGTH_LONG).show()
                    return
                }

                auth.createUserWithEmailAndPassword(_email.value!!, _password.value!!)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navController.navigate(NavigationItem.Home.route)
                        } else {
                            if(task.exception?.message == "The email address is already in use by another account."){
                                Toast.makeText(context, "El correo ya esta en uso", Toast.LENGTH_LONG)
                                    .show()
                            }else{
                                Toast.makeText(context, "No se pudo registrar", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
            }
        }
    }
}
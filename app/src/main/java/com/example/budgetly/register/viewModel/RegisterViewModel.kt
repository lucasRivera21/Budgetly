package com.example.budgetly.register.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Year
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _step = MutableLiveData(1)
    val step: LiveData<Int> = _step

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

    fun putFirstMonth(firsMonth: String){
        _monthValue.value = firsMonth
    }

    fun getNumberDayDependsMonth(monthList: List<String>): IntRange{
        if(_monthValue.value == monthList[1]){
            return 1 .. 28
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
}
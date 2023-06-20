package br.com.hyudin.multiple_counter.presentation.MultipleCounterFragment

import androidx.lifecycle.ViewModel

class MultipleCounterViewModel: ViewModel() {

    fun increaseCount(actualCount: Int): Int {
        return actualCount + 1
    }

    fun decreaseCount(actualCount: Int): Int {
        return actualCount - 1
    }
}
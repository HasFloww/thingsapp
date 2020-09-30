package com.testthings.fragment.presenters

class FirstPresenter {
    fun validate(elementToValidate: String): Boolean {
        return elementToValidate.length in 1..10
    }
}
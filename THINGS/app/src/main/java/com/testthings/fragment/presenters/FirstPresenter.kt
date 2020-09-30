package com.testthings.fragment.presenters

import android.content.res.Resources

class FirstPresenter {


    fun validate(elementToValidate: String): Boolean {
        return elementToValidate.length in 1..10
    }



}
package com.testthings.fragment.presenters

import com.testthings.fragment.DataManager
import com.testthings.fragment.adapters.FirstData

class SecondPresenter {

    private var listOfThings = ArrayList<FirstData>()
    private var chosenThing: FirstData? = null

    init {
        listOfThings.addAll(DataManager.getSelectedThings())
        chosenThing = listOfThings.removeAt(rand(listOfThings.size - 1))
    }

    private fun rand(end: Int): Int {
        return (0..end).random()
    }

    fun getListOfThings(): ArrayList<FirstData> {
        return listOfThings
    }

    fun getChosen(): String {
        return chosenThing?.element ?: ""
    }
}
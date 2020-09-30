package com.testthings.fragment

import com.testthings.fragment.adapters.FirstData

object DataManager {
    var allThings = ArrayList<FirstData>()
    var dataCallback: DataCallback? = null

    fun thingSelected(thing: FirstData, state: Boolean) {
        allThings.find { it == thing }?.isSelected = state
        dataCallback?.onDataChanged(getSelectedNumber())
    }

    fun getSelectedThings(): ArrayList<FirstData> {
        val selectedArray = ArrayList<FirstData>()
        for (data in allThings) {
            if (data.isSelected) {
                selectedArray.add(data)
            }
        }
        return selectedArray
    }

    fun getSelectedNumber(): Int {
        return allThings.count { it.isSelected }
    }

    interface DataCallback {
        fun onDataChanged(selectedNumber: Int)
    }

}
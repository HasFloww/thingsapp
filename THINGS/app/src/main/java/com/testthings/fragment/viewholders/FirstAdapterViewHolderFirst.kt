package com.testthings.fragment.viewholders

import android.view.View
import com.testthings.fragment.DataManager
import com.testthings.fragment.adapters.FirstData
import kotlinx.android.synthetic.main.first_item.view.*

class FirstAdapterViewHolderFirst(private val mView: View) : FirstBaseViewHolder(mView) {

    override fun bind(data: FirstData) {
        mView.thingsItem.text = data.element
        mView.rowSelectedImage.visibility = if (data.isSelected) View.VISIBLE else View.GONE
        mView.setOnClickListener {
            data.isSelected = !data.isSelected
            DataManager.thingSelected(data, data.isSelected)
            mView.rowSelectedImage.visibility = if (data.isSelected) View.VISIBLE else View.GONE
        }

    }
}
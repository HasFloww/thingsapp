package com.testthings.fragment.viewholders

import android.view.View
import com.testthings.fragment.adapters.FirstData
import kotlinx.android.synthetic.main.first_item.view.*


class SecondAdapterViewHolderFirst(private val mView: View) : FirstBaseViewHolder(mView) {

    override fun bind(data: FirstData) {
        mView.thingsItem.text = data.element
    }
}
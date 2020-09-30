package com.testthings.fragment.viewholders

import android.view.View
import com.testthings.fragment.adapters.FirstData
import kotlinx.android.synthetic.main.second_item_footer.view.*


class FooterAdapterViewHolderSecond(val view: View, private val callback: FooterCallback): FirstBaseViewHolder(view) {

    override fun bind(data: FirstData) {
        view.backButton.setOnClickListener {
            callback.onNextButtonClick()
        }
    }

    interface FooterCallback {
        fun onNextButtonClick()
    }
}
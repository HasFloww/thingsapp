package com.testthings.fragment.viewholders

import android.view.View
import com.testthings.fragment.DataManager
import com.testthings.fragment.adapters.FirstData
import kotlinx.android.synthetic.main.first_item_footer.view.*

class FooterAdapterViewHolderFirst(val view: View, val callback: FooterCallback): FirstBaseViewHolder(view) {

    override fun bind(data: FirstData) {
        DataManager.dataCallback = object: DataManager.DataCallback {
            override fun onDataChanged(selectedNumber: Int) {
                callback.forceNotify()
            }

        }
        view.nextButton.isEnabled = DataManager.getSelectedNumber() >= 3
        view.nextButton.setOnClickListener {
            callback.onNextButtonClick()
        }
    }

    interface FooterCallback {
        fun forceNotify()
        fun onNextButtonClick()
    }

}
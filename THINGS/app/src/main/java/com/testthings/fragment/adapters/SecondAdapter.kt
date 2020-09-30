package com.testthings.fragment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testthings.R
import com.testthings.fragment.viewholders.*


class SecondAdapter(val context: Context?) : RecyclerView.Adapter<FirstBaseViewHolder>() {

    var thingsList = ArrayList<FirstData>()
    var callback: SecondCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstBaseViewHolder {
        if (viewType == 0) {
            return FooterAdapterViewHolderSecond((LayoutInflater.from(context).inflate(R.layout.second_item_footer, parent, false)),
                object: FooterAdapterViewHolderSecond.FooterCallback {
                    override fun onNextButtonClick() {
                        callback?.onBackButtonPressed()
                    }
                })
        }
        return SecondAdapterViewHolderFirst(
            LayoutInflater.from(context).inflate(R.layout.second_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return thingsList.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == thingsList.size) 0 else 1
    }

    override fun onBindViewHolder(holderFirst: FirstBaseViewHolder, position: Int) {
        holderFirst.bind(if (position < thingsList.size) thingsList[position] else FirstData())
    }

    interface SecondCallback {
        fun onBackButtonPressed()
    }
}
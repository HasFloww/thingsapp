package com.testthings.fragment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testthings.R
import com.testthings.fragment.DataManager
import com.testthings.fragment.viewholders.FirstBaseViewHolder
import com.testthings.fragment.viewholders.FirstAdapterViewHolderFirst
import com.testthings.fragment.viewholders.FooterAdapterViewHolderFirst

class FirstAdapter(private val context: Context?): RecyclerView.Adapter<FirstBaseViewHolder>() {

    var thingsList = ArrayList<FirstData>()
    lateinit var footerViewHolder: FooterAdapterViewHolderFirst
    var callback: FirstAdapterCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstBaseViewHolder {
        if (viewType == 0) {
            footerViewHolder = FooterAdapterViewHolderFirst((LayoutInflater.from(context).inflate(R.layout.first_item_footer, parent, false)),
                object: FooterAdapterViewHolderFirst.FooterCallback {
                    override fun forceNotify() {
                        notifyDataSetChanged()
                    }

                    override fun onNextButtonClick() {
                        callback?.onNextButton()
                    }
                })
            return footerViewHolder
        }
        return FirstAdapterViewHolderFirst(LayoutInflater.from(context).inflate(R.layout.first_item, parent, false))
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

    fun setElement(element: String) {
        val addedElement = FirstData(element, false)
        thingsList.add(addedElement)
        DataManager.allThings.add(addedElement)
        notifyDataSetChanged()
    }

    interface FirstAdapterCallback {
        fun onNextButton()
    }
}
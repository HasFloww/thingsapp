package com.testthings.fragment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.testthings.fragment.adapters.FirstData


abstract class FirstBaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: FirstData)
}
package com.testthings.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.testthings.R

import com.testthings.fragment.adapters.SecondAdapter
import com.testthings.fragment.presenters.SecondPresenter
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment: Fragment() {

    private var secondAdapter: SecondAdapter? = null
    private val presenter = SecondPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondAdapter = SecondAdapter(context)

        val selectedThing = presenter.getListOfThings()
        thingsItem.text = presenter.getChosen()
        secondAdapter?.thingsList = selectedThing
        secondAdapter?.callback = object: SecondAdapter.SecondCallback {
            override fun onBackButtonPressed() {
                findNavController().popBackStack()
            }
        }
        thingRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = secondAdapter
            addItemDecoration(StickyFooterItemDecoration())
        }
    }
}
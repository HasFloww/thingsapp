package com.testthings.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.testthings.R
import com.testthings.fragment.adapters.FirstAdapter
import com.testthings.fragment.presenters.FirstPresenter
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment: Fragment() {

    var firstAdpter: FirstAdapter? = null
    val presenter = FirstPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        thingRecyclerView.adapter = null
        firstAdpter = FirstAdapter(context)
        firstAdpter?.thingsList?.addAll(DataManager.allThings)
        firstAdpter?.callback = object: FirstAdapter.FirstAdapterCallback {
            override fun onNextButton() {
                findNavController().navigate(R.id.action_firstFragment_to_seconfFragment)
            }
        }
        thingRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = firstAdpter
            addItemDecoration(StickyFooterItemDecoration())
        }


        thingsEditText.onFocusChangeListener = ValidateOnFocusOutListener()

        thingsEditText.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    if (v != null) {
                        val imm = v.context
                            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(v.windowToken, 0)
                        val element = thingsEditText.text.toString()
                        if (presenter.validate(element)) {
                            firstAdpter?.setElement(element)
                            thingsTextInputLayout.error = null
                            thingsEditText.clearFocus()
                            thingsEditText.setText("")
                        } else {
                            thingsTextInputLayout.error = getString(R.string.not_enough_character)
                        }
                    }
                    false
                }
                else -> false
            }
        }

    }

    inner class ValidateOnFocusOutListener : View.OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if (!hasFocus) {
                presenter.validate(thingsEditText.text.toString())
            } else {
                thingsTextInputLayout.error = null
            }
        }
    }

}
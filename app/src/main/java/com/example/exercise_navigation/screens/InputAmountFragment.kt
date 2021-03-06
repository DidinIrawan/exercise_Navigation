package com.example.exercise_navigation.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import kotlinx.android.synthetic.main.fragment_input_amount.*


class InputAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        button_send.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewName.text = "TO : " + arguments?.getString("username")
    }

    override fun onClick(v: View?) {
        when(v) {
            button_send -> {
                val bundle = bundleOf("amount" to amount_transfer.text.toString())
                navController.navigate(R.id.action_inputAmountFragment_to_confirmationFragment, bundle)
            }
        }
    }

}
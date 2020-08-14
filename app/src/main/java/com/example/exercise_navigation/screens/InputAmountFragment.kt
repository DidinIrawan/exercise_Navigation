package com.example.exercise_navigation.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.data.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_amount.*


class InputAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private val transactionViewModel by activityViewModels<TransactionViewModel>()
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
        val name = transactionViewModel.userName
        val bankName = transactionViewModel.bankName
        val accounNumber = transactionViewModel.accountNumber
        viewName.text =
            "To : \nbank name : $bankName \naccount number : $accounNumber \nname : $name"
    }

    override fun onClick(v: View?) {
        when(v) {
            button_send -> {
                val amount = amount_transfer.text

                if (amount.isNullOrEmpty()){
                    Toast.makeText(
                        activity,
                        "The amount of transfer must be filled!",
                        Toast.LENGTH_LONG
                    ).show()
                }else{
                    transactionViewModel.amount = amount_transfer.text.toString()
                    navController.navigate(R.id.action_inputAmountFragment_to_confirmationFragment)
                }
            }
        }
    }

}
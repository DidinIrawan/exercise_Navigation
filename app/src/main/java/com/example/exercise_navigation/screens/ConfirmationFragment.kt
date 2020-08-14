package com.example.exercise_navigation.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.exercise_navigation.R
import com.example.exercise_navigation.data.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_confirmation.*


class ConfirmationFragment : Fragment(),View.OnClickListener {

    private val transactionViewModel by activityViewModels<TransactionViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doneButton.setOnClickListener(this)
        showTransactionData()
    }

    private fun showTransactionData() {
        val name = "Sent to ${transactionViewModel.userName}"
        val amount = "Rp. ${transactionViewModel.amount}"

        sent_to_recipient_name_text.text = name
        sent_to_recipient_account_text.text = transactionViewModel.accountNumber
        sent_to_recipient_amount_text.text = amount
        sent_to_recipient_bank_text.text = transactionViewModel.bankName
    }

    override fun onClick(v: View?) {
        when (v) {
            doneButton -> {
                activity?.finish()
            }
        }
    }
}
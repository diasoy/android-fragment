package com.example.flexiblefragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class OptionDialogFragment : DialogFragment() {
    private var selectedRadioButtonId: Int = -1

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_option_dialog, null)

            val radioGroup = view.findViewById<RadioGroup>(R.id.rg_options)
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                selectedRadioButtonId = checkedId
            }

            if (selectedRadioButtonId != -1) {
                radioGroup.check(selectedRadioButtonId)
            }

            val chooseButton = view.findViewById<Button>(R.id.btn_choose)
            chooseButton.setOnClickListener {
                dialog?.dismiss()
            }

            val closeButton = view.findViewById<Button>(R.id.btn_close)
            closeButton.setOnClickListener {
                dialog?.dismiss()
            }

            builder.setView(view)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
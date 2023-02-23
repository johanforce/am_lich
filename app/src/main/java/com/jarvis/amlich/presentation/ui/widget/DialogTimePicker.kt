package com.jarvis.amlich.presentation.ui.widget

import android.app.AlertDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.jarvis.amlich.R
import java.util.*


class DialogTimePicker : DialogFragment() {
    private var listener: OnDateSetListener? = null
    fun setListener(listener: OnDateSetListener?) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        // Get the layout inflater
        val inflater: LayoutInflater = activity?.layoutInflater!!
        val cal: Calendar = Calendar.getInstance()
        val dialog: View = inflater.inflate(R.layout.dialog_time, null)
        val monthPicker = dialog.findViewById(R.id.picker_month) as NumberPicker
        val yearPicker = dialog.findViewById(R.id.picker_year) as NumberPicker

        monthPicker.minValue = 1
        monthPicker.maxValue = 12
        monthPicker.value = cal.get(Calendar.MONTH)
        val year: Int = cal.get(Calendar.YEAR)
        yearPicker.minValue = 1900
        yearPicker.maxValue = MAX_YEAR
        yearPicker.value = year
        builder.setView(dialog) // Add action buttons
            .setPositiveButton(
                R.string.ok
            ) { dialog, id ->
                listener!!.onDateSet(
                    null,
                    yearPicker.value,
                    monthPicker.value,
                    0
                )
            }
            .setNegativeButton(
                R.string.cancel
            ) { dialog, id ->
                this.dialog?.cancel()
            }
        return builder.create()
    }

    companion object {
        private const val MAX_YEAR = 2099
    }
}
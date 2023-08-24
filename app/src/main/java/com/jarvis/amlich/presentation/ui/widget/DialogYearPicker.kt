package com.jarvis.amlich.presentation.ui.widget

import android.app.AlertDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.jarvis.amlich.R
import java.util.*


class DialogYearPicker(context: Context) : DialogFragment() {
    private var listener: YearPickerCallback? = null
    fun setListener(listener: YearPickerCallback?) {
        this.listener = listener
    }

    interface YearPickerCallback {
        fun onYearSelected(year: Int)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater: LayoutInflater = activity?.layoutInflater!!
        val cal: Calendar = Calendar.getInstance()
        val dialog: View = inflater.inflate(R.layout.dialog_time, null)
        val monthPicker = dialog.findViewById(R.id.picker_month) as NumberPicker
        val yearPicker = dialog.findViewById(R.id.picker_year) as NumberPicker
        monthPicker.visibility = View.GONE

        val currentYear = cal.get(Calendar.YEAR) // Năm hiện tại

        yearPicker.minValue = MIN_YEAR
        yearPicker.maxValue = MAX_YEAR
        yearPicker.value = currentYear

        return AlertDialog.Builder(context).setTitle(R.string.title_year)
            .setView(dialog)
            .setPositiveButton( R.string.ok) { _, _ ->
                val selectedYear = yearPicker.value
                listener?.onYearSelected(selectedYear)
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    companion object {
        private const val MAX_YEAR = 2099
        private const val MIN_YEAR = 1900
    }
}
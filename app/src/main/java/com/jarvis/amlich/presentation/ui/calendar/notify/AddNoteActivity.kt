package com.jarvis.amlich.presentation.ui.calendar.notify

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.view.View
import android.widget.EditText
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.base.observe
import com.jarvis.amlich.common.Constant
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.common.extension.hideKeyBoard
import com.jarvis.amlich.common.utils.AlarmUtils
import com.jarvis.amlich.databinding.ActivityAddNoteBinding
import com.jarvis.amlich.domain.model.NoteModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class AddNoteActivity : BaseActivity<ActivityAddNoteBinding>(ActivityAddNoteBinding::inflate) {
    private val viewModel: NoteViewModel by viewModel()

    private val toDay = Calendar.getInstance()

    override fun setupViews() {
        hideKeyBoardWhenTouchOutside(viewBD.layoutRoot)
        viewBD.clTime.click {
            handleTimePicker()
        }
        viewBD.btNote.click {
            viewModel.insertNote(
                NoteModel(
                    title = viewBD.etTitle.text.toString(),
                    des = viewBD.etDes.text.toString(),
                    dateTime = toDay.timeInMillis
                )
            )
        }

        viewBD.toolbar.backToolbar(onBackPress = {
            finish()
        })
    }

    override fun initData() {
        toDay.timeInMillis = intent.getLongExtra(Constant.TIME_NOTE, 0L)
        viewBD.tvHour.text = toDay.get(Calendar.HOUR_OF_DAY).toString()
        viewBD.tvMinute.text = toDay.get(Calendar.MINUTE).toString()
    }

    override fun observeData() {
        super.observeData()
        observe(viewModel.isInsertNoteSuccess) {
            AlarmUtils.scheduleOneTimeWork(
                Constant.TIME_NOTE,
                toDay.timeInMillis - System.currentTimeMillis(),
                viewBD.etTitle.text.toString(),
                viewBD.etDes.text.toString()
            )
            finish()
        }
    }

    private fun handleTimePicker() {
        val timePickerDialog = TimePickerDialog(
            this,
            R.style.MyDatePickerDialogTheme, { _, hour, minute ->
                toDay.set(Calendar.HOUR_OF_DAY, hour)
                toDay.set(Calendar.MINUTE, minute)

                viewBD.tvHour.text = toDay.get(Calendar.HOUR_OF_DAY).toString()
                viewBD.tvMinute.text = toDay.get(Calendar.MINUTE).toString()
            },
            toDay.get(Calendar.HOUR_OF_DAY),
            toDay.get(Calendar.MINUTE),
            false
        )
        timePickerDialog.setButton(
            DialogInterface.BUTTON_POSITIVE,
            getString(R.string.saveButton),
            timePickerDialog
        )
        timePickerDialog.setButton(
            DialogInterface.BUTTON_NEGATIVE,
            getString(R.string.cancelButton),
            timePickerDialog
        )
        timePickerDialog.setCancelable(false)
        timePickerDialog.show()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun hideKeyBoardWhenTouchOutside(view: View, viewFocus: View? = null) {
        if (view !is EditText) {
            view.setOnTouchListener { _, _ ->
                view.hideKeyBoard()
                viewFocus?.clearFocus()
                viewBD.etDes.clearFocus()
                viewBD.etTitle.clearFocus()
                false
            }
        }
    }
}

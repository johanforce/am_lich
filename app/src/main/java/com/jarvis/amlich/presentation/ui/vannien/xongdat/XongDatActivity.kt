package com.jarvis.amlich.presentation.ui.vannien.xongdat

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.base.observe
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.databinding.ActivityXongdatBinding
import com.jarvis.amlich.databinding.DialogQuestionBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.presentation.ui.widget.DialogYearPicker
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class XongDatActivity : BaseActivity<ActivityXongdatBinding>(ActivityXongdatBinding::inflate) {
    private val viewModel: XongDatViewModel by viewModel()

    private val chooseTimeXongDat = Calendar.getInstance()
    private val chooseBirthDayGiaCHu = Calendar.getInstance()

    private val listTuViAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, Triple<Int, String, Int>>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item.second
            itemBD.tvSoQue.text = item.first.toString() + "/12"
            itemBD.tvNam.text = item.third.toString()
            itemBD.tvNam.isVisible = true
        }
    }

    override fun setupViews() {
        viewBD.toolbar.backToolbar { finish() }
        viewBD.toolbar.clickEndIcon {
            showNoteQuestion()
        }

        viewBD.tvDataYear.text = chooseBirthDayGiaCHu.get(Calendar.YEAR).toString()
        viewBD.tvDataMonth.text = chooseBirthDayGiaCHu.get(Calendar.MONTH).toString()
        viewBD.tvDataDay.text = chooseBirthDayGiaCHu.get(Calendar.DAY_OF_MONTH).toString()
        viewBD.tvYearXongDat.text = chooseTimeXongDat.get(Calendar.YEAR).toString()
        viewBD.clDate.click {
            handleBirthDayGiaChuPicker()
        }
        viewBD.clTime.click {
            handleNamXongDatPicker()
        }
        viewBD.btXongDat.click {
            viewModel.getListXongDat(chooseTimeXongDat.time, chooseBirthDayGiaCHu.time)
        }
        viewBD.recyclerQue.adapter = listTuViAdapter
    }

    private fun showNoteQuestion() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_question, null)
        val dialogBinding = DialogQuestionBinding.bind(dialogView)
        val alertDialog = AlertDialog.Builder(this).create()
        dialogBinding.btCancel.click { alertDialog.dismiss() }
        alertDialog.setView(dialogView)
        alertDialog.show()
    }

    override fun observeData() {
        super.observeData()
        observe(viewModel.listXongDat) {
            listTuViAdapter.submitList(it.sortedByDescending { it.first })
        }
    }

    private fun handleNamXongDatPicker() {
        val timePickerDialog = DialogYearPicker(this)
        timePickerDialog.setListener(object : DialogYearPicker.YearPickerCallback {
            override fun onYearSelected(year: Int) {
                chooseTimeXongDat.set(Calendar.YEAR, year)
                viewBD.tvYearXongDat.text = chooseTimeXongDat.get(Calendar.YEAR).toString()
            }
        })
        timePickerDialog.show(supportFragmentManager, "year_picker")
    }

    @SuppressLint("SetTextI18n")
    private fun handleBirthDayGiaChuPicker() {
        val timePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                chooseBirthDayGiaCHu.set(Calendar.YEAR, year)
                chooseBirthDayGiaCHu.set(Calendar.MONTH, month)
                chooseBirthDayGiaCHu.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                viewBD.tvDataYear.text = chooseBirthDayGiaCHu.get(Calendar.YEAR).toString()
                viewBD.tvDataMonth.text = (chooseBirthDayGiaCHu.get(Calendar.MONTH) + 1).toString()
                viewBD.tvDataDay.text = chooseBirthDayGiaCHu.get(Calendar.DAY_OF_MONTH).toString()
            },
            chooseBirthDayGiaCHu.get(Calendar.YEAR),
            chooseBirthDayGiaCHu.get(Calendar.MONTH),
            chooseBirthDayGiaCHu.get(Calendar.DAY_OF_MONTH)
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
}

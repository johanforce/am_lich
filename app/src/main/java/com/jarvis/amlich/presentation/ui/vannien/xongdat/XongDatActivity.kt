package com.jarvis.amlich.presentation.ui.vannien.xongdat

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.core.view.isVisible
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.base.observe
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.databinding.ActivityXongdatBinding
import com.jarvis.amlich.databinding.ItemQueBinding
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

    override fun initData() {

    }

    override fun observeData() {
        super.observeData()
        observe(viewModel.listXongDat) {
            listTuViAdapter.submitList(it.sortedByDescending { it.first })
        }
    }

    private fun handleNamXongDatPicker() {
        val timePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                chooseTimeXongDat.set(Calendar.YEAR, year)
                chooseTimeXongDat.set(Calendar.MONTH, month)
                chooseTimeXongDat.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                viewBD.tvYearXongDat.text = chooseTimeXongDat.get(Calendar.YEAR).toString()
            },
            chooseTimeXongDat.get(Calendar.YEAR),
            chooseTimeXongDat.get(Calendar.MONTH),
            chooseTimeXongDat.get(Calendar.DAY_OF_MONTH)
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
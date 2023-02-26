package com.jarvis.amlich.presentation.ui.vannien.tuvi

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.core.view.isVisible
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.common.core.tuvi.LaSoTuViHelper
import com.jarvis.amlich.common.enums.CungEnum
import com.jarvis.amlich.common.enums.GenderEnum
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.databinding.ActivityTiviBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.domain.model.TuViModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class TuViActivity : BaseActivity<ActivityTiviBinding>(ActivityTiviBinding::inflate) {
    private val viewModel: TuViViewModel by viewModel()

    private val toDay = Calendar.getInstance()
    private var typeGender = GenderEnum.NU.value
    private var typeCung = 0

    private val listCung = listOf(
        CungEnum.MENH,
        CungEnum.PHU_MAU,
        CungEnum.QUAN_LOC,
        CungEnum.TAT_ACH,
    )

    private val listTuViAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, String>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item
            itemBD.tvSoQue.isVisible = false
        }
    }

    override fun setupViews() {
        viewBD.toolbar.backToolbar { finish() }

        viewBD.tvDataYear.text = toDay.get(Calendar.YEAR).toString()
        viewBD.tvDataMonth.text = toDay.get(Calendar.MONTH).toString()
        viewBD.tvDataDay.text = toDay.get(Calendar.DAY_OF_MONTH).toString()
        viewBD.tvHour.text = toDay.get(Calendar.HOUR_OF_DAY).toString()
        viewBD.tvMinute.text = toDay.get(Calendar.MINUTE).toString()
        viewBD.tvTuVI.text = listCung[0].nameGender
        viewBD.tvSex.text = GenderEnum.NU.nameGender
        viewBD.clDate.click {
            handleDatePicker()
        }
        viewBD.clTime.click {
            handleTimePicker()
        }
        viewBD.clSex.click {
            handerGender()
        }
        viewBD.clTuVI.click {
            handeCung()
        }
        viewBD.btTuvi.click {
            getDataCung()
        }
        viewBD.recyclerQue.adapter = listTuViAdapter
    }

    override fun initData() {

    }

    private fun getDataCung() {
        val dataRequest = viewModel.getThongTinTUVi(toDay.time)
        val dataCung = LaSoTuViHelper.getDataCung(
            dataRequest.chiGioSinh,
            dataRequest.ngaySinhLunar,
            dataRequest.thangSinhLunar,
            dataRequest.canNamSinh,
            dataRequest.chiGioSinh
        )
        val cung = dataCung.first { it.tenCung == listCung[typeCung].nameGender }
        val listRequest = LaSoTuViHelper.getGiaiDoanTuVi(cung)
        val results = mutableListOf<TuViModel>()
        viewModel.listTuVI.value?.map { kq ->
            listRequest.map { request ->
                if (
                    (
                            kq.anChinhTinh == request.anChinhTinh ||
                                    (kq.anChinhTinh.isNullOrEmpty() && request.anChinhTinh.isEmpty())
                            ) &&
                    (
                            kq.anPhuTinh == request.anPhuTinh ||
                                    (kq.anPhuTinh.isNullOrEmpty() && request.anPhuTinh.isEmpty())
                            ) &&
                    (
                            kq.vitri == request.cungMenhCan ||
                                    (kq.vitri.isNullOrEmpty() && request.cungMenhCan.isEmpty()))
                ) results.add(kq)
            }
        }
        listTuViAdapter.submitList(listThongTin(results))
    }

    private fun listThongTin(data: List<TuViModel>): List<String> {
        val list = mutableListOf<String>()
        data.map {
            when {
                !it.vitri.isNullOrEmpty() && !it.anChinhTinh.isNullOrEmpty() && !it.anPhuTinh.isNullOrEmpty() ->
                    list.add(
                        getString(
                            R.string.dong_cung_tai_sao,
                            it.anChinhTinh,
                            it.anPhuTinh,
                            it.vitri,
                            it.luanGiai
                        )
                    )
                !it.anChinhTinh.isNullOrEmpty() && !it.anPhuTinh.isNullOrEmpty() ->
                    list.add(
                        getString(
                            R.string.dong_cung_sao,
                            it.anChinhTinh,
                            it.anPhuTinh,
                            it.luanGiai
                        )
                    )
                !it.anChinhTinh.isNullOrEmpty() ->
                    list.add(getString(R.string.don_thu_mot_sao, it.anChinhTinh, it.luanGiai))
                !it.anPhuTinh.isNullOrEmpty() ->
                    list.add(getString(R.string.don_thu_mot_sao, it.anPhuTinh, it.luanGiai))
                else -> list.add(it.luanGiai ?: "")
            }
        }
        return list
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

    @SuppressLint("SetTextI18n")
    private fun handleDatePicker() {
        val timePickerDialog = DatePickerDialog(
            this,
            R.style.MyDatePickerDialogTheme,
            { _, year, month, dayOfMonth ->
                toDay.set(Calendar.YEAR, year)
                toDay.set(Calendar.MONTH, month)
                toDay.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                viewBD.tvDataYear.text = toDay.get(Calendar.YEAR).toString()
                viewBD.tvDataMonth.text = (toDay.get(Calendar.MONTH) + 1).toString()
                viewBD.tvDataDay.text = toDay.get(Calendar.DAY_OF_MONTH).toString()
            },
            toDay.get(Calendar.YEAR),
            toDay.get(Calendar.MONTH),
            toDay.get(Calendar.DAY_OF_MONTH)
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

    private fun handerGender() {
        val listGender = arrayOf(GenderEnum.NU.nameGender, GenderEnum.NAM.nameGender)
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.title_name))
            .setSingleChoiceItems(
                listGender, typeGender
            ) { _, selectedIndex ->
                typeGender = selectedIndex

                viewBD.tvSex.text =
                    if (typeGender == GenderEnum.NAM.value) GenderEnum.NAM.nameGender else GenderEnum.NU.nameGender
            }
            .setPositiveButton(getString(R.string.ok), null)
            .setNegativeButton(getString(R.string.cancel), null)
            .show()
    }

    private fun handeCung() {
        val listGender = listCung.map { it.nameGender }.toTypedArray()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.tv_title_tu_vi))
            .setSingleChoiceItems(
                listGender, typeGender
            ) { _, selectedIndex ->
                typeCung = selectedIndex
                viewBD.tvTuVI.text = listGender[selectedIndex]

                viewModel.getTuVITheoCung(listGender[selectedIndex])
            }
            .setPositiveButton(getString(R.string.ok), null)
            .setNegativeButton(getString(R.string.cancel), null)
            .show()
    }
}

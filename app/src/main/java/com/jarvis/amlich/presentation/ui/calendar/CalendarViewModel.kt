package com.jarvis.amlich.presentation.ui.calendar

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.core.LunarCoreHelper
import com.jarvis.amlich.common.core.TetHelper
import com.jarvis.amlich.common.extension.endDate
import com.jarvis.amlich.common.extension.startDate
import com.jarvis.amlich.common.extension.startMonth
import com.jarvis.amlich.common.utils.SingleLiveData
import com.jarvis.amlich.domain.model.NoteModel
import com.jarvis.amlich.domain.model.TuViModel
import com.jarvis.amlich.domain.usecase.TuviUseCase
import com.jarvis.amlich.domain.usecase.note.GetNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

open class CalendarViewModel : BaseViewModel() {
    private val tuViUseCase: TuviUseCase by inject()
    private val getNoteUseCase: GetNoteUseCase by inject()

    val listTuVI = SingleLiveData<List<TuViModel>>()
    val noteInDay = SingleLiveData<List<NoteModel>>()
    val noteInMonth = SingleLiveData<List<NoteModel>>()

    fun getStringLunarDay(dayData: LocalDate): String {
        val day = getLunarDay(dayData)[0]
        val month = getLunarDay(dayData)[1]
        return "$day/$month"
    }

    fun getTetAmLichName(dayData: LocalDate): String {
        return TetHelper.getTetAmLich(getStringLunarDay(dayData))
    }

    fun isTetAmLich(dayData: LocalDate): Boolean {
        return TetHelper.isNgayLeAmLich(getStringLunarDay(dayData))
    }

    fun isSunDayOrSaturday(dayData: LocalDate): Boolean {
        return when (dayData.dayOfWeek.value) {
            DayOfWeek.SUNDAY.value, DayOfWeek.SATURDAY.value -> true
            else -> false
        }
    }

    fun getLunarDay(dayData: LocalDate): IntArray {
        return LunarCoreHelper.convertSolar2Lunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year,
            7.00
        )
    }

    fun statusDay(dayData: LocalDate): Int {
        val chiDay = getChiDay(dayData)
        val lunarDay = getLunarDay(dayData)
        val chiDays = LunarCoreHelper.getUnAccentCanChi(chiDay)
        return LunarCoreHelper.rateDayStatus(
            chiDays, lunarDay[1], LunarCoreHelper.getChiDayLunar(
                dayData.dayOfMonth,
                dayData.monthValue,
                dayData.year
            )
        )
    }

    private fun getChiDay(dayData: LocalDate): String {
        return LunarCoreHelper.getChiDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        )
    }

    fun getTuVITheoCung(cung: String) {
        executeTask(onExecute = {
            mLoading.value = true
            val listTuViTheoCung = withContext(Dispatchers.IO) {
                tuViUseCase.invoke(cung)
            }
            listTuVI.postValue(listTuViTheoCung)
            mLoading.value = false
        })
    }

    fun getThongTinTUVi(dayData: Date): ThongTinTuVI {
        val calendar = Calendar.getInstance()
        val localDate = dayData.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        calendar.time = dayData
        val chiGioSinh = LunarCoreHelper.convertTimeSolarToLunar(calendar.get(Calendar.HOUR_OF_DAY))
        val ngaySinh = getLunarDay(localDate)[0]
        val thangSinh = getLunarDay(localDate)[1]
        val canNamSinh = LunarCoreHelper.getCanInYear(calendar.get(Calendar.YEAR))
        val chiNamSinh = LunarCoreHelper.getChiInYear(calendar.get(Calendar.YEAR))
        return ThongTinTuVI(chiGioSinh, ngaySinh, thangSinh, canNamSinh, chiNamSinh)
    }

    fun getNoteInDay(date: Date) {
        executeTask(onExecute = {
            mLoading.value = true
            val listNoteInDay = withContext(Dispatchers.IO) {
                getNoteUseCase.invoke(date.startDate(), date.endDate())
            }
            noteInDay.postValue(listNoteInDay)
            mLoading.value = false
        })
    }

    fun getNoteInMonth(date: Date) {
        executeTask(onExecute = {
            mLoading.value = true
            val listNoteInDay = withContext(Dispatchers.IO) {
                getNoteUseCase.invoke(date.startMonth(), date.endDate())
            }
            noteInMonth.postValue(listNoteInDay)
            mLoading.value = false
        })
    }


}

data class ThongTinTuVI(
    val chiGioSinh: String,
    val ngaySinhLunar: Int,
    val thangSinhLunar: Int,
    val canNamSinh: String,
    val chiNamSinh: String,
)

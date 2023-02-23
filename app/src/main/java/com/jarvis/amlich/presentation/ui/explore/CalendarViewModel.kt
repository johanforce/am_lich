package com.jarvis.amlich.presentation.ui.explore

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.core.HourGoodBadHelper
import com.jarvis.amlich.common.core.LunarCoreHelper
import com.jarvis.amlich.common.core.SaoXauHelper
import com.jarvis.amlich.common.core.TetHelper
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class CalendarViewModel : BaseViewModel() {
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

    fun getNameLunarDay(dayData: LocalDate): String {
        return (LunarCoreHelper.getCanDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        ) + " "
                + LunarCoreHelper.getChiDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        ))

    }

    private fun getChiDay(dayData: LocalDate): String {
        return LunarCoreHelper.getChiDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        )
    }

    private fun getCanDay(dayData: LocalDate): String {
        return LunarCoreHelper.getCanDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        )
    }

    fun getListHourHoangDao(dayData: LocalDate): List<String> {
        val hourHoangDao = HourGoodBadHelper.hourGoodBadStatus(
            LunarCoreHelper.getChiDayLunarEnum(
                dayData.dayOfMonth,
                dayData.monthValue,
                dayData.year
            )
        )
        val instant: Instant =
            dayData.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()
        val res = Date.from(instant)

        return LunarCoreHelper.getCanChiHourInDay(res.time, hourHoangDao.first)
    }

    fun getSaoXau(dayData: LocalDate): List<String> {
        val chiDay = getChiDay(dayData)
        val canDay = getCanDay(dayData)
        val thangLunar = getLunarDay(dayData)[1]
        return SaoXauHelper.getSaoXau(canDay, chiDay, thangLunar)
    }

    fun getSaoTot(dayData: LocalDate): List<String> {
        val chiDay = getChiDay(dayData)
        val canDay = getCanDay(dayData)
        val thangLunar = getLunarDay(dayData)[1]
        return SaoXauHelper.getSaoTot(canDay, chiDay, thangLunar)
    }
}

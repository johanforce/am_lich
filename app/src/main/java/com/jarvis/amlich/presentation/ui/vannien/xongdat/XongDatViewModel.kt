package com.jarvis.amlich.presentation.ui.vannien.xongdat

import androidx.lifecycle.MutableLiveData
import com.jarvis.amlich.common.core.LunarCoreHelper
import com.jarvis.amlich.common.core.xongdat.XongDatHelper
import com.jarvis.amlich.presentation.ui.calendar.CalendarViewModel
import java.time.ZoneId
import java.util.*

class XongDatViewModel : CalendarViewModel() {
    val listXongDat = MutableLiveData<List<Triple<Int, String, Int>>>()

    fun getThienCanDiaChi(dayData: Date): Pair<String, String> {
        val calendar = Calendar.getInstance()
        calendar.time = dayData
        val canNamSinh = LunarCoreHelper.getCanInYear(calendar.get(Calendar.YEAR))
        val chiNamSinh = LunarCoreHelper.getChiInYear(calendar.get(Calendar.YEAR))
        return Pair(canNamSinh, chiNamSinh)
    }

    fun getListXongDat(namXongDat: Date, birthdayGiaChu: Date) {
        val listData = mutableListOf<Triple<Int, String, Int>>()
        val namXongDatePair = getThienCanDiaChi(namXongDat)
        val calendar = Calendar.getInstance()
        calendar.time = namXongDat

        var temp = 0
        val listNguoiXongDat = mutableListOf<Triple<String, String, Int>>()
        while (temp < 60) {
            val data = getThienCanDiaChi(calendar.time)
            listNguoiXongDat.add(
                Triple(data.first, data.second, calendar.get(Calendar.YEAR))
            )
            temp++
            calendar.add(Calendar.YEAR, -1)
        }

        val localBirthDay = birthdayGiaChu.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        calendar.time = birthdayGiaChu
        val day = LunarCoreHelper.convertSolar2Lunar(
            localBirthDay.dayOfMonth,
            localBirthDay.monthValue,
            localBirthDay.year,
            7.00
        )
        val year = day[2]
        calendar.set(Calendar.YEAR, year)
        val birthdayGiaChuPair = getThienCanDiaChi(calendar.time)
        listNguoiXongDat.map {
            val point = XongDatHelper.calculateXongDat(
                birthdayGiaChuPair.first,
                birthdayGiaChuPair.second,
                it.first, it.second,
                namXongDatePair.first,
                namXongDatePair.second
            )
            val thienCanDiaChiXongNha = it.first + " " + it.second
            listData.add(Triple(point, thienCanDiaChiXongNha, it.third))
        }

        val result = mutableListOf<Pair<Int, List<String>>>()
        val groupByPoints = listData.groupBy { it.first }
        groupByPoints.map {
            val listDate = mutableListOf<String>()
            it.value.map { value ->
                if (it.key == value.first) {
                    listDate.add(value.second)
                }
            }
            result.add(Pair(it.key, listDate))
        }
        listXongDat.value = listData
    }
}


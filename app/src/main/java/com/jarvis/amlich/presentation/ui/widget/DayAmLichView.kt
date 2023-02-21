package com.jarvis.amlich.presentation.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.jarvis.amlich.R
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.common.core.HourGoodBadHelper
import com.jarvis.amlich.common.core.KhongMinhXuatHanh
import com.jarvis.amlich.common.core.LunarCoreHelper
import com.jarvis.amlich.common.core.LunarCoreHelper.getUnAccentCanChi
import com.jarvis.amlich.common.core.SaoXauHelper
import com.jarvis.amlich.databinding.ItemHourStatusBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.databinding.ViewEmptyHistoryBinding
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DayAmLichView : FrameLayout {
    private var binding: ViewEmptyHistoryBinding? = null

    private val listHourAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, String>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item
        }
    }

    private val listStarGoodAdapter by lazy {
        SimpleBDAdapter<ItemHourStatusBinding, String>(ItemHourStatusBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item
        }
    }

    private val listStarBadAdapter by lazy {
        SimpleBDAdapter<ItemHourStatusBinding, String>(ItemHourStatusBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item
        }
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    private fun init(context: Context) {
        val systemService =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ViewEmptyHistoryBinding.inflate(systemService, this, true)
    }

    fun initData(dayData: LocalDate) {
        val isBadDay = isBadDay(dayData)
        binding?.ivDotDay?.setImageResource(if (isBadDay) R.drawable.bg_hac_dao else R.drawable.bg_hoang_dao)
        binding?.tvDayStatus?.text = getStatusDay(dayData)
        binding?.tvDaySolar?.text = getDaySonar(dayData)
        binding?.tvDayOfWeek?.text = getDayOfWeek(dayData)
        binding?.tvDayLunar?.text = context.getString(R.string.day_lunar, getDayLunar(dayData))
        binding?.tvDayLunarName?.text =
            context.getString(R.string.day_lunar_name, getNameLunarDay(dayData))
        binding?.tvMonthLunarName?.text =
            context.getString(R.string.month_lunar, getNameMonth(dayData))
        binding?.tvYearLunarName?.text = LunarCoreHelper.getYearName(dayData)

        listHourAdapter.submitList(getListHourHoangDao(dayData))
        binding?.recyclerHourGood?.adapter = listHourAdapter

        listStarBadAdapter.submitList(getSaoXau(dayData))
        binding?.recyclerStarBad?.adapter = listStarBadAdapter

        listStarGoodAdapter.submitList(getSaoTot(dayData))
        binding?.recyclerStarGood?.adapter = listStarGoodAdapter

        binding?.tvTaiThan?.text =
            context.getString(R.string.tai_than_day, getHuongTaiHy(dayData).first)
        binding?.tvHyThan?.text =
            context.getString(R.string.hy_than_day, getHuongTaiHy(dayData).second)

        binding?.tvKhongMinhDes?.text = getXuatHanh(dayData)
    }

    private fun getDayOfWeek(dayData: LocalDate): String {
        return when (dayData.dayOfWeek.value) {
            DayOfWeek.MONDAY.value -> context.getString(R.string.thu_hai)
            DayOfWeek.TUESDAY.value -> context.getString(R.string.thu_ba)
            DayOfWeek.WEDNESDAY.value -> context.getString(R.string.thu_tu)
            DayOfWeek.THURSDAY.value -> context.getString(R.string.thu_nam)
            DayOfWeek.FRIDAY.value -> context.getString(R.string.thu_sau)
            DayOfWeek.SATURDAY.value -> context.getString(R.string.thu_bay)
            else -> context.getString(R.string.chu_nhat)
        }
    }

    private fun getDaySonar(dayData: LocalDate): String {
        return dayData.dayOfMonth.toString() + "-" + dayData.monthValue + "-" + dayData.year
    }

    private fun getLunarDay(dayData: LocalDate): IntArray {
        return LunarCoreHelper.convertSolar2Lunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year,
            7.00
        )
    }

    private fun getNameLunarDay(dayData: LocalDate): String {
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

    private fun getListHourHoangDao(dayData: LocalDate): List<String> {
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

    private fun getSaoXau(dayData: LocalDate): List<String> {
        val chiDay = getChiDay(dayData)
        val canDay = getCanDay(dayData)
        val thangLunar = getLunarDay(dayData)[1]
        return SaoXauHelper.getSaoXau(canDay, chiDay, thangLunar)
    }

    private fun getSaoTot(dayData: LocalDate): List<String> {
        val chiDay = getChiDay(dayData)
        val canDay = getCanDay(dayData)
        val thangLunar = getLunarDay(dayData)[1]
        return SaoXauHelper.getSaoTot(canDay, chiDay, thangLunar)
    }

    private fun getStatusDay(dayData: LocalDate): String {
        val chiDay = getChiDay(dayData)
        val lunarDay = getLunarDay(dayData)
        return LunarCoreHelper.rateDay(chiDay, lunarDay[1])
    }

    private fun isBadDay(dayData: LocalDate): Boolean {
        val chiDay = getChiDay(dayData)
        val lunarDay = getLunarDay(dayData)
        val chiDays = getUnAccentCanChi(chiDay)
        return LunarCoreHelper.isBadDay(chiDays, lunarDay[1])
    }

    private fun getHuongTaiHy(dayData: LocalDate): Pair<String, String> {
        val canDay = getCanDay(dayData)
        return HourGoodBadHelper.getTaiHyPhuongHuong(canDay)
    }

    private fun getDayLunar(dayData: LocalDate): String {
        return getLunarDay(dayData)[0].toString() + "/" + getLunarDay(
            dayData
        )[1].toString()
    }

    private fun getNameMonth(dayData: LocalDate): String {
        val month = getLunarDay(dayData)[1]
        return LunarCoreHelper.getNameMonthLunar(month)
    }

    private fun getXuatHanh(dayData: LocalDate): String {
        val data = getLunarDay(dayData)
        val (day, month) = Pair(data[0], data[1])
        val result = KhongMinhXuatHanh.getXuatHanhKhongMinh(day, month)
        return context.getString(R.string.xuat_hanh_khong_minh_des, result.name, result.meaning)
    }
}
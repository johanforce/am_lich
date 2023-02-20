package com.jarvis.amlich.presentation.ui.explore

import android.annotation.SuppressLint
import android.view.View
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.common.utils.FileUtils
import com.jarvis.amlich.common.utils.setTextColorRes
import com.jarvis.amlich.databinding.ExampleCalendarDayBinding
import com.jarvis.amlich.databinding.FragmentCalendarBinding
import com.jarvis.amlich.presentation.ui.main.MainActivity
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import com.kizitonwose.calendarview.utils.next
import com.kizitonwose.calendarview.utils.previous
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

class CalendarFragment :
    BaseFragment<FragmentCalendarBinding, CalendarViewModel>(FragmentCalendarBinding::inflate) {

    override val viewModel: CalendarViewModel by viewModel()

    private var firstTime: Boolean = true
    private var displayMonth: YearMonth = YearMonth.now()
    private var diaryActivity: MainActivity? = null
    private var lastDayOfSelectedMonth: LocalDate? = null
    private var firstDayOfSelectedMonth: LocalDate? = null

    private var selectedDate: LocalDate? = null
    private val today = LocalDate.now()
    private val currentMonth = YearMonth.now()

    override fun initData() {
        this.diaryActivity = activity as MainActivity
        if (diaryActivity == null) {
            return
        }
        initCalender()
        executePreviousMonth()
        executeNextMonth()
        executeTitleCalendar()
    }

    private fun initCalender() {
//        if (!firstTime) {
//            return
//        }
//        firstTime = false
        val daysOfWeek = DayOfWeek.values()
        viewBD.cvMonth.setup(
            currentMonth.minusYears(1500),
            currentMonth.plusYears(1500),
            daysOfWeek.first()
        )
        viewBD.cvMonth.scrollToMonth(currentMonth)
        @SuppressLint("SetTextI18n")
        class DayViewContainer(view: View) : ViewContainer(view) {
            // Will be set when this container is bound. See the dayBinder.
            lateinit var day: CalendarDay
            val rootDay = ExampleCalendarDayBinding.bind(view).root
            val exLunarDay = ExampleCalendarDayBinding.bind(view).exLunarDay
            val exSonarDay = ExampleCalendarDayBinding.bind(view).exSonarDay
            val bgDay = ExampleCalendarDayBinding.bind(view).bgDay

            init {
                view.setOnClickListener {
                    if (selectedDate == day.date) {
                        selectedDate = null

                        viewBD.cvMonth.notifyDayChanged(day)
                    } else {
                        val oldDate = selectedDate
                        selectedDate = day.date
                        viewBD.cvMonth.notifyDateChanged(day.date)
                        oldDate?.let { viewBD.cvMonth.notifyDateChanged(oldDate) }

                    }
                    viewBD.cvMonth.notifyDayChanged(day)

                    val dayData = day.date
                    viewBD.viewAmLich.initData(dayData)
                    viewBD.layoutTitle.tvActivities.text = viewModel.getTetAmLichName(dayData)
                }
            }
        }

        viewBD.cvMonth.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)

            @SuppressLint("SetTextI18n")
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                val textView = container.exSonarDay
                val exLunarDay = container.exLunarDay
                val bgDay = container.bgDay
                textView.text = day.date.dayOfMonth.toString()

                val dayData = day.date

                exLunarDay.text = viewModel.getStringLunarDay(dayData)

                if (day.owner == DayOwner.THIS_MONTH) {
                    container.rootDay.isEnabled = true
                    container.rootDay.visibility = View.VISIBLE
                } else {
                    container.rootDay.isEnabled = false
                    container.rootDay.visibility = View.INVISIBLE
                }

                when (day.date) {
                    selectedDate -> {
                        bgDay.setBackgroundResource(R.drawable.bg_boder_pri_3)
                    }

                    today -> {
                        textView.setTextColorRes(R.color.pri_4)
                        bgDay.setBackgroundResource(R.drawable.bg_boder_pri_2)

                        if(firstTime){
                            viewBD.viewAmLich.initData(today)
                            viewBD.layoutTitle.tvActivities.text = viewModel.getTetAmLichName(today)
                        }
                        firstTime = false
                    }
                    else -> {
                        bgDay.setBackgroundResource(R.color.transparent)
                        textView.background = null
                    }
                }
                if (viewModel.isTetAmLich(dayData)) exLunarDay.setTextColorRes(R.color.bitter_sweat)
                if (viewModel.isSunDayOrSaturday(dayData)) textView.setTextColorRes(R.color.bitter_sweat)
            }
        }
    }

    private fun executeTitleCalendar() {

        viewBD.cvMonth.monthScrollListener = { month ->
            clearSelected()
            selectedDate = null
            displayMonth = month.yearMonth
            firstDayOfSelectedMonth = month.yearMonth.atDay(1)
            lastDayOfSelectedMonth = month.yearMonth.atEndOfMonth()
            val monthName = FileUtils.upCaseFirst(
                month.yearMonth.month.getDisplayName(
                    TextStyle.FULL,
                    Locale.ENGLISH
                )
            )
            val title = "${monthName}, ${month.year}"
            viewBD.layoutTitle.tvCalendar.text = title
//            viewBD.layoutTitle.btCalendarNext.isEnabled = month.yearMonth != currentMonth

        }
    }

    private fun executePreviousMonth() {
        viewBD.layoutTitle.btCalendarBack.setOnClickListener {
            viewBD.cvMonth.findFirstVisibleMonth()?.let {
                viewBD.cvMonth.smoothScrollToMonth(it.yearMonth.previous)
            }
        }
    }

    private fun executeNextMonth() {
        viewBD.layoutTitle.btCalendarNext.setOnClickListener {
            viewBD.cvMonth.findFirstVisibleMonth()?.let {
                viewBD.cvMonth.smoothScrollToMonth(it.yearMonth.next)
            }
        }
    }

    private fun clearSelected() {
        if (selectedDate != null) {
            val tempoSelectedDate = selectedDate
            selectedDate = null
            viewBD.cvMonth.notifyDateChanged(tempoSelectedDate!!)
        }
    }
}

@file:Suppress("DEPRECATION")

package com.jarvis.amlich.presentation.ui.calendar

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import androidx.core.view.isVisible
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.common.Constant
import com.jarvis.amlich.common.core.StatusDayEnum
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.common.extension.convertDate
import com.jarvis.amlich.common.utils.setTextColorRes
import com.jarvis.amlich.databinding.ExampleCalendarDayBinding
import com.jarvis.amlich.databinding.FragmentCalendarBinding
import com.jarvis.amlich.presentation.ui.calendar.notify.AddNoteActivity
import com.jarvis.amlich.presentation.ui.main.MainActivity
import com.jarvis.amlich.presentation.ui.widget.DialogTimePicker
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.util.*

class CalendarFragment :
    BaseFragment<FragmentCalendarBinding, CalendarViewModel>(FragmentCalendarBinding::inflate) {

    override val viewModel: CalendarViewModel by viewModel()

    private var displayMonth: YearMonth = YearMonth.now()
    private var diaryActivity: MainActivity? = null
    private var lastDayOfSelectedMonth: LocalDate? = null
    private var firstDayOfSelectedMonth: LocalDate? = null

    private var selectedDate: LocalDate? = LocalDate.now()
    private val today = LocalDate.now()
    private val currentMonth = YearMonth.now()

    override fun initData() {
        this.diaryActivity = activity as MainActivity
        if (diaryActivity == null) {
            return
        }
        viewModel.getNoteInDay(Date())
        initCalender()
        executeTitleCalendar()

        viewBD.layoutTitle.ivAddNote.click {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.DAY_OF_MONTH, selectedDate?.dayOfMonth ?: 1)
            calendar.set(Calendar.MONTH, (selectedDate?.monthValue ?: 0) - 1)
            calendar.set(Calendar.YEAR, selectedDate?.year ?: 1970)
            val intent = Intent(activity, AddNoteActivity::class.java)
            intent.putExtra(Constant.TIME_NOTE, calendar.timeInMillis)
            activity?.startActivity(intent)
        }
    }

    private fun initCalender() {
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
            val dot = ExampleCalendarDayBinding.bind(view).icDot
            val icNote = ExampleCalendarDayBinding.bind(view).icNote

            init {
                view.setOnClickListener {
                    if (selectedDate == day.date) {
                        viewBD.cvMonth.notifyDayChanged(day)
                    } else {
                        val oldDate = selectedDate
                        selectedDate = day.date
                        viewBD.cvMonth.notifyDateChanged(day.date)
                        oldDate?.let { viewBD.cvMonth.notifyDateChanged(oldDate) }
                    }
                    viewBD.cvMonth.notifyDayChanged(day)
                    viewBD.viewAmLich.initData(selectedDate ?: LocalDate.now())
                    viewModel.getNoteInDay(day.date.convertDate())
                    viewBD.layoutTitle.tvActivities.text =
                        viewModel.getTetAmLichName(selectedDate ?: LocalDate.now())
                    if (viewBD.layoutTitle.tvActivities.text.isNullOrEmpty()) {
                        viewBD.layoutTitle.tvActivities.text =
                            viewModel.getTetDuongLichName(selectedDate ?: LocalDate.now())
                    }
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
                val dot = container.dot
                val icNote = container.icNote
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

                icNote.isVisible = false

                when (day.date) {
                    today -> {
                        textView.setTextColorRes(R.color.black)
                        exLunarDay.setTextColorRes(R.color.black)
                        bgDay.setBackgroundResource(R.drawable.bg_boder_pri_2)
                    }

                    selectedDate -> {
                        exLunarDay.setTextColorRes(R.color.ink_4)
                        bgDay.setBackgroundResource(R.drawable.bg_boder_pri_3)
                    }

                    else -> {
                        bgDay.setBackgroundResource(R.color.transparent)
                        textView.background = null
                    }
                }
                // if (viewModel.isTetAmLich(dayData)) exLunarDay.setTextColorRes(R.color.bitter_sweat)
                // if (viewModel.isTetDuongLich(dayData)) textView.setTextColorRes(R.color.bitter_sweat)
                if (viewModel.isSunDayOrSaturday(dayData)) textView.setTextColorRes(R.color.bitter_sweat)

                when {
                    viewModel.statusDay(dayData) == StatusDayEnum.VERY_GOOD.value -> {
                        dot.setImageResource(R.drawable.bg_thanh_long_hoang_dao)
                    }

                    viewModel.statusDay(dayData) == StatusDayEnum.GOOD.value -> {
                        dot.setImageResource(R.drawable.bg_hoang_dao)
                    }

                    viewModel.statusDay(dayData) == StatusDayEnum.BAD.value -> {
                        dot.setImageResource(R.drawable.bg_hac_dao)
                    }

                    else -> {
                        dot.isVisible = false
                    }
                }
            }
        }
    }

    private fun executeTitleCalendar() {

        viewBD.cvMonth.monthScrollListener = { month ->
            viewBD.cvMonth.notifyDateChanged(selectedDate ?: LocalDate.now())

            displayMonth = month.yearMonth
            firstDayOfSelectedMonth = month.yearMonth.atDay(1)
            lastDayOfSelectedMonth = month.yearMonth.atEndOfMonth()
            val title = getString(R.string.time_title, "${month.month}, ${month.year}")
            viewBD.layoutTitle.tvCalendar.text = title

            selectedDate = setDayOfMonth(month)
            viewBD.cvMonth.notifyDateChanged(selectedDate ?: LocalDate.now())

            viewBD.viewAmLich.initData(selectedDate ?: LocalDate.now())
            viewBD.layoutTitle.tvActivities.text =
                viewModel.getTetAmLichName(selectedDate ?: LocalDate.now())
            if (viewBD.layoutTitle.tvActivities.text.isNullOrEmpty()) {
                viewBD.layoutTitle.tvActivities.text =
                    viewModel.getTetDuongLichName(selectedDate ?: LocalDate.now())
            }
        }

        viewBD.layoutTitle.viewCalendar.click {
            val pd = DialogTimePicker()
            pd.setListener { _, year, month, _ ->
                val c = YearMonth.of(year, month)
                selectedDate = c.atDay(1)
                viewBD.cvMonth.scrollToMonth(c)
            }
            fragmentManager?.let { it1 -> pd.show(it1, "MonthYearPickerDialog") }
        }
    }

    private fun setDayOfMonth(month: CalendarMonth): LocalDate {
        val calendarSelectDay = Calendar.getInstance()
        calendarSelectDay.set(Calendar.YEAR, selectedDate?.year ?: 2023)
        calendarSelectDay.set(Calendar.MONTH, selectedDate?.month?.value ?: 12)
        calendarSelectDay.set(Calendar.YEAR, selectedDate?.dayOfMonth ?: 1)

        val calendarScrollDay = Calendar.getInstance()
        calendarScrollDay.set(Calendar.YEAR, month.year)
        calendarScrollDay.set(Calendar.MONTH, month.month)
        calendarScrollDay.set(Calendar.YEAR, today?.dayOfMonth ?: 1)

        return if (calendarScrollDay.timeInMillis > calendarSelectDay.timeInMillis) {
            LocalDate.of(month.year, month.month, selectedDate?.plusMonths(1)?.dayOfMonth ?: 1)
        } else {
            LocalDate.of(month.year, month.month, selectedDate?.minusMonths(1)?.dayOfMonth ?: 1)
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.noteInDay.observe(viewLifecycleOwner) {
            viewBD.viewAmLich.getNoteInDay(it)
        }
    }
}

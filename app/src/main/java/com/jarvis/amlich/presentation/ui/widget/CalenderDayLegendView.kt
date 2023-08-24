package com.jarvis.amlich.presentation.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.children
import com.jarvis.amlich.R
import com.jarvis.amlich.common.utils.setTextColorRes
import com.jarvis.amlich.databinding.LayoutCalenderDayLegendBinding

class CalenderDayLegendView : FrameLayout {
    private var binding: LayoutCalenderDayLegendBinding? = null

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

    private fun init(context: Context) {
        val systemService =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutCalenderDayLegendBinding.inflate(systemService, this, true)
        genDisplayDayName()
    }

    private fun genDisplayDayName() {
        binding!!.root.children.forEachIndexed { index, view ->
            (view as TextView).apply {
                text = listWeek[index]
                setTextColorRes(R.color.ink_3)
            }
        }
    }

    private val listWeek = listOf("Hai", "Ba", "Tư", "Năm", "Sáu", "Bảy", "CN")
}

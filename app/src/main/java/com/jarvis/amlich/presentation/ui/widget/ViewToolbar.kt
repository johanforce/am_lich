package com.jarvis.amlich.presentation.ui.widget

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.jarvis.amlich.R
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.databinding.ToolbarBinding

class ViewToolbar : FrameLayout {
    private var binding: ToolbarBinding? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    @SuppressLint("Recycle", "CustomViewStyleable")
    private fun init(context: Context, attrs: AttributeSet?) {
        val systemService =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ToolbarBinding.inflate(systemService, this, true)

        if (attrs != null) {
            val attributeArray: TypedArray =
                context.obtainStyledAttributes(attrs, R.styleable.JxToolbar)
            val toolbarTitle =
                attributeArray.getString(R.styleable.JxToolbar_toolbarTitle)
            val iconEnd =
                attributeArray.getResourceId(R.styleable.JxToolbar_toolbarIconEnd, 0)
            attributeArray.recycle()
            binding?.tvTitle?.text = toolbarTitle
            if (iconEnd != 0) {
                binding?.ivEnd?.setImageResource(iconEnd)
                binding?.ivEnd?.visibility = VISIBLE
            }
        }
    }

    fun backToolbar(onBackPress: () -> Unit = {}) {
        binding?.ivBack?.click {
            onBackPress()
        }
    }

    fun clickEndIcon(onClick: () -> Unit = {}) {
        binding?.ivEnd?.click {
            onClick()
        }
    }

    fun setTitleToolbar(text: String) {
        binding?.tvTitle?.text = text
    }
}
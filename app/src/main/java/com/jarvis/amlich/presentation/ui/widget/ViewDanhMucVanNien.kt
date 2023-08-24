package com.jarvis.amlich.presentation.ui.widget

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.jarvis.amlich.R
import com.jarvis.amlich.databinding.ViewDanhMucVanNienBinding

class ViewDanhMucVanNien : LinearLayoutCompat {
    private var binding: ViewDanhMucVanNienBinding? = null

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

    @SuppressLint("Recycle")
    private fun init(context: Context, attrs: AttributeSet?) {
        val systemService =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ViewDanhMucVanNienBinding.inflate(systemService, this, true)

        if (attrs != null) {
            val attributeArray: TypedArray =
                context.obtainStyledAttributes(attrs, R.styleable.ViewDanhMucVanNien)
            val title =
                attributeArray.getString(R.styleable.ViewDanhMucVanNien_title)
            binding?.tvView?.text = title
        }
    }
}

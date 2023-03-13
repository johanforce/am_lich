@file:Suppress("unused")

package com.jarvis.amlich.common.extension

import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import androidx.annotation.AnimRes
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

private var lastTimeClicked = 0L
private var lastTimeClickedId = 0

/**
 * This is method show in textView
 * @param visible is type View
 */
fun View.show(visible: Boolean) {
    if (visible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

fun View.inVisibility(visible: Boolean) {
    if (visible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.INVISIBLE
    }
}

fun View.click(defaultInterval: Int = 1000, onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener(defaultInterval) {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

class SafeClickListener(
    private var defaultInterval: Int = 1000,
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener {

    override fun onClick(v: View) {
        if (lastTimeClickedId == v.id) {
            if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
                return
            }
        } else if (SystemClock.elapsedRealtime() - lastTimeClicked < 200) {
            return
        }

        lastTimeClicked = SystemClock.elapsedRealtime()
        lastTimeClickedId = v.id
        onSafeCLick(v)
    }
}

fun View.setBackgroundTintColor(@ColorRes colorRes: Int) {
    backgroundTintList =
        ContextCompat.getColorStateList(context, colorRes)
}

fun View.setAnimationResource(@AnimRes resId: Int, duration: Long = 250) {
    kotlin.runCatching {
        val animation = AnimationUtils.loadAnimation(context, resId).apply {
            this.duration = duration
        }
        startAnimation(animation)
    }
}

fun EditText.onChange(cb: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        var contentBefore = ""
        override fun afterTextChanged(s: Editable?) {
            val contentAfter = s?.toString() ?: ""
            if (contentAfter != contentBefore) {
                cb(contentAfter)
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            contentBefore = s?.toString() ?: ""
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            /*No trigger*/
        }
    })
}

fun EditText.onChangeText(cb: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        var contentBefore = ""
        override fun afterTextChanged(s: Editable?) {
            /*No trigger*/
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            contentBefore = s?.toString() ?: ""
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            cb(s.toString())
        }
    })
}
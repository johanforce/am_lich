/*
 * Copyright © OMRON HEALTHCARE Co., Ltd. 2020. All rights reserved.
 */

@file:Suppress("DEPRECATION")

package com.jarvis.amlich.common.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment

/**
 * Hide keyboard for view
 */
fun Context.hideKeyboardFrom(view: View) {
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.hideKeyboardFromAndCleanFocus(view: View) {
    view.clearFocus()
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

/**
 * Hide keyboard in fragment
 */
fun Fragment.hideKeyboard() {
    context?.hideKeyboardFrom(requireView())
}

fun Fragment.hideKeyboardAndCleanFocus() {
    context?.hideKeyboardFromAndCleanFocus(requireView())
}

/**
 * Hide keyboard when User touch out site input is EditText  or search view
 */
fun Fragment.hideKeyBoardWhenTouchOutside() {
    view?.hideKeyBoardWhenTouchOutside()
}

/**
 * This is the method to hide KeyBoard when touch out side of KeyBoard
 */
@SuppressLint("ClickableViewAccessibility")
fun View.hideKeyBoardWhenTouchOutside(viewFocus: View? = null) {
    if (this !is EditText) {
        this.setOnTouchListener { _, _ ->
            hideKeyBoard()
            viewFocus?.requestFocus()
            false
        }
    }
}

/**
 * This is the method to hide KeyBoard
 */
fun View.hideKeyBoard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

/**
 * This is the method to show KeyBoard
 */
fun View.showKeyBoard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun Activity.setTextColorStatusBar(isTextDark: Boolean) {
    window?.decorView?.systemUiVisibility = if (isTextDark) {
        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}

fun Activity.setStatusBarColor(@ColorRes colorRes: Int) {
    window?.statusBarColor = resources.getColor(colorRes)
}

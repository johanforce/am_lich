package com.jarvis.amlich.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.jarvis.amlich.databinding.ActivityBaseBinding
import com.jarvis.amlich.common.DebugLog
import com.jarvis.amlich.common.dialog.AlertNotice

abstract class BaseActivity<VB : ViewBinding>(
    val inflateBinding: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : AppCompatActivity() {
    protected lateinit var viewBD: VB
    protected lateinit var baseBinding: ActivityBaseBinding

    private var isErrorDialogShowing = false
    private val debugLog by lazy {
        DebugLog()
    }

    /**
     * Override onCreate function of Activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBaseBinding()
        setupViews()
        initData()
        observeData()
    }

    private fun initBaseBinding() {
        baseBinding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(baseBinding.root)
        viewBD = inflateBinding(LayoutInflater.from(this), baseBinding.activityContent, true)
    }

    open fun setupViews() {}
    open fun initData() {}
    open fun observeData() {}

    /**
     * This function is used to show loading or not
     * @param isLoading is [Boolean] value
     */
    fun showLoading(isLoading: Boolean) {
        if (isLoading && baseBinding.activityError.isVisible) {
            baseBinding.activityError.isVisible = false
        }
        baseBinding.activityLoading.isVisible = isLoading
    }

    /**
     * This is the method to show error dialog
     */
    fun showErrorDialog(message: String, name: String? = null) {
        if (isErrorDialogShowing) {
            debugLog.d("skip show if showing $name")
            return
        }

        AlertNotice.show(this, message) {
            isErrorDialogShowing = false
        }
        isErrorDialogShowing = true
    }
}

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this) { it?.let { t -> action(t) } }
}


package com.jarvis.amlich.presentation.ui.main

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseActivity
import com.jarvis.amlich.common.Constant.KEY_CALENDAR
import com.jarvis.amlich.common.Constant.KEY_QUE
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.common.firebase.FireBaseEventNameConstants
import com.jarvis.amlich.common.firebase.FireBaseLogEvents
import com.jarvis.amlich.common.utils.setTextColorRes
import com.jarvis.amlich.databinding.ActivityMainBinding
import com.jarvis.amlich.presentation.ui.calendar.CalendarFragment
import com.jarvis.amlich.presentation.ui.vannien.VanNienFragment

@Suppress("DEPRECATION")
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private var isBackPress = false
    private var vanNienFragment: VanNienFragment? = null
    private var calendarFragment: CalendarFragment? = null
    private val fragments: MutableList<Fragment> = arrayListOf()
    private var currentIndex: Int = 0
    private var tempFrag = 0

    override fun initData() {
        super.initData()
        initFragment()
        clickShowFragment(KEY_CALENDAR)

        viewBD.viewControlHealth.click {
            clickShowFragment(KEY_CALENDAR)
        }
        viewBD.viewControlProfile.click {
            clickShowFragment(KEY_QUE)

        }
    }

    private fun showFragmentBottom(position: Int) {
        val isCalendar = position == KEY_CALENDAR
        viewBD.ivHealth.isSelected = (isCalendar)
        viewBD.ivProfile.isSelected = (!isCalendar)
        viewBD.tvHealth.setTextColorRes(if (isCalendar) R.color.pri_1 else R.color.ink_2)
        viewBD.tvProfile.setTextColorRes(if (isCalendar) R.color.ink_2 else R.color.pri_1)
    }

    private fun initFragment() {
        calendarFragment = CalendarFragment()
        vanNienFragment = VanNienFragment()
        fragments.add(calendarFragment ?: CalendarFragment())
        fragments.add(vanNienFragment ?: VanNienFragment())

        val size = fragments.size
        val supportFragmentManager = supportFragmentManager

        for (index in 0 until size) {
            val fragment = fragments[index]
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            if (!fragment.isAdded) {
                fragmentTransaction.add(R.id.viewContainer, fragment, "fragment$index")
            }
            if (index != 0) {
                fragmentTransaction.hide(fragment).commitAllowingStateLoss()
            } else {
                fragmentTransaction.commitAllowingStateLoss()
            }
        }
    }

    private fun clickShowFragment(position: Int) {
        try {
            if (position == KEY_CALENDAR) {
                FireBaseLogEvents.getInstance().log(FireBaseEventNameConstants.TAB_HOME)
            } else {
                FireBaseLogEvents.getInstance().log(FireBaseEventNameConstants.TAB_QUE)
            }

            showFragmentBottom(position)
            val targetFragment = fragments[position]
            val currentFragment: Fragment = getCurrentFragment()
            if (currentFragment.isAdded) {
                currentFragment.onPause()
            }
            if (!isFinishing) {
                supportFragmentManager.beginTransaction().hide(currentFragment).show(targetFragment)
                    .commitAllowingStateLoss()
                currentIndex = position
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getCurrentFragment(): Fragment {
        return fragments[currentIndex]
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (this.currentIndex != KEY_CALENDAR) {
            tempFrag = 1
            clickShowFragment(KEY_CALENDAR)
            return
        }
        if (!isBackPress) {
            Toast.makeText(this, resources.getString(R.string.home_exit), Toast.LENGTH_SHORT).show()
            isBackPress = true
            Handler(Looper.getMainLooper()).postDelayed({
                isBackPress = false
            }, 2000)
            return
        }
        super.onBackPressed()
    }
}


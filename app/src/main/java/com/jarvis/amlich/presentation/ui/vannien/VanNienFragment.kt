package com.jarvis.amlich.presentation.ui.vannien

import android.content.Intent
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.common.extension.click
import com.jarvis.amlich.databinding.FragmentVanNienBinding
import com.jarvis.amlich.presentation.ui.main.MainActivity
import com.jarvis.amlich.presentation.ui.vannien.que.QueActivity
import com.jarvis.amlich.presentation.ui.vannien.tuvi.TuViActivity
import com.jarvis.amlich.presentation.ui.vannien.vankhan.VanKhanActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class VanNienFragment :
    BaseFragment<FragmentVanNienBinding, VanNienViewModel>(FragmentVanNienBinding::inflate) {

    override val viewModel: VanNienViewModel by viewModel()
    private var mainActivity: MainActivity? = null

    override fun setupViews() {
        this.mainActivity = activity as MainActivity

        viewBD.viewTuVi.click {
            val intent = Intent()
            intent.setClass(mainActivity!!, TuViActivity::class.java)
            startActivity(intent)
        }
        viewBD.viewCungMenh.click {
            //do nothing
        }
        viewBD.viewVanKhan.click {
            val intent = Intent()
            intent.setClass(mainActivity!!, VanKhanActivity::class.java)
            startActivity(intent)
        }
        viewBD.viewXinQue.click {
            val intent = Intent()
            intent.setClass(mainActivity!!, QueActivity::class.java)
            startActivity(intent)
        }
        viewBD.viewXongDat.click {
            //do nothing
        }
        viewBD.viewTinhTuoi.click {
            //do nothing
        }
    }
}

package com.jarvis.amlich.di

import com.jarvis.amlich.presentation.ui.vannien.que.detail.DetailViewModel
import com.jarvis.amlich.presentation.ui.calendar.CalendarViewModel
import com.jarvis.amlich.presentation.ui.vannien.tuvi.TuViViewModel
import com.jarvis.amlich.presentation.ui.vannien.que.QueViewModel
import com.jarvis.amlich.presentation.ui.calendar.notify.NoteViewModel
import com.jarvis.amlich.presentation.ui.vannien.VanNienViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QueViewModel() }
    viewModel { CalendarViewModel() }
    viewModel { TuViViewModel() }
    viewModel { DetailViewModel() }
    viewModel { NoteViewModel() }
    viewModel { VanNienViewModel() }
}

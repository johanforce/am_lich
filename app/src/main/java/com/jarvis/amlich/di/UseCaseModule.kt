package com.jarvis.amlich.di


import com.jarvis.amlich.domain.usecase.*
import com.jarvis.amlich.domain.usecase.note.GetNoteUseCase
import com.jarvis.amlich.domain.usecase.note.InsertNoteUseCase
import com.jarvis.amlich.domain.usecase.que.*
import com.jarvis.amlich.domain.usecase.vankhan.TuviFlowUseCase
import com.jarvis.amlich.domain.usecase.vankhan.VanKhanUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { BuonBanUseCase() }
    single { DoanBenhUseCase() }
    single { GiaDaoUseCase() }
    single { HonNhanUseCase() }
    single { KienTungUseCase() }
    single { LucSucUseCase() }
    single { MuuVOngUseCase() }
    single { NguoiDiUseCase() }
    single { QueIdUseCase() }
    single { QueUseCase() }
    single { ThatVatUseCase() }
    single { TuoiMangUseCase() }
    single { VanKhanUseCase() }
    single { TuviUseCase() }
    single { InsertNoteUseCase() }
    single { GetNoteUseCase() }
    single { TuviFlowUseCase() }
}

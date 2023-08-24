package com.jarvis.amlich.data.repository

import com.jarvis.amlich.data.entity.QueEntity
import com.jarvis.amlich.data.local.AppDatabase
import com.jarvis.amlich.domain.model.BuonBanModel
import com.jarvis.amlich.domain.model.DoanBenhModel
import com.jarvis.amlich.domain.model.GiaDaoModel
import com.jarvis.amlich.domain.model.HonNhanModel
import com.jarvis.amlich.domain.model.KienTungModel
import com.jarvis.amlich.domain.model.LucSucModel
import com.jarvis.amlich.domain.model.MuuVongModel
import com.jarvis.amlich.domain.model.NguoiDiModel
import com.jarvis.amlich.domain.model.NoteModel
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.domain.model.ThatVatModel
import com.jarvis.amlich.domain.model.TuViModel
import com.jarvis.amlich.domain.model.TuoiMangModel
import com.jarvis.amlich.domain.model.VanKhanModel
import com.jarvis.amlich.domain.repository.QueRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QueRepositoryImpl(
    private val database: AppDatabase,
) : QueRepository {
    override suspend fun getAllQue(): List<QueModel> {
        return database.queDao().getAll().map(QueEntity::toModel)
    }

    override suspend fun getIdQue(idQue: Int): QueModel {
        return database.queDao().getIdQue(idQue).toModel()
    }

    override suspend fun getBuonBan(idQue: Int): BuonBanModel {
        return database.queDao().getBuonBan(idQue).toModel()
    }

    override suspend fun getDoanBenh(idQue: Int): DoanBenhModel {
        return database.queDao().getDoanBenh(idQue).toModel()
    }

    override suspend fun getGiaDao(idQue: Int): GiaDaoModel {
        return database.queDao().getGiaDao(idQue).toModel()
    }

    override suspend fun getHonNhan(idQue: Int): HonNhanModel {
        return database.queDao().getHonNhan(idQue).toModel()
    }

    override suspend fun getKienTung(idQue: Int): KienTungModel {
        return database.queDao().getKienTung(idQue).toModel()
    }

    override suspend fun getLucSuc(idQue: Int): LucSucModel {
        return database.queDao().getLucSuc(idQue).toModel()
    }

    override suspend fun getMuuVong(idQue: Int): MuuVongModel {
        return database.queDao().getMuuVong(idQue).toModel()
    }

    override suspend fun getNguoiDi(idQue: Int): NguoiDiModel {
        return database.queDao().getNguoiDi(idQue).toModel()
    }

    override suspend fun getThatVat(idQue: Int): ThatVatModel {
        return database.queDao().getThatVat(idQue).toModel()
    }

    override suspend fun getTuoiMang(idQue: Int): TuoiMangModel {
        return database.queDao().getTuoiMang(idQue).toModel()
    }

    override suspend fun getAllVanKhan(): List<VanKhanModel> {
        return database.queDao().getAllVanKhan().map { it.toModel() }
    }

    override suspend fun getVanKhanId(id: Int): VanKhanModel {
        return database.queDao().getAllVanKhanId(id).toModel()
    }

    override suspend fun getGiaiDoanTuViTheoCung(cung: String): List<TuViModel> {
        return database.queDao().getGiaiDoanTuViTheoCung(cung).map { it.toModel() }
    }

    override fun getTuVi(): Flow<List<TuViModel>> {
        return database.queDao().getTuVi().map { it.map { it2 -> it2.toModel() } }
    }

    override suspend fun insertNote(note: NoteModel) {
        return database.queDao().insertNote(note.toEntity())
    }

    override suspend fun getNoteInDay(startDate: Long, endDate: Long): List<NoteModel> {
        return database.queDao().getNoteInTime(startDate, endDate).map { it.toModel() }
    }
}

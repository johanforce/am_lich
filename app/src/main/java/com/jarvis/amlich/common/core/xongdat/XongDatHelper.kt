package com.jarvis.amlich.common.core.xongdat

import com.jarvis.amlich.common.core.tuvi.LaSoTuViHelper

object XongDatHelper {
    val chiNguHanh = listOf(
        Triple("Mùi", Pair(1, 2), "Thổ"),
        Triple("Hợi", Pair(1, 1), "Thủy"),
        Triple("Mão", Pair(1, 3), "Mộc"),
        Triple("Thìn", Pair(2, 2), "Thổ"),
        Triple("Thân", Pair(2, 1), "Kim"),
        Triple("Tý", Pair(2, 3), "Thủy"),
        Triple("Dậu", Pair(3, 3), "Kim"),
        Triple("Tỵ", Pair(3, 1), "Hỏa"),
        Triple("Sửu", Pair(3, 2), "Thổ"),
        Triple("Ngọ", Pair(4, 3), "Hỏa"),
        Triple("Tuất", Pair(4, 2), "Thổ"),
        Triple("Dần", Pair(4, 1), "Mộc"),
    )
    val canNguHanh = listOf(
        Pair("Giáp", "Mộc"),
        Pair("Ất", "Mộc"),
        Pair("Bính", "Hỏa"),
        Pair("Đinh", "Hỏa"),
        Pair("Mậu", "Thổ"),
        Pair("Kỷ", "Thổ"),
        Pair("Canh", "Kim"),
        Pair("Tân", "Kim"),
        Pair("Nhâm", "Thủy"),
        Pair("Quý", "Thủy"),
    )

    val nguHanhXung = listOf(
        NguHanhTuongSinhTuongKhac("Kim", "Thổ", "Thủy", "Hỏa"),
        NguHanhTuongSinhTuongKhac("Mộc", "Thủy", "Hỏa", "Kim"),
        NguHanhTuongSinhTuongKhac("Thủy", "Kim", "Mộc", "Thổ"),
        NguHanhTuongSinhTuongKhac("Hỏa", "Mộc", "Thổ", "Thủy"),
        NguHanhTuongSinhTuongKhac("Thổ", "Hỏa", "Kim", "Mộc"),
    )

    fun checkNguHanhNguoiXongGiaChu(
        thienCanNguoiXong: String,
        diaChiNguoiXong: String,
        thienCanGiaChu: String,
        diaChiGiaChu: String
    ): Int {
        val nguHanhNguoiXong = LaSoTuViHelper.getMenhFromCanChi(thienCanNguoiXong, diaChiNguoiXong)
        val nguHanhGiaCHu = LaSoTuViHelper.getMenhFromCanChi(thienCanGiaChu, diaChiGiaChu)
        val isXung = nguHanhXung.any {
            it.type == nguHanhNguoiXong &&
                    it.conflictType == nguHanhGiaCHu
        }
        val isTuongSinh = nguHanhXung.any {
            (it.type == nguHanhNguoiXong && (it.afterType == nguHanhGiaCHu || it.beforeType == nguHanhGiaCHu)) ||
                    (it.type == nguHanhGiaCHu && (it.afterType == nguHanhNguoiXong || it.beforeType == nguHanhNguoiXong))
        }
        return when {
            isXung -> 0
            isTuongSinh -> 2
            else -> 1
        }
    }

    fun checkNguHanhThienCanNguoiXongGiaChu(
        thienCanNguoiXong: String,
        thienCanGiaChu: String
    ): Int {
        val nguHanhCanNguoiXong = canNguHanh.firstOrNull { it.first == thienCanNguoiXong }
        val nguHanhCanGiaCHu = canNguHanh.firstOrNull { it.first == thienCanGiaChu }
        val isXung = nguHanhXung.any {
            it.type == nguHanhCanNguoiXong?.second &&
                    it.conflictType == nguHanhCanGiaCHu?.second
        }
        val isTuongSinh = nguHanhXung.any {
            it.type == nguHanhCanNguoiXong?.second &&
                    (it.afterType == nguHanhCanGiaCHu?.second ||
                            it.beforeType == nguHanhCanGiaCHu?.second)
        }
        return when {
            isXung -> 0
            isTuongSinh -> 2
            else -> 1
        }
    }

    fun checkNguHanhNguoiXongNamAm(
        thienCanNguoiXong: String,
        diaChiNguoiXong: String,
        thienCanNamAm: String,
        diaChiNamAm: String
    ): Int {
        val nguHanhChiNguoiXong =
            LaSoTuViHelper.getMenhFromCanChi(thienCanNguoiXong, diaChiNguoiXong)
        val nguHanhChiNamAm = LaSoTuViHelper.getMenhFromCanChi(thienCanNamAm, diaChiNamAm)
        val isXung = nguHanhXung.any {
            it.type == nguHanhChiNguoiXong &&
                    it.conflictType == nguHanhChiNamAm
        }
        val isTuongSinh = nguHanhXung.any {
            (it.type == nguHanhChiNguoiXong &&
                    (it.afterType == nguHanhChiNamAm ||
                            it.beforeType == nguHanhChiNamAm)) ||
            (it.type == nguHanhChiNamAm &&
                    (it.afterType == nguHanhChiNguoiXong ||
                            it.beforeType == nguHanhChiNguoiXong))
        }
        return when {
            isXung -> 0
            isTuongSinh -> 2
            else -> 1
        }
    }

    fun checkNguHanhThienCanNguoiXongNamAm(
        thienCanNguoiXong: String,
        thienCanNamAm: String
    ): Int {
        val nguHanhCanNguoiXong = canNguHanh.firstOrNull { it.first == thienCanNguoiXong }
        val nguHanhCanNamAm = canNguHanh.firstOrNull { it.first == thienCanNamAm }
        val isXung = nguHanhXung.any {
            it.type == nguHanhCanNguoiXong?.second &&
                    it.conflictType == nguHanhCanNamAm?.second
        }
        val isTuongSinh = nguHanhXung.any {
            it.type == nguHanhCanNguoiXong?.second &&
                    (it.afterType == nguHanhCanNamAm?.second ||
                            it.beforeType == nguHanhCanNamAm?.second)
        }
        return when {
            isXung -> 0
            isTuongSinh -> 2
            else -> 1
        }
    }

    fun checkTamHopTuHanhXungNguoiXongGiaCHu(
        diaChiNguoiXong: String,
        diaChiGiaChu: String
    ): Int {
        val nguHanhNguoiXong = chiNguHanh.find { it.first == diaChiNguoiXong }
        val nguHanhGiaChu = chiNguHanh.find { it.first == diaChiGiaChu }
        return when {
            nguHanhGiaChu?.second?.first == nguHanhNguoiXong?.second?.first -> 2
            nguHanhGiaChu?.second?.second == nguHanhNguoiXong?.second?.second -> 0
            else -> 1
        }
    }

    fun checkTamHopTuHanhXungNguoiXongNamAm(
        diaChiNguoiXong: String,
        diaChiNamAm: String
    ): Int {
        val nguHanhNguoiXong = chiNguHanh.find { it.first == diaChiNguoiXong }
        val nguHanhGiaChu = chiNguHanh.find { it.first == diaChiNamAm }
        return when {
            nguHanhGiaChu?.second?.first == nguHanhNguoiXong?.second?.first -> 2
            nguHanhGiaChu?.second?.second == nguHanhNguoiXong?.second?.second -> 0
            else -> 1
        }
    }

    fun calculateXongDat(
        thienCanGiaChu: String,
        diaChiGiaChu: String,
        thienCanNguoiXong: String,
        diaChiNguoiXong: String,
        thienCanNamAmLich: String,
        diaChiNamAmLich: String,
    ): Int {
        return checkNguHanhNguoiXongGiaChu(
            thienCanNguoiXong,
            diaChiNguoiXong,
            thienCanGiaChu,
            diaChiGiaChu
        ) +
                checkNguHanhNguoiXongNamAm(
                    thienCanNguoiXong,
                    diaChiNguoiXong,
                    thienCanNamAmLich,
                    diaChiNamAmLich
                ) +
                checkNguHanhThienCanNguoiXongGiaChu(thienCanNguoiXong, thienCanGiaChu) +
                checkNguHanhThienCanNguoiXongNamAm(thienCanNguoiXong, thienCanNamAmLich) +
                checkTamHopTuHanhXungNguoiXongGiaCHu(diaChiNguoiXong, diaChiGiaChu) +
                checkTamHopTuHanhXungNguoiXongNamAm(diaChiNguoiXong, diaChiNamAmLich)
    }
}

data class NguHanhTuongSinhTuongKhac(
    val type: String,
    val beforeType: String,
    val afterType: String,
    val conflictType: String
)
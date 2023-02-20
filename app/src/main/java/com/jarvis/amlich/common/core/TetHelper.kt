package com.jarvis.amlich.common.core

object TetHelper {
    fun getTetAmLich(day: String): String {
        return when (day) {
            TetEnum.TET_NGUYEN_DAN.day -> TetEnum.TET_NGUYEN_DAN.valueStr
            TetEnum.VIA_THAN_TAI.day -> TetEnum.VIA_THAN_TAI.valueStr
            TetEnum.TET_HAN_THUC.day -> TetEnum.TET_HAN_THUC.valueStr
            TetEnum.TET_NGUYEN_TIEU.day -> TetEnum.TET_NGUYEN_TIEU.valueStr
            TetEnum.GIO_TO.day -> TetEnum.GIO_TO.valueStr
            TetEnum.VESAK.day -> TetEnum.VESAK.valueStr
            TetEnum.TET_DOAN_NGO.day -> TetEnum.TET_DOAN_NGO.valueStr
            TetEnum.LE_THAT_TICH.day -> TetEnum.LE_THAT_TICH.valueStr
            TetEnum.LE_VU_LAN.day -> TetEnum.LE_VU_LAN.valueStr
            TetEnum.TET_TRUNG_THU.day -> TetEnum.TET_TRUNG_THU.valueStr
            TetEnum.ONG_TAO.day -> TetEnum.ONG_TAO.valueStr
            else -> ""
        }
    }

    fun isNgayLeAmLich(day: String): Boolean {
        return listTetAmLich.any { it == day }
    }

    val listTetAmLich = listOf(
        TetEnum.TET_NGUYEN_DAN.day,
        TetEnum.VIA_THAN_TAI.day,
        TetEnum.TET_HAN_THUC.day,
        TetEnum.TET_NGUYEN_TIEU.day,
        TetEnum.GIO_TO.day,
        TetEnum.VESAK.day,
        TetEnum.TET_DOAN_NGO.day,
        TetEnum.LE_THAT_TICH.day,
        TetEnum.LE_VU_LAN.day,
        TetEnum.TET_TRUNG_THU.day,
        TetEnum.ONG_TAO.day
    )
}

enum class TetEnum(var valueStr: String, val day: String) {
    // action card not DONE
    TET_NGUYEN_DAN("Tết Nguyên Đán", "1/1"),
    VIA_THAN_TAI("Vía Thần Tài", "10/1"),
    TET_HAN_THUC("Tết Hàn Thực", "3/3"),
    TET_NGUYEN_TIEU("Tết Nguyên Tiêu", "15/1"),
    GIO_TO("Giỗ Tổ Hùng Vương", "10/3"),
    VESAK("Lễ Phật Đản - Vesak", "15/4"),
    TET_DOAN_NGO("Tết Đoan Ngọ", "5/5"),
    LE_THAT_TICH("Lễ Thất Tịch", "7/7"),
    LE_VU_LAN("Lễ Vu Lan - Báo Hiếu", "15/7"),
    TET_TRUNG_THU("Tết Trung Thu", "15/8"),
    ONG_TAO("Cúng Ông Công - Ông Táo", "23/12"),
}

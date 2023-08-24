package com.jarvis.amlich.common.core

object TetHelper {
    fun getTetAmLich(day: String): String {
        return TetEnum.values().find { it.day == day }?.valueStr ?: ""
    }

    fun isNgayLeAmLich(day: String): Boolean {
        return TetEnum.values().any { it.day == day }
    }

    fun getTetDuongLich(day: String): String {
        return SonarEventEnum.values().find { it.day == day }?.valueStr ?: ""
    }

    fun isNgayLeDuongLich(day: String): Boolean {
        return SonarEventEnum.values().any { it.day == day }
    }
}

enum class TetEnum(var valueStr: String, val day: String) {
    TET_NGUYEN_DAN("Tết Nguyên Đán", "1/1"),
    VIA_THAN_TAI("Vía Thần Tài", "10/1"),
    TET_HAN_THUC("Tết Hàn Thực", "3/3"),
    TET_NGUYEN_TIEU("Tết Nguyên Tiêu", "15/1"),
    GIO_TO("Giỗ Tổ Hùng Vương", "10/3"),
    VESAK("Lễ Phật Đản - Vesak", "15/4"),
    TET_DOAN_NGO("Tết Đoan Ngọ", "5/5"),
    LE_THAT_TICH("Lễ Thất Tịch", "7/7"),
    TET_CUU_TRUNG("Tết Cửu Trùng", "9/9"),
    LE_VU_LAN("Lễ Vu Lan - Báo Hiếu", "15/7"),
    TET_TRUNG_THU("Tết Trung Thu", "15/8"),
    TET_HA_NGUYEN("Tết Hạ Nguyên", "15/10"),
    ONG_TAO("Cúng Ông Công - Ông Táo", "23/12"),
}

enum class SonarEventEnum(var valueStr: String, val day: String) {
    L_1("Tết Dương Lịch", "1/1"),
    L_2("Lễ Tình Nhân", "14/2"),
    L_3("Ngày Thầy Thuốc Việt Nam", "27/2"),
    L_4("Ngày Quốc Tế Phụ Nữ", "8/3"),
    L_5("Thành Lập Đoàn TNCS HCM", "26/3"),
    L_6("Ngày Cá Tháng Tư", "1/4"),
    L_7("Ngày Giải Phóng Miền Nam", "30/4"),
    L_8("Ngày Quốc Tế Lao Động", "1/5"),
    L_9("Chiến Thắng Điện Biên Phủ", "7/5"),
    L_10("Ngày Của Mẹ", "13/5"),
    L_11("Ngày Quốc Tế Thiếu Nhi", "1/6"),
    L_12("Ngày Của Cha", "17/6"),
    L_13("Ngày Báo Chí Việt Nam", "21/6"),
    L_14("Ngày Gia Đình Việt Nam", "28/6"),
    L_15("Ngày Dân Số Thế Giới", "11/7"),
    L_16("Ngày Thương Binh Liệt Sỹ", "27/7"),
    L_17("Ngày Thành Lập Công Đoàn VN", "28/7"),
    L_18("Ngày Tổng Khởi Nghĩa", "19/8"),
    L_19("Ngày Quốc Khánh", "2/9"),
    L_20("Ngày Thành Lập Mặt Trận Tổ Quốc VN", "10/9"),
    L_21("Ngày Quốc Tế Người Cao Tuổi", "1/10"),
    L_22("Ngày Giải Phóng Thủ Đô", "10/10"),
    L_23("Ngày Doanh Nhân Việt Nam", "13/10"),
    L_24("Ngày Phụ Nữ Việt Nam", "20/10"),
    L_25("Lễ Hội Halloween", "31/10"),
    L_26("Ngày Pháp Luật Việt Nam", "9/11"),
    L_27("Ngày Nhà Giáo Việt Nam", "20/11"),
    L_28("Ngày Thành Lập Hội Chữ Thập Đỏ VN", "23/11"),
    L_29("Ngày Thế Giới Phòng Chống AIDS", "1/12"),
    L_30("Ngày Toàn Quốc Kháng Chiến", "19/12"),
    L_31("Ngày Thành Lập QĐNDVN", "22/12"),
    L_32("Lễ Giáng Sinh", "25/12")
}

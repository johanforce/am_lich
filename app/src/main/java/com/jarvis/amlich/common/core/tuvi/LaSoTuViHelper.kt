package com.jarvis.amlich.common.core.tuvi

import com.jarvis.amlich.common.core.CanEnum
import com.jarvis.amlich.common.core.ChiEnum
import com.jarvis.amlich.common.core.HanhEnum
import com.jarvis.amlich.common.core.LunarCoreHelper

class LaSoTuViHelper {
    val banMenh = listOf(
        "HẢI TRUNG KIM",
        "GIÁNG HẠ THỦY",
        "TÍCH LỊCH HỎA",
        "BÍCH THƯỢNG THỔ",
        "TANG ÐỐ MỘC",
        "ÐẠI KHÊ THỦY",
        "LƯ TRUNG HỎA",
        "THÀNH ÐẦU THỔ",
        "TÒNG BÁ MỘC",
        "KIM BẠCH KIM",
        "PHÚ ÐĂNG HỎA",
        "SA TRUNG THỔ",
        "ÐẠI LÂM MỘC",
        "BẠCH LẠP KIM",
        "TRƯỜNG LƯU THỦY",
        "SA TRUNG KIM",
        "THIÊN HÀ THỦY",
        "THIÊN THƯỢNG HỎA",
        "LỘ BÀN THỔ",
        "DƯƠNG LIỄU MỘC",
        "TRUYỀN TRUNG THỦY",
        "SƠN HẠ HỎA",
        "ÐẠI TRẠCH THỔ",
        "THẠCH LỰU MỘC",
        "KIẾM PHONG KIM",
        "SƠN ÐẦU HỎA",
        "ỐC THƯỢNG THỔ",
        "BÌNH ÐỊA MỘC",
        "XOA XUYẾN KIM",
        "ÐẠI HẢI THỦY"
    )

    val listThanMenh = listOf(
        MenhGioThang("Tý", 1, "Dần", "Dần"),
        MenhGioThang("Tý", 2, "Mão", "Mão"),
        MenhGioThang("Tý", 3, "Thìn", "Thìn"),
        MenhGioThang("Tý", 4, "Tỵ", "Tỵ"),
        MenhGioThang("Tý", 5, "Ngọ", "Ngọ"),
        MenhGioThang("Tý", 6, "Mùi", "Mùi"),
        MenhGioThang("Tý", 7, "Thân", "Thân"),
        MenhGioThang("Tý", 8, "Dậu", "Dậu"),
        MenhGioThang("Tý", 9, "Tuất", "Tuất"),
        MenhGioThang("Tý", 10, "Hợi", "Hợi"),
        MenhGioThang("Tý", 11, "Tý", "Tý"),
        MenhGioThang("Tý", 12, "Sửu", "Sửu"),

        MenhGioThang("Sửu", 1, "Sửu", "Mão"),
        MenhGioThang("Sửu", 2, "Dần", "Thìn"),
        MenhGioThang("Sửu", 3, "Mão", "Tỵ"),
        MenhGioThang("Sửu", 4, "Thìn", "Ngọ"),
        MenhGioThang("Sửu", 5, "Tỵ", "Mùi"),
        MenhGioThang("Sửu", 6, "Ngọ", "Thân"),
        MenhGioThang("Sửu", 7, "Mùi", "Dậu"),
        MenhGioThang("Sửu", 8, "Thân", "Tuất"),
        MenhGioThang("Sửu", 9, "Dậu", "Hợi"),
        MenhGioThang("Sửu", 10, "Tuất", "Tý"),
        MenhGioThang("Sửu", 11, "Hợi", "Sửu"),
        MenhGioThang("Sửu", 12, "Tý", "Dần"),

        MenhGioThang("Dần", 1, "Tý", "Thìn"),
        MenhGioThang("Dần", 2, "Sửu", "Tỵ"),
        MenhGioThang("Dần", 3, "Dần", "Ngọ"),
        MenhGioThang("Dần", 4, "Mão", "Mùi"),
        MenhGioThang("Dần", 5, "Thìn", "Thân"),
        MenhGioThang("Dần", 6, "Tỵ", "Dậu"),
        MenhGioThang("Dần", 7, "Ngọ", "Tuất"),
        MenhGioThang("Dần", 8, "Mùi", "Hợi"),
        MenhGioThang("Dần", 9, "Thân", "Tý"),
        MenhGioThang("Dần", 10, "Dậu", "Sửu"),
        MenhGioThang("Dần", 11, "Tuất", "Dần"),
        MenhGioThang("Dần", 12, "Hợi", "Mão"),

        MenhGioThang("Mão", 1, "Hợi", "Tỵ"),
        MenhGioThang("Mão", 2, "Tý", "Ngọ"),
        MenhGioThang("Mão", 3, "Sửu", "Mùi"),
        MenhGioThang("Mão", 4, "Dần", "Thân"),
        MenhGioThang("Mão", 5, "Mão", "Dậu"),
        MenhGioThang("Mão", 6, "Thìn", "Tuất"),
        MenhGioThang("Mão", 7, "Tỵ", "Hợi"),
        MenhGioThang("Mão", 8, "Ngọ", "Tý"),
        MenhGioThang("Mão", 9, "Mùi", "Sửu"),
        MenhGioThang("Mão", 10, "Thâ", "Dần"),
        MenhGioThang("Mão", 11, "Dậu", "Mão"),
        MenhGioThang("Mão", 12, "Tuất", "Thìn"),

        MenhGioThang("Thìn", 1, "Tuất", "Ngọ"),
        MenhGioThang("Thìn", 2, "Hợi", "Mùi"),
        MenhGioThang("Thìn", 3, "Tý", "Thân"),
        MenhGioThang("Thìn", 4, "Sửu", "Dậu"),
        MenhGioThang("Thìn", 5, "Dần", "Tuất"),
        MenhGioThang("Thìn", 6, "Mão", "Hợi"),
        MenhGioThang("Thìn", 7, "Thìn", "Tý"),
        MenhGioThang("Thìn", 8, "Tỵ", "Sửu"),
        MenhGioThang("Thìn", 9, "Ngọ", "Dần"),
        MenhGioThang("Thìn", 10, "Mùi", "Mão"),
        MenhGioThang("Thìn", 11, "Thân", "Thìn"),
        MenhGioThang("Thìn", 12, "Dậu", "Tỵ"),

        MenhGioThang("Tỵ", 1, "Dậu", "Mùi"),
        MenhGioThang("Tỵ", 2, "Tuất", "Thân"),
        MenhGioThang("Tỵ", 3, "Hợi", "Dậu"),
        MenhGioThang("Tỵ", 4, "Tý", "Tuất"),
        MenhGioThang("Tỵ", 5, "Sửu", "Hợi"),
        MenhGioThang("Tỵ", 6, "Dần", "Tý"),
        MenhGioThang("Tỵ", 7, "Mão", "Sửu"),
        MenhGioThang("Tỵ", 8, "Thìn", "Dần"),
        MenhGioThang("Tỵ", 9, "Tỵ", "Mão"),
        MenhGioThang("Tỵ", 10, "Ngọ", "Thìn"),
        MenhGioThang("Tỵ", 11, "Mùi", "Tỵ"),
        MenhGioThang("Tỵ", 12, "Thân", "Ngọ"),

        MenhGioThang("Ngọ", 1, "Thân", "Thân"),
        MenhGioThang("Ngọ", 2, "Dậu", "Dậu"),
        MenhGioThang("Ngọ", 3, "Tuất", "Tuất"),
        MenhGioThang("Ngọ", 4, "Hợi", "Hợi"),
        MenhGioThang("Ngọ", 5, "Tý", "Tý"),
        MenhGioThang("Ngọ", 6, "Sửu", "Sửu"),
        MenhGioThang("Ngọ", 7, "Dần", "Dần"),
        MenhGioThang("Ngọ", 8, "Mão", "Mão"),
        MenhGioThang("Ngọ", 9, "Thìn", "Thìn"),
        MenhGioThang("Ngọ", 10, "Tỵ", "Tỵ"),
        MenhGioThang("Ngọ", 11, "Ngọ", "Ngọ"),
        MenhGioThang("Ngọ", 12, "Mùi", "Mùi"),

        MenhGioThang("Mùi", 1, "Mùi", "Dậu"),
        MenhGioThang("Mùi", 2, "Thân", "Tuất"),
        MenhGioThang("Mùi", 3, "Dậu", "Hợi"),
        MenhGioThang("Mùi", 4, "Tuất", "Tý"),
        MenhGioThang("Mùi", 5, "Hợi", "Sửu"),
        MenhGioThang("Mùi", 6, "Tý", "Dần"),
        MenhGioThang("Mùi", 7, "Sửu", "Mão"),
        MenhGioThang("Mùi", 8, "Dần", "Thìn"),
        MenhGioThang("Mùi", 9, "Mão", "Tỵ"),
        MenhGioThang("Mùi", 10, "Thìn", "Ngọ"),
        MenhGioThang("Mùi", 11, "Tỵ", "Mùi"),
        MenhGioThang("Mùi", 12, "Ngọ", "Thân"),

        MenhGioThang("Thân", 1, "Ngọ", "Tuất"),
        MenhGioThang("Thân", 2, "Mùi", "Hợi"),
        MenhGioThang("Thân", 3, "Thân", "TÝ"),
        MenhGioThang("Thân", 4, "Dậu", "Sửu"),
        MenhGioThang("Thân", 5, "Tuất", "Dần"),
        MenhGioThang("Thân", 6, "Hợi", "Mão"),
        MenhGioThang("Thân", 7, "Thân", "Tý"),
        MenhGioThang("Thân", 8, "Sửu", "Tỵ"),
        MenhGioThang("Thân", 9, "Dần", "Ngọ"),
        MenhGioThang("Thân", 10, "Mão", "Mùi"),
        MenhGioThang("Thân", 11, "Thìn", "Thân"),
        MenhGioThang("Thân", 12, "Tỵ", "Dận"),

        MenhGioThang("Dậu", 1, "Tỵ", "Hợi"),
        MenhGioThang("Dậu", 2, "Ngọ", "Tý"),
        MenhGioThang("Dậu", 3, "Mùi", "Sửu"),
        MenhGioThang("Dậu", 4, "Thân", "Dần"),
        MenhGioThang("Dậu", 5, "Dậu", "Mão"),
        MenhGioThang("Dậu", 6, "Tuất", "Thìn"),
        MenhGioThang("Dậu", 7, "Hợi", "Tỵ"),
        MenhGioThang("Dậu", 8, "Tý", "Ngọ"),
        MenhGioThang("Dậu", 9, "Sửu", "Mùi"),
        MenhGioThang("Dậu", 10, "Dần", "Thân"),
        MenhGioThang("Dậu", 11, "Mão", "Dậu"),
        MenhGioThang("Dậu", 12, "Thìn", "Tuất"),

        MenhGioThang("Tuất", 1, "Thìn", "Tý"),
        MenhGioThang("Tuất", 2, "Tỵ", "Sửu"),
        MenhGioThang("Tuất", 3, "Ngọ", "Dần"),
        MenhGioThang("Tuất", 4, "Mùi", "Mão"),
        MenhGioThang("Tuất", 5, "Thân", "Thìn"),
        MenhGioThang("Tuất", 6, "Dậu", "Tỵ"),
        MenhGioThang("Tuất", 7, "Tuất", "Ngọ"),
        MenhGioThang("Tuất", 8, "Hợi", "Mùi"),
        MenhGioThang("Tuất", 9, "Tý", "Thân"),
        MenhGioThang("Tuất", 10, "Sửu", "Dậu"),
        MenhGioThang("Tuất", 11, "Dần", "Tuất"),
        MenhGioThang("Tuất", 12, "Mão", "Hợi"),

        MenhGioThang("Hợi", 1, "Mão", "Sửu"),
        MenhGioThang("Hợi", 2, "Thìn", "Dần"),
        MenhGioThang("Hợi", 3, "Tý", "Mão"),
        MenhGioThang("Hợi", 4, "Ngọ", "Thìn"),
        MenhGioThang("Hợi", 5, "Mùi", "Tỵ"),
        MenhGioThang("Hợi", 6, "Thân", "Ngọ"),
        MenhGioThang("Hợi", 7, "Tuất", "Thân"),
        MenhGioThang("Hợi", 8, "Hợi", "Dậu"),
        MenhGioThang("Hợi", 9, "Dậu", "Tý"),
        MenhGioThang("Hợi", 10, "Tý", "Tuất"),
        MenhGioThang("Hợi", 11, "Sửu", "Hợi"),
        MenhGioThang("Hợi", 12, "Dần", "Tý"),
    )

//    val tuVi = listOf("B", "Đ", "M", "B", "V", "M", "M", "Đ", "M", "B", "V", "B")
//    val liemTrinh = listOf("V", "Đ", "V", "H", "M", "H", "V", "Đ", "V", "H", "M", "H")
//    val thienDong = listOf("V", "H", "M", "Đ", "H", "Đ", "H", "H", "M", "H", "H", "Đ")
//    val vuKhuc = listOf("V", "M", "V", "Đ", "M", "H", "V", "M", "V", "Đ", "M", "H")
//    val x = listOf("H", "Đ", "V", "V", "V", "M", "M", "Đ", "H", "H", "H", "H")
//    val x = listOf("Đ", "Đ", "H", "M", "M", "V", "Đ", "Đ", "V", "M", "M", "H")
//    val x = listOf("V", "Đ", "H", "H", "H", "H", "H", "Đ", "V", "M", "M", "M")
//    val x = listOf("H", "M", "Đ", "H", "V", "H", "H", "M", "Đ", "H", "V", "H")
//    val x = listOf("V", "H", "V", "M", "H", "H", "V", "H", "Đ", "M", "H", "Đ")
//    val x = listOf("V", "Đ", "M", "H", "V", "Đ", "V", "Đ", "M", "H", "V", "Đ")
//    val x = listOf("V", "Đ", "V", "V", "M", "H", "M", "Đ", "V", "H", "M", "H")
//    val x = listOf("M", "Đ", "M", "H", "H", "V", "M", "Đ", "M", "H", "H", "V")
//    val x = listOf("M", "V", "H", "H", "Đ", "H", "M", "V", "H", "H", "Đ", "H")
//    val x = listOf("H", "Đ", "H", "H", "Đ", "H", "H", "Đ", "H", "H", "Đ", "H")
//    val x = listOf("H", "Đ", "H", "H", "Đ", "H", "H", "Đ", "H", "H", "Đ", "H")
//    val x = listOf("H", "H", "Đ", "Đ", "Đ", "Đ", "Đ", "H", "H", "H", "H", "H")
//    val x = listOf("H", "H", "Đ", "Đ", "Đ", "Đ", "Đ", "H", "H", "H", "H", "H")
//    val x = listOf("H", "Đ", "H", "Đ", "H", "Đ", "H", "Đ", "H", "H", "Đ", "Đ")
//    val x = listOf("H", "Đ", "H", "Đ", "H", "Đ", "H", "Đ", "H", "H", "Đ", "Đ")
//    val x = listOf("H", "H", "Đ", "H", "H", "Đ", "H", "H", "Đ", "H", "H", "Đ")
//    val x = listOf("H", "H", "Đ", "H", "H", "Đ", "H", "H", "Đ", "H", "H", "Đ")
//    val x = listOf("", "Đ", "", "", "Đ", "", "", "Đ", "", "", "Đ", "")
//    val x = listOf("", "", "Đ", "Đ", "", "", "", "", "Đ", "Đ", "", "")
//    val x = listOf("", "", "Đ", "Đ", "", "", "", "", "Đ", "Đ", "", "")
//    val x = listOf("Đ", "Đ", "", "Đ", "", "", "Đ", "Đ", "", "Đ", "", "")
//    val x = listOf("Đ", "Đ", "", "Đ", "", "", "Đ", "Đ", "", "Đ", "", "")
//    val x = listOf("", "", "Đ", "", "", "Đ", "", "", "", "", "", "")
//    val thienHinh = listOf("", "", "Đ", "Đ", "", "", "", "", "Đ", "Đ", "", "")
//    val thienRieu = listOf("", "", "Đ", "Đ", "", "", "", "", "", "Đ", "Đ", "")

    val listSaoTuvi = listOf(
        "Tử vi",
        "Liêm trinh",
        "Thiên đồng",
        "Vũ khúc",
        "Thái dương",
        "Thiên cơ",
        "Thái âm",
        "Tham lang",
        "Cự môn",
        "Thiên tướng",
        "Thiên lương",
        "Thất sát",
        "Phá quân",
        "Đà la",
        "Kình dương",
        "Linh tinh",
        "Hỏa tinh",
        "Văn xương",
        "Văn khúc",
        "Địa không",
        "Địa kiếp",
        "Hóa kỵ",
        "Đại hao",
        "Tiểu Hao",
        "Thiên khốc",
        "Thiên hư",
        "Thiên mã",
        "Thiên Hình",
        "Thiên riêu"
    )

    fun getPointThienCan(thienCan: String): Int {
        return when (thienCan) {
            CanEnum.GIAP.valueStr, CanEnum.AT.valueStr -> 1
            CanEnum.BINH.valueStr, CanEnum.DINH.valueStr -> 2
            CanEnum.MAU.valueStr, CanEnum.KY.valueStr -> 3
            CanEnum.CANH.valueStr, CanEnum.TAN.valueStr -> 4
            else -> 5
        }
    }

    fun getPointDiaChi(diaChi: String): Int {
        return when (diaChi) {
            ChiEnum.TY.valueStr, ChiEnum.SUU.valueStr, ChiEnum.MUI.valueStr, ChiEnum.NGO.valueStr -> 0
            ChiEnum.DAN.valueStr, ChiEnum.MAO.valueStr, ChiEnum.THAN.valueStr, ChiEnum.DAU.valueStr -> 1
            else -> 2
        }
    }

    fun getMenhFromCanChi(thienCan: String, diaChi: String): String {
        val pointThienCan = getPointThienCan(thienCan)
        val pointDiaChi = getPointDiaChi(diaChi)
        val pointHanh = (pointDiaChi + pointThienCan) % 5
        return when (pointHanh) {
            0 -> HanhEnum.MOC.valueStr
            1 -> HanhEnum.KIM.valueStr
            2 -> HanhEnum.THUY.valueStr
            3 -> HanhEnum.HOA.valueStr
            else -> HanhEnum.THO.valueStr
        }
    }

    fun getNguHanhNapAm(year: Int): String {
        val baseYear = 1924
        return banMenh[((year - baseYear)) % 60 % 2]
    }

    fun getMenhThanFromHourLunar(hourLunar: String, monthLunar: Int): MenhGioThang {
        return listThanMenh.first { it.gio == hourLunar && it.thang == monthLunar }
    }

    fun getCanForAge(hourLunar: String, monthLunar: Int, canYearLunar: String): String {
        val cungMenh = getMenhThanFromHourLunar(hourLunar, monthLunar).menh
        val listCuc = listOf(
            CucFromYear(listOf("Tý", "Sửu"), listOf("Giáp", "Kỷ"), "Thủy"),
            CucFromYear(listOf("Tý", "Sửu"), listOf("Ất", "Canh"), "Hỏa"),
            CucFromYear(listOf("Tý", "Sửu"), listOf("Bính", "Tân"), "THổ"),
            CucFromYear(listOf("Tý", "Sửu"), listOf("Đinh", "Nhâm"), "Mộc"),
            CucFromYear(listOf("Tý", "Sửu"), listOf("Mậu", "Quý"), "Kim"),

            CucFromYear(listOf("Dần", "Mão"), listOf("Giáp", "Kỷ"), "Hỏa"),
            CucFromYear(listOf("Dần", "Mão"), listOf("Ất", "Canh"), "Thổ"),
            CucFromYear(listOf("Dần", "Mão"), listOf("Bính", "Tân"), "Mộc"),
            CucFromYear(listOf("Dần", "Mão"), listOf("Đinh", "Nhâm"), "Kim"),
            CucFromYear(listOf("Dần", "Mão"), listOf("Mậu", "Quý"), "Thủy"),

            CucFromYear(listOf("Thìn", "Tỵ"), listOf("Giáp", "Kỷ"), "Mộc"),
            CucFromYear(listOf("Thìn", "Tỵ"), listOf("Ất", "Canh"), "Kim"),
            CucFromYear(listOf("Thìn", "Tỵ"), listOf("Bính", "Tân"), "Thủy"),
            CucFromYear(listOf("Thìn", "Tỵ"), listOf("Đinh", "Nhâm"), "Hỏa"),
            CucFromYear(listOf("Thìn", "Tỵ"), listOf("Mậu", "Quý"), "Thổ"),

            CucFromYear(listOf("Ngọ", "Mùi"), listOf("Giáp", "Kỷ"), "THổ"),
            CucFromYear(listOf("Ngọ", "Mùi"), listOf("Ất", "Canh"), "Mộc"),
            CucFromYear(listOf("Ngọ", "Mùi"), listOf("Bính", "Tân"), "Kim"),
            CucFromYear(listOf("Ngọ", "Mùi"), listOf("Đinh", "Nhâm"), "Thủy"),
            CucFromYear(listOf("Ngọ", "Mùi"), listOf("Mậu", "Quý"), "Hỏa"),

            CucFromYear(listOf("Thân", "Dậu"), listOf("Giáp", "Kỷ"), "Kim"),
            CucFromYear(listOf("Thân", "Dậu"), listOf("Ất", "Canh"), "Thủy"),
            CucFromYear(listOf("Thân", "Dậu"), listOf("Bính", "Tân"), "Hỏa"),
            CucFromYear(listOf("Thân", "Dậu"), listOf("Đinh", "Nhâm"), "Thổ"),
            CucFromYear(listOf("Thân", "Dậu"), listOf("Mậu", "Quý"), "Mộc"),

            CucFromYear(listOf("Tuất", "Hợi"), listOf("Giáp", "Kỷ"), "Hỏa"),
            CucFromYear(listOf("Tuất", "Hợi"), listOf("Ất", "Canh"), "Thổ"),
            CucFromYear(listOf("Tuất", "Hợi"), listOf("Bính", "Tân"), "Mộc"),
            CucFromYear(listOf("Tuất", "Hợi"), listOf("Đinh", "Nhâm"), "Kim"),
            CucFromYear(listOf("Tuất", "Hợi"), listOf("Mậu", "Quý"), "Thủy"),
        )
        return listCuc.first {
            val setMenh = it.listMenh.toSet()
            val setCanYear = it.listMenh.toSet()
            (setMenh.equals(cungMenh) && setCanYear.equals(canYearLunar))
        }.cucFromYear
    }

    fun getListAnSaoTuVi() = listOf(
        AnSaoTuVI(1, "Sửu", "Thìn", "Hợi", "Ngọ", "Dậu"),
        AnSaoTuVI(2, "Dần", "Sửu", "Thìn", "Hợi", "Ngọ"),
        AnSaoTuVI(3, "Dần", "Dần", "Sửu", "Thìn", "Hợi"),
        AnSaoTuVI(4, "Mão", "Tỵ", "Dần", "Sửu", "Thìn"),
        AnSaoTuVI(5, "Mão", "Dần", "Tý", "Dần", "Sửu"),
        AnSaoTuVI(6, "Thìn", "Mão", "Tỵ", "Mùi", "Dần"),
        AnSaoTuVI(7, "Thìn", "Ngọ", "Dần", "Tý", "Tuất"),
        AnSaoTuVI(8, "Tỵ", "Mão", "Mão", "Tỵ", "Mùi"),
        AnSaoTuVI(9, "Tỵ", "Thìn", "Sửu", "Dần", "Tý"),
        AnSaoTuVI(10, "Ngọ", "Mùi", "Ngọ", "Mão", "Tỵ"),
        AnSaoTuVI(11, "Ngọ", "Thìn", "Mão", "Thân", "Dần"),
        AnSaoTuVI(12, "Mùi", "Tỵ", "Thìn", "Sửu", "Mão"),
        AnSaoTuVI(13, "Mùi", "Thân", "Dần", "Ngọ", "Hợi"),
        AnSaoTuVI(14, "Thân", "Tỵ", "Mùi", "Mão", "Thân"),
        AnSaoTuVI(15, "Thân", "Ngọ", "Thìn", "Thìn", "Sửu"),
        AnSaoTuVI(16, "Dậu", "Dậu", "Tỵ", "Dậu", "Ngọ"),
        AnSaoTuVI(17, "Dậu", "Ngọ", "Mão", "Dần", "Mão"),
        AnSaoTuVI(18, "Tuất", "Mùi", "Thân", "Mùi", "Thìn"),
        AnSaoTuVI(19, "Tuất", "Tuất", "Tỵ", "Thìn", "Tý"),
        AnSaoTuVI(20, "Hợi", "Mùi", "Ngọ", "Tỵ", "Dậu"),
        AnSaoTuVI(21, "Hợi", "Thân", "Thìn", "Tuất", "Dần"),
        AnSaoTuVI(22, "Tý", "Hợi", "Dậu", "Mão", "Mùi"),
        AnSaoTuVI(23, "Tý", "Thân", "Ngọ", "Thân", "Dậu"),
        AnSaoTuVI(24, "Sửu", "Thìn", "Hợi", "Ngọ", "Thìn"),
        AnSaoTuVI(25, "Sửu", "Tý", "Tỵ", "Ngọ", "Sửu"),
        AnSaoTuVI(26, "Dần", "Dậu", "Tuất", "Hợi", "Tuất"),
        AnSaoTuVI(27, "Dần", "Tuất", "Mùi", "Thìn", "Mão"),
        AnSaoTuVI(28, "Mão", "Sửu", "Thân", "Dậu", "Thân"),
        AnSaoTuVI(29, "Mão", "Tuất", "Ngọ", "Ngọ", "Tỵ"),
        AnSaoTuVI(30, "Thìn", "Hợi", "Hợi", "Mùi", "Ngọ")
    )

    fun getListAnSaoChinh = listOf(
        AnSaoChinhTinh(
            "Tý",
            listOf("Tử Vi"), listOf("Vô Chính"),
            listOf("Phá Quân"), listOf("Vô Chính Diệu"),
            listOf("Liêm Trinh", "Thiên Phủ"), listOf("Thái Âm"),
            listOf("Tham Lang"), listOf("Thiên Đồng", "Cự Môn"),
            listOf("Vũ Khúc", "Thiên Tướng"), listOf("Thái Dương", "Thiên Lương"),
            listOf("Thất Sát"), listOf("Thiên Cơ")
        ),
    )

    fun getAnSaoTuVi(
        hourLunar: String,
        dayLunar: Int,
        monthLunar: Int,
        canYearLunar: String
    ): String {
        val cucFromYear = getCanForAge(hourLunar, monthLunar, canYearLunar) k
        val anSaoTuVI = getListAnSaoTuVi().first { it.dayLunar == dayLunar }
        return when (cucFromYear) {
            "Thủy" -> anSaoTuVI.thuyNhiCuc
            "Kim" -> anSaoTuVI.kimTuCuc
            "Mộc" -> anSaoTuVI.mocTamCUc
            "Hỏa" -> anSaoTuVI.hoaLucCuc
            else -> anSaoTuVI.thoNguCuc
        }
    }

    fun list14CungTuVi(menhThan: MenhGioThang): List<String> {
        val listChi = LunarCoreHelper.CHI
        val positionCungMenh = listChi.indexOfFirst { it == menhThan.menh }
        val cungPhuMau = listChi[(positionCungMenh + 1) % 12]
        val cungPhucDuc = listChi[(positionCungMenh + 2) % 12]
        val cungDienTrach = listChi[(positionCungMenh + 3) % 12]
        val cungQuanLoc = listChi[(positionCungMenh + 4) % 12]
        val cungNoboc = listChi[(positionCungMenh + 5) % 12]
        val cungThienDi = listChi[(positionCungMenh + 6) % 12]
        val cungTatAch = listChi[(positionCungMenh + 7) % 12]
        val cungTaiBach = listChi[(positionCungMenh + 8) % 12]
        val cungTuTuc = listChi[(positionCungMenh + 9) % 12]
        val cungTheThiep = listChi[(positionCungMenh + 10) % 12]
        val cungHuynhDe = listChi[(positionCungMenh + 11) % 12]

        return listOf(
            menhThan.menh, cungPhuMau, cungPhucDuc,
            cungDienTrach, cungQuanLoc, cungNoboc,
            cungThienDi, cungTatAch, cungTaiBach,
            cungTuTuc, cungTheThiep, cungHuynhDe, menhThan.than
        )
    }

}

data class MenhGioThang(
    val gio: String,
    val thang: Int,
    val menh: String,
    val than: String
)

data class CucFromYear(
    val listMenh: List<String>,
    val listCanYear: List<String>,
    val cucFromYear: String
)

data class AnSaoTuVI(
    val dayLunar: Int,
    val thuyNhiCuc: String,
    val mocTamCUc: String,
    val kimTuCuc: String,
    val thoNguCuc: String,
    val hoaLucCuc: String,
)

data class AnSaoChinhTinh(
    val anSaoTuVi: String,
    val cungTY: List<String>,
    val cungSuu: List<String>,
    val cungDan: List<String>,
    val cungMao: List<String>,
    val cungThin: List<String>,
    val cungTi: List<String>,
    val cungNgo: List<String>,
    val cungMui: List<String>,
    val cungThan: List<String>,
    val cungDau: List<String>,
    val cungTuat: List<String>,
    val cungHoi: List<String>,
)
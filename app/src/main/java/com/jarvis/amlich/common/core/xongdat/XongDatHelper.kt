package com.jarvis.amlich.common.core.xongdat

object XongDatHelper {
    val chiNguHanh = listOf(
        Triple("Mùi", 1, "Thổ"),
        Triple("Hợi", 1, "Thủy"),
        Triple("Mão", 1, "Mộc"),
        Triple("Thìn", 2, "Thổ"),
        Triple("Thân", 2, "Kim"),
        Triple("Tý", 2, "Thủy"),
        Triple("Dậu", 3, "Kim"),
        Triple("Tỵ", 3, "Hỏa"),
        Triple("Sửu", 3, "Thổ"),
        Triple("Ngọ", 4, "Hỏa"),
        Triple("Tuất", 4, "Thổ"),
        Triple("Dần", 4, "Mộc"),
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
        Pair("Mậu", "Thủy"),
        Pair("Quý", "Thủy"),
    )

    val nguHanhXung = listOf(
        NguHanhXung("Kim", "Thổ", "Thủy", "Mộc"),
        NguHanhXung("Mộc", "Thủy", "Hỏa", "Thổ"),
        NguHanhXung("Thủy", "Kim", "Mộc", "Hỏa"),
        NguHanhXung("Hỏa", "Mộc", "Thổ", "Kim"),
        NguHanhXung("Thổ", "Hỏa", "Kim", "Thủy"),
    )

    fun checkNguHanhDiaChi(){

    }
}

data class NguHanhXung(
    val type: String,
    val beforeType: String,
    val afterType: String,
    val conflictBeforeType: String,
    val conflictAfterType: String
)
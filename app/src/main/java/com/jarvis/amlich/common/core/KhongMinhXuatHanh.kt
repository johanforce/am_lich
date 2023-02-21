package com.jarvis.amlich.common.core

object KhongMinhXuatHanh {
    val listKhongMinh = listOf(
        KhongMinhDay(
            "Hảo Thương",
            listOf(1, 4, 7, 10),
            listOf(6, 12, 18, 24, 30),
            StatusEnum.GOOD.value,
            "Xuất hành thuận lợi, gặp người lớn vừa lòng, làm việc việc như ý muốn, áo phẩm vinh quy. "
        ),
        KhongMinhDay(
            "Đạo Tặc", listOf(1, 4, 7, 10), listOf(5, 11, 17, 23, 29),
            StatusEnum.BAD.value, "Rất xấu. Xuất hành bị hại, mất của. "
        ),
        KhongMinhDay(
            "Thuần Dương",
            listOf(1, 4, 7, 10),
            listOf(4, 10, 16, 22, 28),
            StatusEnum.GOOD.value,
            "Xuất hành tốt, lúc về cũng tốt, nhiều thuận lợi, được người tốt giúp đỡ, cầu tài được như ý muốn, tranh luận thường thắng lợi. "
        ),
        KhongMinhDay(
            "Đường Phong",
            listOf(1, 4, 7, 10),
            listOf(1, 7, 13, 19, 25),
            StatusEnum.GOOD.value,
            "Rất tốt, xuất hành thuận lợi, cầu tài được như ý muốn, gặp quý nhân phù trợ "
        ),
        KhongMinhDay(
            "Kim Thổ",
            listOf(1, 4, 7, 10),
            listOf(2, 8, 14, 20, 26),
            StatusEnum.BAD.value,
            "Ra đi nhỡ tàu, nhỡ xe, cầu tài không được, trên đường đi mất của, bất lợi."
        ),
        KhongMinhDay(
            "Kim Dương",
            listOf(1, 4, 7, 10),
            listOf(3, 9, 15, 21, 27),
            StatusEnum.GOOD.value,
            "Xuất hành tốt, có quý nhân phù trợ, tài lộc thông suốt, thưa kiện có nhiều lý phải. "
        ),
        KhongMinhDay(
            "Thiên Đạo",
            listOf(2, 5, 8, 11),
            listOf(1, 9, 17, 25),
            StatusEnum.BAD.value,
            "Xuất hành cầu tài nên tránh, dù được cũng rất tốn kém, thất lý mà thua."
        ),
        KhongMinhDay(
            "Thiên Thương",
            listOf(2, 5, 8, 11),
            listOf(8, 16, 24, 30),
            StatusEnum.GOOD.value,
            "Xuất hành để gặp cấp trên thì tuyệt vời, cầu tài thì được tài. Mọi việc đều thuận lợi."
        ),
        KhongMinhDay(
            "Thiên Hầu",
            listOf(2, 5, 8, 11),
            listOf(7, 15, 23),
            StatusEnum.BAD.value,
            "Xuất hành dầu ít hay nhiều cũng cãi cọ, phải tránh xẩy ra tai nạn chảy máu, máu sẽ khó cầm."
        ),
        KhongMinhDay(
            "Thiên Dương",
            listOf(2, 5, 8, 11),
            listOf(6, 14, 22),
            StatusEnum.GOOD.value,
            "Xuất hành tốt, cầu tài được tài. Hỏi vợ được vợ. Mọi việc đều như ý muốn."
        ),
        KhongMinhDay(
            "Thiên Môn",
            listOf(2, 5, 8, 11),
            listOf(2, 10, 18, 26),
            StatusEnum.GOOD.value,
            "Xuất hành làm mọi việc đều vừa ý, cầu được ước thấy mọi việc đều thành đạt."
        ),
        KhongMinhDay(
            "Thiên Đường",
            listOf(2, 5, 8, 11),
            listOf(3, 11, 19, 27),
            StatusEnum.GOOD.value,
            "Xuất hành tốt, quý nhân phù trợ, buôn bán may mắn, mọi việc đều như ý."
        ),
        KhongMinhDay(
            "Thiên Tài",
            listOf(2, 5, 8, 11),
            listOf(4, 12, 20, 28),
            StatusEnum.GOOD.value,
            "Nên xuất hành, cầu tài thắng lợi. Được người tốt giúp đỡ. Mọi việc đều thuận."
        ),
        KhongMinhDay(
            "Thiên Tặc",
            listOf(2, 5, 8, 11),
            listOf(5, 13, 21, 29),
            StatusEnum.BAD.value,
            "Xuất hành xấu, cầu tài không được. Đi đường dễ mất cắp. Mọi việc đều rất xấu."
        ),
        KhongMinhDay(
            "Bạch Hổ Đầu",
            listOf(3, 6, 9, 12),
            listOf(2, 10, 18, 26),
            StatusEnum.GOOD.value,
            "Xuất hành, cầu tài đều được. Đi đâu đều thông đạt cả."
        ),
        KhongMinhDay(
            "Bạch Hổ Kiếp",
            listOf(3, 6, 9, 12),
            listOf(3, 11, 19, 27),
            StatusEnum.GOOD.value,
            "Xuất hành, cầu tài được như ý muốn, đi hướng Nam và Bắc rất thuận lợi."
        ),
        KhongMinhDay(
            "Thanh Long Kiếp",
            listOf(3, 6, 9, 12),
            listOf(7, 15, 25, 23),
            StatusEnum.GOOD.value,
            "Xuất hành 4 phương, 8 hướng đều tốt, trăm sự được như ý."
        ),
        KhongMinhDay(
            "Thanh Long Đầu",
            listOf(3, 6, 9, 12),
            listOf(6, 14, 22),
            StatusEnum.GOOD.value,
            "Xuất hành nên đi vào sáng sớm. Cỗu tài thắng lợi. Mọi việc như ý."
        ),
        KhongMinhDay(
            "Bạch Hổ Túc",
            listOf(3, 6, 9, 12),
            listOf(4, 12, 20, 28),
            StatusEnum.BAD.value,
            "Cấm đi xa, làm việc gì cũng không thành công. Rất xấu trong mọi việc."
        ),
        KhongMinhDay(
            "Huyền Vũ",
            listOf(3, 6, 9, 12),
            listOf(5, 13, 21, 29),
            StatusEnum.BAD.value,
            "Xuất hành thường gặp cãi cọ, gặp việc xấu, không nên đi."
        ),
        KhongMinhDay(
            "Chu Tước",
            listOf(3, 6, 9, 12),
            listOf(1, 9, 17),
            StatusEnum.BAD.value,
            "Xuất hành, cầu tài đều xấu. Hay mất của, kiện cáo thua vì đuối lý."
        ),
        KhongMinhDay(
            "Thanh Long Túc",
            listOf(3, 6, 9, 12),
            listOf(8, 16, 24, 30),
            StatusEnum.BAD.value,
            "Đi xa không nên, xuất hành xấu, tài lộc không có. Kiện cáo cũng đuối lý."
        ),
    )

    fun getXuatHanhKhongMinh(day: Int, month: Int): KhongMinhDay {
        return listKhongMinh.first { ob ->
            ob.listDay.any { it == day } &&
                    ob.listMonth.any { it == month }
        }
    }
}

data class KhongMinhDay(
    val name: String,
    val listMonth: List<Int>,
    val listDay: List<Int>,
    val status: Int,
    val meaning: String
)

enum class StatusEnum(var valueStr: String, val value: Int) {
    // action card not DONE
    GOOD("Tốt", 1),
    BAD("Xấu", 0),
}
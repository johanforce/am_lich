package com.jarvis.amlich.common.core

import com.jarvis.amlich.R
import com.jarvis.amlich.di.App

object SaoXauHelper {
    private val thienCuong =
        listOf("Tỵ", "Tý", "Mùi", "Dần", "Dậu", "Thìn", "Hợi", "Ngọ", "Sửu", "Thân", "Mão", "Tuất")
    private val thuTu =
        listOf("Tuất", "Thìn", "Hợi", "Tỵ", "Tý", "Ngọ", "Sửu", "Mùi", "Dần", "Thân", "Mão", "Dậu")
    private val daiHao =
        listOf("Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ")
    private val tuKhi =
        listOf("Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ")
    private val quanPhu =
        listOf("Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ")
    private val tieuHao =
        listOf("Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn")
    private val satChu =
        listOf("Tý", "Tỵ", "Mùi", "Mão", "Thân", "Tuất", "Sửu", "Hợi", "Ngọ", "Dậu", "Dần", "Thìn")
    private val thienHoa =
        listOf("Tý", "Mão", "Ngọ", "Dậu", "Tý", "Mão", "Ngọ", "Dậu", "Tý", "Mão", "Ngọ", "Dậu")
    private val diaHoa =
        listOf("Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần", "Sửu", "Tý", "Hợi")
    private val hoaTai =
        listOf("Sửu", "Mùi", "Dần", "Thân", "Mão", "Dậu", "Thìn", "Tuất", "Tỵ", "Hợi", "Tý", "Ngọ")
    private val nguyetPha =
        listOf(
            "Thân",
            "Tuất",
            "Tuất",
            "Hợi",
            "Sửu",
            "Sửu",
            "Dần",
            "Thìn",
            "Thìn",
            "Tỵ",
            "Mùi",
            "Mùi"
        )
    private val bangTieu =
        listOf("Tỵ", "Tý", "Sửu", "Thân", "Mão", "Tuất", "Hợi", "Ngọ", "Mùi", "Dần", "Dậu", "Thìn")
    private val ngoaGiai =
        listOf("Tỵ", "Tý", "Sửu", "Thân", "Mão", "Tuất", "Hợi", "Ngọ", "Mùi", "Dần", "Dậu", "Thìn")
    private val thoCam =
        listOf("Hợi", "Hợi", "Hợi", "Dần", "Dần", "Dần", "Tỵ", "Tỵ", "Tỵ", "Thân", "Thân", "Thân")
    private val thoKy =
        listOf("Dần", "Tỵ", "Thân", "Hợi", "Mão", "Ngọ", "Dậu", "Tý", "Thìn", "Mùi", "Tuất", "Sửu")
    private val vangVong =
        listOf("Dần", "Tỵ", "Thân", "Hợi", "Mão", "Ngọ", "Dậu", "Tý", "Thìn", "Mùi", "Tuất", "Sửu")
    private val coThan =
        listOf("Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu")
    private val quaTu =
        listOf("Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão")
    private val trungTang =
        listOf("Giáp", "Ất", "Mậu", "Bính", "Đinh", "Kỷ", "Canh", "Tân", "Kỷ", "Nhâm", "Quý", "Mậu")
    private val trungPhuc =
        listOf("Canh", "Tân", "Kỷ", "Nhâm", "Quý", "Mậu", "Giáp", "Ất", "Kỷ", "Bính", "Đinh", "Mậu")

    private val khongPhong =
        listOf("Thìn", "Tỵ", "Tý", "Tuất", "Hợi", "Mùi", "Ngọ", "Mão", "Dần", "Dậu", "Thân", "Sửu")

    private val thienTac =
        listOf("Thìn", "Dậu", "Dần", "Mùi", "Tý", "Tỵ", "Tuất", "Mão", "Thân", "Sửu", "Ngọ", "Hợi")
    private val phuDauDat =
        listOf("Thìn", "Thìn", "Thìn", "Mùi", "Mùi", "Mùi", "Ngọ", "Ngọ", "Ngọ", "Tý", "Tý", "Tý")
    private val tamTang = listOf(
        "Thìn",
        "Thìn",
        "Thìn",
        "Mùi",
        "Mùi",
        "Mùi",
        "Tuất",
        "Tuất",
        "Tuất",
        "Sửu",
        "Sửu",
        "Sửu"
    )
    private val nguTu =
        listOf("Tý", "Dậu", "Sửu", "Thân", "Tý", "Thìn", "Hợi", "Mão", "Mùi", "Dần", "Ngọ", "Tuất")
    private val tuThoi = listOf(
        "Ất Mùi",
        "Ất Mùi",
        "Ất Mùi",
        "Bính Tuất",
        "Bính Tuất",
        "Bính Tuất",
        "Tân Sửu",
        "Tân Sửu",
        "Tân Sửu",
        "Nhâm Thìn",
        "Nhâm Thìn",
        "Nhâm Thìn"
    )
    private val lucBatThanh =
        listOf("Dần", "Ngọ", "Tuất", "Tỵ", "Dậu", "Sửu", "Thân", "Tý", "Thìn", "Hợi", "Mão", "Mùi")
    private val hoangSa =
        listOf("Ngọ", "Dần", "Tý", "Ngọ", "Dần", "Tý", "Ngọ", "Dần", "Tý", "Ngọ", "Dần", "Tý")
    private val nguyetHu = listOf(
        "Sửu",
        "Tuất",
        "Mùi",
        "Thìn",
        "Sửu",
        "Tuất",
        "Mùi",
        "Thìn",
        "Sửu",
        "Tuất",
        "Mùi",
        "Thìn"
    )
    private val nguyetYem =
        listOf("Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần", "Sửu", "Tý", "Hợi")
    private val nguyetHoa =
        listOf("Tỵ", "Thìn", "Mão", "Dần", "Sửu", "Tý", "Hợi", "Tuất", "Tỵ", "Hợi", "Ngọ", "Tý")
    private val tieuHongSa = listOf("Tỵ", "", "", "", "", "", "", "", "", "", "", "")
    private val cuaKhong =
        listOf("Thìn", "Sửu", "Tuất", "Mùi", "Mão", "Tý", "Dậu", "Ngọ", "Dần", "Hợi", "Thân", "Tý")
    private val chuTuoc =
        listOf("Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu")
    private val haKhoi =
        listOf("Hợi", "Ngọ", "Sửu", "Thân", "Mão", "Tuất", "Tỵ", "Tý", "Mùi", "Dần", "Dậu", "Thìn")
    private val nguQuy =
        listOf("Ngọ", "Dần", "Thìn", "Dậu", "Mão", "Thân", "Sửu", "Tỵ", "Tý", "Hợi", "Mùi", "Tuất")
    private val phiMaSat =
        listOf("Tý", "Dậu", "Ngọ", "Mão", "Tý", "Dậu", "Ngọ", "Mão", "Tý", "Dậu", "Ngọ", "Mão")
    private val thanCach =
        listOf("Tỵ", "Mão", "Sửu", "Hợi", "Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi", "Dậu", "Mùi")
    private val nhanCach =
        listOf("Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi", "Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi")
    private val diaTac =
        listOf("Sửu", "Tý", "Hợi", "Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần")
    private val nguyetKien =
        listOf("Mão", "Mão", "Mão", "Ngọ", "Ngọ", "Ngọ", "Dậu", "Dậu", "Dậu", "Tý", "Tý", "Tý")
    private val thienDia =
        listOf("Mão", "Mão", "Mão", "Ngọ", "Ngọ", "Ngọ", "Dậu", "Dậu", "Dậu", "Tý", "Tý", "Tý")
    private val loBanSat =
        listOf("Tý", "Tý", "Tý", "Mão", "Mão", "Mão", "Ngọ", "Ngọ", "Ngọ", "Dậu", "Dậu", "Dậu")
    private val nguyetHinh =
        listOf("Tỵ", "Tý", "Thìn", "Thân", "Ngọ", "Sửu", "Dần", "Dậu", "Mùi", "Hợi", "Mão", "Tuất")
    private val toiChi =
        listOf("Ngọ", "Tý", "Mùi", "Sửu", "Thân", "Dần", "Dậu", "Mão", "Tuất", "Thìn", "Hợi", "Tỵ")

    private val thienHinh = listOf(
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý"
    )
    private val thienLao = listOf(
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ"
    )
    private val cauTran =
        listOf("Hợi", "Sửu", "Mão", "Tị", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu")
    private val satSu =
        listOf("Thìn", "Tuất", "Thìn", "Mão", "Mão", "Sửu", "Mùi", "Sửu", "Tý", "Ngọ", "Ngọ", "Tý")
    private val bachHo = listOf(
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn"
    )
    private val lySang =
        listOf("Dậu", "Dậu", "Dậu", "Dần", "Dần", "Dần", "Tuất", "Tuất", "Tuất", "Tỵ", "Tỵ", "Tỵ")
    private val nguyenVu =
        listOf("Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi")

    private val listSaoXau =
        listOf(
            "Thiên Cương",
            "Thụ Tử",
            "Đại Hao",
            "Tử Khí",
            "Quan Phù",
            "Tiểu Hao",
            "Sát Chủ",
            "Thiên Hỏa",
            "Địa Hỏa",
            "Hỏa Tai",
            "Nguyệt Phá",
            "Băng Tiêu",
            "Ngọa Giải",
            "Thổ Cấm",
            "Thổ Kỵ",
            "Vãng Vong",
            "Cô Thần",
            "Quả Tú",
            "Trùng Tang",
            "Trùng Phục",
            "Không Phòng",
            "Thiên Tặc",
            "Phủ Đầu Sát",
            "Ngũ Quỷ",
            "Tứ Thời",
            "Lục Bất Thành",
            "Hoàng Sa",
            "Nguyệt Hư",
            "Nguyệt Yếm",
            "Nguyệt Hỏa",
            "Tiêu Hồng Sa",
            "Cửa Không",
            "Chu Tước",
            "Hà Khôi",
            "Ngũ Quỷ",
            "Phi Ma Sát",
            "Thần Cách",
            "Nhân Cách",
            "Địa Tặc",
            "Nguyệt Kiến",
            "Thiên Địa",
            "Lỗ Ban Sát",
            "Nguyệt Hình",
            "Tội Chỉ",
            "Tam Tang",
            "Thiên Hình",
            "Thiên Lao",
            "Câu Trần",
            "Sát Sư",
            "Bạch Hổ",
            "Ly Sàng",
            "Nguyên Vu"
        )

    private val listListDay = listOf(
        thienCuong,
        thuTu,
        daiHao,
        tuKhi,
        quanPhu,
        tieuHao,
        satChu,
        thienHoa,
        diaHoa,
        hoaTai,
        nguyetPha,
        bangTieu,
        ngoaGiai,
        thoCam,
        thoKy,
        vangVong,
        coThan,
        quaTu,
        trungTang,
        trungPhuc,
        khongPhong,
        thienTac,
        phuDauDat,
        nguTu,
        tuThoi,
        lucBatThanh,
        hoangSa,
        nguyetHu,
        nguyetYem,
        nguyetHoa,
        tieuHongSa,
        cuaKhong,
        chuTuoc,
        haKhoi,
        nguQuy,
        phiMaSat,
        thanCach,
        nhanCach,
        diaTac,
        nguyetKien,
        thienDia,
        loBanSat,
        nguyetHinh,
        toiChi,
        tamTang,
        thienHinh,
        thienLao,
        cauTran,
        satSu,
        bachHo,
        lySang,
        nguyenVu
    )

    private val listTitleDay = listOf(
        App.context.getString(R.string.des_thienCuong),
        App.context.getString(R.string.des_thuTu),
        App.context.getString(R.string.des_daiHao),
        App.context.getString(R.string.des_tuKhi),
        App.context.getString(R.string.des_quanPhu),
        App.context.getString(R.string.des_tieuHao),
        App.context.getString(R.string.des_satChu),
        App.context.getString(R.string.des_thienHoa),
        App.context.getString(R.string.des_diaHoa),
        App.context.getString(R.string.des_hoaTai),
        App.context.getString(R.string.des_nguyetPha),
        App.context.getString(R.string.des_bangTieu),
        App.context.getString(R.string.des_ngoaGiai),
        App.context.getString(R.string.des_thoCam),
        App.context.getString(R.string.des_thoKy),
        App.context.getString(R.string.des_vangVong),
        App.context.getString(R.string.des_coThan),
        App.context.getString(R.string.des_quaTu),
        App.context.getString(R.string.des_trungTang),
        App.context.getString(R.string.des_trungPhuc),
        App.context.getString(R.string.des_khongPhong),
        App.context.getString(R.string.des_thienTac),
        App.context.getString(R.string.des_phuDauDat),
        App.context.getString(R.string.des_nguTu),
        App.context.getString(R.string.des_tuThoi),
        App.context.getString(R.string.des_lucBatThanh),
        App.context.getString(R.string.des_hoangSa),
        App.context.getString(R.string.des_nguyetHu),
        App.context.getString(R.string.des_nguyetYem),
        App.context.getString(R.string.des_nguyetHoa),
        App.context.getString(R.string.des_tieuHongSa),
        App.context.getString(R.string.des_cuaKhong),
        App.context.getString(R.string.des_chuTuoc),
        App.context.getString(R.string.des_haKhoi),
        App.context.getString(R.string.des_nguQuy),
        App.context.getString(R.string.des_phiMaSat),
        App.context.getString(R.string.des_thanCach),
        App.context.getString(R.string.des_nhanCach),
        App.context.getString(R.string.des_diaTac),
        App.context.getString(R.string.des_nguyetKien),
        App.context.getString(R.string.des_thienDia),
        App.context.getString(R.string.des_loBanSat),
        App.context.getString(R.string.des_nguyetHinh),
        App.context.getString(R.string.des_toiChi),
        App.context.getString(R.string.des_tamTang),
        App.context.getString(R.string.des_thienHinh),
        App.context.getString(R.string.des_thienLao),
        App.context.getString(R.string.des_cauTran),
        App.context.getString(R.string.des_satSu),
        App.context.getString(R.string.des_bachHo),
        App.context.getString(R.string.des_lySang),
        App.context.getString(
            R.string.des_nguyenVu
        )
    )

    fun getSaoXau(canDay: String, chiDay: String, thang: Int): List<String> {
        val results = mutableListOf<String>()
        listListDay.mapIndexed { index, strings ->
            if (strings[thang - 1] == canDay || strings[thang - 1] == chiDay || strings[thang - 1] == "$canDay $chiDay") {
                results.add(listSaoXau[index] + ": " + listTitleDay[index])
            }
        }
        return results
    }


    private val thienDuc = listOf(
        "Đinh",
        "Thân",
        "Nhâm",
        "Tân",
        "Hợi",
        "Giáp",
        "Quý",
        "Dần",
        "Bính",
        "Ất",
        "Tỵ",
        "Canh"
    )
    private val thienDucHop =
        listOf("Nhâm", "Tý", "Đinh", "Bính", "Dần", "Kỷ", "Mậu", "Hợi", "Tân", "Canh", "Thân", "Ất")
    private val nguyetDuc = listOf(
        "Bính",
        "Giáp",
        "Nhâm",
        "Canh",
        "Bính",
        "Giáp",
        "Nhâm",
        "Canh",
        "Bính",
        "Giáp",
        "Nhâm",
        "Canh"
    )
    private val nguyetDucHop =
        listOf("Tân", "Kỷ", "Đinh", "Ất", "Tân", "Kỷ", "Đinh", "Ất", "Tân", "Kỷ", "Đinh", "Ất")
    private val thienHy =
        listOf("Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu")
    private val thienPhu =
        listOf("Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão")

    private val thienQuy1 = listOf(
        "Giáp",
        "Giáp",
        "Giáp",
        "Bính",
        "Bính",
        "Bính",
        "Canh",
        "Canh",
        "Canh",
        "Nhâm",
        "Nhâm",
        "Nhâm"
    )
    private val thienQuy2 =
        listOf("Ất", "Ất", "Ất", "Đinh", "Đinh", "Đinh", "Tân", "Tân", "Tân", "Quý", "Quý", "Quý")
    private val thienXa =
        listOf(
            "Mậu Dần",
            "Mậu Dần",
            "Mậu Dần",
            "Giáp Ngọ",
            "",
            "Giáp Ngọ",
            "Mậu Thân",
            "Mậu Thân",
            "Mậu Thân",
            "Giáp Tý",
            "",
            "Giáp Tý"
        )
    private val sinhKhi =
        listOf("Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi")
    private val thienPhuc1 = listOf("Kỷ", "Mậu", "", "Tân", "Tân", "", "Ất", "Giáp", "", "Đinh", "Bính", "")
    private val thienPhuc2 = listOf("", "", "", "Quý", "Nhâm", "", "", "", "", "", "", "")
    private val thienThanh =
        listOf("Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ")
    private val thienQuan = listOf(
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân"
    )
    private val thienMa = listOf(
        "Ngọ", "Thân", "Tuất", "Tý", "Dần", "Thìn", "Ngọ", "Thân", "Tuất", "Tý", "Dần", "Thìn"
    )
    private val kimQuy = listOf(
        "Thìn", "Ngọ", "Thân", "Tuất", "Tý", "Dần", "Thìn", "Ngọ", "Thân", "Tuất", "Tý", "Dần"
    )
    private val baoQuang = listOf(
        "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão"
    )
    private val nguyetTai = listOf(
        "Ngọ", "Tỵ", "Tỵ", "Mùi", "Dậu", "Hợi", "Ngọ", "Tỵ", "Tỵ", "Mùi", "Dậu", "Hợi"
    )
    private val nguyetAn = listOf(
        "Bính", "Đinh", "Canh", "Kỷ", "Mậu", "Tân", "Nhâm", "Quý", "Canh", "Ất", "Giáp", "Tân"
    )
    private val nguyetKhong = listOf(
        "Nhâm",
        "Canh",
        "Bính",
        "Giáp",
        "Nhâm",
        "Canh",
        "Bính",
        "Giáp",
        "Nhâm",
        "Canh",
        "Bính",
        "Giáp"
    )
    private val minhTinh = listOf(
        "Thân", "Tuất", "Tý", "Dần", "Thìn", "Ngọ", "Thân", "Tuất", "Tý", "Dần", "Thìn", "Ngọ"
    )
    private val thanhTam = listOf(
        "Hợi", "Tỵ", "Tý", "Ngọ", "Sửu", "Mùi", "Dần", "Thân", "Mão", "Dậu", "Thìn", "Tuất"
    )
    private val nguPhu = listOf(
        "Hợi", "Dần", "Tỵ", "Thân", "Hợi", "Dần", "Tỵ", "Thân", "Hợi", "Dần", "Tỵ", "Thân"
    )
    private val locKho = listOf(
        "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão"
    )
    private val uViTinh = listOf(
        "Hợi", "Thìn", "Sửu", "Ngọ", "Mão", "Thân", "Tỵ", "Tuất", "Mùi", "Tý", "Dậu", "Dần"
    )
    private val phucSinh = listOf(
        "Dậu", "Mão", "Tuất", "Thìn", "Hợi", "Tỵ", "Tý", "Ngọ", "Sửu", "Mùi", "Dần", "Thân"
    )
    private val catKhanh = listOf(
        "Dậu", "Dần", "Hợi", "Thìn", "Sửu", "Ngọ", "Mão", "Thân", "Tỵ", "Tuất", "Mùi", "Tý"
    )
    private val amDuc = listOf(
        "Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi", "Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi"
    )
    private val macDucTinh = listOf(
        "Dần", "Mùi", "Thìn", "Dậu", "Ngọ", "Hợi", "Thân", "Sửu", "Tuất", "Mão", "Tý", "Tỵ"
    )
    private val kinhTam = listOf(
        "Mùi", "Sửu", "Thân", "Dần", "Dậu", "Mão", "Tuất", "Thìn", "Hợi", "Tỵ", "Tý", "Ngọ"
    )
    private val tueHop = listOf(
        "Sửu", "Tý", "Hợi", "Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần"
    )
    private val nguyetGiai = listOf(
        "Thân", "Thân", "Dậu", "Dậu", "Tuất", "Tuất", "Hợi", "Hợi", "Ngọ", "Ngọ", "Mùi", "Mùi"
    )
    private val quanNhat = listOf(
        "", "Mão", "", "", "Ngọ", "", "", "Dậu", "", "", "Tý", ""
    )
    private val hoatDieu = listOf(
        "Tỵ", "Tuất", "Mùi", "Tý", "Dậu", "Dần", "Hợi", "Thìn", "Sửu", "Ngọ", "Mão", "Thân"
    )
    private val giaiThan = listOf(
        "Thân", "Thân", "Tuất", "Tuất", "Tý", "Tý", "Dần", "Dần", "Thìn", "Thìn", "Ngọ", "Ngọ"
    )
    private val phoHo = listOf(
        "Thân", "Dần", "Dậu", "Mão", "Tuất", "Thìn", "Hợi", "Tỵ", "Tý", "Ngọ", "Sửu", "Mùi"
    )
    private val ichHau = listOf(
        "Tý", "Ngọ", "Sửu", "Mùi", "Dần", "Thân", "Mão", "Dậu", "Thìn", "Tuất", "Tỵ", "Hợi"
    )
    private val tucThe = listOf(
        "Sửu", "Mùi", "Dần", "Thân", "Mão", "Dậu", "Thìn", "Tuất", "Tỵ", "Hợi", "Ngọ", "Tý"
    )
    private val yeuYen = listOf(
        "Dần", "Thân", "Mão", "Dậu", "Thìn", "Tuất", "Tỵ", "Hợi", "Ngọ", "Tý", "Mùi", "Sửu"
    )
    private val dichMa = listOf(
        "Thân", "Tỵ", "Dần", "Hợi", "Thân", "Tỵ", "Dần", "Hợi", "Thân", "Tỵ", "Dần", "Hợi"
    )
    private val tamHop1 = listOf(
        "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ"
    )
    private val tamHop2 = listOf(
        "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu"
    )
    private val mauThuong1 = listOf(
        "Hợi", "Hợi", "Hợi", "Dần", "Dần", "Dần", "Thìn", "Thìn", "Thìn", "Thân", "Thân", "Thân"
    )
    private val mauThuong2 = listOf(
        "Tý", "Tý", "Tý", "Mão", "Mão", "Mão", "Sửu", "Sửu", "Sửu", "Dậu", "Dậu", "Dậu"
    )
    private val lucHop = listOf(
        "Hợi", "Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần", "Sửu", "Tý"
    )
    private val phucHau = listOf(
        "Dần", "Dần", "Dần", "Tỵ", "Tỵ", "Tỵ", "Thân", "Thân", "Thân", "Hợi", "Hợi", "Hợi"
    )
    private val daiHongSa1 = listOf(
        "Tý", "Tý", "Tý", "Thìn", "Thìn", "Thìn", "Ngọ", "Ngọ", "Ngọ", "Thân", "Thân", "Thân"
    )
    private val daiHongSa2 = listOf(
        "Sửu", "Sửu", "Sửu", "Tỵ", "Tỵ", "Tỵ", "Mùi", "Mùi", "Mùi", "Tuất", "Tuất", "Tuất"
    )
    private val hoangAn = listOf(
        "Tuất", "Sửu", "Dần", "Tỵ", "Dậu", "Mão", "Tý", "Ngọ", "Hợi", "Thìn", "Thân", "Mùi"
    )
    private val danNHat = listOf(
        "Ngọ", "Ngọ", "Ngọ", "Dậu", "Dậu", "Dậu", "Tý", "Tý", "Tý", "Mão", "Mão", "Mão"
    )
    private val thanhLongHoangDao = listOf(
        "Tý", "Dần", "Thìn", "Ngọ", "Thân", "Tuất", "Tý", "Dần", "Thìn", "Ngọ", "Thân", "Tuất"
    )
    private val minhDuong = listOf(
        "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi"
    )
    private val kimDuong = listOf(
        "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão"
    )
    private val ngocDuong = listOf(
        "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ"
    )

    private val nameSaoTot = listOf(
        "Thiên Đức",
        "Thiên Đức Hợp",
        "Nguyệt Đức",
        "Thiên Hỷ",
        "Thiên Phú",
        "Thiên Quý",
        "Thiên Quý",
        "Thiên Xá",
        "Thiên Xá",
        "Sinh Khí",
        "Thiên Phúc",
        "Thiên Phúc",
        "Thiên Thành",
        "Thiên Quan",
        "Thiên Mã",
        "Thiên Tài",
        "Địa Tài",
        "Nguyệt Tài",
        "Nguyệt Ân",
        "Nguyệt Không",
        "Minh Tinh",
        "Thánh tâm",
        "Ngũ Phú",
        "Lộc Khố",
        "Phúc Sinh",
        "Cát Khánh",
        "Âm Đức",
        "U Vi Tinh",
        "Mãn Đức",
        "Kính Tâm",
        "Tuế Hợp",
        "Nguyệt Giải",
        "Quan Nhật",
        "Hoạt Điệu",
        "Giải Thần",
        "Phổ Hộ",
        "Ích Hậu",
        "Tục Thế",
        "Yếu Yên",
        "Dịch Mã",
        "Tam Hợp",
        "Tam Hợp",
        "Lục Hợp",
        "Mẫu Thương",
        "Mẫu Thương",
        "Phúc Hậu",
        "Đại Hồng Sa",
        "Đại Hồng Sa",
        "Dân Nhật",
        "Hoàng Ân",
        "Thanh Long",
        "Minh Đường",
        "Kim Đường",
        "Ngọc Đường ",
    )

    private val listListSaoTot = listOf(
        thienDuc,
        thienDucHop,
        nguyetDuc,
        nguyetDucHop,
        thienHy,
        thienPhu,
        thienQuy1,
        thienQuy2,
        thienXa,
        sinhKhi,
        thienPhuc1,
        thienPhuc2,
        thienThanh,
        thienQuan,
        thienMa,
        kimQuy,
        baoQuang,
        nguyetTai,
        nguyetAn,
        nguyetKhong,
        minhTinh,
        thanhTam,
        nguPhu,
        locKho,
        phucSinh,
        catKhanh,
        amDuc,
        uViTinh,
        macDucTinh,
        kinhTam,
        tueHop,
        nguyetGiai,
        quanNhat,
        hoatDieu,
        giaiThan,
        phoHo,
        ichHau,
        tucThe,
        yeuYen,
        dichMa,
        tamHop1,
        tamHop2,
        lucHop,
        mauThuong1,
        mauThuong2,
        phucHau,
        daiHongSa1,
        daiHongSa2,
        danNHat,
        hoangAn,
        thanhLongHoangDao,
        minhDuong,
        kimDuong,
        ngocDuong
    )

    private val listTitleDaySaoTot = listOf(
        App.context.getString(R.string.des_thienDuc),
        App.context.getString(R.string.des_thienDucHop),
        App.context.getString(R.string.des_nguyetDuc),
        App.context.getString(R.string.des_nguyetDucHop),
        App.context.getString(R.string.des_thienHy),
        App.context.getString(R.string.des_thienPhu),
        App.context.getString(R.string.des_thienQuy1),
        App.context.getString(R.string.des_thienQuy2),
        App.context.getString(R.string.des_thienXa),
        App.context.getString(R.string.des_sinhKhi),
        App.context.getString(R.string.des_thienPhuc1),
        App.context.getString(R.string.des_thienPhuc2),
        App.context.getString(R.string.des_thienThanh),
        App.context.getString(R.string.des_thienQuan),
        App.context.getString(R.string.des_thienMa),
        App.context.getString(R.string.des_kimQuy),
        App.context.getString(R.string.des_baoQuang),
        App.context.getString(R.string.des_nguyetTai),
        App.context.getString(R.string.des_nguyetAn),
        App.context.getString(R.string.des_nguyetKhong),
        App.context.getString(R.string.des_minhTinh),
        App.context.getString(R.string.des_thanhTam),
        App.context.getString(R.string.des_nguPhu),
        App.context.getString(R.string.des_locKho),
        App.context.getString(R.string.des_phucSinh),
        App.context.getString(R.string.des_catKhanh),
        App.context.getString(R.string.des_amDuc),
        App.context.getString(R.string.des_uViTinh),
        App.context.getString(R.string.des_macDucTinh),
        App.context.getString(R.string.des_kinhTam),
        App.context.getString(R.string.des_tueHop),
        App.context.getString(R.string.des_nguyetGiai),
        App.context.getString(R.string.des_quanNhat),
        App.context.getString(R.string.des_hoatDieu),
        App.context.getString(R.string.des_giaiThan),
        App.context.getString(R.string.des_phoHo),
        App.context.getString(R.string.des_ichHau),
        App.context.getString(R.string.des_tucThe),
        App.context.getString(R.string.des_yeuYen),
        App.context.getString(R.string.des_dichMa),
        App.context.getString(R.string.des_tamHop1),
        App.context.getString(R.string.des_tamHop2),
        App.context.getString(R.string.des_lucHop),
        App.context.getString(R.string.des_mauThuong1),
        App.context.getString(R.string.des_mauThuong2),
        App.context.getString(R.string.des_phucHau),
        App.context.getString(R.string.des_daiHongSa1),
        App.context.getString(R.string.des_daiHongSa2),
        App.context.getString(R.string.des_danNHat),
        App.context.getString(R.string.des_hoangAn),
        App.context.getString(R.string.des_thanhLongHoangDao),
        App.context.getString(R.string.des_minhDuong),
        App.context.getString(R.string.des_kimDuong),
        App.context.getString(R.string.des_ngocDuong)
    )

    fun getSaoTot(canDay: String, chiDay: String, thang: Int): List<String> {
        val results = mutableListOf<String>()
        listListSaoTot.mapIndexed { index, strings ->
            if (strings[thang - 1] == canDay || strings[thang - 1] == chiDay || strings[thang - 1] == "$canDay $chiDay") {
                results.add(nameSaoTot[index] + ": " + SaoXauHelper.listTitleDaySaoTot[index])
            }
        }
        return results
    }
}

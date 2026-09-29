package com.example.employeeinfo_2415053122129.utils

import java.text.NumberFormat
import java.util.Locale

// 1. Extension Function định dạng lương sang tiền tệ VND (Yêu cầu mở rộng cá nhân)
fun Double.toVndCurrency(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
    return formatter.format(this)
}

// 2. Extension Function chuyển đổi tên nhân viên thành chữ in hoa
fun String.toFormattedName(): String {
    return this.uppercase(Locale("vi", "VN"))
}

// 3. Extension Function quy đổi đánh giá thâm niên nhân viên
fun Int.toSeniorityRank(): String {
    return when {
        this >= 5 -> "Nhân viên kỳ cựu (Senior)"
        this >= 2 -> "Nhân viên có kinh nghiệm"
        else -> "Nhân viên mới (Junior)"
    }
}
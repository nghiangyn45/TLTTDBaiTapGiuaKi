package com.example.employeeinfo_2415053122129.utils

import com.example.employeeinfo_2415053122129.model.Employee
import java.text.NumberFormat
import java.util.Locale

// Yêu cầu 6.2: Hiển thị lương với định dạng đặc biệt (Tiền tệ VND)
fun Double.toVndCurrency(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
    return formatter.format(this)
}

// Yêu cầu 6.3: Hiển thị tên viết hoa[cite: 38]
fun String.toFormattedName(): String {
    return this.uppercase(Locale("vi", "VN"))
}

// Yêu cầu 6.1: So sánh mức lương trên số chuẩn (Đặt lương chuẩn ví dụ: 15.000.000 VNĐ)[cite: 38]
fun Double.compareWithStandardSalary(standard: Double): String {
    return if (this >= standard) {
        "Cao hơn mức chuẩn (${(this - standard).toVndCurrency()})"
    } else {
        "Thấp hơn mức chuẩn"
    }
}

// Yêu cầu 6.5: Hiển thị mức xếp loại dựa trên thâm niên[cite: 38]
fun Int.toSeniorityRanking(): String {
    return when {
        this >= 5 -> "Cấp bậc: Chuyên gia (Senior)"
        this >= 2 -> "Cấp bậc: Nhân viên chính thức"
        else -> "Cấp bậc: Nhân viên tập sự (Junior)"
    }
}

// Yêu cầu 6.4: Hiển thị thông tin nhân viên bằng Extension Function[cite: 38]
fun Employee.getSummaryInfo(): String {
    return "Nhân viên: ${this.fullName} - Phòng ban: ${this.department}"
}
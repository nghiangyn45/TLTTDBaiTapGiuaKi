package com.example.employeeinfo_2415053122129

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.employeeinfo_2415053122129.databinding.ActivityMainBinding
import com.example.employeeinfo_2415053122129.model.Employee
import com.example.employeeinfo_2415053122129.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Khởi tạo dữ liệu nhân viên cá nhân hóa (Yêu cầu 5)[cite: 38]
        val employee = Employee(
            employeeId = "2415053122129",
            fullName = "Nguyễn Minh Nghĩa",
            department = "Phòng Phát triển Phần mềm",
            age = 20,
            salary = 18500000.0,
            gender = "Nam",
            seniority = 3
        )

        // Mức lương chuẩn để so sánh (Yêu cầu 6.1)[cite: 38]
        val standardSalary = 15000000.0

        // Hiển thị dữ liệu lên giao diện sử dụng các yêu cầu mở rộng (Yêu cầu 6)[cite: 38]
        with(binding) {
            // 6.3: Hiển thị tên viết hoa[cite: 38]
            tvName.text = employee.fullName.toFormattedName()

            tvEmployeeId.text = "Mã nhân viên: ${employee.employeeId}"
            tvDepartment.text = "Phòng ban: ${employee.department}"
            tvAgeAndGender.text = "Tuổi: ${employee.age} | Giới tính: ${employee.gender}"

            // 6.2: Hiển thị lương với định dạng đặc biệt[cite: 38]
            tvSalary.text = "Lương cơ bản: ${employee.salary.toVndCurrency()}"

            // 6.1: Hiển thị thông tin mức lương trên số chuẩn[cite: 38]
            tvSalaryComparison.text = "So với chuẩn: ${employee.salary.compareWithStandardSalary(standardSalary)}"

            // 6.5: Hiển thị mức xếp loại dựa trên thâm niên[cite: 38]
            tvSeniorityRank.text = "Thâm niên (${employee.seniority} năm): ${employee.seniority.toSeniorityRanking()}"

            // 6.4: Hiển thị thông tin nhân viên bằng Extension Function[cite: 38]
            tvSummaryInfo.text = "Tóm tắt: ${employee.getSummaryInfo()}"

            // 6.6: Bổ sung một thông tin vào giao diện[cite: 38]
            tvExtraInfo.text = "Trạng thái hợp đồng: Chính thức (Full-time)"
        }
    }
}
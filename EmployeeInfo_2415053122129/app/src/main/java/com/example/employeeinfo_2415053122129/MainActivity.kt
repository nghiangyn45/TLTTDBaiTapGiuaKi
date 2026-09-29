package com.example.employeeinfo_2415053122129
import com.example.employeeinfo_2415053122129.model.Employee
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.employeeinfo_2415053122129.databinding.ActivityMainBinding
import com.example.employeeinfo_2415053122129.utils.toFormattedName
import com.example.employeeinfo_2415053122129.utils.toSeniorityRank
import com.example.employeeinfo_2415053122129.utils.toVndCurrency

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Thiết lập ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Khởi tạo dữ liệu nhân viên riêng biệt (thay thế bằng thông tin của bạn)[cite: 34]
        val employee = Employee(
            employeeId = "2415053122129",
            fullName = "Nguyễn Minh Nghĩa",
            department = "Phòng Phát triển Phần mềm",
            age = 20,
            salary = 18500000.0,
            gender = "Nam",
            seniority = 3
        )

        // Hiển thị dữ liệu từ Model kết hợp sử dụng các Extension Function[cite: 35]
        with(binding) {
            // Sử dụng Extension Function viết hoa tên
            tvName.text = employee.fullName.toFormattedName()

            tvEmployeeId.text = "Mã nhân viên: ${employee.employeeId}"
            tvDepartment.text = "Phòng ban: ${employee.department}"
            tvAgeAndGender.text = "Tuổi: ${employee.age} | Giới tính: ${employee.gender}"

            // Sử dụng Extension Function định dạng tiền tệ VND cho mức lương
            tvSalary.text = "Lương: ${employee.salary.toVndCurrency()}"

            // Sử dụng Extension Function phân loại thâm niên
            tvSeniority.text = "Thâm niên: ${employee.seniority} năm (${employee.seniority.toSeniorityRank()})"
        }
    }
}
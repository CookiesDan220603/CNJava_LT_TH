

import java.util.List;

public class Program {
	public static void main(String[] args) {

		// 1. khởi tạo danh sách sinh viên
		List<Student> list = StudentUtils.generate();
		StudentUtils.print(list);

		// 2. sắp xếp theo tên và in ra kết quả
		StudentUtils.sortByName(list);
		StudentUtils.print(list);

		// 3. sắp xếp tăng dần theo điểm trung bình và in ra kết quả
		StudentUtils.sortByAvg(list);
		StudentUtils.print(list);

		// @TODO: sắp xếp giảm dần theo tuổi rồi in kết quả
		StudentUtils.sortByAgeDescending(list);
		StudentUtils.print(list);

		// @TODO: tính điểm trung bình của toàn bộ danh sách rồi in kết quả
		double avg = StudentUtils.avg(list);
		System.out.printf("The average score of all students: %.2f\n", avg);

		// @TODO: lấy danh sách TÊN học sinh giỏi rồi in kết quả
		System.out.println("\nList of excellent student's name:");
		List<String> names = StudentUtils.goodStudentName(list);
		names.forEach(System.out::println);
	}
}

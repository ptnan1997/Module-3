package Session3;
import  java.util.Scanner;

public class Session3_Bai3 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ***************** MENU NHẬP LƯƠNG *****************
                1. Nhập lương nhân viên
                2. Hiển thị thống kê
                3. Tính tổng số tiền thưởng cho nhân viên
                4. Thoát
                ***************************************************
                """);
        boolean isContinued = true;
        int count =0;
        double avg ;
        double totalSalary = 0;
        double maxSalary = 0;
        double minSalary = 500000000;
        double totalBonus = 0;
        while (isContinued) {
            System.out.print("Nhập vào lựa chọn của bạn:");
            int choice = sc.nextInt();
        switch (choice){
            case 1:
                double salary;
                double bonus = 0;
                System.out.println("Nhập lương nhân viên (nhập -1 để kết thúc");
                while (true){
                    System.out.print("Nhập lương:");
                    salary = sc.nextDouble();
                    if (salary == -1){
                        break;
                    }
                    if (salary <0 || salary >500000000){
                        System.err.println("Số lương không nằm trong khoảng cho phép. Nhập lại");
                        continue;
                    }

                    if (salary >50000000 ){
                        System.out.println("Thu nhập cao");
                    }else if  (salary >= 15000000 ){
                        System.out.println("Thu nhập khá");
                    }else if (salary >= 5000000 ){
                        System.out.println("Thu nhập trung bình");
                    } else if(salary > 0 ){
                        System.out.println("Thu nhập thấp");
                    }
                    // Thực hiện tính

                    count +=1;// Tổng nhân viên
                    totalSalary += salary; // Tổng lương

                    if(salary > maxSalary){
                        maxSalary = salary;// Lương cao nhất
                    }
                    if (salary < minSalary){
                        minSalary = salary;// Lương thấp nhất
                    }
                    if (salary > 0 && salary <= 5000000){
                        bonus = salary * 0.05;
                    } else if (salary >5000000 && salary <= 15000000){
                        bonus = salary * 0.1;
                    } else if (salary > 15000000 && salary <= 50000000){
                        bonus = salary * 1.5;
                    } else if (salary > 50000000 && salary <= 100000000){
                        bonus = salary * 2.0;
                    } else if (salary > 100000000){
                        bonus = salary * 2.5;
                    }
                    totalBonus += bonus;
                }
                break;
            case 2:
                if (count == 0){
                    System.err.println("Chưa có dữ liệu");
                } else {
                    avg = totalSalary / count;
                    System.out.printf("""
                                Số nhân viên đã nhập: %d \n
                                Lương trung bình: %f \n
                                Lương cao nhất: %f \n
                                Lương thấp nhất: %f \n
                                Tổng tiền lương: %f \n
                                """,count,avg,maxSalary,minSalary,totalSalary
                                );
                }
                break;
            case 3:
                System.out.println("Tổng tiền thưởng cho toàn bộ nhân viên" + totalBonus);
                break;
            case 4:
                System.out.println("Kết thúc chương trình");
                isContinued  = false;
                break;
            default:
                System.err.println("Lựa chọn không hợp lệ");
            }
        }
    }
}

// khai báo
//	+ totalEmployee : lưu trữ tổng số nhân
//    + totalSalary : lưu trữ tổng lương của tất cả các nhân viên
//    + minSalary : lưu trữ lương thấp - gán = 0
//        + maxSalary : lưu trữ lương cao nhất - gán = 0
//        + totalBonus : lưu trữ tổng thưởng cho tất cả các nhân viên = 0
//
//làm chức năng 1 gồm các bước :
//B1 : Khai báo 4 biến :
//
//B2 : Cho người dùng nhập vào  lương của từng nhân viên - nhập -1 để kết thúc nhập lương
//	- salary = scanner.nextDouble()
//    - Sử dụng do while để cho người dùng nhập lương cho từng nhân viên
//		+ cho người dùng nhập vào giá trị của salary
//        + kiểm tra nếu salary != -1 và nhập đúng
//			+ phân loại lương nhân viên
//            + cập nhật đếm nhân viên
//            + cập nhật tổng lương của nhân
//            + tìm lương nhỏ nhất
//            + tìm lương cao nhất
//	- in ra thông báo nhập lương thành công
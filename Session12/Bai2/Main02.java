package Session12.Bai2;

import Session12.Bai2.ra.business.AppointmentBusiness;
import Session12.Bai2.ra.entity.Appointment;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentBusiness manager  = new AppointmentBusiness();

        int choice;
        do {
            System.out.println("""
                    ============= QUẢN LÝ LỊCH HẸN ============
                    1. Thêm lịch hẹn
                    2. Hiển thị danh sách lịch hẹn
                    3. Tìm kiếm lịch hẹn theo tên bệnh nhân
                    4. Cập nhật lịch hẹn theo mã lịch hẹn
                    5. Xóa lịch hẹn theo mã lịch hẹn
                    6. Thống kê
                    7. Thoát
                    ==========================================
                    Lựa chọn của bạn:
                    """);
            choice  = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> { //Thêm lịch hẹn
                    Appointment appointment = new Appointment();
                    manager.addAppointment(appointment);
                }
                case 2 -> {//Hiển thị danh sách lịch hẹn
                    manager.displayAllAppointment();
                }
                case 3 -> {//Tìm kiếm lịch hẹn theo tên bệnh nhân
                    System.out.print("Nhập vào tên bệnh nhân muốn tìm kiếm: ");
                    String patientNameFind =  sc.nextLine();
                    manager.searchByPatientName(patientNameFind);
                }
                case 4 -> {//Cập nhật lịch hẹn theo mã lịch hẹn
                    System.out.print("Nhập vào mã lịch hẹn bạn muốn cập nhật: ");
                    String appointmentUpdateID = sc.nextLine();
                    manager.updateAppointmentByID(appointmentUpdateID);
                }
                case 5 -> {//Xóa lịch hẹn theo mã lịch hẹn
                    System.out.print("Nhập vào mã lịch hẹn bạn muốn xóa: ");
                    String appointmentDeleteID =  sc.nextLine();
                    manager.deleteAppointmentByID(appointmentDeleteID);
                }
                case 6 -> {//Thống kê
                    manager.Statistics();
                }
                case 7 -> {//Thoát
                    System.out.println("Kết thúc chương trình. Cảm ơn đã sử dụng 😍");
                    choice = -1;
                }
                default -> System.out.println("Lựa chọn không hợp lệ ❌");
            }
        } while (choice>0);
        sc.close();
    }
}

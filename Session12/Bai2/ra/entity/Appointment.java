package Session12.Bai2.ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctorName;

    // Constructor không tham số
    public Appointment() {

    }

    // Constructor có tham số
    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctorName) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
    }

    // Getter
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }
    // Setter có điều kiện


    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void inputData(Scanner sc) {
        // 1) appointmentId: 6 ký tự
        while (true) {
            System.out.print("Nhập mã lịch hẹn (6 ký tự): ");
            String id = sc.nextLine().trim();
            if (id.length() != 6) {
                System.out.println("Mã lịch hẹn phải đúng 6 ký tự!");
                continue;
            }
            this.appointmentId = id;
            break;
        }

        // 2) patientName: 10-50
        while (true) {
            System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
            String name = sc.nextLine().trim();
            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên bệnh nhân phải từ 10 đến 50 ký tự!");
                continue;
            }
            this.patientName = name;
            break;
        }

        // 3) phoneNumber: số di động VN (bản phổ biến: 0 + 9 chữ số)
        // Bạn có thể chỉnh regex nếu thầy yêu cầu chặt hơn theo nhà mạng
        while (true) {
            System.out.print("Nhập số điện thoại (VN): ");
            String phone = sc.nextLine().trim();
            if (!phone.matches("^0\\d{9}$")) {
                System.out.println("SĐT không hợp lệ! (Ví dụ: 0912345678)");
                continue;
            }
            this.phoneNumber = phone;
            break;
        }

        // 4) appointmentDate: dd/MM/yyyy
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày hẹn khám (dd/MM/yyyy): ");
            String dateStr = sc.nextLine().trim();
            try {
                this.appointmentDate = LocalDate.parse(dateStr, fmt);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ! Nhập đúng định dạng dd/MM/yyyy");
            }
        }

        // 5) doctor: <= 200
        while (true) {
            System.out.print("Nhập bác sĩ phụ trách (<=200 ký tự): ");
            String doc = sc.nextLine().trim();
            if (doc.length() > 200) {
                System.out.println("Tên bác sĩ tối đa 200 ký tự!");
                continue;
            }
            this.doctorName = doc;
            break;
        }

    }@Override
    public String toString () {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patienName='" + patientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}

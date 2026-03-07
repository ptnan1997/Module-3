package Session12.Bai2.ra.business;

import Session12.Bai1.ra.entity.Product;
import Session12.Bai2.ra.entity.Appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentBusiness {
    private Scanner sc = new Scanner(System.in);
    private List<Appointment> appointment =  new ArrayList<>();

    public AppointmentBusiness() {
    }
    // ===== Helper: check trùng  (không phân biệt hoa thường) =====
    private boolean isDuplicateName(String appointmentId) {
        for (Appointment apm : appointment) {
            if (apm.getAppointmentId()!= null && apm.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                return true;
            }
        }
        return false;
    }

    // ===== Helper: tìm index theo id =====
    private int findIndexById(String id) {
        for (int i = 0; i < appointment.size(); i++) {
            if (appointment.get(i).getAppointmentId().equalsIgnoreCase(id)) return i;
        }
        return -1;
    }
    // Thêm lịch hẹn mới
    public void addAppointment (Appointment appointments) {
        appointments.inputData(sc);
        appointment.add(appointments);
        System.out.println("Add appointment successful ✅");
    }
    // Hiển thị danh sách lịch hẹn khám
    public void displayAllAppointment(){
        for (Appointment ap : appointment) {
            System.out.println(ap.toString());
        }
    }
    // Tìm kiếm theo tên bệnh nhân
    public void searchByPatientName (String patientName){
        for (Appointment ap : appointment) {
            if (ap.getPatientName().equalsIgnoreCase(patientName)) {
                System.out.println(ap);
            }
        }
    }
    // Cập nhật lịch hẹn theo mã lịch hẹn
    public void updateAppointmentByID (String appointmentId){
        for (Appointment ap : appointment) {
            if (ap.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                ap.inputData(sc);
                break;
            }
        }
        System.out.println("Update appointment successful ✅");
    }
    // Xóa lịch hẹn theo mã lịch hẹn
    public void deleteAppointmentByID(String appointmentId){
        for (Appointment ap : appointment) {
            if (ap.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                appointment.remove(ap);
                break;
            }
        }
        System.out.println("Delete appointment successful ✅");
    }
    // Thống kê
    public void Statistics (){
        int countOfAppointment = 0;
        for (Appointment ap : appointment) {
            countOfAppointment = countOfAppointment + 1;
        }
        System.out.println("Total number of appointments : " + countOfAppointment);
        int countOfAppointmentByDoctor = 0;
        System.out.println("Please enter the name of doctor you wanna look for appointment");
        String doctorNameStatistics = sc.nextLine();
        for (Appointment ap : appointment) {
            if (ap.getDoctorName().equalsIgnoreCase(doctorNameStatistics)){
                countOfAppointmentByDoctor = countOfAppointmentByDoctor + 1;
            }
        }
        System.out.printf("Total number of appointments by %s : %s",doctorNameStatistics, countOfAppointmentByDoctor);
    }
}

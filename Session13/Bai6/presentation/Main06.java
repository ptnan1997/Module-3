package Session13.Bai6.presentation;

import Session13.Bai6.ra.dao.InputData13_6;
import Session13.Bai6.ra.dao.TaskManagement;
import Session13.Bai6.ra.entity.Tasks.Status;

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        TaskManagement taskManagement = new TaskManagement();
        int choice;
        do {
            System.out.println("""
                    =============== TO-DO LIST ============
                    1. Thêm công việc
                    2. Liệt kê công việc
                    3. Cập nhật trạng thái công việc
                    4. Xóa công việc
                    5. Tìm kiếm công việc
                    6. Thống kê công việc
                    7. Thoát
                    =======================================
                    """);
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 ->{ //Thêm công việc
                    String taskName = InputData13_6.getString(sc,"Nhập taskName: ");
                    Status status = InputData13_6.getStatus(sc,"Nhập status");
                    taskManagement.addTask(taskName,status);
                }
                case 2 -> // Liệt kê công việc
                    taskManagement.listTasks();

                case 3 ->{ // Cập nhật trạng thái công việc
                    int taskId = InputData13_6.getInt(sc,"Nhập vào taskId cập nhật:");
                    Status status = InputData13_6.getStatus(sc,"Nhập vào trạng thái mới: ");

                    taskManagement.updateTask(taskId,status);
                }
                case 4 ->{ //Xóa công việc
                    int taskId = InputData13_6.getInt(sc,"Nhập vào taskId muốn xóa: ");
                    taskManagement.deleteTask(taskId);
                }
                case 5 ->{ //Tìm kiếm công việc
                    String taskName = InputData13_6.getString(sc,"Nhập vào taskName cần tìm: ");
                    taskManagement.searchTaskByName(taskName);
                }
                case 6 ->{ // Thống kê công việc
                    Status st = InputData13_6.getStatus(sc,"Nhập trạng thái của công việc(unfinish/finish): ");
                    taskManagement.taskStatistic(st);
                }
                case 7 ->
                    System.out.println("Kết thúc chương trình! Cảm ơn đã sử dụng");

                default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại");
            }
        } while(choice!=7);
    }
}

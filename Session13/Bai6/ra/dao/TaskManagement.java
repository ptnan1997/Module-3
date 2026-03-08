package Session13.Bai6.ra.dao;

import Session13.Bai6.JDBC.database_bai6;
import Session13.Bai6.ra.entity.Tasks;
import Session13.Bai6.ra.entity.Tasks.Status;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TaskManagement implements ITaskManager{

    @Override
    public List<Tasks> listTasks() {
        List <Tasks> listTasks = new ArrayList<>();
        // Mở kết nối
        Connection conn = database_bai6.openConnection();
        // Tạo truy vấn bằng CallableStatement
        try {
            CallableStatement call = conn.prepareCall("{Call list_tasks()}");
            // Lấy dữ liệu trả về
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Tasks tsk  = new Tasks(
                        rs.getString("task_name"),
                        Status.valueOf(rs.getString("status"))
                );
                tsk.setTaskId(rs.getInt("task_id"));
                listTasks.add(tsk);
            }
            if (listTasks.isEmpty()){
                System.out.println("No tasks found");
            } else {
                for (Tasks tsk : listTasks){
                    System.out.println(tsk);
                }
            }
        } catch  (SQLException e) {
            throw new RuntimeException(e);
        }
        return  listTasks;
    }

    @Override
    public void addTask(String taskName, Status status) {
        try {
            // Mở kết nối
            Connection conn = database_bai6.openConnection();
            // Tạo truy vấn bằng CallableStatement
            CallableStatement call = conn.prepareCall("{Call add_task(?,?)}");
            // Thực thi cập nhật dữ liệu
            call.setString(1, taskName);
            call.setString(2, String.valueOf(status));
            call.executeUpdate();
            call.close();
            System.out.println("Task added ✅");
        } catch  (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTask(int taskId, Status status) {
        try {
            // Mở kết nối
            Connection conn = database_bai6.openConnection();
            // Tạo truy vấn bằng CallableStatement
            CallableStatement call = conn.prepareCall("{Call update_task_status(?,?)}");
            // Thực thi cập nhật dữ liệu
            call.setInt(1, taskId);
            call.setString(2, String.valueOf(status));
            call.executeUpdate();
            call.close();
            System.out.println("Task updated ✅");
        } catch  (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTask(int taskId) {
        try {
            // Mở kết nối
            Connection conn = database_bai6.openConnection();
            // Tạo truy vấn bằng CallableStatement
            CallableStatement call = conn.prepareCall("{Call delete_task(?)}");
            // Thực thi cập nhật dữ liệu
            call.setInt(1, taskId);
            call.executeUpdate();
            call.close();
            System.out.println("Task deleted ✅");
        } catch  (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchTaskByName(String taskName) {
        // Mở kết nối
        Connection conn = database_bai6.openConnection();
        try {
            // Tạo truy vấn bằng CallableStatement
            CallableStatement call = conn.prepareCall("{Call search_task_by_name(?)}");
            // Thực thi cập nhật dữ liệu
            call.setString(1, taskName);
            ResultSet  rs = call.executeQuery();
            if(rs.next()){
                Tasks tsk  = new Tasks(
                        rs.getString("task_name"),
                        Status.valueOf(rs.getString("status"))
                );
                tsk.setTaskId(rs.getInt("task_id"));
                System.out.println(tsk);
            }
        } catch  (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void taskStatistic(Status status) {
        try {
            // Mở kết nối
            Connection conn = database_bai6.openConnection();
            // Tạo truy vấn bằng CallableStatement
            CallableStatement call = conn.prepareCall("{Call add_task(?)}");
            // Thực thi cập nhật dữ liệu
            call.setString(1, String.valueOf(status));
            ResultSet  rs = call.executeQuery();
            if(rs.next()){
                Tasks tsk  = new Tasks(
                        rs.getString("task_name"),
                        Status.valueOf(rs.getString("status"))
                );
                tsk.setTaskId(rs.getInt("task_id"));
                System.out.println(tsk);
            }
        } catch  (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

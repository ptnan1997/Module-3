package Session13.Bai6.ra.dao;

import Session13.Bai6.ra.entity.Tasks;
import Session13.Bai6.ra.entity.Tasks.Status;

import java.util.List;

public interface ITaskManager {
    void addTask(String taskName , Status status);
    List<Tasks> listTasks();
    void updateTask(int taskId, Status status);
    void deleteTask(int taskId);
    void searchTaskByName(String taskName);
    void taskStatistic (Status status);
}

package Session13.Bai6.ra.entity;
public class Tasks {
    private int taskId;
    private String taskName;
    public enum Status {FINISHED,UNFINISHED};
    private Status status;
    // Constuctor không tham số
    public Tasks(){
        this.status = Status.UNFINISHED;
    }
    // Constructor có tham số
    public Tasks( String taskName, Status status) {
        this.taskName = taskName;
        this.status = status;
    }
    // Getter and Setter


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status=" + status +
                '}';
    }
}

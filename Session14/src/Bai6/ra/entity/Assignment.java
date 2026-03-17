package Bai6.ra.entity;

public class Assignment {
    private int employId;
    private int projectId;
    // Constructor không tham số

    public Assignment() {
    }

    // Constructor có tham số


    public Assignment(int employId, int projectId) {
        this.employId = employId;
        this.projectId = projectId;
    }

    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "employId=" + employId +
                ", projectId=" + projectId +
                '}';
    }
}

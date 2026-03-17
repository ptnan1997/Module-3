package Bai6.ra.entity;

public class Projects {
    private int projectId;
    private String projectName;
    // Constructor không tham số

    public Projects() {
    }

    // Constructor có tham số

    public Projects( String projectName) {
        this.projectName = projectName;
    }
    // Getter and setter

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}

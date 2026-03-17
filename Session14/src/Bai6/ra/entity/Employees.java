package Bai6.ra.entity;

public class Employees {
    private int employId;
    private String employName;
    // Constructor không tham số

    public Employees() {
    }
    // Constructor có tham số
    public Employees( String employName) {
        this.employName = employName;
    }

    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employId=" + employId +
                ", employName='" + employName + '\'' +
                '}';
    }
}

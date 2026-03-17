package Bai4.ra.entity;

public class Accounts {
    private int accountId;
    private double  balance;
    // Constructor không tham số

    public Accounts() {
    }
    // Constructor có tham số
    public Accounts(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    // Setter and Getter

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}

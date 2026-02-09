package Session8.Bai4;

public class BankAccount implements IBank {
    private String accountId;// Mã tài khoản
    private double balance;// Số dư tài khoản
    private String userName;// Tên người dùng
    private String phoneNumber;// Số điện thoại

    // Constructor
    public BankAccount(String accountId, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.balance = 0.0;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }
    // PHƯƠNG THỨC GETTER
    public double getBalance() {
        return balance;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public void deposit(double amount) {
        if (amount >0){
            this.balance += amount;
            System.out.println("Đã nhận tiền " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount >0 && amount <= balance){
            balance -= amount;
            System.out.println("Đã rút tiền " + amount);
        }
    }
    public void displayBalance(){
        System.out.println("Số dư tài khoản: (" + accountId + "): " + balance + "\n");
    }
}

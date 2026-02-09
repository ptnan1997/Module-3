package Session8.Bai4;

public class Main04 {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("A001","Nguyễn Văn A","+8412345678");
        BankAccount accountB = new BankAccount("B001","Trần Văn B", "+84933212235");

        // Nạp tiền vào tài khoản A
        accountA.deposit(1000);

        // Chuyển tiền từ tài khoản A sang tài khoản B
        double transferAmount = 300;
        accountA.withdraw(transferAmount);
        accountB.deposit(transferAmount);

        // Hiển thị số dư các tài khoản
        accountA.displayBalance();
        accountB.displayBalance();
    }
}

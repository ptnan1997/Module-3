package Bai4.presentation;

import Bai4.ra.dao.AccountManager;

public class Main04 {
    public static void main(String[] args) {
        AccountManager manager  = new AccountManager();
        manager.tranferFunds(1,2,5000);
    }
}

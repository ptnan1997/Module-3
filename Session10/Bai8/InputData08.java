package Session10.Bai8;

import Session10.Bai2.inputData;

import java.util.Scanner;

public class InputData08 {
    public static String getString (Scanner scanner, String suggest ) {
        return inputData.getString(scanner, suggest);
    }
    public static int getInt(Scanner scanner , String suggest) {
        String rs;

        do {
            System.out.println(suggest);
            rs = scanner.nextLine();
            try {
                if (rs.isEmpty()){
                    System.out.println("Vui lòng ko bỏ trống !");
                }else if (Integer.parseInt(rs) < 0){
                    System.out.println(" Vui lòng nhập số nguyên >= 0 !");
                }else {
                    break;
                }
            }catch (Exception e){
                System.out.println(" Vui lòng nhập số nguyên >= 0 !");
            }


        }while ( true );
        return Integer.parseInt(rs);
    }
}

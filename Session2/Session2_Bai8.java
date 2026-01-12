package Session2;
import java.util.Scanner;
public class Session2_Bai8 {
    static void main() {
    Scanner sc  = new Scanner (System.in);
    System.out.println("Nhập vào một số từ 100 đến 999");
    int number = Integer.parseInt(sc.nextLine());
        if (!(number >= 100) || !(number <= 999)) {
            System.err.println("Số nhập vào không hợp lệ");
        }
        int units = number%10;
        int tens =  number/10%10;
        int hundreds = number/100;
        String result  = "";
        switch (hundreds){
            case 1:
                result += "Một Trăm ";
                break;
            case 2:
                result += "Hai Trăm ";
                break;
            case 3:
                result += "Ba Trăm ";
                break;
            case 4:
                result += "Bốn Trăm ";
                break;
            case 5:
                result += "Năm Trăm ";
                break;
            case 6:
                result += "Sáu Trăm ";
                break;
            case 7:
                result += "Bảy Trăm ";
                break;
            case 8:
                result += "Tám Trăm ";
                break;
            case 9:
                result += "Chín Trăm ";
                break;
        }
        switch (tens){
            case 0:
                if (units != 0){
                    result += "Lẻ ";
                }
                break;
            case 1:
                result += "Mười ";
                break;
            case 2:
                result += "Hai Mươi ";
                break;
            case 3:
                result += "Ba Mươi ";
                break;
            case 4:
                result += "Bốn Mươi ";
                break;
            case 5:
                result += "Năm Mươi ";
                break;
            case 6:
                result += "Sáu Mươi ";
                break;
            case 7:
                result += "Bảy Mươi ";
                break;
            case 8:
                result += "Tám Mươi ";
                break;
            case 9:
                result += "Chín Mươi ";
                break;
        }
        switch (units){
            case 0:
                result += "";
                break;
            case 1:
                result += "Mốt";
                break;
            case 2:
                result += "Hai";
                break;
            case 3:
                result += "Ba";
                break;
            case 4:
                result += "Bốn";
                break;
            case 5:
                if (tens != 0 ){
                    result += "Lăm";
                }
                if (tens == 0) {
                    result += "Năm";
                }
                break;
            case 6:
                result += "Sáu";
                break;
            case 7:
                result += "Bảy";
                break;
            case 8:
                result += "Tám";
                break;
            case 9:
                result += "Chín";
                break;
        }
        System.out.printf("Số dạng chữ là : %s",result);
    }
}

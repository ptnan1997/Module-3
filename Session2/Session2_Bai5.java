package Session2;
import java.util.Scanner;
public class Session2_Bai5 {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào một số nguyên từ 1 đến 12");
        int number = Integer.parseInt(sc.next());
        switch (number){
            case 1:
                System.out.println("Tháng 1");
                break;
                case 2:
                    System.out.println("Tháng 2");
                    break;
                    case 3:
                        System.out.println("Tháng 3");
                        break;
                        case 4:
                            System.out.println("Tháng 4");
                            break;
            case 5:
                System.out.println("Tháng 5");
                break;
                case 6:
                    System.out.println("Tháng 6");
                    break;
                    case 7:
                        System.out.println("Tháng 7");
                        break;
            case 8:
                System.out.println("Tháng 8");
                break;
                case 9:
                    System.out.println("Tháng 9");
                    break;
            case 10:
                System.out.println("Tháng 10");
                break;
                case 11:
                    System.out.println("Tháng 11");
                    break;
            case 12:
                System.out.println("Tháng 12");
                break;
            default:
                System.err.println("Tháng không hợp lệ");
        }
        if (number == 1 || number == 3|| number == 5 || number == 7 || number == 8 || number == 10 || number == 12) {
            System.out.println("Số ngày của tháng là 31");
        }else if(number == 4 || number == 6 || number == 9 || number ==11){
            System.out.println("Số ngày của tháng là 30");
        } else if (number == 2) {
            System.out.println("Số ngày của tháng là 28 hoặc 29");
        }
    }
}

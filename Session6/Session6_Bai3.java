package Session6;
import java.util.Scanner;
public class Session6_Bai3 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        boolean isContinued = true;
        int count = 0;
        String [] plates = new  String[100];
        while (isContinued) {
            System.out.println("""
                    ****************** QUẢN LÝ BIỂN SỐ XE ****************
                    1.  Thêm các biển số xe
                    2.  Hiển thị danh sách biển số xe
                    3.  Tìm kiếm biển số xe
                    4.  Tìm biển số xe theo mã tỉnh
                    5.  Sắp xếp biển số xe tăng dần
                    6.  Thoát
                    ******************************************************
                """);
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: //Thêm các biển số xe
                    while (true){
                        System.out.println("Nhập vào biển số xe ( Nhập stop để dừng)");
                        String  plate = sc.nextLine();

                        if ( plate.equals("stop") ){
                            break;
                        }
                        if (isValidPlate(plate)){
                            System.err.println("Biển số xe không hợp lệ ❌");
                            continue;
                        }
                        plates[count] = plate;
                        count++;
                        if (count >= plates.length) {
                            System.out.println("Danh sách đã đầy, không thể thêm nữa!");
                            break;
                        }
                    }break;
                case 2:// Hiển thị danh sách biển số xe
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu biển số xe");
                        break;
                    }
                    printPlate(plates,count);
                    break;
                case 3: // Tìm kiếm biển số xe
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu biển số xe");
                    }else {
                        System.out.println("Nhập vào biển số bạn muốn tìm");
                        String findPlate = sc.nextLine();
                        if (!isValidPlate(findPlate)) {
                            System.out.println("Biển số bạn nhập không đúng định dạng");
                        } else {
                            linearSearch(plates, findPlate,count);
                        }
                    }
                    break;
                case 4: // Tìm biển số xe theo mã tỉnh
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu biển số xe");
                        break;
                    }
                    System.out.println("Nhập mã tỉnh (2 số): ");
                    String provinceCode = sc.nextLine();

                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (plates[i].startsWith(provinceCode)) {
                            System.out.println(plates[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy biển số thuộc mã tỉnh này");
                    }
                    break;
                case 5: // Sắp xếp biển số xe tăng dần
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu biển số xe");
                        break;
                    }
                    selectionSort(plates,count);
                    printPlate(plates,count);
                    break;
                case 6: // Thoát chương trình
                    System.out.println("👋 Thoát chương trình. Tạm biệt!");
                    isContinued = false;
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ, vui lòng chọn lại.");
                    break;
            }
        }
    }
    // Thuật toán xác thực thông tin định dạng biển số xe
    public static  boolean isValidPlate(String plate) {
        return !plate.matches("^\\d{2}[A-Z]{1,2}-\\d{3,5}\\.?\\d{0,2}$");
    }
    // Thuật toán in dữ liệu
    public static void printPlate(String [] plate, int count) {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(plate[i]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    // Thuật toán Tìm Kiếm Tuyến Tính
    public static void linearSearch (String [] plates, String findPlate,int count ){
        boolean found = false;
        for (int i = 0; i < count; i++){
            if (plates[i].equals(findPlate)){
                found = true;
                System.out.printf("Vị trí của biến số %s là: %s",findPlate,i);
                break;
            }
        }
        if (!found){
            System.out.println("Không có biển số trong danh sách");
        }
    }
    // Thuật toán sắp xếp mảng biển số xe tăng dần
    public static void selectionSort (String [] plates, int count){
        for (int i = 0; i < count; i++){
            int minIndex =  i;
            for (int j = i+1; j < count; j++){
                if(plates[j].compareTo(plates[minIndex]) < 0){
                    minIndex = j;
                }
            }
            String temp = plates[minIndex];
            plates[minIndex] = plates[i];
            plates[i] = temp;
        }
    }
}

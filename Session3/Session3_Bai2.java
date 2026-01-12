package Session3;
import java.util.Scanner;
public class Session3_Bai2 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        boolean isContinued = true;double sum = 0;
        double avg;
        int count = 0;
        double minNumber = 10;
        double maxNumber = 0;
        while (isContinued) {
        System.out.println("""
                ===== Menu =====
                1. Nhập điểm học viên
                2. Hiển thị thống kê
                3. Thoát
                ================
                """);
        System.out.print("Lựa chọn của bạn:");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("--- Nhập điểm học viên (nhập -1 để dừng ---");
                boolean isCheck = true;
                boolean isScore = true;
                while (isScore){
                    double score;
                    do {
                        System.out.print("Nhập điểm: ");
                        score =  sc.nextDouble();

                        if (score == -1){
                            isCheck = false;
                            break;
                        }
                        if (score <0 || score > 10) {
                            System.err.println("Điểm không hợp lệ. Nhập lại.");
                        }else if (score >0 || score <= 10) {
                            isCheck = false;
                        }
                    } while (isCheck);
                    if (score == -1) {
                        isScore = false;
                    }
                    if (score >= 9 && score <= 10) {
                        System.out.println("Học lực: Xuất sắc");
                    } else if (score >= 8 && score < 9) {
                        System.out.println("Học lực: Giỏi");
                    } else if (score >= 7  && score < 8) {
                        System.out.println("Học lực: Khá");
                    } else if (score >=5 && score < 7) {
                        System.out.println("Học lực: Trung Bình");
                    } else if (score >= 0 && score < 5) {
                        System.out.println("Học lực: Yếu");
                    }
                    count = count + 1;
                    sum = sum + score;
                    // Điểm cao nhất
                    if (score > maxNumber){
                        maxNumber = score;
                    }
                    // Điểm thấp nhất
                    if (score < minNumber){
                        minNumber = score;
                    }
                }
            break;
            case 2:
                if (count == 0){
                    System.out.println("Chưa có dữ liệu");
                    continue;
                } else {
                    avg = sum/count;
                    System.out.println("Điểm trung bình: " + avg);
                    System.out.println("Tổng số học viên đã nhập: " + count);
                    System.out.println("Điểm cao nhất: " + maxNumber);
                    System.out.println("Điểm thấp nhất: " + minNumber);
                }
                break;
            case 3:
                System.out.println("Kết thúc chương trình.");
                isContinued = false;
                break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}

package Session6;
import java.util.Scanner;
public class Session6_Bai1 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        boolean isContinued = true;
        double[] scores = new double[100];
        int count = 0;
        double sum;
        double avg;
        double max;
        double min;
        int pass;
        int fail;
        int good ;
        int brillian;
        while (isContinued){
            System.out.println("""
                    ************* QUẢN LÝ ĐIỂM SV ******************
                    1. Nhập danh sách điểm sinh viên
                    2. In danh sách điểm
                    3. Tính điểm trung bình của các sinh viên
                    4. Tìm điểm cao nhất và thấp nhất
                    5. Đếm số lượng sinh viên đạt và trượt
                    6. Sắp xếp điểm tăng dần
                    7. Thống kê số lượng sinh viên giỏi và xuất sắc
                    8. Thoát
                    ************************************************
                    """);

            System.out.print("Lựa chọn của bạn: ");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    boolean isScore = true;
                    while (isScore){
                        System.out.print("Nhập điểm sinh viên (Nhập -1 để dừng nhập): ");
                        double score = sc.nextDouble();

                        if (score == -1){
                            isScore = false;
                            continue;
                        }
                        if (!isValidScore(score)){
                            System.err.println("Điểm không hợp lệ ❌");
                        } else {
                            scores[count] = score;
                            count++;
                        }
                    }break;
                case 2:
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu điểm");
                        break;
                    }
                    printScores(scores, count);
                    break;
                case 3:
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu điểm");
                        break;
                    }
                    sum =0;
                    for (int  i  = 0; i < count; i++) {
                        sum += scores[i];
                    }
                    avg = sum/count;
                    System.out.println("Điểm trung bình:" + avg);
                    break;
                case 4:
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu điểm");
                        break;
                    }
                    max = scores[0];
                    min = scores[0];
                    for (int  i  = 0; i < count; i++) {
                        if (scores[i] > max){
                            max = scores[i];
                        }
                        if (scores[i] < min){
                            min = scores[i];
                        }
                    }
                    System.out.println("Điểm cao nhất: "+ max);
                    System.out.println("Điểm thấp nhất: " + min);
                    break;
                case 5:
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu điểm");
                        break;
                    }
                    pass = 0;
                    fail = 0;
                    for (int i=  0; i < count; i++) {
                        if (scores[i]>=5) pass++;
                        else fail++;
                    }
                    System.out.println("Số sinh viên đạt: " + pass);
                    System.out.println("Số sinh viên trượt: " + fail);
                    break;
                case 6:
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu điểm");
                        break;
                    }
                    selectionSort(scores,count);
                    System.out.println("Sắp xếp điểm tăng dần");
                    printScores(scores,count);
                    break;
                case 7:
                    if (count == 0){
                        System.out.println("Chưa có dữ liệu điểm");
                        break;
                    }
                    brillian = 0;
                    good = 0;
                    for  (int i  = 0; i < count; i++) {
                        if (scores[i]>=9) brillian++;
                        else if (scores[i]>=8)good++;
                    }
                    System.out.println("Giỏi: "+ good);
                    System.out.println("Xuất sắc: "+ brillian);
                    break;
                case 8:
                    System.out.println("Kết thúc quản lý sinh viên ✅");
                    isContinued = false;
            }
        }
    }
    public static boolean isValidScore (double score) {
        return score >= 0 && score <= 10;
    }
    public static void selectionSort(double [] scores,int count){
        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }
    public static void printScores(double [] scores, int count){
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(scores[i]);
            if( i < count - 1 ) System.out.print(", ");
        }
        System.out.println("]");
    }
}

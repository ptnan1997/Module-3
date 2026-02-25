package Session11.Bai1;
import java.util.Arrays;
import java.util.List;

public class Main01 {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Cac so chan trong danh sach: ");
        list.forEach(number -> {
            if (number % 2 == 0){
                System.out.println(number);
            }
        });
        int sum = list.stream().mapToInt(number -> number).sum();
        System.out.println("Tong cac so co trong danh sach: "+ sum);

    }
}

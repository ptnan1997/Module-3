package Session4;
import java.util.Arrays;
import java.util.Scanner;
public class Session4_Bai6 {
    static void main() {
        Scanner  sc = new Scanner(System.in);
        // KHỞI TẠO MẢNG
        System.out.println("Nhập vào kích thước của mảng");
        int size  = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Nhập các phần tử của mảng");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần: ");
        System.out.println(Arrays.toString(arr));
        // Thực thi tìm kiếm tuyến tính của số 8 trong mảng
        System.out.print("Nhập vào số cẩn tìm: ");
        int numberFind = sc.nextInt();
        int findIndexLinear = linearSearch(arr,numberFind);
        System.out.printf("Tìm kiếm tuyến tính: Phần tử %d tìm thấy tại chỉ số: %d \n", numberFind, findIndexLinear);
        // Thực thi tìm kiếm nhị phân của số cần tìm trong mảng
        int findIndexBinary = binarySearch(arr,numberFind);
        System.out.printf("Tìm kiếm nhị phân: Phần tử %d tìm thấy tại chỉ số: %d \n",numberFind , findIndexBinary);
    }
    // Sắp xếp chọn theo thứ tự giảm dần
    public static void selectionSort (int[] array){
        for  (int i = 0; i < array.length; i++) {
            int maxIndex = i;
            // TÌm giá trị nhỏ nhất
            for(int j = i+1; j < array.length; j++) {
                if (array[j]>array[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp  = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }
    // Thuật toán tìm kiếm tuyến tính
    public static int linearSearch(int [] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i ;
            }
        }
        return -1;
    }
    // Thuật toán tìm kiếm nhị phân
    public static int binarySearch (int [] array, int value) {
        int low =  0;
        int high = array.length-1;
        while (low <= high) {
            int mid = (low+high) / 2;
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] == value) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

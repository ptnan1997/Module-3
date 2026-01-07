import java.util.Scanner;
void main() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Nhập tử số 1");
    int numerator1  = Integer.parseInt(sc.nextLine());

    System.out.println("Nhập mẫu số 1");
    int denominator1  = Integer.parseInt(sc.nextLine());

    System.out.println("Nhập tử số 2");
    int  numerator2  = Integer.parseInt(sc.nextLine());

    System.out.println("Nhập mẫu số 2");
    int denominator2  = Integer.parseInt(sc.nextLine());
    int resultNumerator = (numerator1 *denominator2)+(denominator1 *numerator2);
    int resultDenominator = denominator1 *denominator2;
    System.out.println(resultNumerator+"/"+resultDenominator);
}
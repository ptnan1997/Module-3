package Session5;

public class Session5_Bai2 {
    static void main() {
        // Khởi tạo chuỗi ban đầu
        StringBuilder originalString = new StringBuilder("Hello, Java World!");

        // In chuỗi ban đầu
        System.out.println("Chuỗi ban đầu: " + originalString);

        // Xóa các ký tự từ vị trí 5 đến 9
        originalString.delete(5, 10); // Xóa từ vị trí 5 đến 9 (bao gồm 5, không bao gồm 10)
        System.out.println("Chuỗi sau khi xóa: " + originalString);

        // Thay thế đoạn "World" bằng "Universe"
        int start = originalString.indexOf("World");
        if (start != -1) {
            originalString.replace(start, start + 5, "Universe"); // "World" có độ dài 5
        }
        System.out.println("Chuỗi sau khi thay thế: " + originalString);
    }
}

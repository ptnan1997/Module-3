package Session5;

public class Session5_Bai5 {
    static void main() {



        int times =1000000;
        // =============== String ================
        String str = "rikkei";
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            str += "World";
        }
        long end = System.currentTimeMillis();
        System.out.println("Time takes: " + (end - start)+ "ms");
        // =========== StringBuffer ============
        start =  System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer ("rikkei");
        for (int i = 0; i < times; i++) {
            sbf.append("World");
        }
        end = System.currentTimeMillis();
        System.out.println("Time takes: " + (end - start)+ "ms");
        // ============ StringBuilder ===========
        start =   System.currentTimeMillis();
        StringBuilder sb = new StringBuilder ("rikkei");
        for (int i = 0; i < times; i++) {
            sb.append("World");
        }
        end = System.currentTimeMillis();
        System.out.println("Time takes: " + (end - start)+ "ms");
        System.out.println("""
                Nhận xét:
                - String : Không hiệu quả cho phép nối chuỗi nhiều lần do tạo ra nhiều đối tượng mới.
                - StringBuilder: Hiệu quả và nhanh chóng, thích hợp cho nhiều thao tác nối chuỗi trong một luồng.
                - StringBuffer: Tương tự như stringbuilder nhung an toàn với đa luồng, có thể chậm hơn một chút do đồng bộ hóa
                
                """);
    }


}

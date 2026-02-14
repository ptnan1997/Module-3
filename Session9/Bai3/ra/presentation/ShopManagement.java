package Session9.Bai3.ra.presentation;
import Session9.Bai3.ra.entity.Categories;
import Session9.Bai3.ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    Scanner  sc = new Scanner(System.in);
    Categories [] category =  new Categories[100];
    Product[]  product = new Product[100];
    private int countCategory = 0;
    private int countProduct = 0;
    private int indexOfCategories(int catalogid){
        for (int i = 0; i < countCategory; i++){
            if (category[i].getCatalogId()==catalogid){
                return i;
            }
        }
        return -1;
    }
    private int indexOfProduct(String productId){
        for (int i = 0; i < countProduct; i++){
            if (product[i] != null && product[i].getProductId().equals(productId)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
         new  ShopManagement().ShopMenu();
    }
    private void ShopMenu(){
        while (true){
            System.out.println("""
                ========= SHOP MENU =========
                1. Quản lý danh mục sản phẩm
                2. Quản lý sản phẩm
                3. Thoát
                =============================
                """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 ->
                    CategoriesMenu();

                case 2 ->
                    ProductManagement();

                case 3 ->{
                    System.out.println("Kết thúc chương trình");
                    return;
                }
                default ->
                    System.out.println("Giá trị không hợp lệ");

            }
        }

    }
    private void CategoriesMenu (){
        while (true){
            System.out.println("""
                =========== CATEGORIES ===========
                1. Nhập thông tin các danh mục
                2. Hiển thị thông tin các danh mục
                3. Cập nhật thông tin danh mục
                4. Xóa danh mục
                5. Cập nhật trạng thái danh mục
                6. Thoát (quay lại menu shopmanagement)
                ==================================
                """);
            System.out.print("Lựa chọn của bạn: ");
            int choice  = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 ->{//Nhập thông tin các danh mục
                    if (countCategory >= 100) {
                        System.out.println("Danh sách đã đầy, không thể thêm!");
                        break;
                    }
                        System.out.println("---- Nhập thông tin danh mục ----");
                        Categories cg = new Categories();
                        cg.inputData(sc,category, countCategory);

                        category[countCategory] = cg;
                        countCategory++;
                }
                case 2 ->{// Hiển thị thông tin các danh mục
                    if(countCategory== 0){
                        System.out.println("Danh sách rỗng!! Không thể hiển thị");
                        break;
                    }
                    for (int i = 0; i < countCategory; i++) {
                        category[i].displayData();
                    }
                }
                case 3 ->{// Cập nhật thông tin danh mục
                    if(countCategory== 0){
                        System.out.println("Danh sách rỗng!! Không thể hiển thị");
                        break;
                    }
                    System.out.print("Nhập mã danh mục cần cập nhật: ");
                    int findID = Integer.parseInt(sc.nextLine());
                    int found = indexOfCategories(findID);
                    if (found == -1){
                        System.out.println("Danh mục không tồn tại");
                        break;
                    }

                    category[found].inputData(sc,category, found);

                    System.out.println("Cập nhật thành công ✅");
                }

                case 4 ->{// Xóa danh mục
                    if (countCategory ==0){
                        System.out.println("Danh sách danh mục trống !!");
                        break;
                    }
                    System.out.print("Nhập mã danh mục cần xóa: ");
                    int idx = Integer.parseInt(sc.nextLine());
                    int found = indexOfCategories(idx);
                    if (found == -1){
                        System.out.println("Danh mục không tồn tại");
                        break;
                    }
                    for  (int i = found; i < countCategory-1; i++){
                        category[i] = category[i+1];
                    }
                    countCategory--;
                    category[countCategory]=null;
                    System.out.println("Đã xóa thành công ✅");
                }
                case 5 -> { // Cập nhật trạng thái danh mục
                    if (countCategory == 0) {
                        System.out.println("Danh sách danh mục trống !!");
                        break;
                    }

                    System.out.print("Nhập mã danh mục cần cập nhật trạng thái: ");
                    int id = Integer.parseInt(sc.nextLine());

                    int found = indexOfCategories(id);
                    if (found == -1) {
                        System.out.println("Danh mục không tồn tại");
                        break;
                    }

                    // Đảo trạng thái: true -> false, false -> true
                    boolean current = category[found].getCatalogStatus();
                    category[found].setCatalogStatus(!current);

                    System.out.println("Đã cập nhật trạng thái thành công ✅");
                }

                case 6 ->{ // Thoát (quay lại shopMenu)
                    System.out.println("Kết thúc quản lý danh mục");
                    return;
                }
                default -> System.out.println("Giá trị không hợp lệ !!!");
            }
        }

    }



    private void ProductManagement () {
        while (true) {
            System.out.println("""
            =========== PRODUCTMANAGEMENT ===========
            1. Nhập thông tin các sản phẩm
            2. Hiển thị thông tin các sản phẩm
            3. Sắp xếp các sản phẩm theo giá
            4. Cập nhật thông tin sản phẩm theo mã sản phẩm
            5. Xóa sản phẩm theo mã sản phẩm
            6. Tìm kiếm các sản phẩm theo tên sản phẩm
            7. Tìm kiếm sản phẩm trong khoảng giá a-b (a,b nhập từ bàn phím)
            8. Thoát (quay lại menu shopmanagement)
            =========================================
            """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1 -> { // Nhập thông tin các sản phẩm
                    if (countProduct >= 100) {
                        System.out.println("Danh sách sản phẩm đã đầy!");
                        break;
                    }
                    if (countCategory == 0) {
                        System.out.println("Chưa có danh mục. Hãy tạo danh mục trước khi thêm sản phẩm!");
                        break;
                    }

                    System.out.println("---- Nhập thông tin sản phẩm ----");
                    Product p = new Product();
                    p.inputData(sc, product, countProduct, category, countCategory);

                    product[countProduct] = p;
                    countProduct++;

                    System.out.println("Thêm sản phẩm thành công ✅");
                }

                case 2 -> { // Hiển thị thông tin các sản phẩm
                    if (countProduct == 0) {
                        System.out.println("Danh sách sản phẩm rỗng!! Không thể hiển thị");
                        break;
                    }
                    for (int i = 0; i < countProduct; i++) {
                        if (product[i] != null) {
                            product[i].displayData();
                        }
                    }
                }

                case 3 -> { // Sắp xếp các sản phẩm theo giá (tăng dần)
                    if (countProduct < 2) {
                        System.out.println("Không đủ sản phẩm để sắp xếp!");
                        break;
                    }
                    for (int i = 0; i < countProduct - 1; i++) {
                        for (int j = 0; j < countProduct - 1 - i; j++) {
                            if (product[j] != null && product[j + 1] != null) {
                                if (product[j].getPrice() > product[j + 1].getPrice()) {
                                    Product tmp = product[j];
                                    product[j] = product[j + 1];
                                    product[j + 1] = tmp;
                                }
                            }
                        }
                    }
                    System.out.println("Sắp xếp theo giá tăng dần thành công ✅");
                }

                case 4 -> { // Cập nhật thông tin sản phẩm theo mã sản phẩm
                    if (countProduct == 0) {
                        System.out.println("Danh sách sản phẩm rỗng!! Không thể cập nhật");
                        break;
                    }

                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String id = sc.nextLine().trim();
                    int found = indexOfProduct(id);

                    if (found == -1) {
                        System.out.println("Sản phẩm không tồn tại!");
                        break;
                    }

                    // Không dùng inputData vì inputData bắt nhập lại productId và sẽ dễ bị trùng.
                    System.out.println("---- Cập nhật sản phẩm (không đổi mã) ----");

                    // Tên (10-50 ký tự, không trùng tên với sản phẩm khác)
                    while (true) {
                        System.out.print("Nhập tên mới (10-50 ký tự): ");
                        String newName = sc.nextLine().trim();

                        if (newName.length() < 10 || newName.length() > 50) {
                            System.out.println("Tên phải từ 10 đến 50 ký tự!");
                            continue;
                        }

                        boolean duplicated = false;
                        for (int i = 0; i < countProduct; i++) {
                            if (product[i] != null && i != found) {
                                if (product[i].getProductName().equalsIgnoreCase(newName)) {
                                    duplicated = true;
                                    break;
                                }
                            }
                        }
                        if (duplicated) {
                            System.out.println("Tên sản phẩm đã tồn tại. Nhập lại!");
                            continue;
                        }

                        product[found].setProductName(newName);
                        break;
                    }

                    // Giá (>0)
                    while (true) {
                        System.out.print("Nhập giá mới (>0): ");
                        float newPrice = Float.parseFloat(sc.nextLine());
                        if (newPrice <= 0) {
                            System.out.println("Giá phải > 0!");
                        } else {
                            product[found].setPrice(newPrice);
                            break;
                        }
                    }

                    // Mô tả
                    System.out.print("Nhập mô tả mới: ");
                    product[found].setDescription(sc.nextLine().trim());

                    // Chọn catalogId
                    if (countCategory == 0) {
                        System.out.println("Hiện không có danh mục nào để gán cho sản phẩm!");
                    } else {
                        while (true) {
                            System.out.println("----- Danh mục -----");
                            for (int i = 0; i < countCategory; i++) {
                                if (category[i] != null) {
                                    System.out.println(category[i].getCatalogId() + " - " + category[i].getCatalogName());
                                }
                            }
                            System.out.print("Chọn catalogId mới: ");
                            int chooseId = Integer.parseInt(sc.nextLine());

                            boolean exists = false;
                            for (int i = 0; i < countCategory; i++) {
                                if (category[i] != null && category[i].getCatalogId() == chooseId) {
                                    exists = true;
                                    break;
                                }
                            }

                            if (!exists) {
                                System.out.println("catalogId không tồn tại! Chọn lại.");
                            } else {
                                product[found].setCatalogId(chooseId);
                                break;
                            }
                        }
                    }

                    // Status 0/1/2
                    while (true) {
                        System.out.println("0 - Đang bán");
                        System.out.println("1 - Hết hàng");
                        System.out.println("2 - Không bán");
                        System.out.print("Chọn trạng thái mới: ");
                        int st = Integer.parseInt(sc.nextLine());
                        if (st < 0 || st > 2) {
                            System.out.println("Chỉ được nhập 0,1,2!");
                        } else {
                            product[found].setProductStatus(st);
                            break;
                        }
                    }

                    System.out.println("Cập nhật sản phẩm thành công ✅");
                }

                case 5 -> { // Xóa sản phẩm theo mã sản phẩm
                    if (countProduct == 0) {
                        System.out.println("Danh sách sản phẩm trống !!");
                        break;
                    }

                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String id = sc.nextLine().trim();
                    int found = indexOfProduct(id);

                    if (found == -1) {
                        System.out.println("Sản phẩm không tồn tại!");
                        break;
                    }

                    for (int i = found; i < countProduct - 1; i++) {
                        product[i] = product[i + 1];
                    }
                    countProduct--;
                    product[countProduct] = null;

                    System.out.println("Đã xóa sản phẩm thành công ✅");
                }

                case 6 -> { // Tìm kiếm theo tên (chứa từ khóa)
                    if (countProduct == 0) {
                        System.out.println("Danh sách sản phẩm trống !!");
                        break;
                    }

                    System.out.print("Nhập tên cần tìm: ");
                    String key = sc.nextLine().trim().toLowerCase();

                    boolean foundAny = false;
                    for (int i = 0; i < countProduct; i++) {
                        if (product[i] != null) {
                            if (product[i].getProductName().toLowerCase().contains(key)) {
                                product[i].displayData();
                                foundAny = true;
                            }
                        }
                    }

                    if (!foundAny) {
                        System.out.println("Không tìm thấy sản phẩm phù hợp!");
                    }
                }

                case 7 -> { // Tìm trong khoảng giá a-b
                    if (countProduct == 0) {
                        System.out.println("Danh sách sản phẩm trống !!");
                        break;
                    }

                    System.out.print("Nhập giá a: ");
                    float a = Float.parseFloat(sc.nextLine());
                    System.out.print("Nhập giá b: ");
                    float b = Float.parseFloat(sc.nextLine());

                    float min = Math.min(a, b);
                    float max = Math.max(a, b);

                    boolean foundAny = false;
                    for (int i = 0; i < countProduct; i++) {
                        if (product[i] != null) {
                            float price = product[i].getPrice();
                            if (price >= min && price <= max) {
                                product[i].displayData();
                                foundAny = true;
                            }
                        }
                    }

                    if (!foundAny) {
                        System.out.println("Không có sản phẩm nào trong khoảng giá này!");
                    }
                }

                case 8 -> { // Thoát
                    System.out.println("Kết thúc quản lý sản phẩm. Quay lại ShopMenu --->>>");
                    return;
                }

                default -> System.out.println("Giá trị không hợp lệ !!!");
            }
        }
    }


}

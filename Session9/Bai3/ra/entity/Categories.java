package Session9.Bai3.ra.entity;

import java.util.Scanner;

public class Categories implements IShop{
    private static int autoID = 0;
    private int catalogId;
    private String catalogName;
    private String description;
    private Boolean catalogStatus;
    // Constructor không tham số
    public Categories(){
        this.catalogId = autoID++;
    }
    // Constructor có tham số
    public Categories ( String catalogName, String description, Boolean catalogStatus){
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }
    // Getter và Setter

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
    public void inputData(Scanner scanner, Categories[] categories, int index) {
        boolean duplicated;
        String newName;

        // ====== Nhập và kiểm tra trùng tên ======
        do {
            duplicated = false;

            System.out.println("_______ Nhập thông tin danh mục ______");
            System.out.print("1. Nhập tên danh mục: ");
            newName = scanner.nextLine().trim();

            for (int i = 0; i < categories.length; i++) {
                if (categories[i] != null && i != index) {
                    if (categories[i].getCatalogName()
                            .equalsIgnoreCase(newName)) {
                        duplicated = true;
                        System.out.println("Tên danh mục đã tồn tại, vui lòng nhập lại!");
                        break;
                    }
                }
            }

        } while (duplicated);

        // Khi tên hợp lệ mới gán
        this.catalogName = newName;

        // ====== Nhập các thông tin còn lại ======
        System.out.print("2. Nhập mô tả: ");
        this.description = scanner.nextLine();

        System.out.print("3. Trạng thái danh mục (true/false): ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập thông tin thành công ✅");
    }

    public void displayData() {
        System.out.println( "Mã danh mục: " + catalogId + "\n" +
                "Tên danh mục " + catalogName + "\n" +
                "Mô tả: " + description + "\n" +
                "Trạng thái: " + catalogStatus + "\n");
    }
}

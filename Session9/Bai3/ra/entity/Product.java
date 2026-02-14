package Session9.Bai3.ra.entity;

import java.util.Scanner;

public class Product implements IShop{
        private String productId;// C/S/A + 3 ký tự số => tổng 4 ký tự
        private String productName;    // 10-50 ký tự, không trùng
        private float price;           // > 0
        private String description;    // mô tả
        private int catalogId;         // mã danh mục
        private int productStatus;     // 0: Đang bán, 1: Hết hàng, 2: Không bán

        public Product() {
        }

        public Product(String productId, String productName, float price, String description, int catalogId, int productStatus) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
            this.description = description;
            this.catalogId = catalogId;
            this.productStatus = productStatus;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(int catalogId) {
            this.catalogId = catalogId;
        }

        public int getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(int productStatus) {
            this.productStatus = productStatus;
        }


        public void inputData(Scanner scanner,
                              Product[] arrProduct,
                              int indexProduct,
                              Categories[] arrCategories,
                              int indexCatalog) {

            // ===== productId =====
            while (true) {
                System.out.print("Nhập mã sản phẩm (C/S/A + 3 số, ví dụ C001): ");
                String id = scanner.nextLine().trim();

                boolean formatOk = id.matches("^[CSA]\\d{3}$");
                if (!formatOk) {
                    System.err.println("Sai định dạng! Mã phải có 4 ký tự, bắt đầu C/S/A và theo sau là 3 chữ số.");
                    continue;
                }

                boolean duplicate = false;
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i] != null && id.equalsIgnoreCase(arrProduct[i].getProductId())) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    System.err.println("Mã sản phẩm đã tồn tại. Nhập lại!");
                    continue;
                }

                this.productId = id.toUpperCase();
                break;
            }

            // ===== productName =====
            while (true) {
                System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
                String name = scanner.nextLine().trim();

                if (name.length() < 10 || name.length() > 50) {
                    System.err.println("Tên sản phẩm phải từ 10 đến 50 ký tự.");
                    continue;
                }

                boolean duplicate = false;
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i] != null && name.equalsIgnoreCase(arrProduct[i].getProductName())) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    System.err.println("Tên sản phẩm đã tồn tại. Nhập lại!");
                    continue;
                }

                this.productName = name;
                break;
            }

            // ===== price =====
            while (true) {
                System.out.print("Nhập giá (>0): ");
                float p = Float.parseFloat(scanner.nextLine());

                if (p <= 0) {
                    System.out.println("Giá phải > 0!");
                } else {
                    this.price = p;
                    break;
                }
            }

            // ===== description =====
            System.out.print("Nhập mô tả sản phẩm: ");
            this.description = scanner.nextLine().trim();

            // ===== catalogId (show menu categories) =====
            while (true) {

                System.out.println("----- Danh mục -----");
                for (int i = 0; i < indexCatalog; i++) {
                    if (arrCategories[i] != null) {
                        System.out.println(arrCategories[i].getCatalogId()
                                + " - "
                                + arrCategories[i].getCatalogName());
                    }
                }

                System.out.print("Chọn catalogId: ");
                int chooseId = scanner.nextInt();
                scanner.nextLine();

                boolean exists = false;
                for (int i = 0; i < indexCatalog; i++) {
                    if (arrCategories[i] != null &&
                            arrCategories[i].getCatalogId() == chooseId) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    System.out.println("catalogId không tồn tại!");
                } else {
                    this.catalogId = chooseId;
                    break;
                }
            }

            // ===== productStatus =====
            while (true) {
                System.out.println("0 - Đang bán");
                System.out.println("1 - Hết hàng");
                System.out.println("2 - Không bán");
                System.out.print("Chọn trạng thái: ");

                int status = scanner.nextInt();
                scanner.nextLine();

                if (status < 0 || status > 2) {
                    System.out.println("Chỉ được nhập 0,1,2!");
                } else {
                    this.productStatus = status;
                    break;
                }
            }
        }

        @Override
        public void displayData() {
            String statusText = switch (productStatus) {
                case 0 -> "Đang bán";
                case 1 -> "Hết hàng";
                case 2 -> "Không bán";
                default -> "Không xác định";
            };

            System.out.println("-------------- PRODUCT --------------");
            System.out.println("Mã SP       : " + productId);
            System.out.println("Tên SP      : " + productName);
            System.out.println("Giá         : " + price);
            System.out.println("Mô tả       : " + description);
            System.out.println("Danh mục ID : " + catalogId);
            System.out.println("Trạng thái  : " + statusText);
            System.out.println("-------------------------------------");
        }
    }



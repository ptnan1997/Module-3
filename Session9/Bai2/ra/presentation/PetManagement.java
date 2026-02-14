package Session9.Bai2.ra.presentation;

import Session9.Bai2.ra.entity.Pet;

import java.util.Scanner;

public class PetManagement {
    Scanner  sc = new Scanner(System.in);
    private final int MAX = 100;
    Pet [] pets = new Pet[MAX];
    private int count =0;

    void main() {

        while(true) {
            printMenu();
            System.out.println("Lựa chọn của bạn");
            int choice = sc.nextInt();
            switch  (choice) {
                case 1 -> { // Hiển thị danh sách thú cưng
                    if (count == 0){
                        System.out.println("Danh sách rỗng!!!");
                        break;
                    }
                     displayData();
                }
                case 2 -> { // Thêm thú cưng
                    if (count >= MAX) {
                        System.out.println("Danh sách đã đầy, không thể thêm!");
                        break;
                    }

                    System.out.println("---- Nhập thông tin sinh viên ----");
                    Pet st = new Pet() {
                        public void speak() {

                        }
                    };
                    st.inputData(sc);

                    // kiểm tra trùng mã sinh viên
                    boolean duplicated = false;
                    for (int i = 0; i < count; i++) {
                        if (pets[i].getId().equals(st.getId())) {
                            duplicated = true;
                            break;
                        }
                    }

                    if (duplicated) {
                        System.out.println("Mã sinh viên đã tồn tại. Thêm thất bại!");
                        break;
                    }

                    pets[count++] = st;
                    System.out.println("Thêm sinh viên thành công ✅");
                }
                case 3 -> { // Gọi tiếng kêu
                    if (count == 0) {
                        System.out.println("Danh sách trống, chưa có thú cưng nào!");
                        break;
                    }

                    System.out.print("Nhập mã thú cưng muốn gọi tiếng kêu: ");
                    String idCall = sc.nextLine().trim();

                    int foundIndex = -1;
                    for (int i = 0; i < count; i++) {
                        if (pets[i].getId().equalsIgnoreCase(idCall)) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex == -1) {
                        System.out.println("Không tìm thấy thú cưng có mã: " + idCall);
                    } else {
                        System.out.print("Thú cưng: ");
                        pets[foundIndex].displayData();
                        System.out.print("Tiếng kêu: ");
                        pets[foundIndex].speak(); // 🔥 Tự chạy đúng Dog/Cat
                    }
                }
                case 4 -> { // Xóa thú cưng theo id
                    if (count == 0){
                        System.out.println("Danh sách trống, chưa có thú cưng nào!");
                        break;
                    }
                    deletePets();
                }
                case 5 -> { // Tím thú cưng theo tên
                    if (count == 0){
                        System.out.println("Danh sách trống, chưa có thú cưng nào!");
                        break;
                    }
                    findByPetName();
                }
                case 6 -> { // Thoát
                    System.out.println("Kết thúc chương trình !!");
                    return;
                }
                default ->
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }

    }
    void printMenu(){
        System.out.println("""
                --------- QUẢN LÝ THÚ CƯNG --------
                1. Hiển thị danh sách thú cưng
                2. Thêm thú cưng
                3. Gọi tiếng kêu
                4. Xóa thú cưng
                5. Tìm thú cưng theo tên
                6. Thoát
                -----------------------------------
                """);
    }
    private int indexOfPets(String id){
        for (int i = 0; i < MAX; i++) {
            if (pets[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public void displayData(){
        System.out.println("----- Danh sách thú cưng -----");
        for  (int i = 0; i < MAX; i++) {
            pets[i].displayData();
        }
    }
    public void deletePets(){
        System.out.print("Nhập vào id của thú cưng bạn muốn xóa: ");
        String deletePetID = sc.nextLine();
        int  indexDeletePet = indexOfPets(deletePetID);
        if (indexDeletePet == -1) {
            System.out.println("ID thú cưng tồn tại");
        } else {
            for (int i = indexDeletePet; i < count - 1; i++) {
                pets[i] =  pets[i + 1];
            }
            pets[count--] = null;
            System.out.println("Đã xoá thành công ✅");
        }

    }
    public void findByPetName(){
        System.out.print("Nhập vào tên thú cưng bạn muốn tìm: ");
        String  findPetName = sc.nextLine();
        for (int i = 0; i < count; i++){
            if( pets[i].getPetName().equals(findPetName)){
                System.out.println(pets[i].displayData());
            }
        }

    }
}

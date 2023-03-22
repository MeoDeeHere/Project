import DAO.TaiKhoanDAO;
import Model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        TaiKhoan taiKhoan = new TaiKhoan();
        boolean cond = true;
        while (cond) {
            System.out.print("Tài Khoản: ");
            String username = scanner.nextLine();
            System.out.print("Mật Khẩu: ");
            String password = scanner.nextLine();
            taiKhoan = taiKhoanDAO.getTaikhoan(username, password);
            if (taiKhoan.getMaTK() == 0) { //so sanh với 0 để xem có nhập đúng tk mk không?
                System.out.println("Dang Nhap that bai");
               // continue;
            } else {
                System.out.println("dang nhap thanh cong");
                System.out.println("=====================================");
                System.out.println("--------------* MENU *--------------");
                System.out.println("1. In ra danh sách nhân viên/ phòng ban");
                System.out.println("2. Thêm/sửa/xóa nhân viên");
                System.out.println("3. Thêm/sửa/xóa phòng ban");
                System.out.println("4. Tìm kiếm nhân viên");
                System.out.println("5. Thêm/chuyển/xóa thông tin phòng ban cho nhân viên");
                System.out.println("6. Tính thuế thu nhập cá nhân cho nhân viên");
                System.out.println("7. Các chức năng khác");
                System.out.println("8. Thoát");
                System.out.print("Nhập lựa chọn của bạn: ");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1){
                    case 1:
                        System.out.println("-------------------");
                        System.out.println("1. In danh sách nhân viên");
                        System.out.println("2. In dach sách phòng ban");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        int choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2){
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("-------------------");
                        System.out.println("1. Thêm nhân viên mới");
                        System.out.println("2. Sửa thông tin nhân viên");
                        System.out.println("3. Xóa nhân viên");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        int choice3 = Integer.parseInt(scanner.nextLine());
                        switch (choice3){
                            case 1:
                                break;
                            case 3:
                                break;
                            case 2:
                                System.out.print("Nhập mã nhân viên cần sửa thông tin");
                                int manv = Integer.parseInt(scanner.nextLine());
                                //in thông tin nhân viên
                                System.out.println("----------Chọn thông tin muốn thay đổi---------");
                                System.out.println("1. Tên nhân viên");
                                System.out.println("2. Giới tính");
                                System.out.println("3. Tuổi");
                                System.out.println("4. Quê quán");
                                System.out.println("5. Số điện thoại");
                                System.out.println("6. Email");
                                System.out.println("7. Lương");
                                System.out.println("8. Mã phòng ban");
                                System.out.println("9. Mã người quản lý trực tiếp");
                                System.out.println("10. Thoát");
                                System.out.print("Nhập lựa chọn của bạn: ");
                                int choice3_1 = Integer.parseInt(scanner.nextLine());
                                switch (choice3_1) {
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        break;
                                    case 9:
                                        break;
                                    case 10:
                                        break;
                                }
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("-------------------");
                        System.out.println("1. Thêm Phòng ban mới");
                        System.out.println("2. Sửa thông tin phòng ban");
                        System.out.println("3. Xóa phòng ban");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        int choice4 = Integer.parseInt(scanner.nextLine());
                        switch (choice4){
                            case 1:
                                break;
                            case 3:
                                break;
                            case 2:
                                System.out.print("Nhập mã phòng ban cần sửa thông tin: ");
                                int mapb = Integer.parseInt(scanner.nextLine());
                                System.out.println("------------Chọn thông tin cân sửa-----------");
                                System.out.println("1. Tên phòng ban");
                                System.out.println("2. Mã Quản Lý");
                                int choice4_1 = Integer.parseInt(scanner.nextLine());
                                switch (choice4_1){
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                }
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("-------------------");
                        System.out.println("1. Mã nhân viên");
                        System.out.println("2. Tên nhân viên");
                        System.out.println("3. Số điện thoại");
                        System.out.println("4. Email");
                        System.out.println("5. Thoát");
                        System.out.print("Chọn thông loại thông tin mà bạn muốn tìm: ");
                        int choice5 = Integer.parseInt(scanner.nextLine());
                        System.out.println("-----------------");
                        switch (choice5){
                            case 1:
                                System.out.print("Nhập mã nhân viên: ");
                                int manv = Integer.parseInt(scanner.nextLine());
                                break;
                            case 2:
                                System.out.println("Nhập tên nhân viên: ");
                                String ten = scanner.nextLine();
                                break;
                            case 3:
                                System.out.println("Số điện thoại: ");
                                String soDT = scanner.nextLine();
                                break;
                            case 4:
                                System.out.println("Nhập Email: ");
                                int email = Integer.parseInt(scanner.nextLine());
                                break;
                            case 5:
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("-------------------");
                        System.out.println("1. Thêm Phòng ban mới cho nhân viên");
                        System.out.println("2. chuyển phòng ban cho nhân viên");
                        System.out.println("3. Xóa phòng ban cho nhân viên");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        int choice6 = Integer.parseInt(scanner.nextLine());
                        switch (choice6){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                        break;
                    case 6:
                        System.out.println("-------------------");
                        System.out.print("Nhập mã nhân viên cần tính thuế: ");
                        int manv = Integer.parseInt(scanner.nextLine());
                        // in thông tin nhân viên ra
                        System.out.println("Nhập số người phụ thuộc: ");
                        int nguoi = Integer.parseInt(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("-------------------");
                        System.out.println("1. In danh sách các quản lý");
                        System.out.println("2. In ra 3 nhân viên có lương cao nhất");
                        System.out.println("3. In ra danh sách nhân viên của phòng ban tương ứng");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        int choice7 = Integer.parseInt(scanner.nextLine());
                        switch (choice7){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                System.out.println("Nhập mã phòng ban: ");
                                int mapb = Integer.parseInt(scanner.nextLine());
                                // in ra danh sách nhân viên mã phòng ban đó
                                break;
                        }
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }
            }
        }
    }
}

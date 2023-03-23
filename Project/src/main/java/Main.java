import DAO.TaiKhoanDAO;
import Model.TaiKhoan;
import Service.NhanVienService;
import Service.PhongBanService;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PhongBanService phongBanService = new PhongBanService();
        NhanVienService nhanVienService = new NhanVienService();

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
                while (cond){
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
                switch (choice1) {
                    case 1:
                        boolean cond1 = true;
                        while (cond1) {
                            System.out.println("-------------------");
                            System.out.println("1. In danh sách nhân viên");
                            System.out.println("2. In dach sách phòng ban");
                            System.out.println("3. Thoát");
                            System.out.print("Nhập lựa chọn của bạn: ");
                            int choice2 = Integer.parseInt(scanner.nextLine());
                            switch (choice2) {
                                case 1:
                                    nhanVienService.showAll();
                                    break;
                                case 2:
                                    phongBanService.showAll();
                                    break;
                                case 3:
                                    cond1 = false;
                                    break;
                            }
                        }
                        break;

                    case 2:
                        boolean cond2 = true;
                        while (cond2) {
                            System.out.println("-------------------");
                            System.out.println("1. Thêm nhân viên mới");
                            System.out.println("2. Sửa thông tin nhân viên");
                            System.out.println("3. Xóa nhân viên");
                            System.out.println("4. Thoát");
                            System.out.print("Nhập lựa chọn của bạn: ");
                            int choice3 = Integer.parseInt(scanner.nextLine());
                            switch (choice3) {
                                case 1:
                                    System.out.println("----------------------");
                                    nhanVienService.insert();
                                    break;
                                case 3:
                                    System.out.println("----------------------");
                                    nhanVienService.delete();
                                    break;
                                case 2:
                                    System.out.println("----------------------");
                                    nhanVienService.update();
                                    break;
                                case 4:
                                    cond2 = false;
                                    break;
                            }
                        }
                        break;
                    case 3:
                        boolean cond3 = true;
                        while (cond3) {
                            System.out.println("-------------------");
                            System.out.println("1. Thêm Phòng ban mới");
                            System.out.println("2. Sửa thông tin phòng ban");
                            System.out.println("3. Xóa phòng ban");
                            System.out.println("4. Thoát");
                            System.out.print("Nhập lựa chọn của bạn: ");
                            int choice4 = Integer.parseInt(scanner.nextLine());
                            switch (choice4) {
                                case 1:
                                    phongBanService.insert();
                                    phongBanService.showAll();
                                    break;
                                case 3:
                                    phongBanService.delete();
                                    System.out.println("----------------------");
                                    phongBanService.showAll();
                                    break;
                                case 2:
                                    phongBanService.update();
                                    break;
                                case 4:
                                    cond3 = false;
                                    break;
                            }
                        }
                        break;
                    case 4:
                        nhanVienService.findByValues();
                        break;
                    case 5:
                        boolean cond5 = true;
                        while (cond5) {
                            System.out.println("-------------------");
                            System.out.println("1. Thêm Phòng ban mới cho nhân viên");
                            System.out.println("2. chuyển phòng ban cho nhân viên");
                            System.out.println("3. Xóa phòng ban cho nhân viên");
                            System.out.println("4. Thoát");
                            System.out.print("Nhập lựa chọn của bạn: ");
                            int choice6 = Integer.parseInt(scanner.nextLine());
                            switch (choice6) {
                                case 1:
                                    nhanVienService.themPhongBan();
                                    break;
                                case 2:
                                    nhanVienService.chuyenPhongBan();
                                    break;
                                case 3:
                                    nhanVienService.xoaPhongBan();
                                    break;
                                case 4:
                                    cond5 = false;
                                    break;
                            }
                        }
                        break;
                    case 6:

                        System.out.println("-------------------");
                        System.out.print("Nhập mã nhân viên cần tính thuế: ");
                        int manv = Integer.parseInt(scanner.nextLine());
                        System.out.println("Nhập số người phụ thuộc: ");
                        int nguoi = Integer.parseInt(scanner.nextLine());
                        Double temp = nhanVienService.tinhThueThuNhapCaNhan(manv,nguoi);
                        System.out.println("Thuế thu nhập cá nhân của nhân viên đó là: " + temp);
                        break;
                    case 7:
                        boolean cond7 = true;
                        while (cond7) {
                            System.out.println("-------------------");
                            System.out.println("1. In danh sách các quản lý");
                            System.out.println("2. In ra 3 nhân viên có lương cao nhất");
                            System.out.println("3. In ra danh sách nhân viên của phòng ban tương ứng");
                            System.out.println("4. Thoát");
                            System.out.print("Nhập lựa chọn của bạn: ");
                            int choice7 = Integer.parseInt(scanner.nextLine());
                            switch (choice7) {
                                case 1:
                                    nhanVienService.ThongTinQuanLY();
                                    break;
                                case 2:
                                    nhanVienService.top3Luong();
                                case 3:
                                    nhanVienService.showNhanVienTheoPhongBan();
                                    break;
                                case 4:
                                    cond7 = false;
                                    break;
                            }
                            break;
                        }
                    case 8:
                        System.exit(0);
                        break;
                    }
                }
            }
        }
    }
}

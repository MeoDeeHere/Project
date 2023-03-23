package Service;

import DAO.NhanVienDAO;
import DAO.PhongBanDao;
import Database.Connect;
import Model.NhanVien;
import Model.PhongBan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienService {
    public NhanVienDAO nhanVienDAO;
    public NhanVien nhanVien;
    public PhongBanDao phongBanDao;
    public static Scanner scanner = new Scanner(System.in);
    public NhanVienService(){
        nhanVienDAO = new NhanVienDAO();
    }
    public void showAll(){
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        nhanVienList = nhanVienDAO.showAll();
        for (NhanVien nv:nhanVienList
             ) {
            System.out.println(nv.Thongtinnhanvienkhongkemtenphongban());
        }
    }
    public void findByValues(){
        boolean con = true;
        while (con){
        System.out.println("-------------------");
        System.out.println("1. Mã nhân viên");
        System.out.println("2. Tên nhân viên");
        System.out.println("3. Số điện thoại");
        System.out.println("4. Email");
        System.out.println("5. Thoát");
        System.out.print("Chọn thông loại thông tin mà bạn muốn tìm: ");
        int choice5 = Integer.parseInt(scanner.nextLine());
        switch (choice5) {
            case 1:
                System.out.print("Nhập mã nhân viên: ");
                int manv = Integer.parseInt(scanner.nextLine());
                NhanVien nhanVien1 = nhanVienDAO.showbyEnterValues("maNV", manv);
                if (nhanVien1.getMaNV()==0){
                    System.out.println("Nhập sai mã nhân viên");
                }else System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                break;
            case 2:
                System.out.print("Nhập tên nhân viên: ");
                String ten = scanner.nextLine();
                NhanVien nhanVien2 = nhanVienDAO.showbyEnterValues("ten", ten);
                if (nhanVien2.getMaNV()==0){
                    System.out.println("Nhập sai tên nhân viên");
                }else System.out.println(nhanVien2.Thongtinnhanvienkhongkemtenphongban());
                break;
            case 3:
                System.out.print("Số điện thoại: ");
                String soDT = scanner.nextLine();
                NhanVien nhanVien3 = nhanVienDAO.showbyEnterValues("soDT", soDT);
                if (nhanVien3.getMaNV()==0){
                    System.out.println("Nhập sai số điện thoại của nhân viên");
                }else System.out.println(nhanVien3.Thongtinnhanvienkhongkemtenphongban());
                break;
            case 4:
                System.out.print("Nhập Email: ");
                int email = Integer.parseInt(scanner.nextLine());
                NhanVien nhanVien4 = nhanVienDAO.showbyEnterValues("email", email);
                if (nhanVien4.getMaNV()==0){
                    System.out.println("Nhập sai email của nhân viên");
                }else System.out.println(nhanVien4.Thongtinnhanvienkhongkemtenphongban());
                break;
            case 5:
                con = false;
                break;
            }
        }
    }
    public void insert(){
        System.out.print("Nhập tên nhân viên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập giới tính nhân viên: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập quê quán nhân viên: ");
        String queQuan = scanner.nextLine();
        System.out.print("Nhập số điện thoại nhân viên: ");
        String soDT = scanner.nextLine();
        System.out.print("Nhập email nhân viên: ");
        String email = scanner.nextLine();
        System.out.print("Nhập lương nhân viên: ");
        int luong = Integer.parseInt(scanner.nextLine());
        NhanVien nhanVien = new NhanVien(ten,gioiTinh,tuoi,queQuan,soDT,email,luong);
        nhanVienDAO.insert1(nhanVien);
    }
    public void delete(){
        boolean cond = true;
        while (cond) {
            System.out.print("Nhập mã nhân viên cần xóa: ");
            int manv = Integer.parseInt(scanner.nextLine());
            NhanVien nhanVien1 = nhanVienDAO.showbyID(manv);
            if (nhanVien1.getMaNV() == 0) {
                System.out.println("Nhập sai mã nhân viên");
            } else {
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                PhongBan phongBan = phongBanDao.showByMaQL(manv);
                if (phongBan.getMaQL() !=0){
                    System.out.println("Nhân viên ban xóa là quản lý");
                    System.out.println(phongBan.ThongTinPhongBan());
                    System.out.println("Nhập mã quản lý mới cho phòng ban: ");
                    int maql = Integer.parseInt(scanner.nextLine());
                    phongBanDao.update("maQL",maql, phongBan.getMaPB());
                    nhanVienDAO.update2(manv);
                }
                System.out.println("Xóa nhân viên");
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                nhanVienDAO.delete(manv);
                cond = false;
            }
        }
    }
    public void update() {
        boolean cond1 = true;
        while (cond1) { // vòng while này sẽ sét xem nhập đúng mã nhân viên chưa?
            System.out.print(" Nhâp mã nhân viên: ");
            int manv = Integer.parseInt(scanner.nextLine());
            NhanVien temp = nhanVienDAO.showbyID(manv);
            if (temp.getMaNV() == 0) {
                System.out.println("Nhập sai mã phòng ban");
            } else {
                System.out.println(temp.Thongtinnhanvienkhongkemtenphongban());
                boolean con = true;
                do {
                    System.out.println("----------Chọn thông tin muốn thay đổi---------");
                    System.out.println("1. Tên nhân viên");
                    System.out.println("2. Giới tính");
                    System.out.println("3. Tuổi");
                    System.out.println("4. Quê quán");
                    System.out.println("5. Số điện thoại");
                    System.out.println("6. Email");
                    System.out.println("7. Lương");
                    System.out.println("8. Mã người quản lý trực tiếp");
                    System.out.println("9. Thoát");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    int choice3_1 = Integer.parseInt(scanner.nextLine());
                    switch (choice3_1) {
                        case 1:
                            System.out.print("Tên mới của Nhân viên: ");
                            String newName = scanner.nextLine();
                            nhanVienDAO.update("tenPB", newName, manv);
                            break;
                        case 2:
                            System.out.print("Giới tính mới của Nhân viên: ");
                            String newGender = scanner.nextLine();
                            nhanVienDAO.update("gioiTinh", newGender, manv);
                            break;
                        case 3:
                            System.out.print("Tuổi mới của Nhân viên: ");
                            int newAge = Integer.parseInt(scanner.nextLine());
                            nhanVienDAO.update("tuoi", newAge, manv);
                            break;
                        case 4:
                            System.out.print("Quê quán mới của Nhân viên: ");
                            String newHomeTown = scanner.nextLine();
                            nhanVienDAO.update("queQuan", newHomeTown, manv);
                            break;
                        case 5:
                            System.out.print("số điện thoại mới của Nhân viên: ");
                            String newPhoneNumber = scanner.nextLine();
                            nhanVienDAO.update("soDT", newPhoneNumber, manv);
                            break;
                        case 6:
                            System.out.print("Email mới của Nhân viên: ");
                            String newEmail = scanner.nextLine();
                            nhanVienDAO.update("email", newEmail, manv);
                            break;
                        case 7:
                            System.out.print("Lương mới của Nhân viên: ");
                            int newSalary = Integer.parseInt(scanner.nextLine());
                            nhanVienDAO.update("luong", newSalary, manv);
                            break;
                        case 8:
                            System.out.print("Mã người quản lý mới của Nhân viên: ");
                            int newReportTo = Integer.parseInt(scanner.nextLine());
                            nhanVienDAO.update("maNguoiQL", newReportTo, manv);
                            break;
                        case 9:
                            break;

                    }
                    temp = nhanVienDAO.showbyID(manv);
                    System.out.println(temp.Thongtinnhanvienkhongkemtenphongban());
                    cond1 = false; //nếu đúng sẽ thoát khỏi vòng while
                } while (con);
            }

        }
    }
    public void themPhongBan(){
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        nhanVienList = nhanVienDAO.showAllHaveNullPHongBan();
        for (NhanVien nv:nhanVienList
        ) {
            System.out.println(nv.Thongtinnhanvienkhongkemtenphongban());
        }
        boolean cond = true;
        while (cond){
            System.out.print("Nhập mã nhân viên cần thêm phòng ban: ");
            int manv = Integer.parseInt(scanner.nextLine());
            NhanVien nhanVien1 = nhanVienDAO.showbyID(manv);
            if(nhanVien1.getMaPB() !=0){
                System.out.println("Nhân viên bạn nhập đã có phòng ban");
            }else {
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                System.out.print("Nhập mã phòng ban mới");
                int mapb = Integer.parseInt(scanner.nextLine());
                nhanVienDAO.updateMaPhongBan(mapb,manv);
                nhanVien1 = nhanVienDAO.showbyID(manv);
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                cond = false;
            }
        }
    }
    public void chuyenPhongBan(){
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        nhanVienList = nhanVienDAO.showAllHaveNotNullPHongBan();
        for (NhanVien nv:nhanVienList
        ) {
            System.out.println(nv.Thongtinnhanvienkhongkemtenphongban());
        }
        boolean cond = true;
        while (cond){
            System.out.print("Nhập mã nhân viên cần thêm phòng ban: ");
            int manv = Integer.parseInt(scanner.nextLine());
            NhanVien nhanVien1 = nhanVienDAO.showbyID(manv);
            if(nhanVien1.getMaPB() ==0){
                System.out.println("Nhân viên bạn nhập chưa có phòng ban");
            }else {
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                PhongBan phongBan = phongBanDao.showByMaQL(manv);
                if (phongBan.getMaQL() !=0){
                    System.out.println("Nhân viên bạn chuyển phòng ban là quản lý");
                    System.out.println(phongBan.ThongTinPhongBan());
                    System.out.println("Nhập mã quản lý mới cho phòng ban: ");
                    int maql = Integer.parseInt(scanner.nextLine());
                    phongBanDao.update2(maql, phongBan.getMaPB());
                    nhanVienDAO.update2(manv);
                }
                System.out.print("Nhập mã phòng ban mới");
                int mapb = Integer.parseInt(scanner.nextLine());
                nhanVienDAO.updateMaPhongBan(mapb,manv);
                nhanVien1 = nhanVienDAO.showbyID(manv);
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                cond = false;
            }
        }
    }
    public void xoaPhongBan(){
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        nhanVienList = nhanVienDAO.showAllHaveNotNullPHongBan();
        for (NhanVien nv:nhanVienList
        ) {
            System.out.println(nv.Thongtinnhanvienkhongkemtenphongban());
        }
        boolean cond = true;
        while (cond){
            System.out.print("Nhập mã nhân viên cần thêm phòng ban: ");
            int manv = Integer.parseInt(scanner.nextLine());
            NhanVien nhanVien1 = nhanVienDAO.showbyID(manv);
            if(nhanVien1.getMaPB() ==0){
                System.out.println("Nhân viên bạn nhập chưa có phòng ban nên không thể xóa");
            }else {
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                PhongBan phongBan = phongBanDao.showByMaQL(manv);
                if (phongBan.getMaQL() !=0){
                    System.out.println("Nhân viên bạn xóa phòng ban là quản lý");
                    System.out.println(phongBan.ThongTinPhongBan());
                    System.out.println("Nhập mã quản lý mới cho phòng ban: ");
                    int maql = Integer.parseInt(scanner.nextLine());
                    phongBanDao.update2(maql,phongBan.getMaPB());
                    nhanVienDAO.update2(manv);
                }
                nhanVienDAO.deleteMaPhongBan(manv);
                nhanVien1 = nhanVienDAO.showbyID(manv);
                System.out.println(nhanVien1.Thongtinnhanvienkhongkemtenphongban());
                cond = false;
            }
        }
    }
    public double tinhThueThuNhapCaNhan(int ID, int nguoiPhuThuoc){
        NhanVien nhanVien1 = nhanVienDAO.showbyID(ID);
        nhanVien1.Thongtinnhanvienkhongkemtenphongban();
        double tienThuePhaiDong = 0;
        double tienChiuThue = nhanVien1.getLuong() - 11000000 - nguoiPhuThuoc*4400000;
        if (tienChiuThue >0 && tienChiuThue <= 50000000) {
            tienThuePhaiDong = tienChiuThue * 0.05;
            return tienThuePhaiDong;
        }else if (tienChiuThue <=10000000){
            tienThuePhaiDong = tienChiuThue * 0.05 + (tienChiuThue - 5000000)*0.1;
        } else if (tienChiuThue<=18000000){
            tienThuePhaiDong = tienChiuThue * 0.05 + (tienChiuThue - 5000000)*0.1 + (tienChiuThue -10000000)*0.15;
            return tienThuePhaiDong;
        }else if (tienChiuThue <= 32000000){
            tienThuePhaiDong = tienChiuThue * 0.05 + (tienChiuThue - 5000000)*0.1 + (tienChiuThue -10000000)*0.15 +
                    (tienChiuThue -18000000)*0.20;
            return tienThuePhaiDong;
        }else if (tienChiuThue <= 52000000) {
            tienThuePhaiDong = tienChiuThue * 0.05 + (tienChiuThue - 5000000) * 0.1 + (tienChiuThue - 10000000) * 0.15 +
                    (tienChiuThue - 18000000) * 0.20 + (tienChiuThue - 52000000) * 0.25;
            return tienThuePhaiDong;
        }else if (tienChiuThue <= 80000000) {
            tienThuePhaiDong = tienChiuThue * 0.05 + (tienChiuThue - 5000000) * 0.1 + (tienChiuThue - 10000000) * 0.15 +
                    (tienChiuThue - 18000000) * 0.20 + (tienChiuThue - 52000000) * 0.25 + (tienChiuThue - 80000000) *0.30;
            return tienThuePhaiDong;
        }else if (tienChiuThue > 80000000) {
            tienThuePhaiDong = tienChiuThue * 0.05 + (tienChiuThue - 5000000) * 0.1 + (tienChiuThue - 10000000) * 0.15 +
                    (tienChiuThue - 18000000) * 0.20 + (tienChiuThue - 52000000) * 0.25 + (tienChiuThue - 80000000) *0.30
                    +(tienChiuThue - 80000000)*0.35;
            return tienThuePhaiDong;}
        return tienThuePhaiDong;
    }
    public void ThongTinQuanLY(){
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        nhanVienList = nhanVienDAO.thongTinQuanLY();
        for (NhanVien nv:nhanVienList
        ) {
            System.out.println(nv.ThongTinQuanLY());
        }
    }
    public void top3Luong(){
        boolean cond = true;
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        while (cond) {
            System.out.println("-------------------");
            System.out.println("1. Theo phòng ban");
            System.out.println("2. Toàn bộ nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice7_1 = Integer.parseInt(scanner.nextLine());
            switch (choice7_1) {
                case 1:
                    System.out.println("-----<>-----");
                    System.out.println("Nhập mã phòng ban:");
                    int mapb = Integer.parseInt(scanner.nextLine());
                    nhanVienList = nhanVienDAO.Top3LuongTheoPhongBan(mapb);
                    for (NhanVien nv :
                            nhanVienList) {
                        System.out.println(nv.Thongtinnhanvienkemtenphongban());
                    }
                    break;
                case 2:
                    nhanVienList = nhanVienDAO.Top3Luong();
                    for (NhanVien nv :
                            nhanVienList) {
                        System.out.println(nv.Thongtinnhanvienkemtenphongban());
                    }
                    break;
                case 3:
                    cond = false;
                    break;
            }
        }
    }
    public void showNhanVienTheoPhongBan(){
        System.out.println("Nhập mã phòng ban: ");
        int mapb = Integer.parseInt(scanner.nextLine());
        List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
        nhanVienList = nhanVienDAO.showNhanVienTheoPhongBan(mapb);
        for (NhanVien nv:
             nhanVienList) {
            System.out.println(nv.Thongtinnhanvienkemtenphongban());
        }
    }
}

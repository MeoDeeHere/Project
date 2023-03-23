package Service;

import DAO.PhongBanDao;
import Model.PhongBan;

import java.util.List;
import java.util.Scanner;

public class PhongBanService {
    public PhongBanDao phongBanDao;
    public List<PhongBan> phongBanList;
    public static Scanner scanner = new Scanner(System.in);
    public PhongBanService(){
        phongBanDao = new PhongBanDao();
    }
    public void showAll(){
        phongBanList = phongBanDao.showAll();
        for (PhongBan pb:phongBanList) {
            System.out.println(pb.ThongTinPhongBan());
        }
    }
    public void insert(){
        System.out.print("Nhập tên phòng ban: ");
        String tenPB = scanner.nextLine();
        System.out.print("Nhập mã quản lý (tham chiếu tới danh sách nhân viên): ");
        int maQL = Integer.parseInt(scanner.nextLine());
        PhongBan pb = new PhongBan(tenPB,maQL);
        phongBanDao.insert(pb);
    }
    public void update() {
        boolean cond1 = true;
        while (cond1) { // vòng while này sẽ sét xem nhập đúng mã phòng ban chưa?
            System.out.print(" Nhâp mã phòng ban: ");
            int maPB = Integer.parseInt(scanner.nextLine());
            PhongBan temp = phongBanDao.showbyID(maPB);
            if (temp.getMaQL() == 0) {
                System.out.println("Nhập sai mã phòng ban");
            } else {
                System.out.println(temp.ThongTinPhongBan());
                boolean con = true;
                do {
                    System.out.println("------------Chọn thông tin cân sửa-----------");
                    System.out.println("1. Tên phòng ban");
                    System.out.println("2. Mã Quản Lý");
                    System.out.println("3. Thoát");
                    int choice4_1 = Integer.parseInt(scanner.nextLine());
                    switch (choice4_1) {
                        case 1:
                            System.out.print("Tên mới của phòng ban: ");
                            String newName = scanner.nextLine();
                            phongBanDao.update("tenPB", newName, maPB);
                            break;
                        case 2:
                            System.out.print("Mã quản lý mới của phòng ban (Tham chiếu ở danh sách nhân viên): ");
                            int newMaQL = Integer.parseInt(scanner.nextLine());
                            phongBanDao.update("tenPB", newMaQL, maPB);
                            break;
                        case 3:
                            con = false;
                            break;
                    }
                    temp = phongBanDao.showbyID(maPB);
                    System.out.println(temp.ThongTinPhongBan());
                    cond1 = false; //nếu đúng sẽ thoát khỏi vòng while
                } while (con);
            }

        }

    }
    public void delete() {
        boolean cond = true;
        while (cond) {
            System.out.print("Nhập mã phòng ban: ");
            int maPB = Integer.parseInt(scanner.nextLine());
            PhongBan pb1 = phongBanDao.showbyID(maPB);
            if (pb1.getMaPB()==0){
                System.out.println("Nhập sai mã phòng ban");
            }else {
            System.out.println("Xóa phòng ban");
            PhongBan pb = phongBanDao.showbyID(maPB);
            System.out.println(pb.ThongTinPhongBan());
            phongBanDao.delete(maPB);
            cond = false;
            }
        }
    }
}

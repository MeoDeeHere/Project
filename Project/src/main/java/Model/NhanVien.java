package Model;

public class NhanVien {
    private int maNV;
    private String ten;
    private String gioiTinh;
    private int tuoi;
    private String queQuan;
    private String soDT;
    private String email;
    private int Luong;
    private int maPB;
    private int maNguoiQL;
    private String tenPB;

    public NhanVien() {
    }

    public NhanVien(String ten, String gioiTinh, int tuoi, String queQuan, String soDT, String email, int luong) {
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.soDT = soDT;
        this.email = email;
        Luong = luong;
    }

    public NhanVien(String ten, String gioiTinh, int tuoi, String queQuan, String soDT, String email, int luong, int maPB, int maNguoiQL) {
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.soDT = soDT;
        this.email = email;
        Luong = luong;
        this.maPB = maPB;
        this.maNguoiQL = maNguoiQL;
    }

    public NhanVien(int maNV, String ten, String gioiTinh, int tuoi, String queQuan,
                    String soDT, String email, int luong, int maPB, int maNguoiQL) {
        this.maNV = maNV;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.soDT = soDT;
        this.email = email;
        Luong = luong;
        this.maPB = maPB;
        this.maNguoiQL = maNguoiQL;
    }

    public NhanVien(int maNV, String ten, String gioiTinh, int tuoi, String queQuan, String soDT, String email, int luong, int maPB, int maNguoiQL, String tenPB) {
        this.maNV = maNV;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.soDT = soDT;
        this.email = email;
        Luong = luong;
        this.maPB = maPB;
        this.maNguoiQL = maNguoiQL;
        this.tenPB = tenPB;
    }

    public NhanVien(int maNV, String ten, String gioiTinh, int tuoi, String queQuan, String soDT, String email, int luong, int maPB, String tenPB) {
        this.maNV = maNV;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.soDT = soDT;
        this.email = email;
        Luong = luong;
        this.maPB = maPB;
        this.tenPB = tenPB;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int luong) {
        Luong = luong;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public int getMaNguoiQL() {
        return maNguoiQL;
    }

    public void setMaNguoiQL(int maNguoiQL) {
        this.maNguoiQL = maNguoiQL;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String ThongTinQuanLY() {
        return "Quản Lý [" +
                "maNV=" + maNV +
                ", ten='" + ten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", tuoi=" + tuoi +
                ", queQuan='" + queQuan + '\'' +
                ", soDT='" + soDT + '\'' +
                ", email='" + email + '\'' +
                ", Luong=" + Luong +
                ", maPB=" + maPB +
                ", tenPB='" + tenPB + '\'' +
                ']';
    }

    public String Thongtinnhanvienkemtenphongban() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", ten='" + ten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", tuoi=" + tuoi +
                ", queQuan='" + queQuan + '\'' +
                ", soDT='" + soDT + '\'' +
                ", email='" + email + '\'' +
                ", Luong=" + Luong +
                ", maPB=" + maPB +
                ", maNguoiQL=" + maNguoiQL +
                ", tenPB='" + tenPB + '\'' +
                '}';
    }

    public String Thongtinnhanvienkhongkemtenphongban() {
        return "NhanVien [" +
                "maNV=" + maNV +
                ", ten='" + ten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", tuoi=" + tuoi +
                ", queQuan='" + queQuan + '\'' +
                ", soDT='" + soDT + '\'' +
                ", email='" + email + '\'' +
                ", Luong=" + Luong +
                ", maPB=" + maPB +
                ", maNguoiQL=" + maNguoiQL +
                ']';
    }
}

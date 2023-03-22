package Model;

public class PhongBan {
    private int maPB;
    private String tenPB;
    private int maQL;

    public PhongBan() {
    }

    public PhongBan(int maPB, String tenPB, int maQL) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.maQL = maQL;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public int getMaQL() {
        return maQL;
    }

    public void setMaQL(int maQL) {
        this.maQL = maQL;
    }


    public String ThongTinPhongBan() {
        return "PhongBan [" +
                "maPB=" + maPB +
                ", tenPB='" + tenPB + '\'' +
                ", maQL=" + maQL +
                ']';
    }
}

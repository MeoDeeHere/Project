package DAO;

import Database.Connect;
import Model.NhanVien;
import Model.PhongBan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    public List<NhanVien> showAll(){
        List<NhanVien> nhanVienList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT * FROM NhanVien";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"));
                nhanVienList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nhanVienList;
    }
    public NhanVien showbyID(int ID){
        NhanVien nv = new NhanVien();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "SELECT * FROM NhanVien WHERE maNV='" + ID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                nv= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nv;
    }
    public <T> NhanVien showbyEnterValues(T col, T values){
        NhanVien nv = new NhanVien();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "SELECT * FROM NhanVien WHERE " +col + "='" + values + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                nv= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"));
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nv;
    }
//    public void insert1 (NhanVien nhanVien){
//        nhanVien = null;
//        Connection conn = null;
//        PreparedStatement prst = null;
//        try {
//            conn= Connect.getInstance().getConnection();
//            String sql = "INSERT INTO NhanVien (ten, gioiTinh, tuoi, queQuan, soDT, email, luong, maPB, maNguoiQL)" +
//                    " VALUES (?,?,?,?,?,?,?,?,?)";
//            prst= conn.prepareStatement(sql);
//            prst= conn.prepareStatement(sql);
//            prst.setString(1,nhanVien.getTen());
//            prst.setString(2, nhanVien.getGioiTinh());
//            prst.setInt(3,nhanVien.getTuoi());
//            prst.setString(4, nhanVien.getQueQuan());
//            prst.setString(5,nhanVien.getSoDT());
//            prst.setString(6, nhanVien.getEmail());
//            prst.setInt(7,nhanVien.getLuong());
//            prst.setInt(8, nhanVien.getMaPB());
//            prst.setInt(9, nhanVien.getMaNguoiQL());
//            prst.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }finally {
//            if (prst !=null){
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    // TODO: handle exception
//                    throw new RuntimeException();
//                }}
//        }
//    }
public void insert1 (NhanVien nhanVien){
    Connection conn = null;
    PreparedStatement prst = null;
    try {
        conn= Connect.getInstance().getConnection();
        String sql = "INSERT INTO NhanVien (ten, gioiTinh, tuoi, queQuan, soDT, email, luong)" +
                " VALUES (?,?,?,?,?,?,?)";
        prst= conn.prepareStatement(sql);
        prst= conn.prepareStatement(sql);
        prst.setString(1,nhanVien.getTen());
        prst.setString(2, nhanVien.getGioiTinh());
        prst.setInt(3,nhanVien.getTuoi());
        prst.setString(4, nhanVien.getQueQuan());
        prst.setString(5,nhanVien.getSoDT());
        prst.setString(6, nhanVien.getEmail());
        prst.setInt(7,nhanVien.getLuong());
        prst.executeUpdate();
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }finally {
        if (prst !=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                // TODO: handle exception
                throw new RuntimeException();
            }}
        }
    }
    public void delete (int ID){
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql2 = "UPDATE NhanVien SET maNguoiQL = null WHERE maNguoiQL='" + ID + "'";
            String sql = "DELETE FROM NhanVien WHERE maNV='" + ID + "'";
            Statement stmt = conn.createStatement();
            stmt.execute(sql2);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
    }
    public <T> void update(T col, T val,int ID) {
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "UPDATE NhanVien SET " + col + "='" + val + "' WHERE maNV= '" + ID+"'";
            stmt.execute(sql);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
    }
    public void update2(int ID) {
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "UPDATE NhanVien SET maNguoiQL= null WHERE maNguoiQL= '" + ID+"'";
            stmt.execute(sql);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
    }
    public List<NhanVien> showAllHaveNullPHongBan(){
        List<NhanVien> nhanVienList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT * FROM NhanVien where maPB is null";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"));
                nhanVienList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nhanVienList;
    }
    public List<NhanVien> showAllHaveNotNullPHongBan(){
        List<NhanVien> nhanVienList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT * FROM NhanVien where maPB is not null";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"));
                nhanVienList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nhanVienList;
    }
    public void updateMaPhongBan(int val, int ID){
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql2 = "UPDATE NhanVien SET maNguoiQL = null WHERE maNguoiQL= '" + ID+"'";
            String sql = "UPDATE NhanVien SET maPB='" + val + "' WHERE maNV= '" + ID+"'";
            stmt.execute(sql2);
            stmt.execute(sql);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
    }
    public void deleteMaPhongBan(int ID){
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql2 = "UPDATE NhanVien SET maNguoiQL = null WHERE maNguoiQL= '" + ID+"'";
            String sql = "UPDATE NhanVien SET maPB = null WHERE maNV= '" + ID+"'";
            stmt.execute(sql2);
            stmt.execute(sql);

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
    }
    public List<NhanVien> thongTinQuanLY(){
        List<NhanVien> quanLyList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT \n" +
                    "\tNV.maNV, NV.ten, NV.gioiTinh, NV.tuoi, NV.queQuan, NV.soDT, NV.email, NV.luong, PB.maPB, PB.tenPB\n" +
                    "FROM\n" +
                    "\tNhanVien AS NV\n" +
                    "INNER JOIN\n" +
                    "\tPhongBan AS PB\n" +
                    "ON NV.maNV = PB.maQL;";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getString("tenPB"));
                quanLyList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return quanLyList;
    }
    public List<NhanVien> Top3Luong(){
        List<NhanVien> nhanVienList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT * FROM nhanvien ORDER BY luong DESC LIMIT 3";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"));
                nhanVienList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nhanVienList;
    }
    public List<NhanVien> Top3LuongTheoPhongBan(int ID){
        List<NhanVien> nhanVienList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT \n" +
                    "\tNV.maNV, NV.ten, NV.gioiTinh, NV.tuoi, NV.queQuan, NV.soDT, NV.email, NV.luong, PB.maPB, Nv.maNguoiQL, PB.tenPB\n" +
                    "FROM\n" +
                    "\tNhanVien AS NV\n" +
                    "INNER JOIN\n" +
                    "\tPhongBan AS PB\n" +
                    "ON NV.maPB = PB.maPB\n" +
                    "WHERE NV.maPB = " + ID +
                    "ORDER BY luong DESC LIMIT 3";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"),rs.getString("tenPB"));
                nhanVienList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nhanVienList;
    }
    public List<NhanVien> showNhanVienTheoPhongBan(int ID){
        List<NhanVien> nhanVienList =new ArrayList<NhanVien>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT \n" +
                    "\tNV.maNV, NV.ten, NV.gioiTinh, NV.tuoi, NV.queQuan, NV.soDT, NV.email, NV.luong, PB.maPB, Nv.maNguoiQL, PB.tenPB\n" +
                    "FROM\n" +
                    "\tNhanVien AS NV\n" +
                    "INNER JOIN\n" +
                    "\tPhongBan AS PB\n" +
                    "ON NV.maPB = PB.maPB\n" +
                    "WHERE NV.maPB = "+ ID  ;
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                NhanVien nhanVien= new NhanVien(rs.getInt("maNV"), rs.getString("ten"),
                        rs.getString("gioiTinh"),rs.getInt("tuoi"),rs.getString("queQuan"),
                        rs.getString("soDT"),rs.getString("email"),rs.getInt("luong"),
                        rs.getInt("maPB"),rs.getInt("maNguoiQL"),rs.getString("tenPB"));
                nhanVienList.add(nhanVien);
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(conn!=null) {
                try {
                    conn.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return nhanVienList;
    }
}

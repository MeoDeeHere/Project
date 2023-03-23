package DAO;

import Database.Connect;
import Model.PhongBan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongBanDao {
    public List<PhongBan> showAll(){
        List<PhongBan> phongBanList =new ArrayList<PhongBan>();
        Connection conn= null;
        try {
            conn= Connect.getInstance().getConnection();
            Statement stmt= conn.createStatement();
            String sql="SELECT * FROM PhongBan";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                PhongBan pb= new PhongBan(rs.getInt("maPB"),
                        rs.getString("tenPB"), rs.getInt("maQL"));
                phongBanList.add(pb);
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
        return phongBanList;
    }
    public void insert (PhongBan phongBan){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn= Connect.getInstance().getConnection();
            String sql = "INSERT INTO PhongBan (tenPB, maQL) VALUES (?,?)";
            prst= conn.prepareStatement(sql);
            prst= conn.prepareStatement(sql);
            prst.setString(1,phongBan.getTenPB());
            prst.setInt(2, phongBan.getMaQL());
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
    public PhongBan showbyID (int ID) {
        PhongBan pb = new PhongBan();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "SELECT * FROM PhongBan WHERE maPB='" + ID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                pb = new PhongBan(rs.getInt("maPB"),
                        rs.getString("tenPB"), rs.getInt("maQL"));
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
        return pb;
    }
    public <T> void update(T col, T val,int ID) {
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "UPDATE PhongBan SET " + col + "='" + val + "' WHERE maPB= '" + ID+"'";
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
    public void update2(int val,int ID) {
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql2 = "UPDATE NhanVien SET maPB = null WHERE maPB= '" + ID+"'";
            String sql = "UPDATE PhongBan SET maQL ='" + val + "' WHERE maPB= '" + ID+"'";
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
    public void delete (int ID) {
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql2 = "UPDATE NhanVien SET maPB = null WHERE maPB='" + ID + "'";
            String sql = "DELETE FROM PhongBan WHERE maPB='" + ID + "'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql2);
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
    public PhongBan showByMaQL (int ID) {
        PhongBan pb = new PhongBan();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "SELECT * FROM PhongBan WHERE maQL='" + ID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                pb = new PhongBan(rs.getInt("maPB"),
                        rs.getString("tenPB"), rs.getInt("maQL"));
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
        return pb;
    }
}

package DAO;

import Database.Connect;
import Model.TaiKhoan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {
    public TaiKhoan getTaikhoan(String tk, String mk){
        TaiKhoan taiKhoan =new TaiKhoan();
        Connection connection = null;
        try {
            connection= Connect.getInstance().getConnection();
            Statement stmt= connection.createStatement();
            String sql="SELECT maTK FROM TaiKhoan where tenTK = '" + tk +"' and matKhau = '" +mk+"'";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                taiKhoan= new TaiKhoan(rs.getInt("maTK"));
                /* nếu có tài khoản thì mã tài khoản sẽ có giá trị tương ứng với tài khoản đó
                   nếu không có thì mã tài khoản sẽ có giá trị là 0
                */
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    throw new RuntimeException(e2);
                }
            }
        }
        return taiKhoan;
    }
}

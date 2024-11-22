package model;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangModel {
    private String makhachHang, tenKhachHang, cmnd, soDienThoai;

    public KhachHangModel() {}

    public KhachHangModel(String makhachHang, String tenKhachHang, String cmnd, String soDienThoai) {
        this.makhachHang = makhachHang;
        this.tenKhachHang = tenKhachHang;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
    }

    public String getMakhachHang() {
        return makhachHang;
    }

    public void setMakhachHang(String makhachHang) {
        this.makhachHang = makhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<Object[]> getAllKhachHang() {
        List<Object[]> khachHang = new ArrayList<>();
        String query = "SELECT * FROM KHACHHANG";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                khachHang.add(new Object[]{
                        rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getString("CMND"),
                        rs.getString("SoDienThoai")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public boolean addKhachHang(String maKhachHang,String tenKhachHang,String cmnd,String soDienThoai) {
        String query = "INSERT INTO KHACHHANG (MaKhachHang, TenKhachHang, CMND, SoDienThoai) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maKhachHang);
            pstmt.setString(2, tenKhachHang);
            pstmt.setString(3, cmnd);
            pstmt.setString(4, soDienThoai);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteKhachHang(String maKhachHang) {
        String query = "DELETE FROM KHACHHANG WHERE MaKhachHang = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maKhachHang);
            return pstmt.executeUpdate() > 0;
        }  catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean khachHangInHoaDon(String makhachHang) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT COUNT(*) FROM KHACHHANG WHERE MaKhachHang = ?")) {
            statement.setString(1, makhachHang);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateKhachHang(String maKhachHang, String tenKhachHang, String cmnd, String soDienThoai, String khachHang) {
        String query = "UPDATE KHACHHANG SET TenKhachHang = ?, CMND = ?, SoDienThoai = ? WHERE MaKhachHang = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setString(1, tenKhachHang);
            psmt.setString(2, cmnd);
            psmt.setString(3, soDienThoai);
            psmt.setString(4, maKhachHang); // Giá trị MaPhong ở đây sẽ được sử dụng để tìm phòng cần cập nhật
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Object[]> searchKhachHang(String attribute, String value) {
        String query = "SELECT * FROM KHACHHANG WHERE " + attribute + " = ?";
        List<Object[]> resultList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, value);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Object[] khachHang = {
                            rs.getString("MaKhachHang"),
                            rs.getString("tenKhachHang"),
                            rs.getString("CMND"),
                            rs.getString("SoDienThoai")
                    };
                    resultList.add(khachHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}

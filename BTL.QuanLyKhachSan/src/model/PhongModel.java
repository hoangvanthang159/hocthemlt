package model;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongModel {
    private String maPhong, loaiPhong, tinhTrang;
    private double giaPhong;

    public PhongModel() {}

    public PhongModel(String maPhong, String loaiPhong, double giaPhong) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.tinhTrang = loaiPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public List<Object[]> getAllRooms() {
        List<Object[]> rooms = new ArrayList<>();
        String query = "SELECT * FROM PHONG";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                rooms.add(new Object[]{
                        rs.getString("MaPhong"),
                        rs.getString("LoaiPhong"),
                        rs.getDouble("GiaPhong"),
                        rs.getString("TinhTrang")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }


    public double getGiaPhong(String maPhong) {
        String query = "SELECT GiaPhong FROM PHONG WHERE MaPhong = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {

            psmt.setString(1, maPhong);
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("GiaPhong");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(); // Ghi log lỗi chi tiết nếu cần
        }
        return -1; // Trả về -1 nếu không tìm thấy giá phòng
    }


    public boolean addRoom(String maPhong, String loaiPhong, double giaPhong, String tinhTrang) {
        String query = "INSERT INTO PHONG (MaPhong, LoaiPhong, GiaPhong, TinhTrang) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maPhong);
            pstmt.setString(2, loaiPhong);
            pstmt.setDouble(3, giaPhong);
            pstmt.setString(4, tinhTrang);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean phongInHoaDon(String maPhong) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT COUNT(*) FROM HOADON WHERE MaPhong = ?")) {
            statement.setString(1, maPhong);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteRoom(String maPhong) {
        String query = "DELETE FROM PHONG WHERE MaPhong = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maPhong);
            return pstmt.executeUpdate() > 0;
        }  catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateRoom(String maPhong, String loaiPhong, double giaPhong, String tinhTrang, String phong) {
        String query = "UPDATE PHONG SET LoaiPhong = ?, GiaPhong = ?, TinhTrang = ? WHERE MaPhong = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setString(1, loaiPhong);
            psmt.setDouble(2, giaPhong);
            psmt.setString(3, tinhTrang);
            psmt.setString(4, maPhong); // Giá trị MaPhong ở đây sẽ được sử dụng để tìm phòng cần cập nhật
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Object[]> searchRoomByAttribute(String attribute, String value) {
        String query = "SELECT * FROM PHONG WHERE " + attribute + " = ?";
        List<Object[]> resultList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, value);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Object[] room = {
                            rs.getString("MaPhong"),
                            rs.getString("LoaiPhong"),
                            rs.getDouble("GiaPhong"),
                            rs.getString("TinhTrang")
                    };
                    resultList.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

//    public List<Object[]> searchRooms(String keyword) {
//        String query = "SELECT * FROM PHONG WHERE MaPhong LIKE ? OR LoaiPhong LIKE ? OR GiaPhong LIKE ? OR TinhTrang LIKE ?";
//        List<Object[]> resultList = new ArrayList<>();
//        try (Connection conn = DatabaseConnection.getConnection();
//                PreparedStatement pstmt = conn.prepareStatement(query)) {
//            String searchKey = "%" + keyword + "%";
//            pstmt.setString(1, searchKey);
//            pstmt.setString(2, searchKey);
//            pstmt.setString(3, searchKey);
//            pstmt.setString(4, searchKey);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    Object[] row = {
//                            rs.getString("MaPhong"),
//                            rs.getString("LoaiPhong"),
//                            rs.getDouble("GiaPhong"),
//                            rs.getString("TinhTrang")
//                    };
//                    resultList.add(row);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resultList;
//    }


}

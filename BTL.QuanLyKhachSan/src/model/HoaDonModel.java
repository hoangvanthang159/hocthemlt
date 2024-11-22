package model;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonModel {
    private String maHoaDon;
    private String maKhachHang;
    private String maPhong;
    private Date ngayNhanPhong;
    private Date ngayTraPhong;
    private int soGio;
    private double tongTien;

    public HoaDonModel() {
    }

    public HoaDonModel(String maHoaDon, String maKhachHang, String maPhong, Date ngayNhanPhong, Date ngayTraPhong, int soGio, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maPhong = maPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.soGio = soGio;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public List<Object[]> getAllHoaDon() {
        List<Object[]> danhSachHoaDon = new ArrayList<>();
        String query = "SELECT * FROM HOADON";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                danhSachHoaDon.add(new Object[]{
                        rs.getString("maHoaDon"),       // Mã hóa đơn
                        rs.getString("maKhachHang"),   // Mã khách hàng
                        rs.getString("maPhong"),       // Mã phòng
                        rs.getDate("ngayNhanPhong"),   // Ngày nhận phòng
                        rs.getDate("ngayTraPhong"),    // Ngày trả phòng
                        rs.getInt("soGio"),            // Số giờ
                        rs.getDouble("tongTien")       // Tổng tiền
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }

public boolean addHoaDon(String maHoaDon, String maKhachHang, String maPhong, Date ngayNhanPhong, Date ngayTraPhong, int soGio, double tongTien) {
    String query = "INSERT INTO HOADON (MaHoaDon, MaKhachHang, MaPhong, NgayNhanPhong, NgayTraPhong, SoGio, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement psmt = conn.prepareStatement(query)) {

        // Kiểm tra sự tồn tại của khách hàng trước (tùy chọn)
        boolean isCustomerExist = checkCustomerExist(maKhachHang, conn); // Gọi phương thức kiểm tra khách hàng
        if (!isCustomerExist) {
            // Thông báo lỗi nếu khách hàng không tồn tại
            System.out.println("Lỗi: Khách hàng với mã " + maKhachHang + " không tồn tại!");
            return false;
        }

        psmt.setString(1, maHoaDon);
        psmt.setString(2, maKhachHang);
        psmt.setString(3, maPhong);
        psmt.setDate(4, new java.sql.Date(ngayNhanPhong.getTime()));
        psmt.setDate(5, new java.sql.Date(ngayTraPhong.getTime()));
        psmt.setInt(6, soGio);
        psmt.setDouble(7, tongTien);
        return psmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    // Phương thức kiểm tra sự tồn tại của khách hàng (tùy chỉnh theo cấu trúc database)
    private boolean checkCustomerExist(String maKhachHang, Connection conn) throws SQLException {
        String checkQuery = "SELECT * FROM KHACHHANG WHERE MaKhachHang = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
        checkStmt.setString(1, maKhachHang);
        ResultSet rs = checkStmt.executeQuery();
        return rs.next(); // Kiểm tra xem có kết quả trả về không (nghĩa là khách hàng tồn tại)
    }

    public boolean deleteHoaDon(String maHoaDon) {
        String query = "DELETE FROM HOADON WHERE MaHoaDon = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maHoaDon);
            return pstmt.executeUpdate() > 0;
        }  catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateHoaDon(String maHoaDon, String maKhachHang, String maPhong, Date ngayNhanPhong, Date ngayTraPhong, int soGio) {
        String query = "UPDATE HOADON SET MaKhachHang = ?, MaPhong = ?, NgayNhanPhong = ?, NgayTraPhong = ?, SoGio = ? WHERE MaHoaDon = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {

            // Gán giá trị cho các tham số trong câu lệnh SQL
            psmt.setString(1, maKhachHang); // MaKhachHang
            psmt.setString(2, maPhong);    // MaPhong
            psmt.setDate(3, new java.sql.Date(ngayNhanPhong.getTime())); // NgayNhanPhong
            psmt.setDate(4, new java.sql.Date(ngayTraPhong.getTime()));  // NgayTraPhong
//            psmt.setDouble(5, tongTien);   // TongTien
            psmt.setInt(5, soGio);
            psmt.setString(6, maHoaDon);   // MaHoaDon (WHERE)

            // Thực thi câu lệnh
            return psmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Object[]> searchHoaDon(String attribute, String value) {
        String query = "SELECT * FROM HOADON WHERE " + attribute + " = ?";
        List<Object[]> resultList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, value);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Object[] hoaDon = {
                            rs.getString("MaHoaDon"),
                            rs.getString("MaKhachHang"),
                            rs.getString("MaPhong"),
                            rs.getDate("NgayNhanPhong"),
                            rs.getDate("NgayTraPhong"),
                            rs.getInt("SoGio")
//                            rs.getDouble("TongTien")
                    };
                    resultList.add(hoaDon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public double getRevenueByDay (String day, String month, String year) {
        String query = "SELECT SUM(tongTien) FROM HOADON " +
                "WHERE DAY(ngayNhanPhong) = ? " +
                "AND MONTH(ngayNhanPhong) = ? " +
                "AND YEAR(ngayNhanPhong) = ? " +
                "AND DAY(ngayTraPhong) = ? " +
                "AND MONTH(ngayTraPhong) = ? " +
                "AND YEAR(ngayTraPhong) = ?";
        return getRevenue(query, day, month, year, day, month, year);
    }

    public double getRevenueByMonth(String month, String year) {
        String query = "SELECT SUM(tongTien) FROM HOADON " +
                "WHERE MONTH(ngayNhanPhong) <= ? " +
                "AND YEAR(ngayNhanPhong) <= ? " +
                "AND MONTH(ngayTraPhong) >= ? " +
                "AND YEAR(ngayTraPhong) >= ?";
        return getRevenue(query, month, year, month, year);
    }

    public double getRevenueByYear(String year) {
        String query = "SELECT SUM(tongTien) FROM HOADON " +
                "WHERE YEAR(ngayNhanPhong) = ?"; // Thống kê theo năm
        return getRevenue(query, year);
    }

    private double getRevenue(String query, String... params) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setString(i + 1, params[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getTotalRevenue() {
        String query = "SELECT SUM(TongTien) FROM HOADON"; // Đảm bảo tên bảng chính xác
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1); // Lấy tổng doanh thu
            }
        } catch (SQLException e) {
            // Log lỗi hoặc xử lý tùy ý
            System.err.println("Lỗi khi truy vấn tổng doanh thu: " + e.getMessage());
        }
        return 0; // Trả về 0 nếu có lỗi
    }

    public HoaDonModel  getInvoiceById (String maHoaDon){
        String query = "SELECT * FROM HOADON WHERE MaHoaDon = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maHoaDon);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new HoaDonModel(
                            rs.getString("MaHoaDon"),
                            rs.getString("MaKhachHang"),
                            rs.getString("MaPhong"),
                            rs.getDate("NgayNhanPhong"),
                            rs.getDate("NgayTraPhong"),
                            rs.getInt("SoGio"),
                            rs.getDouble("TongTien")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package controller;

import model.HoaDonModel;

import java.util.Date;
import java.util.List;

public class HoaDonController {
    private static HoaDonModel hoaDonModel;

    public HoaDonController() {
        hoaDonModel = new HoaDonModel();
    }

    public List<Object[]> getAllHoaDon() {
        return hoaDonModel.getAllHoaDon();
    }

    public boolean addHoaDon(String maHoaDon, String maKhachHang, String maPhong, Date ngayNhanPhong, Date ngayTraPhong, int soGio, double tongTien) {
        return hoaDonModel.addHoaDon(maHoaDon, maKhachHang,  maPhong, ngayNhanPhong, ngayTraPhong, soGio, tongTien);
    }

    public static boolean deleteHoaDon(String maHoaDon) {
        return hoaDonModel.deleteHoaDon(maHoaDon);
    }

    public static boolean updateHoaDon(String maHoaDon, String maKhachHang, String maPhong, Date ngayNhanPhong, Date ngayTraPhong, int soGio) {
        return hoaDonModel.updateHoaDon(maHoaDon, maKhachHang,  maPhong, ngayNhanPhong, ngayTraPhong, soGio);
    }

    public List<Object[]> searchHoaDon(String attribute, String value) {
        return hoaDonModel.searchHoaDon(attribute, value);
    }

    public double getRevenueByDay(String day, String month, String year) {
        return hoaDonModel.getRevenueByDay(day, month, year);
    }

    public double getRevenueByMonth(String month, String year) {
        return hoaDonModel.getRevenueByMonth(month, year);
    }

    public double getRevenueByYear(String year) {
        return hoaDonModel.getRevenueByYear(year);
    }

    public double getTotalRevenue() {
        return hoaDonModel.getTotalRevenue();
    }

    public HoaDonModel getInvoiceById(String maHoaDon) {
        return hoaDonModel.getInvoiceById(maHoaDon);
    }
}

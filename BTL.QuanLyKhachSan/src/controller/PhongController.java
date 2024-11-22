package controller;

import model.PhongModel;
import java.util.List;

public class PhongController {
    private static PhongModel phongModel;

    public PhongController() {
        phongModel = new PhongModel();
    }

    public List<Object[]> getAllRooms() {
        return phongModel.getAllRooms();
    }

    public boolean addRoom(String maPhong, String loaiPhong, double giaPhong, String tinhTrang) {
        return phongModel.addRoom(maPhong, loaiPhong, giaPhong, tinhTrang);
    }

    public static boolean deleteRoom(String maPhong) {
        return phongModel.deleteRoom(maPhong);
    }

    public static boolean updateRoom(String maPhong, String loaiPhong, double giaPhong, String tinhTrang) {
        return phongModel.updateRoom(maPhong, loaiPhong, giaPhong, tinhTrang,  maPhong);
    }

    public List<Object[]> searchRoomByAttribute(String attribute, String value) {
        return phongModel.searchRoomByAttribute(attribute, value);
    }

    public boolean phongInHoaDon(String maPhong) {
        return phongModel.phongInHoaDon(maPhong);
    }
}

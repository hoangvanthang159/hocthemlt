package controller;

import model.DatPhongModel;
import java.util.ArrayList;
import java.util.List;

public class DatPhongController {
    private static List<DatPhongModel> danhSachHoaDon = new ArrayList<>();

    public static void themHoaDon(DatPhongModel hoaDon) {
        danhSachHoaDon.add(hoaDon);
    }

    public static List<DatPhongModel> getDanhSachHoaDon() {
        return danhSachHoaDon;
    }
}

package model;

public class DatPhongModel {
    private String maKH;
    private String maPhong;
    private String ngayDat;
    private String ngayTra;
    private int soNguoi;

    public DatPhongModel(String maKH, String maPhong, String ngayDat, String ngayTra, int soNguoi) {
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.ngayDat = ngayDat;
        this.ngayTra = ngayTra;
        this.soNguoi = soNguoi;
    }

    // Getter và Setter
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }
}

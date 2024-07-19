public class MatHang {
    private static int maHangcout =1000;
    private int maHang;
    private String tenHang;
    private NhomHang nhomhang;
    private double giaban;
    private int soLuong;

    public MatHang(String tenHang, NhomHang nhomhang, double giaban, int soLuong) {
        this.tenHang = tenHang;
        this.nhomhang = nhomhang;
        this.giaban = giaban;
        this.soLuong = soLuong;
        this.maHang = maHangcout++;
    }

    public static int getMaHangcout() {
        return maHangcout;
    }

    public static void setMaHangcout(int maHangcout) {
        MatHang.maHangcout = maHangcout;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public NhomHang getNhomhang() {
        return nhomhang;
    }

    public void setNhomhang(NhomHang nhomhang) {
        this.nhomhang = nhomhang;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    public int size() {
        return maHang;
    }
}

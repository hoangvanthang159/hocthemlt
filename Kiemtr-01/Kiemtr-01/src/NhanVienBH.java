public class NhanVienBH extends ConNguoi  {

    private static int maNVCout = 1000;
    private int maNV;
    private String ngayKyHD;

    public NhanVienBH(String hoTen, String diaChi) {
        super(hoTen, diaChi);
        this.maNV = maNVCout++;
        this.ngayKyHD = ngayKyHD;
    }

    public static int getMaNVCout() {
        return maNVCout;
    }

    public static void setMaNVCout(int maNVCout) {
        NhanVienBH.maNVCout = maNVCout;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getNgayKyHD() {
        return ngayKyHD;
    }

    public void setNgayKyHD(String ngayKyHD) {
        this.ngayKyHD = ngayKyHD;
    }

    @Override
    public String toString() {
        return "NhanVienBH{" +
                "maNV=" + maNV +
                ", ngayKyHD='" + ngayKyHD + '\'' +
                '}';
    }
}

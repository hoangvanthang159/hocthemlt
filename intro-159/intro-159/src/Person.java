import java.io.Serializable;
public class Person  implements Serializable {
    private static int idCounter = 10000;
    private int maKH;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private String loaiKH;

    public Person(String hoTen, String diaChi, String soDT, String loaiKH) {
        this.maKH = idCounter++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.loaiKH = loaiKH;
    }
    public int getMaKH() {
        return maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH=" + maKH +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDT='" + soDT + '\'' +
                ", loaiKH='" + loaiKH + '\'' +
                '}';
    }
}

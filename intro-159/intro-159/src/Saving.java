import java.io.Serializable;
public class Saving implements Serializable{
    private Person khachHang;
    private Bank nganHang;
    private double soTienGui;

    public Saving(Person khachHang, Bank nganHang, double soTienGui) {
        this.khachHang = khachHang;
        this.nganHang = nganHang;
        this.soTienGui = soTienGui;
    }

    public Person getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(Person khachHang) {
        this.khachHang = khachHang;
    }

    public Bank getNganHang() {
        return nganHang;
    }

    public void setNganHang(Bank nganHang) {
        this.nganHang = nganHang;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "khachHang=" + khachHang +
                ", nganHang=" + nganHang +
                ", soTienGui=" + soTienGui +
                '}';
    }
}

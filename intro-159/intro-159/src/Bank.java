import java.io.Serializable;
public class Bank {
    private static int idCounter = 100;
    private int maNH;
    private String tenNH;
    private double laiSuat;

    public Bank(String tenNH, double laiSuat) {
        this.maNH = idCounter++;
        this.tenNH = tenNH;
        this.laiSuat = laiSuat;
    }

    public int getMaNH() {
        return maNH;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        return "NganHang{" +
                "maNH=" + maNH +
                ", tenNH='" + tenNH + '\'' +
                ", laiSuat=" + laiSuat +
                '}';
    }
}

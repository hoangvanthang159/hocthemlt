import java.util.List;
import java.util.ArrayList;
public class DanhSachBanHang {
    private NhanVienBH nhanVien;
    private List<MatHang> matHangs;

    public DanhSachBanHang(NhanVienBH nhanvien) {
        this.nhanVien = nhanvien;
        this.matHangs = new ArrayList<>();
    }
    public void themMatHang(MatHang matHang) {
        if (matHang.size() < 5) {
            matHangs.add(matHang);
            System.out.println("Gioi han 5 mat hang voi moi nhan vien");
        }

}

    public NhanVienBH getNhanvien() {
        return nhanVien;
    }

    public List<MatHang> getMatHangs() {
        return matHangs;
    }

    public void inDanhSach(){
        System.out.println("Nhan vien: " + nhanVien.getHoTen());
        for (MatHang matHang : matHangs) {
            System.out.println("Mat hang" + matHang.getMaHang());
        }
    }
}

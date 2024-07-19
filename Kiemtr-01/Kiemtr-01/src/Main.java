import javax.swing.*;
import  java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     List<MatHang> danhSachMatHang = new ArrayList<>();
     List<NhanVienBH> nhanVienBH = new ArrayList<>();
     List<DanhSachBanHang> danhSachBanHang = new ArrayList<>();

     boolean exit = false;

     while (true) {
         System.out.println("==========MENU==========");
         System.out.println("1.Nhap danh sach mat hang moi nhap");
         System.out.println("2.In ra danh sách các mặt hàng đã có");
         System.out.println("3.Nhập danh sách nhân viên.");
         System.out.println("4.In ra danh sách nhân viên đã có");
         System.out.println("5.Lập Bảng danh sách bán hàng cho từng nhân viên.");
         System.out.println("6.In danh sách ra màn hình");
         System.out.println("7.Sắp xếp danh sách Bảng danh sách bán hàng theo tên nhân viên");
         System.out.println("8.Sắp xếp danh sách Bảng danh sách bán hàng theo tên nhóm mặt hàng");
         System.out.println("Lập bảng kê doanh thu cho mỗi nhân viên.");
         System.out.println("10.Thoát");
         int Object; Object  choice;
         Scanner scanner =null;
         (choice) =scanner.nextInt();
         scanner.nextLine();

         switch (choice) {
             case 1:
                 System.out.println("Nhap ten hang:");
                 String tenHang =scanner.nextLine();
                 System.out.println("Nhap nhom hang  (DIEN-TU,DIENL-ANH,MAY-TINH,THIET-BI-VAN-PHONG)");
                 NhomHang nhomhang = NhomHang.valueOf(Scanner.nextLine().toUpperCase());
                 System.out.println("Nhap gia ban:");
                 double giaBan = scanner.nextDouble();
                 System.out.println("Nhap so luong ");
                 int soLuong = scanner.nextInt();
                 danhSachMatHang.add(new MatHang(tenHang,nhomhang,giaBan,soLuong));
                 break;
             case 2:
                 for (MatHang matHang : danhSachMatHang) {
                     System.out.println("Ma Hang:" +matHang.getMaHang() +",Ten hang:" + matHang.getTenHang() + ",Nhom hang:" + matHang.getNhomhang() +",Gia ban" + matHang.getGiaban() +",SoLuong:" + matHang.getSoLuong());
                 }
                 break;
             case 3:
                 System.out.println("Nhap ho ten:");
                 String hoTen =scanner.nextLine();
                 System.out.println("Nhap dia chi:");
                 String diaChi =scanner.nextLine();
                 System.out.println("Nhap so dien thoai:");
                 String soDienThoai =scanner.nextLine();
                 System.out.println("Nhap so ngay ky hop dong:");
                 String ngayKyHopDong =scanner.nextLine();
                 JPopupMenu danhSachNhanVien;
                 danhSachNhanVien.add(new NhanVienBH(hoTen,diaChi, soDienThoai,ngayKyHopDong);
                 break;
             case 4:
                 for (NhanVienBH nv : danhSachNhanVien) {
                     System.out.println("Ma NV:" +nv.getMaNV() + ",Ho ten:" + nv.getHoTen() + ",Ngay KHD" + nv.getNgayKyHD());
                 }
                 break;
             case 5:
                 System.out.println("Nhap ma nhan vien:");
                 int maNhanVien =scanner.nextInt();
                 NhanVienBH nhanvien =  hashCode(nhanVien);
                 for ( int i= 0; i<5; i++){
                     System.out.println("Nhap ma hang:");
                     int maHang =scanner.nextInt();
                     MatHang mathang = danhSachMatHang.stream().reduce()
                 }
                 
         }
     }
    }
}

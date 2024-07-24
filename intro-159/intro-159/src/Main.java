import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Nhập danh sách khách hàng");
            System.out.println("2. In danh sách khách hàng");
            System.out.println("3. Nhập danh sách ngân hàng");
            System.out.println("4. In danh sách ngân hàng");
            System.out.println("5. Nhập danh sách sổ tiết kiệm");
            System.out.println("6. In danh sách sổ tiết kiệm");
            System.out.println("7. Sắp xếp sổ tiết kiệm theo họ tên khách hàng");
            System.out.println("8. Sắp xếp sổ tiết kiệm theo số tiền gửi");
            System.out.println("9. Lập bảng kê tổng số tiền gửi cho mỗi khách hàng");
            System.out.println("0. Thoát");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    nhapDanhSachKhachHang(scanner);
                    break;
                case 2:
                    inDanhSachKhachHang();
                    break;
                case 3:
                    nhapDanhSachNganHang(scanner);
                    break;
                case 4:
                    inDanhSachNganHang();
                    break;
                case 5:
                    nhapDanhSachSoTietKiem(scanner);
                    break;
                case 6:
                    inDanhSachSoTietKiem();
                    break;
                case 7:
                    sapXepSoTietKiemTheoHoTen();
                    break;
                case 8:
                    sapXepSoTietKiemTheoSoTienGui();
                    break;
                case 9:
                    lapBangKeTongSoTienGui();
                    break;
                case 0:
                    saveData();
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
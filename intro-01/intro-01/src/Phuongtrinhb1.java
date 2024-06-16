import java.util.Scanner;
public class Phuongtrinhb1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị của a (a khác 0): ");
        double a = scanner.nextDouble();
        if (a == 0) {
            System.out.println("Giá trị của a không được bằng 0. Vui lòng nhập lại.");
            return;
        }
        System.out.print("Nhập giá trị của b: ");
        double b = scanner.nextDouble();
        double x = -b / a;
        System.out.println("Nghiệm của phương trình " + a + "x + " + b + " = 0 là: x = " + x);
        scanner.close();
    }
}

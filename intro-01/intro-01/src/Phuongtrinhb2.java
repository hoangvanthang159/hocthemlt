import java.util.Scanner;
public class Phuongtrinhb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a;
        while (true) {
            System.out.print("Nhập giá trị a (a khác 0): ");
            a = scanner.nextFloat();
            if (a != 0) {
                break;
            }
            System.out.println("Giá trị của a không được bằng 0.Nhập lại.");
        }
        System.out.print("Nhập giá trị b: ");
        float b = scanner.nextFloat();
        System.out.print("Nhập giá trị c: ");
        float c = scanner.nextFloat();
        float delta = b * b - 4 * a * c;
        if (delta > 0) {
            float x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            float x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            System.out.printf("Phương trình có hai nghiệm phân biệt: x1 = %.2f, x2 = %.2f\n", x1, x2);
        } else if (delta == 0) {
            float x = -b / (2 * a);
            System.out.printf("Phương trình có nghiệm kép: x = %.2f\n", x);
        }
        else {
            System.out.println("Phương trình vô nghiệm.");
        }
        scanner.close();
    }
}

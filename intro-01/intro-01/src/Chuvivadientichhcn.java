import java.util.Scanner;
public class Chuvivadientichhcn {
    public static void main(String[] args) {
        double length, width;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài của hình chữ nhật: ");
        length = scanner.nextDouble();

        System.out.print("Nhập chiều rộng của hình chữ nhật: ");
        width = scanner.nextDouble();
        scanner.close();
        double perimeter = 2 * (length + width);
        double area = length * width;
        System.out.println("Chu vi của hình chữ nhật là: " + perimeter);
        System.out.println("Diện tích của hình chữ nhật là: " + area);
    }
}

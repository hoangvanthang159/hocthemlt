import java.util.Scanner;
public class chuvihinhchunhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài của hình chữ nhật: ");
        double length = scanner.nextDouble();

        System.out.print("Nhập chiều rộng của hình chữ nhật: ");
        double width = scanner.nextDouble();

        double perimeter = 2 * (length + width);
        double area = length * width;


        System.out.println("Chu vi của hình chữ nhật là: " + perimeter);
        System.out.println("Diện tích của hình chữ nhật là: " + area);
        scanner.close();
    }
}

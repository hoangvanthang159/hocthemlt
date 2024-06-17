
import java.util.Scanner;
public class timsolonnhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        double num1 = scanner.nextDouble();

        System.out.print("Nhập số thứ hai: ");
        double num2 = scanner.nextDouble();

        System.out.print("Nhập số thứ ba: ");
        double num3 = scanner.nextDouble();

        System.out.print("Nhập số thứ tư: ");
        double num4 = scanner.nextDouble();


        double max = num1;

        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }
        if (num4 > max) {
            max = num4;
        }


        System.out.println("Số lớn nhất trong bốn số là: " + max);


        scanner.close();
    }
}

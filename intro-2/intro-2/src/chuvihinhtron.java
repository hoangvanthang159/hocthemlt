import java.util.Scanner;
public class chuvihinhtron {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nhập bán kính của hình tròn: ");
        double radius = scanner.nextDouble();

        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;


        System.out.println("Chu vi của hình tròn là: " + circumference);
        System.out.println("Diện tích của hình tròn là: " + area);

        scanner.close();
    }
}

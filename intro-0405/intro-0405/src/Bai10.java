import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> elements = new HashSet<>();
        int n;

        System.out.print("Nhập số n: ");
        n = scanner.nextInt();

        while (elements.size() < n) {
            System.out.print("Nhập một số nguyên: ");
            int num = scanner.nextInt();
            if (elements.contains(num)) {
                System.out.println("Số này đã tồn tại, vui lòng nhập lại.");
            } else {
                elements.add(num);
            }
        }

        System.out.println("Dãy số đã nhập:");
        for (int num : elements) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}

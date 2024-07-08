import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số N: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        Random random = new Random();
        System.out.println("Mảng được tạo ngẫu nhiên:");
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        inSoKhacNhau(array);
    }

    public static void inSoKhacNhau(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();

        for (int num : array) {
            uniqueElements.add(num);
        }

        System.out.println("Các số khác nhau trong dãy là:");
        for (int num : uniqueElements) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

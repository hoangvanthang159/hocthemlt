import java.util.Scanner;
public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số N: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]: ");
            array[i] = scanner.nextInt();
        }

        if (kiemTraMangDoiXung(array)) {
            System.out.println("Mảng là mảng đối xứng.");
        } else {
            System.out.println("Mảng không phải là mảng đối xứng.");
        }
    }

    public static boolean kiemTraMangDoiXung(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

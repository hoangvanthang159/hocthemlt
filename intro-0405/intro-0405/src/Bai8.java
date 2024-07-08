import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Bai8 {
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

        int phanTuXuatHienNhieuNhat = timPhanTuXuatHienNhieuNhat(array);

        System.out.println("Phần tử có số lần xuất hiện nhiều nhất là: " + phanTuXuatHienNhieuNhat);
    }

    public static int timPhanTuXuatHienNhieuNhat(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int mostFrequentElement = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentElement = entry.getKey();
            }
        }

        return mostFrequentElement;
    }
}

import java.util.Arrays;
public class Bai20 {
    public static void findMinMax(int[] arr) {

        Arrays.sort(arr);

        int min = arr[0];


        int max = arr[arr.length - 1];

        System.out.println("Số nhỏ nhất trong mảng là: " + min);
        System.out.println("Số lớn nhất trong mảng là: " + max);
    }

    public static void main(String[] args) {

        int[] a = {23, 56, 12, 89, 9, 45};

        findMinMax(a);
    }
}

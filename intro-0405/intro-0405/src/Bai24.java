import java.util.Arrays;
import java.util.Collections;
public class Bai24 {
    public static void main(String[] args) {
        Integer[] a = {5, 2, 9, 1, 5, 6};

        Arrays.sort(a, Collections.reverseOrder());


        System.out.print("Mảng sau khi sắp xếp giảm dần: ");
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

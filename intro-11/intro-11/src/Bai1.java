public class Bai1 {
    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
    public static void main(String[] args) {
        System.out.println("Các số thuận nghịch có 6 chữ số là:");
        for (int i = 100000; i <= 999999; i++) {
            if (isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }
}

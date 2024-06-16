import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Ngaythangnamsinh {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String input = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(input, formatter);
        scanner.close();
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthday, currentDate).getYears();
        System.out.println("Tuổi của người này là: " + age + " tuổi");
    }
}

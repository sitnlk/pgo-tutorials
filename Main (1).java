import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your city of residence:");
        String city = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        System.out.println("Is it a weekday? (true/false):");
        boolean isWeekday = scanner.nextBoolean();
        double ticketPrice = 40.0;

        if (age < 10 || isWeekday || city.equalsIgnoreCase("Warsaw")) {
            ticketPrice = 0.0;
        } else if (age >= 10 && age <= 18) {
            ticketPrice *= 0.5;
        }

        System.out.println("Data: " + city + ", " + age + " years old, " + (isWeekday ? "weekday" : "weekend"));
        System.out.println("Ticket price: " + ticketPrice + " PLN");

        scanner.close();
    }
}

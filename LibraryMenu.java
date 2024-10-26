import java.util.Scanner;

public class LibraryMenu {
    public void displayMenu() {
        System.out.println("Kutubxona Boshqaruv Tizimi");
        System.out.println("1. Kitob qo'shish");
        System.out.println("2. Kitob olish");
        System.out.println("3. Kitob qaytarish");
        System.out.println("4. Barcha kitoblar");
        System.out.println("5. Logout");
    }

    public int getChoice(Scanner scanner) {
        System.out.print("Tanlang: ");
        while(!scanner.hasNextInt()) {
            System.out.println("Iltimos raqam kiriting");
            scanner.next();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;

    }
}

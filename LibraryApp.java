import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
       var dbService = new DatabaseService();
       var libraryService = new LibraryService(dbService);
       var scanner = new Scanner(System.in);
       var bookService = new BookService(libraryService, scanner);
       var authService = new AuthService(libraryService, scanner);
       var menuHandler = new MenuHandler(authService, bookService, scanner);
       var controller = new LibraryController(authService, bookService, menuHandler);
       controller.start();

    }
}

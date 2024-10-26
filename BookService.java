import java.util.Scanner;

public class BookService {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public BookService(LibraryService libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }

    public void addBook() {
        System.out.println("Kitob nomini kiriting: ");
        String title = scanner.nextLine();
        System.out.println("Kitob yozuvchini nomini kiriting: ");
        String author = scanner.nextLine();
        System.out.println("Kitob ISBN raqamini kiriting: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn);
        libraryService.addBook(book);
        System.out.println("Kitob saqlandi");
    }

    public void borrowBook(User user) {
        if (libraryService.getBooks().isEmpty()){
            System.out.println("Hozir berish uchun kitob mavjud emas");
            return;
        }

        System.out.println("Mavjud kitoblar: ");
        for (Book book : libraryService.getBooks()) {
            if(!book.getIsBorrowed()){
                System.out.println("- " + book.getTitle());
            }
        }

        System.out.println("Olmoqchi bo'lgan kitob nomini kiriting: ");
        String bookTitle = scanner.nextLine();

        Book selectedBook = libraryService.findBookByTitle(bookTitle);

        if(selectedBook !=null && !selectedBook.getIsBorrowed()){
            libraryService.borrowBook(bookTitle, user);

            System.out.println("Siz olgan kitob: " + bookTitle);
        } else if(selectedBook != null && selectedBook.getIsBorrowed()){
            System.out.println("Bu kitob allaqachon olingan");
        } else {
            System.out.println("Bu kitob mavjud emas");
        }
    }


    public void returnBook(User user) {
        if (user.getBorrowedBooks().isEmpty()){
            System.out.println("Siz hali kitob olmagansiz");
            return;
        }

        System.out.println("Siz olgan kitoblar: ");
        for (int i = 0; i < user.getBorrowedBooks().size(); i++) {
            Book book = user.getBorrowedBooks().get(i);
            System.out.println((i+1) + ". " + book.getTitle());
        }

        System.out.println("Qaytarmoqchi bo'lgan kitob raqamini kiriting: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice>0 && choice<=user.getBorrowedBooks().size()){
            Book selectedBook = user.getBorrowedBooks().get(choice-1);
            libraryService.returnBook(selectedBook.getTitle(), user);
            System.out.println("Kitob qaytarildi: " + selectedBook.getTitle());
        } else {
            System.out.println("Bu raqamda kitob mavjud emas");
        }

    }


    public void displayAllBooks() {
        if(libraryService.getBooks().isEmpty()) {
            System.out.println("Hozir kitoblar mavjud emas");
        } else {
            System.out.println("Barcha kitoblar: ");
            for (Book book : libraryService.getBooks()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn() + ", Borrowed: " + book.getIsBorrowed());
            }
        }

    }

}

//! User

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private String password;
    private String role;
    private List<Book> borrowedBooks;


    public User(String userId, String name, String role, String password) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
         borrowedBooks.remove(book);
    }
}

public class Library {
    public void borrowBook(Book book, User user) {
        if(user instanceof Student) {
            System.out.println("Talaba kitobni 14 kunga olib turishi mumkin");
        } {
            System.out.println("Mehmon kitob ololmaydi");
        }

        book.setIsBorrowed(true);
    }
}

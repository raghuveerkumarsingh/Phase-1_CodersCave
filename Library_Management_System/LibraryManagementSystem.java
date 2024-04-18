import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books;
    private List<User> users;
    private List<BorrowingRecord> borrowingRecords;

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.borrowingRecords = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public BorrowingRecord borrowBook(User user, Book book) {
        BorrowingRecord record = new BorrowingRecord(user, book);
        borrowingRecords.add(record);
        return record;
    }

    // Method to get user by ID
    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    // Method to get book by ISBN
    public Book getBookByIsbn(String bookIsbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(bookIsbn)) {
                return book;
            }
        }
        return null;
    }
}

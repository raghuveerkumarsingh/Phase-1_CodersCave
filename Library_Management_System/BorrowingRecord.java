import java.util.Date;

public class BorrowingRecord {
    private User user;
    private Book book;
    private Date borrowDate;
    private Date returnDate;

    public BorrowingRecord(User user, Book book) {
        this.user = user;
        this.book = book;
        this.borrowDate = new Date();
    }

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

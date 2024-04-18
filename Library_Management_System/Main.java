import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding books
        System.out.println("Adding books to the library:");
        addBooksFromUserInput(lms, scanner);

        // Adding users
        System.out.println("\nAdding users to the system:");
        addUsersFromUserInput(lms, scanner);

        // Borrowing books
        System.out.println("\nBorrowing books:");
        borrowBooksFromUserInput(lms, scanner);

        // Displaying books, users, and borrowing records
        System.out.println("\nBooks in the library:");
        displayBooksInTable(lms.getBooks());

        System.out.println("\nUsers in the system:");
        displayUsersInTable(lms.getUsers());

        System.out.println("\nBorrowing Records:");
        displayBorrowingRecordsInTable(lms.getBorrowingRecords());

        scanner.close();
    }

    // Method to add books from user input
    public static void addBooksFromUserInput(LibraryManagementSystem lms, Scanner scanner) {
        System.out.print("Enter the number of books to add: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter details for Book " + (i + 1) + ":");
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            lms.addBook(new Book(title, author, isbn));
        }
    }

    // Method to add users from user input
    public static void addUsersFromUserInput(LibraryManagementSystem lms, Scanner scanner) {
        System.out.print("Enter the number of users to add: ");
        int numUsers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numUsers; i++) {
            System.out.println("Enter details for User " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            lms.addUser(new User(name, id));
        }
    }

    // Method to borrow books from user input
    public static void borrowBooksFromUserInput(LibraryManagementSystem lms, Scanner scanner) {
        System.out.print("Enter the number of borrowing records to create: ");
        int numBorrowings = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numBorrowings; i++) {
            System.out.println("Enter details for Borrowing Record " + (i + 1) + ":");
            System.out.print("Borrower's Name: ");
            String borrowerName = scanner.nextLine();
            System.out.print("User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Book ISBN: ");
            String bookIsbn = scanner.nextLine();
            User user = lms.getUserById(userId);
            Book book = lms.getBookByIsbn(bookIsbn);
            if (user != null && book != null) {
                BorrowingRecord record = lms.borrowBook(user, book);
                if (record != null) {
                    System.out.println("Book \"" + book.getTitle() + "\" borrowed by user \"" + borrowerName + "\".");
                } else {
                    System.out.println("Failed to create borrowing record. Please try again.");
                }
            } else {
                System.out.println("User ID or Book ISBN not found. Skipping borrowing.");
            }
        }
    }

    // Method to display books in table format
    public static void displayBooksInTable(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-25s | %-13s |\n", "Title", "Author", "ISBN");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Book book : books) {
            System.out.printf("| %-30s | %-25s | %-13s |\n", book.getTitle(), book.getAuthor(), book.getIsbn());
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    // Method to display users in table format
    public static void displayUsersInTable(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-10s |\n", "Name", "ID");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (User user : users) {
            System.out.printf("| %-20s | %-10s |\n", user.getName(), user.getId());
        }
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    // Method to display borrowing records in table format
    public static void displayBorrowingRecordsInTable(List<BorrowingRecord> records) {
        if (records.isEmpty()) {
            System.out.println("No borrowing records available.");
            return;
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-30s | %-15s |\n", "Borrower", "Book", "Borrow Date");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (BorrowingRecord record : records) {
            System.out.printf("| %-20s | %-30s | %-15s |\n", record.getUser().getName(),
                    record.getBook().getTitle(), record.getBorrowDate());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
}

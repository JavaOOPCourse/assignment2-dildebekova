import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(10);

        while (true) {
            System.out.println("\n📚 Library Management System");
            System.out.println("1. Add book");
            System.out.println("2. Add e-book");
            System.out.println("3. Display all books");
            System.out.println("4. Search book by title");
            System.out.println("5. Borrow book");
            System.out.println("6. Return book");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();

                    library.addBook(new Book(title, author, year));
                }

                case 2 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("File size (MB): ");
                    double size = scanner.nextDouble();

                    library.addBook(new EBook(title, author, year, size));
                }

                case 3 -> library.displayBooks();

                case 4 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Book book = library.searchByTitle(title);
                    System.out.println(book != null ? book : "❌ Book not found.");
                }

                case 5 -> {
                    System.out.print("Enter title: ");
                    library.borrowBook(scanner.nextLine());
                }

                case 6 -> {
                    System.out.print("Enter title: ");
                    library.returnBook(scanner.nextLine());
                }

                case 7 -> {
                    System.out.println("👋 Goodbye!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}

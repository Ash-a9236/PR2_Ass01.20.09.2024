package ash_a9236.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


    /*
        public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Student");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Students");
            System.out.println("6. Display Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Available Copies: ");
                    int availableCopies = Integer.parseInt(scanner.nextLine());
                    lms.addBook(bookId, title, author, availableCopies);
                    break;

                case "2":
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    String rollNumber = scanner.nextLine();
                    lms.addStudent(name, rollNumber);
                    break;

                case "3":
                    System.out.print("Enter Student Roll Number: ");
                    String borrowRollNumber = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String borrowBookId = scanner.nextLine();
                    lms.borrowBook(borrowRollNumber, borrowBookId);
                    break;

                case "4":
                    System.out.print("Enter Student Roll Number: ");
                    String returnRollNumber = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String returnBookId = scanner.nextLine();
                    lms.returnBook(returnRollNumber, returnBookId);
                    break;

                case "5":
                    lms.displayStudents();
                    break;

                case "6":
                    lms.displayBooks();
                    break;

                case "7":
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("7"));

        scanner.close();
    }
     */




    }
}
package ash_a9236.example;

import java.util.Scanner;

/*/
TO DO
#3 is not working (student ID or Book ID is declared as null or smthing
 */

public class Main {
    public static void main(String[] args) {
        LibraryManagmentSystem lms = new LibraryManagmentSystem();
        Scanner scanner = new Scanner(System.in);
        String userAns;

        do {

            System.out.println("_________________________________________________________________");
            System.out.println("         Welcome to the Library Management System!");
            System.out.println("1. Add Book");
            System.out.println("2. Add Student");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Students");
            System.out.println("6. Display Books");
            System.out.println("7. Exit");
            System.out.println("Enter your choice : ");
            System.out.println("_________________________________________________________________\n");

            userAns = scanner.nextLine();

            switch (userAns) {
                case "1":
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Available Copies: ");
                    int availableCopies = Integer.parseInt(scanner.nextLine());
                    lms.addBook(title, author, availableCopies);
                    break;

                case "2":
                    lms.addStudent();
                    break;

                case "3":
                    System.out.print("Enter Student Roll Number : ");
                    int borrowRollNumber = scanner.nextInt();
                    String extraLine = scanner.nextLine();
                    System.out.print("Enter Book ID : ");
                    String borrowBookId = scanner.nextLine();
                    lms.borrowBook(borrowRollNumber, borrowBookId);
                    break;

                case "4":
                    System.out.print("Enter Student Roll Number : ");
                    int returnRollNumber = scanner.nextInt();
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
        } while (!userAns.equals("7"));
    }
}

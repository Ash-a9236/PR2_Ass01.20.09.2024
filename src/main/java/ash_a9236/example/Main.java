package ash_a9236.example;

import java.util.Scanner;


/*______________________________________________________________________________________________________________________

Assignment 01
Written by Helene Rousseau, 6229734
For Programming 2 Section 00002 - Fall 2024

_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
Explanation :

This programs creates a library management system where you can add a student or a book to the system, and make
student borrow and return books.
To get identified in the system, students have a unique ID called rollNumber while books have a unique random ID
called bookID.
The programs verifies if a student is able to borrow books, and updates the number of available copies depending on
how many students had borrowed the same book.

______________________________________________________________________________________________________________________*/



public class Main {
    public static void main(String[] args) {
        //Base for the code, creation of the lms as well as the UI
        LibraryManagmentSystem lms = new LibraryManagmentSystem();
        Scanner scanner = new Scanner(System.in);
        String userAns;
        boolean isFirstPass = true;

        //The main loop which goes through all of the cases and tells which method to call and when to exit
        do {
            if (isFirstPass) {
                System.out.println("_________________________________________________________________");
                System.out.println("         Welcome to the Library Management System!\n");
                System.out.println("    1. Add Book                         4. Return Book");
                System.out.println("    2. Add Student                      5. Display Students");
                System.out.println("    3. Borrow Book                      6. Display Books");
                System.out.println("                        7. Exit");
                System.out.println("_________________________________________________________________\n");
                isFirstPass = false;
            } else {
                // Display the smaller menu for subsequent choices
                System.out.println("            Choose another option:");
                System.out.println("1. Add Book                         4. Return Book");
                System.out.println("2. Add Student                      5. Display Students");
                System.out.println("3. Borrow Book                      6. Display Books");
                System.out.println("                        7. Exit");
                System.out.print("_________________________________________________________________\n");
            }

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
                    String extraLine2 = scanner.nextLine();
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

            // Prompt to continue or exit
            if (!userAns.equals("7")) {
                System.out.println("\nDo you want to continue? \nPress 0 to continue, 7 to exit: ");
                userAns = scanner.nextLine();
                if (userAns.equals("7")) {
                    break;
                }
            }

        } while (!userAns.equals("7"));
    }
}

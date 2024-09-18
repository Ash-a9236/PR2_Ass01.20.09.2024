package ash_a9236.example;

public class Information {

/*
MAIN : INTRODUCTION

TOP :
/______________________________________________________________________________________________________________________

Assignment 01
Written by Helene Rousseau, 6229734
For Programming 2 Section 00002 - Fall 2024

_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
Explanation :
- In a comment, give a general explanation of what your program does. As the programming
questions get more complex, the explanations will get lengthier.
- Include comments in your program describing the main steps in your program.


______________________________________________________________________________________________________________________/

OTHER :
    Display a welcome message.
        - Display clear prompts for users when you are expecting the user to enter data from the keyboard.
        - All output should be displayed with clear messages and in an easy to read format.
        - End your program with a closing message so that the user knows that the program has terminated.


*/


//CLASSES

/*______________________________________________________________________________________________________________________

MAIN____________________________________________________________________________________________________________________
o Implement a menu-driven program to add books, add students, borrow and return books, and display the list of students
with their borrowed books. See the sample menu.

o Use two ArrayLists in the main program:An ArrayList to store the collection of books in the library and an ArrayList
to store the list of students.

o Add a new book: Prompt the user to enter the book's details and add it to a collection of books.

o Add a new student: Prompt the user to enter the student's details and add them to a collection of students.

o Borrow a book: A student can borrow a book if it is available in the library (i.e. copies are available). After
borrowing, the number of available copies should decrease, and the book should be added to the student's list of
borrowed books.

o Return a book: A student can return a borrowed book. The number of available copies of the book should increase, and
the book should be removed from the student's list of borrowed books.

o Display all students and their borrowed books: Show the list of all students and the books they have borrowed.



BOOK____________________________________________________________________________________________________________________
o Book ID (unique identifier)
o Title
o Author
o Number of available copies

- addBook()
- borrowedBooks()
- isAvailable()




STUDENT_________________________________________________________________________________________________________________
o Name
o Roll number (unique identifier)
o List of borrowed books (use an ArrayList to store books borrowed by the student)

- addStudent()
        Prompt the user to enter the student's details and add them to a collection of students
- borrowBook()
        A student can borrow a book if it is available in the library (i.e. copies are available). After borrowing,
        the number of available copies should decrease, and the book should be added to the student's list of borrowed
        books.

        * A student cannot borrow more than 3 books at the same time
        * When a student borrows or returns a book, ensure that the state of the system is updated (number of copies
        available, borrowed books list, etc.)
- returnBook()
        A student can return a borrowed book. The number of available copies of the book should increase, and the book
        should be removed from the student's list of borrowed books.

        * When a student borrows or returns a book, ensure that the state of the system is updated (number of copies
        available, borrowed books list, etc.)

REQUIREMENTS____________________________________________________________________________________________________________
o A student cannot borrow more than 3 books at the same time.

o Ensure that the student cannot borrow the same book more than once.

o Handle invalid scenarios gracefully (e.g., trying to borrow a book that is out of stock or return a book that
wasn't borrowed).

o When a student borrows or returns a book, ensure that the state of the system is updated (number of copies available,
borrowed books list, etc.).

o Enforce the limit of 3 books per student.

o Your class should have a reasonable set of accessor and mutator methods, constructors, equals method, and toString
method, whether or not your program uses them. You can add other methods if you wish.


________________________________________________________________________________________________________________________
import java.util.ArrayList;
import java.util.Scanner;

// Book class to represent a book in the library
class Book {
    private String id;
    private String title;
    private String author;
    private int availableCopies;

    public Book(String id, String title, String author, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
        } else {
            System.out.println("No copies available.");
        }
    }

    public void returnBook() {
        availableCopies++;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Available Copies: " + availableCopies;
    }
}

// Student class to represent a student
class Student {
    private String name;
    private String rollNumber;
    private ArrayList<Book> borrowedBooks;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 3 && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println("Successfully borrowed: " + book.getTitle());
        } else {
            System.out.println("Cannot borrow this book.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println("Successfully returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Roll Number: " + rollNumber + ", Borrowed Books: " + borrowedBooks.size();
    }
}

// Main class to run the program
public class LibraryManagementSystem {
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(String id, String title, String author, int availableCopies) {
        books.add(new Book(id, title, author, availableCopies));
        System.out.println("Book added successfully.");
    }

    public void addStudent(String name, String rollNumber) {
        students.add(new Student(name, rollNumber));
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void borrowBook(String rollNumber, String bookId) {
        Student student = findStudent(rollNumber);
        Book book = findBook(bookId);
        if (student != null && book != null) {
            student.borrowBook(book);
        } else {
            System.out.println("Invalid student or book ID.");
        }
    }

    public void returnBook(String rollNumber, String bookId) {
        Student student = findStudent(rollNumber);
        Book book = findBook(bookId);
        if (student != null && book != null) {
            student.returnBook(book);
        } else {
            System.out.println("Invalid student or book ID.");
        }
    }

    private Student findStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    private Book findBook(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

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
}


*/




}

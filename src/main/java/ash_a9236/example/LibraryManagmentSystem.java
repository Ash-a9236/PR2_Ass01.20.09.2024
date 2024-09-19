package ash_a9236.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LibraryManagmentSystem {
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public LibraryManagmentSystem() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    private Student findStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void addStudent() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please input the student roll number");
        int rollNumber = console.nextInt();

        if (findStudent(rollNumber) == null) {
            System.out.println("Input the student's full name : ");
            String name = console.nextLine();
            students.add(new Student(name, rollNumber));
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student No " + rollNumber + " already exists in the system");
        }
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (title.equalsIgnoreCase(book.getTitle())) {
//                System.out.println(book);
                return book;
            }
        }
        return null;
    }

    public void addBook(String title, String author, int availableCopies) {
        Scanner console = new Scanner(System.in);
        String ans = "";

        if (findBook(title) == null) {
            books.add(new Book(title, author, availableCopies));
            System.out.println("Book added to system successfully.");
        } else {
            System.out.println("The book you want to add seems to already be in the system..." +
                    "\nIs this the book you want to add? \n" + findBook(title) + "Answer with yes or no");
            ans = console.nextLine();

            if (ans.toLowerCase().equals("no")) {
                books.add(new Book(title, author, availableCopies));
                System.out.println("Book added to system successfully.");
            } else {
                String addCopiesBook = findBook(title).getBookID();
                System.out.println("How many copies do you wish to add?");
                int newCopies = console.nextInt();

                for (Book book : books) {
                    if (book.getBookID().equals(addCopiesBook)) {
                        book.setAvailableCopies(book.getAvailableCopies() + newCopies);
                    }
                }
                System.out.println("New available copy added succefully!\nThere are now "
                        + findBook(title).getAvailableCopies() + " copies available.");
            }
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void borrowBook(int rollNumber, String bookId) {
        Student student = findStudent(rollNumber);
        Book book = findBook(bookId);
        if (student != null && book != null) {
            student.borrowBook(book);
        } else {
            System.out.println("Invalid student or book ID.");
        }
    }

    public void returnBook(int rollNumber, String bookId) {
        Student student = findStudent(rollNumber);
        Book book = findBook(bookId);
        if (student != null && book != null) {
            student.returnBook(book);
        } else {
            System.out.println("Invalid student or book ID.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryManagmentSystem that = (LibraryManagmentSystem) o;
        return Objects.equals(books, that.books) && Objects.equals(students, that.students);
    }
}

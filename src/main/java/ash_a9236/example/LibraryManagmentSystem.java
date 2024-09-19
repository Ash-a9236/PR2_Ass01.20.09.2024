package ash_a9236.example;

import java.util.ArrayList;
import java.util.Objects;

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

    public void addStudent(String name, int rollNumber) {
        students.add(new Student(name, rollNumber));
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private Book findBook(String bookId) {
        for (Book book : books) {
            if (book.getBookID().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(String title, String author, int availableCopies) {
        books.add(new Book(title, author, availableCopies));
        System.out.println("Book added successfully.");
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

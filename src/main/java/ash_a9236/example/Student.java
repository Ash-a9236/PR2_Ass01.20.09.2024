package ash_a9236.example;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private String name;
    private int rollNumber;
    private ArrayList<Book> borrowedBooks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Adds a book to a student borrowed books
     * @param book the book to borrow
     */
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 3 && book.getAvailableCopies() > 0 && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println("Book borrowed : " + book.getTitle() + " BY " + book.getAuthor());
        } else if(borrowedBooks.size() == 3){
            System.out.println("You already have 3 books borrowed. Return one to borrow " + book.getTitle()
                    + " by " + book.getAuthor());
        } else if(book.getAvailableCopies() == 0) {
            System.out.println("No copies available at the moment for " + book.getTitle() + " BY " + book.getAuthor());
        } else if(borrowedBooks.contains(book)) {
            System.out.println("You have already borrowed " + book.getTitle() + " BY " + book.getAuthor());
        }
    }

    /**
     * returns a book from a student to the system
     * @param book the book to return
     */
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println("Successfully returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    public void printBorrowedBooks(ArrayList<Book> borrowedBooks) {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println("- " + borrowedBooks.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ").append(rollNumber)
                .append("\nName: ").append(name)
                .append("\nBooks borrowed:\n");

        // Call printBorrowedBooks to print the borrowed books
        if (borrowedBooks.isEmpty()) {
            sb.append("No books borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                sb.append("_").append(book);
            }
        }

        return sb.toString(); // Return the string representation
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber && Objects.equals(name, student.name) &&
                Objects.equals(borrowedBooks, student.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNumber, borrowedBooks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}

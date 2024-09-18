package ash_a9236.example;

import java.util.ArrayList;

public class Student {
    private String name;
    private int rollNumber;
    private ArrayList<Book> borrowedBooks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 3 && book.getAvailableCopies() > 0) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println("Book borrowed : " + book.getTitle() + " by " + book.getAuthor());
        } else if(borrowedBooks.size() == 3){
            System.out.println("You already have 3 books borrowed. Return one to borrow " + book.getTitle()
                    + " by " + book.getAuthor());
        } else if(book.getAvailableCopies() == 0) {
            System.out.println("No copies available at the moment for " + book.getTitle() + " by " + book.getAuthor());
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

    @Override
    public String toString() {
        return "Student " + + rollNumber +
                "\nName : " + name + '\'' +
                "Books borrowed : " + borrowedBooks;
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


    /*
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


class Student {
    private String name;
    private String rollNumber;
    private ArrayList<Book> borrowedBooks;


    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Roll Number: " + rollNumber + ", Borrowed Books: " + borrowedBooks.size();
    }
}




 */
}

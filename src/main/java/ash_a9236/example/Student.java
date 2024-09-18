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
        if (borrowedBooks.size() < 3 && book.getAvailableCopies() > 0 && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println("Book borrowed : " + book.getTitle() + " by " + book.getAuthor());
        } else if(borrowedBooks.size() == 3){
            System.out.println("You already have 3 books borrowed. Return one to borrow " + book.getTitle()
                    + " by " + book.getAuthor());
        } else if(book.getAvailableCopies() == 0) {
            System.out.println("No copies available at the moment for " + book.getTitle() + " by " + book.getAuthor());
        } else if(borrowedBooks.contains(book)) {
            System.out.println("You have already borrowed " + book.getTitle() + " by " + book.getAuthor());
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
}

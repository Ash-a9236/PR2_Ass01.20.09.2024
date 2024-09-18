package ash_a9236.example;

import java.util.Objects;

public class Book {

    public static int count = 0;
    private final int bookID;
    private final String title;
    private final String author;
    private int availableCopies;

    public Book(int availableCopies, String author, String title, int bookID) {
        this.availableCopies = availableCopies;
        this.author = author;
        this.title = title;
        this.bookID = count++;
    }

    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            System.out.println("Book borrowed.");
        } else {
            System.out.println("No copies available at the moment.");
        }
    }

    public void returnBook() {
        availableCopies++;
        System.out.println("Book returned.");
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }

    public int getBookID() {
        return bookID;
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

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "Book" + bookID +
                "\nTitle : " + title + '\'' +
                "Author : " + author + '\'' +
                "AvailableCopies : " + availableCopies + " available copies";
    }
}

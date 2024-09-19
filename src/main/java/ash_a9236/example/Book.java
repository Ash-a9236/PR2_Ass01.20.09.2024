package ash_a9236.example;

import java.util.Objects;

public class Book {

    public static int count = 0;
    private final String bookID;
    private final String title;
    private final String author;
    private int availableCopies;

    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookID = "" + count++;
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

    public String getBookID() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return availableCopies == book.availableCopies && Objects.equals(bookID, book.bookID) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, title, author, availableCopies);
    }

    @Override
    public String toString() {
        return "Book" + bookID +
                "\nTitle : " + title + '\'' +
                "Author : " + author + '\'' +
                "AvailableCopies : " + availableCopies + " available copies";
    }
}

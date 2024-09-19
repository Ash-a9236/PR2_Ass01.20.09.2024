package ash_a9236.example;

import java.util.Objects;
import java.util.Random;

public class Book {

    public static int count = 1;
    private final String bookID;
    private final String title;
    private final String author;
    private int availableCopies;

    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookID = title.substring(0, 3).toUpperCase() + createRandId() + count++;
    }

    /**
     * Creates a random int between 100 and 999 to create a unique ID for a book
     * @return a random number between 100 and 999
     */
    public int createRandId() {
        Random rand = new Random();
        int randNum = rand.nextInt(100, 1000);
        return randNum;
    }

    /**
     * checks if a book can be borrowed through the number of available copies and removes a copy from the system if
     * it is borrowed
     */
    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            System.out.println("Book borrowed.");
        } else {
            System.out.println("No copies available at the moment.");
        }
    }

    /**
     * returns a book through the system by updating the number of copies to +1
     */
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
        return "Book " + bookID +
                "\nTitle : " + title +
                "\nAuthor : " + author +
                "\nAvailableCopies : " + availableCopies + " available copies";
    }
}

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




*/




}

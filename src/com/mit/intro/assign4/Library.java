package com.mit.intro.assign4;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // Add the missing implementation to this class
    private static String OPENING_HOURS = "from 9am to 5pm";

    private String address;

    private List<Book> books;

    public Library(String address) {
        this.address = address;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void borrowBook(String bookTitle) {
        boolean hasBookFlag = false;
        for (Book book : this.books) {
            if (book != null && book.getTitle().equals(bookTitle)) {
                hasBookFlag = true;
                if (!book.isBorrowed()) {
                    book.borrowed();
                    System.out.println("You successfully borrowed " + bookTitle);
                    return;
                }
            }
        }
        if (hasBookFlag) {
            System.out.println("Sorry, this book is already borrowed.");
        } else {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public void printAvailableBooks() {
        boolean hasAvailableBooks = false;
        for (Book book : this.books) {
            if (book != null && !book.isBorrowed()) {
                hasAvailableBooks = true;
                System.out.println(book.getTitle());
            }
        }
        if (!hasAvailableBooks) {
            System.out.println("No book in catalog");
        }
    }

    public void returnBook(String bookTitle) {
        boolean hasBookFlag = false;
        for (Book book : this.books) {
            if (book != null && book.getTitle().equals(bookTitle)) {
                hasBookFlag = true;
                if (book.isBorrowed()) {
                    book.returned();
                    System.out.println("You successfully returned " + bookTitle);
                    return;
                }
            }
        }
        if (hasBookFlag) {
            System.out.println("Sorry, this book is already returned.");
        } else {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily " + OPENING_HOURS + ".");
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

}

package mylab.library.entity;

import workshop.book.entity.Magazine;
import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
        this.books = new ArrayList<>(); // 빈 도서 목록 초기화
	}
	public String getName() {
	}
	public void addBook(Book book) {
		if (book != null) {
	        books.add(book);
	    }
	}
	
	public Book findBookByTitle(String title) {
	}
	public List<Book> findBooksByAuthor(String author) {
	}
	public Book findBookByISBN(String isbn) {
	}
	
	public boolean checkOutBook(String isbn) {
	}
	public boolean returnBook(String isbn) {
	}
	
	public List<Book> getAvailableBooks() {
	}
	public List<Book> getAllBooks() {
	}
	public int getTotalBooks() {
	}
	
	public int getAvailableBooksCount() {
	}
	public int getBorrowedBooksCount() {
	}
}
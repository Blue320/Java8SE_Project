package study.library.entity;

import study.library.entity.Book.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
	private List<Book> books;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
	}
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (title.equals(book.getTitle())) {
				return book;
			}
		}
		return null;
	}
	public List<Book> findBooksByAuthor(String author) {
		List<Book> authorBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (author.equals(book.getAuthor())) {
				authorBooks.add(book);
			}
		}
		return authorBooks;
	}
	
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (isbn.equals(book.getIsbn())) {
				return book;
			}
		}
		return null;
	}
	public void checkOutBook(String isbn) {
		for (Book book : books) {
			if (isbn.equals(book.getIsbn())) {
				book.setAvailable(false);
				System.out.println("도서 대출 성공!");
				System.out.println("대출된 도서 정보:");
				System.out.println(book.toString());
			}
		}
	}
	public void returnBook(String isbn) {
		for (Book book : books) {
			if (isbn.equals(book.getIsbn())) {
				book.setAvailable(true);
				System.out.println("도서 반납 성공!");
				System.out.println("반납된 도서 정보:");
				System.out.println(book.toString());
			}
		}
	}
	public List<Book> getAvailableBooks() {
		List<Book> availBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getAvailable()) {
				availBooks.add(book);
			}
		}
		return availBooks;
	}
	public List<Book> getAllBooks() {
		return books;
	}
	public int getTotalBooks() {
		return books.size();
	}
	public int getAvailableBooksCount() {
		return getAvailableBooks().size();
	}
	public int getBorrowedBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}
}

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
		return name;
	}
	public void addBook(Book book) {
		if (book != null) {
	        books.add(book);
	        System.out.println("도서가 추가되었습니다: " + book.getTitle());
	    }
	}
	
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}
	
	//한 저자가 쓴 책이 여러 권일 수도 있으므로, 변환 타입을 List<Book>으로 지정
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(author)) {
				result.add(book);
			}
		}
		return result;
	}
	
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equalsIgnoreCase(isbn)) {
				return book;
			}
		}
		return null;
	}
	
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		
		if (book == null) {
			return false;
		}
		else {
			return book.checkOut();
		}
	}
	
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book == null || book.isAvailable()) {
			return false;
		}
		else {
			book.returnBook();
			return true;
		}
	}
	
	public List<Book> getAvailableBooks() {
		List<Book> available = new ArrayList<>();
		
		for (Book book : books) {
			if (book.isAvailable()) {
				available.add(book);
			}
		}
		return available;
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
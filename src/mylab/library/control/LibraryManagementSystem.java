package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {
	//도서관 객체를 생성하고 도서를 추가하여 각종 기능을 테스트하는 메서드
	public static void main(String[] args) {
	}
	//샘플 도서 추가, 도서관 정보 출력
	public static void addSampleBooks(library Library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}
	//각 기능 테스트
	public static void testFindBook(library Library) {
	}
	public static void testCheckOut(library Library) {
	}
	public static void testReturn(library Library) {
	}
	//대출 가능한 도서 목록을 출력
	public static void displayAvailableBooks(library Library) {
	}
}

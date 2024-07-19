package logichandle;

import entity.Book;

import java.util.Scanner;

public class BookLogicHandle {

    private final Book[] books = new Book[1000];// đống sách trong thư viện

    public int getBooksLength() {
        return books.length;
    }

    public void printBooks() {
//        for (int i = 0; i < books.length; i++) {
//            if (books[i] != null) {
//                System.out.println(books[i]);
//            }
//        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                continue;
            }
            System.out.println(books[i]);
        }
    }

    public void inputNewBook() {
        System.out.print("Nhập số lượng đầu sách muốn thêm moi: ");
        int bookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < bookNumber; i++) {
            // nhập thông tin cho từng đầu sách và lưu vào mảng books
            System.out.println("Nhập thông tin cho đầu sách thứ " + (i + 1));

            // nập thông tin cho từng đầu sách
            Book book = new Book();
            book.inputInfo();

            // lưu vào mảng books
            saveBook(book);
        }
    }

    public void saveBook(Book book) {
        for (int j = 0; j < books.length; j++) {
            if (books[j] == null) {
                books[j] = book;
                break;
            }
        }
    }

    public boolean checkCoSachHayChua() {
        boolean coSachHayChua = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                coSachHayChua = true;
                break;
            }
        }
        return coSachHayChua;
    }

    public Book searchBookById(int bookId) {
        for (int k = 0; k < books.length; k++) {
            if (books[k] != null && bookId == books[k].getId()) {
                return books[k];
            }
        }
        return null;
    }

}

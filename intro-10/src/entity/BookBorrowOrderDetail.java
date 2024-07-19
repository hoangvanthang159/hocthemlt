package entity;

public class BookBorrowOrderDetail {

    private Book book;
    private int quantity;

    public BookBorrowOrderDetail(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "entity.BookBorrowOrderDetail{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}

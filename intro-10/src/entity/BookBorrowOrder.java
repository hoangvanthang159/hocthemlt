package entity;

import java.util.Arrays;

public class BookBorrowOrder {

    private Reader reader;
    private BookBorrowOrderDetail[] details;
    private int tongSoSach;

    public BookBorrowOrder(Reader reader, BookBorrowOrderDetail[] details) {
        this.reader = reader;
        this.details = details;
    }

    public BookBorrowOrder(Reader reader, BookBorrowOrderDetail[] details, int tongSoSach) {
        this.reader = reader;
        this.details = details;
        this.tongSoSach = tongSoSach;
    }

    /**
     * reader = A
     * details= [
     * {book = Lập trình Java, quantity = 2},
     * {book = Anh hùng xạ điêu, quantity = 5},
     * ]
     */


    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public BookBorrowOrderDetail[] getDetails() {
        return details;
    }

    public void setDetails(BookBorrowOrderDetail[] details) {
        this.details = details;
    }

    public int getTongSoSach() {
        return tongSoSach;
    }

    public void setTongSoSach(int tongSoSach) {
        this.tongSoSach = tongSoSach;
    }

    public int getTotalQuantity() {
        int total = 0;
        for (BookBorrowOrderDetail detail : details) {
            total += detail.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        return "entity.BookBorrowOrder{" +
                "reader=" + reader +
                ", details=" + Arrays.toString(details) +
                '}';
    }
}

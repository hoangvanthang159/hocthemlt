package entity;

import constant.BookSpecialist;

import java.util.Scanner;

public class Book {

    private static int AUTO_ID = 10000;

    private int id;
    private String name;
    private String author;
    private BookSpecialist bookSpecialist;
    private int publishedYear;

    public Book() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookSpecialist getBookSpecialist() {
        return bookSpecialist;
    }

    public void setBookSpecialist(BookSpecialist bookSpecialist) {
        this.bookSpecialist = bookSpecialist;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "entity.Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookSpecialist=" + bookSpecialist.getValue() +
                ", publishedYear=" + publishedYear +
                '}';
    }

    public void inputInfo() {
        System.out.println("Nhập tên sách: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập tác giả của sách: ");
        this.setAuthor(new Scanner(System.in).nextLine());
        System.out.println("Nhập năm xuất bản của sách: ");
        this.setPublishedYear(new Scanner(System.in).nextInt());
        System.out.println("Lựa chọn chuyên ngành của sách:");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Văn học – Nghệ thuật");
        System.out.println("3. Điện tử Viễn thông");
        System.out.println("4. Công nghệ thông tin");
        int specialist;
        while (true) {
            specialist = new Scanner(System.in).nextInt();
            if (specialist >= 1 && specialist <= 4) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        }
        switch (specialist) {
            case 1:
                this.setBookSpecialist(BookSpecialist.KHTN);
                break;
            case 2:
                this.setBookSpecialist(BookSpecialist.VHNT);
                break;
            case 3:
                this.setBookSpecialist(BookSpecialist.DTVT);
                break;
            case 4:
                this.setBookSpecialist(BookSpecialist.CNTT);
                break;
        }
    }

}

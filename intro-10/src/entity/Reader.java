package entity;

import constant.ReaderType;

import java.util.Scanner;

public class Reader extends Person {

    private static int AUTO_ID = 10000;

    private int id;
    private ReaderType readerType;

    public Reader() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    @Override
    public String toString() {
        return "entity.Reader{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", readerType=" + readerType.getValue() +
                ", id=" + id +
                '}';
    }

    public void inputInfo() {
        super.inputInfo();
        System.out.println("Chọn loại bạn đọc");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giảng viên");
        int type;
        while (true) {
            type = new Scanner(System.in).nextInt();
            if (type >= 1 && type <= 3) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        }
        switch (type) {
            case 1:
                this.setReaderType(ReaderType.STUDENT);
                break;
            case 2:
                this.setReaderType(ReaderType.POST_STUDENT);
                break;
            case 3:
                this.setReaderType(ReaderType.TEACHER);
                break;

        }
    }

}

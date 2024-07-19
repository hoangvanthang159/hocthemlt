package entity;

import java.util.Scanner;

public class Person {

    protected String name;
    protected String address;
    protected String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void inputInfo() {
        System.out.print("Nhập họ và tên: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chi: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập SDT: ");
        this.setPhone(new Scanner(System.in).nextLine());
    }

}

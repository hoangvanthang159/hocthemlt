package constant;

public enum BookSpecialist {

    KHTN("Khoa học tự nhiên"),
    VHNT("Văn học nghệ thuật"),
    DTVT("Điện tử viễn thông"),
    CNTT("Công nghệ thông tin");

    public String value;

    public String getValue() {
        return value;
    }

    BookSpecialist(String value) {
        this.value = value;
    }
}

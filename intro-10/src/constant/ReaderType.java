package constant;

public enum ReaderType {
    STUDENT("Sinh viên"),
    POST_STUDENT("Học viên cao học"),
    TEACHER("Giảng viên");

    public String value;

    public String getValue() {
        return value;
    }

    ReaderType(String value) {
        this.value = value;
    }
}

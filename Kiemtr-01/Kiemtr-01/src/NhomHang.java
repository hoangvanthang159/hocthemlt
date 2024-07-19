public enum NhomHang {
    DT("DIENTU"),
    DL("DIENLANH"),
    MT("MAYTINH"),
    TBVP("THIETBIVANPHONG");

    public String value;

    public String getValue() {
        return value;
    }

    NhomHang(String value) {
        this.value = value;
    }
}



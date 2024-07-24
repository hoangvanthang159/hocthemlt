public enum BankType {
    CN( " CA_NHAN"),
    TT(" TAP_THE"),
    DN(" DOANH_NGHIEP");

    public String value;

    public String getValue() {
        return value;
    }

    BankType(String value) {
        this.value = value;
    }
}

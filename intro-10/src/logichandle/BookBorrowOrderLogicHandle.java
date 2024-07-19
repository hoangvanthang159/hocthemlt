package logichandle;

import entity.Book;
import entity.BookBorrowOrder;
import entity.BookBorrowOrderDetail;
import entity.Reader;

import java.util.Scanner;

public class BookBorrowOrderLogicHandle {

    private final BookBorrowOrder[] orders = new BookBorrowOrder[1000];// danh sách lượt mượn sách

    // Dependency injection
    private final BookLogicHandle bookLogicHandle;
    private final ReaderLogicHandle readerLogicHandle;

    public BookBorrowOrderLogicHandle(BookLogicHandle bookLogicHandle, ReaderLogicHandle readerLogicHandle) {
        this.bookLogicHandle = bookLogicHandle;
        this.readerLogicHandle = readerLogicHandle;
    }

    public void printBookBorrowOrders() {
//        for (int i = 0; i < orders.length; i++) {
//            if (orders[i] == null) {
//                continue;
//            }
//            System.out.println(orders[i]);
//        }

        for (BookBorrowOrder order : orders) {
            if (order == null) {
                continue;
            }
            System.out.println(order);
        }
    }

    public void createBookBorrowOrders() {
        /**
         * có 1 loạt các bạn đọc đang xếp hàng chờ muượn sách,
         * trên tay mỗi bạn có 1 vài cuốn sách
         *
         * Bạn là thủ thư, làm việc LẦN LƯỢT với từng bạn đọc và hỏi các thông tin sau:
         * - Bạn là ai?
         * - Bạn mượn các dau sách nào?
         * - Từng đầu sách bạn mượn bao nhiêu cuốn?
         *
         *
         * Hỏi xong -> tạo phiếu mượn sách -> lưu phiếu vao hệ thống
         *
         */


        // kiểm tra xem thư viện có bạn đọc và sách chưa?
        boolean coBanDocHayChua = readerLogicHandle.checkCoBanDocHayChua();
        boolean coSachHayChua = bookLogicHandle.checkCoSachHayChua();

        if (!coBanDocHayChua || !coSachHayChua) {
            System.out.println("Chưa có đủ dữ liệu về bạn đọc và/hoặc sách để thực hiện mượn. " +
                    "Vui lòng nhập thông tin của bạn đọc và sách trước khi mượn");
            return;
        }


        System.out.print("Có bao nhiêu bạn đọc đang cần mượn sách: ");
        int readerNumber;
        while (true) {
            readerNumber = new Scanner(System.in).nextInt();
            if (readerNumber > 0 && readerNumber <= readerLogicHandle.getReadersLength()) {
                break;
            }
            System.out.println("Số lượng bạn đọc không hợp lệ, vui lòng nhập lại: ");
        }
        for (int i = 0; i < readerNumber; i++) {
            // voi từng bạn đọc, hỏi 3 câu trên
            System.out.println("Nhập thông tin id của bạn đoc thứ " + (i + 1) + ": ");

            Reader reader = truyVanBanDoc();

            BookBorrowOrderDetail[] details = khaiBaoThongTinSachMuon();
            int total = 0;
            for (BookBorrowOrderDetail detail : details) {
                total += detail.getQuantity();
            }
//            BookBorrowOrder order = new BookBorrowOrder(reader, details); // lượt mượn sách - phiếu mượn sách
            BookBorrowOrder order = new BookBorrowOrder(reader, details, total); // lượt mượn sách - phiếu mượn sách
            // lưu vào danh sách các lượt mượn
            saveOrder(order);
        }
    }

    public void saveOrder(BookBorrowOrder order) {
        for (int j = 0; j < orders.length; j++) {
            if (orders[j] != null) {
                continue;
            }
            orders[j] = order;
            break;
        }
    }

    public BookBorrowOrderDetail[] khaiBaoThongTinSachMuon() {
        System.out.println("Bạn đọc này muốn mượn bao nhiêu đầu sach: ");
        int bookNumber = 0;
        while (true) {
            bookNumber = new Scanner(System.in).nextInt();
            if (bookNumber > 0 && bookNumber <= bookLogicHandle.getBooksLength() && bookNumber <= 5) {
                break;
            }
            System.out.println("Số lưượng sach muốn mượn không hợp lệ (là số dương và không vượt quá 5), vui lòng nhập lại: ");
        }
        BookBorrowOrderDetail[] details = new BookBorrowOrderDetail[bookNumber];
        int count = 0;
        for (int j = 0; j < bookNumber; j++) {
            System.out.println("Nhập id của đầu sách thu " + (j + 1) + ": ");

            Book book = null;
            while (true) {
                int bookId = new Scanner(System.in).nextInt();
                // xác định xem cái id của sách kia có tồn tại trong thư viện không
                book = bookLogicHandle.searchBookById(bookId);
                if (book != null) {
                    break;
                }
                System.out.println("Không có sách nào khớp với id sách vừa nhập, vui lòng nhập lại: ");
            }

            System.out.println("Đầu sách '" + book.getName() + "' này bạn muốn mượn bao nhiêu quyển: ");
            int quantity;
            // check quá 3 cuốn thì next
            while (true) {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0 && quantity < 4) {
                    break;
                }
                System.out.println("Số sach muon phai là số dương và nhỏ hơn 4, vui lòng nhập lại: ");
            }
            BookBorrowOrderDetail detail = new BookBorrowOrderDetail(book, quantity);
            details[count] = detail;
            count++;
        }
        return details;
    }

    public Reader truyVanBanDoc() {
        Reader reader = null;
        while (true) {
            int readerId = new Scanner(System.in).nextInt();

            // tìm xem trong thư viên có bạn đọc nào có id khớp với ID vừa nhập không
            reader = readerLogicHandle.searchReaderById(readerId);
            if (reader != null) {
                break;
            }
            System.out.print("Không có bạn đọc nào mang ma vừa nhâp, vui lòng nhập lại: ");
        }
        return reader;
    }


    public void searchByReaderName() {
        System.out.println("Nhập vào tên bạn đọc muốn tìm kiếm: ");
        String readerName = new Scanner(System.in).nextLine();
        for (int i = 0; i < orders.length; i++) {
            // reader = "Nguyễn Văn B" -> nguyễn văn b
            // người ta nhập = "B"  -> b
            if (orders[i] != null
                    && orders[i].getReader().getName().toLowerCase().contains(readerName.toLowerCase())) {
                System.out.println(orders[i]);
            }
        }
    }

    public void sort() {
        while (true) {
            System.out.println("1. Sắp xếp theo tên bạn đọc");
            System.out.println("2. Sắp xếp theo số lượng cuốn sách được muọn");
            System.out.println("3. Quay lại menu cha");
            System.out.println("Chọn đê: ");
            int functionChoice;
            while (true) {
                functionChoice = new Scanner(System.in).nextInt();
                if (functionChoice >= 1 && functionChoice <= 3) {
                    break;
                }
                System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            }
            switch (functionChoice) {
                case 1:
                    sortByReaderName();
                    printBookBorrowOrders();
                    break;
                case 2:
                    sortByBookQuantity();
                    printBookBorrowOrders();
                    break;
                case 3:
                    return;
            }
        }
    }

    private void sortByBookQuantity() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                continue;
            }
            for (int j = 0; j < orders.length; j++) {
                if (orders[j] == null) {
                    continue;
                }

//                if (orders[i].getTotalQuantity() > orders[j].getTotalQuantity()) {
                if (orders[i].getTongSoSach() > orders[j].getTongSoSach()) {
                    BookBorrowOrder temp = orders[j];
                    orders[j] = orders[i];
                    orders[i] = temp;
                }
            }
        }
    }

    private void sortByReaderName() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                continue;
            }
            for (int j = 0; j < orders.length; j++) {
                if (orders[j] == null) {
                    continue;
                }
                String readerName1 = orders[i].getReader().getName().toLowerCase();
                String readerName2 = orders[j].getReader().getName().toLowerCase();
                /**
                 * khi A compareTo với B
                 * nếu kết quả là 1 số DUONG thì A > B
                 * nếu kết quả là 1 số ÂM thì A < B
                 * nếu kết quả là 0 thì A = B
                 *
                 * Nam > Hải
                 * Lê < Lệ
                 *
                 */
                if (readerName1.compareTo(readerName2) > 0) {
                    BookBorrowOrder temp = orders[j];
                    orders[j] = orders[i];
                    orders[i] = temp;
                }
            }
        }
    }
}

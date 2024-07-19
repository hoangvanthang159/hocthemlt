package logichandle;

import entity.Reader;

import java.util.Scanner;

public class ReaderLogicHandle {

    private final Reader[] readers = new Reader[1000];// danh sách bạn đọc có trong thư viện

    public int getReadersLength() {
        return readers.length;
    }

    public void printReaders() {
        for (int i = 0; i < readers.length; i++) {
            if (readers[i] == null) {
                continue;
            }
            System.out.println(readers[i]);
        }
    }

    public void inputNewReader() {
        System.out.print("Nhập số lượng bạn đọc muốn đăng ký tài khoản tại thư viện: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            System.out.println("Nhập thông tin cho bạn đọc thứ " + (i + 1));
            Reader reader = new Reader();
            reader.inputInfo();

            // lưu bạn đọc
            saveReader(reader);
        }

    }

    public void saveReader(Reader reader) {
//        for (int j = 0; j < readers.length; j++) {
//            if (readers[j] == null) {
//                readers[j] = reader;
//                break;
//            }
//        }
        for (int j = 0; j < readers.length; j++) {
            if (readers[j] != null) {
                continue;
            }
            readers[j] = reader;
            break;
        }
    }

    public boolean checkCoBanDocHayChua() {
        boolean coBanDocHayChua = false;
        for (int i = 0; i < readers.length; i++) {
            if (readers[i] != null) {
                coBanDocHayChua = true;
                break;
            }
        }
        return coBanDocHayChua;
    }

    public Reader searchReaderById(int readerId) {
        for (int j = 0; j < readers.length; j++) {
            if (readers[j] != null && readerId == readers[j].getId()) {
                return readers[j];
            }
        }
        return null;
    }

}

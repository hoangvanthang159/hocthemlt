//package view;
//
//import controller.PhongController;
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumnModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class PhongView extends JFrame {
//    private PhongController phongController;
//    private DefaultTableModel tableModel;
//
//    public PhongView() {
//        // Tạo cửa sổ giao diện
//        setTitle("Quản Lý Khách Sạn");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(1536, 864);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        // Font chữ
//        Font fontTitle = new Font("Arial", Font.BOLD, 40);
//        Font fontButton = new Font("Arial", Font.PLAIN, 20);
//        Font fontText = new Font("Arial", Font.PLAIN, 16);
//        Font fontTable = new Font("Arial", Font.BOLD, 14);
//
//        // Panel tiêu đề
//        JPanel titlePanel = new JPanel(new BorderLayout());
//        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));//        JPanel backPanel = new JPanel(new BorderLayout());
////        backPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//
//        JButton btnBack = new JButton("<= Quay lại");
//        btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
//        btnBack.setMargin(new Insets(5, 10, 5, 10));
//        btnBack.setFocusPainted(false);
//        btnBack.setBackground(Color.GRAY);
//        btnBack.setOpaque(true);
//
//        // Sự kiện Quai lại
//        btnBack.addActionListener(e -> {
//            dispose();
//            new Main();
//        });
//
//        // Tạo tiêu đề
//        JLabel jbTitle = new JLabel("QUẢN LÝ PHÒNG", JLabel.CENTER);
//        jbTitle.setFont(fontTitle);
//        jbTitle.setForeground(new Color(56, 120, 56));
//
//        titlePanel.add(btnBack, BorderLayout.WEST);
//        titlePanel.add(jbTitle, BorderLayout.CENTER);
//        add(titlePanel, BorderLayout.NORTH);
//
//        // Tạo bảng
//        tableModel = new DefaultTableModel(new String[]{
//                "Mã Phòng", "Loại Phòng", "Giá Phòng", "Tình Trạng"
//        }, 0);
//        JTable table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(table);
//        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Danh sách phòng");
//        titledBorder1.setTitleFont(fontTable);
//        titledBorder1.setTitleColor(Color.BLUE);
//        scrollPane.setBorder(titledBorder1);
//        add(scrollPane, BorderLayout.CENTER);
//
//        JPanel formPanel = new JPanel(new GridBagLayout());
//        TitledBorder titledBorder2 = BorderFactory.createTitledBorder("Thông tin phòng");
//        titledBorder2.setTitleFont(fontTable);
//        titledBorder2.setTitleColor(Color.BLUE);
//        formPanel.setBorder(titledBorder2);
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        JTextField jtfMaPhong = new JTextField(15);
//        JTextField jtfLoaiPhong = new JTextField(15);
//        JTextField jtfGiaPhong = new JTextField(15);
//        JTextField jtfTinhTrang = new JTextField(15);
//
//        JComboBox<String> jcbLoaiPhong = new JComboBox<>(new String[]{
//                "", "Thương Gia", "VIP", "Bình Dân"
//        });
//        JComboBox<String> jcbTinhTrang = new JComboBox<>(new String[]{
//                "", "Trống", "Đã có người"
//        });
//
//        addThanhPhan(formPanel, new JLabel("Mã Phòng: "), jtfMaPhong, gbc, 0, fontText);
//        addThanhPhan(formPanel, new JLabel("Loại Phòng: "), jtfLoaiPhong, gbc, 1, fontText);
//        addThanhPhan(formPanel, new JLabel("Giá Phòng: "), jtfGiaPhong, gbc, 2, fontText);
//        addThanhPhan(formPanel, new JLabel("Tình Trạng: "), jtfTinhTrang, gbc, 3, fontText);
////        addThanhPhan(formPanel, new JLabel("Loại Phonggg: "), jcbLoaiPhong, gbc, 4, fontText);
//
//        add(formPanel, BorderLayout.WEST);
//
//        // Panel chứa nút chức năng
//        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
//        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        // Button thêm
//        JButton btnAdd = taoNut("THÊM", Color.GREEN, fontButton);
//        btnAdd.setFont(fontButton);
//        btnAdd.addActionListener(e -> {
//            String maPhong = jtfMaPhong.getText();
//            String loaiPhong = jtfLoaiPhong.getText();
//            String giaPhong = jtfGiaPhong.getText();
//            String tinhTrang = jtfTinhTrang.getText();
//
//            // Gọi phongController để thêm phòng
//            if (phongController.addRoom(maPhong, loaiPhong, Integer.parseInt(giaPhong), tinhTrang)) {
//                JOptionPane.showMessageDialog(PhongView.this, "Thêm phòng thành công!");
//                loadRooms();
//            } else {
//                JOptionPane.showMessageDialog(PhongView.this, "Thêm phòng thất bại.");
//            }
//        });
//
//        JButton btnDelete  = taoNut("XÓA", Color.RED, fontButton);
//        btnDelete.setFont(fontButton);
//        btnDelete.addActionListener(e -> {
//            String maPhong = jtfMaPhong.getText();
//            if (PhongController.deleteRoom(maPhong)) {
//                JOptionPane.showMessageDialog(PhongView.this, "Xóa phòng thành công!");
//                loadRooms();
//            } else {
//                JOptionPane.showMessageDialog(PhongView.this, "Xóa phòng thất bại");
//            }
//        });
//
//        JButton btnUpdate = taoNut("SỬA", Color.CYAN, fontButton);
//        btnUpdate.setFont(fontButton);
//        btnUpdate.addActionListener(e -> {
//            String maPhong = jtfMaPhong.getText();
//            String loaiPhong = jtfLoaiPhong.getText();
//            String giaPhong = jtfGiaPhong.getText();
//            String tinhTrang = jtfTinhTrang.getText();
//
//            if  (PhongController.updateRoom(maPhong, loaiPhong, Integer.parseInt(giaPhong), tinhTrang)) {
//                JOptionPane.showMessageDialog(PhongView.this, "Sửa phòng thành công!");
//                loadRooms();
//            } else {
//                JOptionPane.showMessageDialog(PhongView.this, "Sửa phòng thất bại");
//            }
//        });
//
//        JButton btnSearch = taoNut("TÌM", Color.ORANGE, fontButton);
//        btnSearch.setFont(fontButton);
//        btnSearch.addActionListener(e -> {
//            String maPhong = jtfMaPhong.getText().trim();
//            String loaiPhong = jtfLoaiPhong.getText();
//            String giaPhongStr = jtfGiaPhong.getText().trim();
//            String tinhTrang = jtfTinhTrang.getText();
//
////                String loaiPhong = (String) jcbLoaiPhong.getSelectedItem();
////                String tinhTrang = (String) jcbTinhTrang.getSelectedItem();
//
//            List<Object[]> foundRooms = null;
//
//            if (!maPhong.isEmpty()) {
//                // Tìm theo mã phòng
//                foundRooms = phongController.searchRoomByAttribute("MaPhong", maPhong);
//            } else if (!giaPhongStr.isEmpty()) {
//                try {
//                    // Tìm theo giá phòng
//                    double giaPhong = Double.parseDouble(giaPhongStr);
//                    foundRooms = phongController.searchRoomByAttribute("GiaPhong", String.valueOf(giaPhong));
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(PhongView.this, "Giá phòng không hợp lệ.");
//                    return;
//                }
//            } else if (!loaiPhong.isEmpty()) {
//                // Tìm theo loại phòng
//                foundRooms = phongController.searchRoomByAttribute("LoaiPhong", loaiPhong);
//            } else if (!tinhTrang.isEmpty()) {
//                // Tìm theo tình trạng
//                foundRooms = phongController.searchRoomByAttribute("TinhTrang", tinhTrang);
//            }
//
//            if (foundRooms != null && !foundRooms.isEmpty()) {
//                // Hiển thị kết quả tìm kiếm lên bảng
//                tableModel.setRowCount(0);
//                for (Object[] room : foundRooms) {
//                    tableModel.addRow(room);
//                }
//            } else {
//                JOptionPane.showMessageDialog(PhongView.this, "Không tìm thấy phòng phù hợp.");
//            }
//        });
//
//        JButton btnReset = taoNut("Reset", Color.PINK, fontButton);
//        btnReset.setFocusPainted(false);
//        btnReset.addActionListener(e -> {
//            loadRooms();
//        });
//
//        buttonPanel.add(btnAdd);
//        buttonPanel.add(btnDelete);
//        buttonPanel.add(btnUpdate);
//        buttonPanel.add(btnSearch);
//        buttonPanel.add(btnReset);
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        phongController = new PhongController();
//        loadRooms();
//
//        setVisible(true);
//    }
//
//    public JButton taoNut (String text, Color color, Font font) {
//        JButton button = new JButton(text);
//        button.setBackground(color);
//        button.setFont(font);
//        button.setForeground(Color.BLACK);
//        button.setFocusPainted(false);
//        return button;
//    }
//
//    private void addThanhPhan(JPanel panel, JComponent label, JComponent field, GridBagConstraints gbc, int row, Font font) {
//        gbc.gridx = 0;
//        gbc.gridy = row;
//        label.setFont(font);
//        panel.add(label, gbc);
//        gbc.gridx = 1;
//        panel.add(field, gbc);
//        field.setFont(font);
//    }
//
//    private void loadRooms() {
//        tableModel.setRowCount(0);
//        for (Object[] room : phongController.getAllRooms()) {
//            tableModel.addRow(room);
//        }
//    }
//
//    public static void main(String[] args) {
//        new PhongView();
//    }
//}
package view;

import controller.PhongController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PhongView extends JFrame {
    private PhongController phongController;
    private DefaultTableModel tableModel;

    public PhongView() {
        // Thiết lập cửa sổ
        setTitle("Quản Lý Khách Sạn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Định nghĩa font chữ
        Font fontTitle = new Font("Arial", Font.BOLD, 40);
        Font fontButton = new Font("Arial", Font.PLAIN, 20);
        Font fontText = new Font("Arial", Font.PLAIN, 16);
        Font fontTable = new Font("Arial", Font.BOLD, 14);

        // Panel tiêu đề
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnBack = new JButton("<= Quay lại");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
        btnBack.setMargin(new Insets(5, 10, 5, 10));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(Color.GRAY);
        btnBack.setOpaque(true);
        btnBack.addActionListener(e -> {
            dispose();
            new Main();
        });

        JLabel jbTitle = new JLabel("QUẢN LÝ PHÒNG", JLabel.CENTER);
        jbTitle.setFont(fontTitle);
        jbTitle.setForeground(new Color(56, 120, 56));

        titlePanel.add(btnBack, BorderLayout.WEST);
        titlePanel.add(jbTitle, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        // Tạo bảng danh sách phòng
        tableModel = new DefaultTableModel(new String[]{
                "Mã Phòng", "Loại Phòng", "Giá Phòng", "Tình Trạng"
        }, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Danh sách phòng");
        titledBorder1.setTitleFont(fontTable);
        titledBorder1.setTitleColor(Color.BLUE);
        scrollPane.setBorder(titledBorder1);
        add(scrollPane, BorderLayout.CENTER);

        // Panel thông tin phòng
        JPanel formPanel = new JPanel(new GridBagLayout());
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder("Thông tin phòng");
        titledBorder2.setTitleFont(fontTable);
        titledBorder2.setTitleColor(Color.BLUE);
        formPanel.setBorder(titledBorder2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField jtfMaPhong = new JTextField(15);

        JComboBox<String> jcbLoaiPhong = new JComboBox<>(new String[]{
                "", "Đặc Biệt", "VIP", "Bình Dân"
        });
        JTextField jtfGiaPhong = new JTextField(15);
        JComboBox<String> jcbTinhTrang = new JComboBox<>(new String[]{
                "", "Trống", "Đã Sử Dụng", "Đang dọn dẹp"
        });

        addThanhPhan(formPanel, new JLabel("Mã Phòng: "), jtfMaPhong, gbc, 0, fontText);
        addThanhPhan(formPanel, new JLabel("Loại Phòng: "), jcbLoaiPhong, gbc, 1, fontText);
        addThanhPhan(formPanel, new JLabel("Giá Phòng: "), jtfGiaPhong, gbc, 2, fontText);
        addThanhPhan(formPanel, new JLabel("Tình Trạng: "), jcbTinhTrang, gbc, 3, fontText);

        add(formPanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnAdd = taoNut("THÊM", Color.GREEN, fontButton);
        btnAdd.addActionListener(e -> {
            String maPhong = jtfMaPhong.getText();
            String loaiPhong = (String) jcbLoaiPhong.getSelectedItem();
            String giaPhong = jtfGiaPhong.getText();
            String tinhTrang = (String) jcbTinhTrang.getSelectedItem();

            try {
                if (phongController.addRoom(maPhong, loaiPhong, Integer.parseInt(giaPhong), tinhTrang)) {
                    JOptionPane.showMessageDialog(this, "Thêm phòng thành công!");
                    loadRooms();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm phòng thất bại.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Giá phòng không hợp lệ.");
            }
        });

        JButton btnDelete = taoNut("XÓA", Color.RED, fontButton);
        btnDelete.addActionListener(e -> {
            String maPhong = jtfMaPhong.getText().trim();
            if (maPhong.isEmpty()) {
                JOptionPane.showMessageDialog(PhongView.this, "Vui lòng nhập mã phòng cần xóa.");
                return;
            }
            if (phongController.phongInHoaDon(maPhong)) {
                JOptionPane.showMessageDialog(PhongView.this, "Phòng đã tồn tại trong hóa đơn, không thể xóa.");
                return;
            }
            if (phongController.deleteRoom(maPhong)) {
                JOptionPane.showMessageDialog(this, "Xóa phòng thành công!");
                loadRooms();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa phòng thất bại.");
            }
        });

        JButton btnUpdate = taoNut("SỬA", Color.CYAN, fontButton);
        btnUpdate.addActionListener(e -> {
            String maPhong = jtfMaPhong.getText();
            String loaiPhong = (String) jcbLoaiPhong.getSelectedItem();
            String giaPhong = jtfGiaPhong.getText();
            String tinhTrang = (String) jcbTinhTrang.getSelectedItem();

            try {
                if (phongController.updateRoom(maPhong, loaiPhong, Integer.parseInt(giaPhong), tinhTrang)) {
                    JOptionPane.showMessageDialog(this, "Sửa phòng thành công!");
                    loadRooms();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa phòng thất bại.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Giá phòng không hợp lệ.");
            }
        });

        JButton btnSearch = taoNut("TÌM", Color.ORANGE, fontButton);
        btnSearch.addActionListener(e -> {
            String maPhong = jtfMaPhong.getText().trim();
            String loaiPhong = (String) jcbLoaiPhong.getSelectedItem();
            String giaPhongStr = jtfGiaPhong.getText().trim();
            String tinhTrang = (String) jcbTinhTrang.getSelectedItem();

            List<Object[]> foundRooms = null;

            if (!maPhong.isEmpty()) {
                foundRooms = phongController.searchRoomByAttribute("MaPhong", maPhong);
            } else if (!giaPhongStr.isEmpty()) {
                try {
                    double giaPhong = Double.parseDouble(giaPhongStr);
                    foundRooms = phongController.searchRoomByAttribute("GiaPhong", String.valueOf(giaPhong));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Giá phòng không hợp lệ.");
                    return;
                }
            } else if (!loaiPhong.equals("")) {
                foundRooms = phongController.searchRoomByAttribute("LoaiPhong", loaiPhong);
            } else if (!tinhTrang.equals("")) {
                foundRooms = phongController.searchRoomByAttribute("TinhTrang", tinhTrang);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập hoặc chọn một tiêu chí tìm kiếm.");
                return;
            }

            tableModel.setRowCount(0);
            if (foundRooms != null && !foundRooms.isEmpty()) {
                for (Object[] room : foundRooms) {
                    tableModel.addRow(room);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy phòng phù hợp.");
            }
        });

        JButton btnReset = taoNut("Reset", Color.PINK, fontButton);
        btnReset.addActionListener(e -> {
            loadRooms();
        });

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnReset);
        add(buttonPanel, BorderLayout.SOUTH);

        phongController = new PhongController();
        loadRooms();

        setVisible(true);
    }

    private JButton taoNut(String text, Color color, Font font) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setFont(font);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        return button;
    }

    private void addThanhPhan(JPanel panel, JComponent label, JComponent field, GridBagConstraints gbc, int row, Font font) {
        gbc.gridx = 0;
        gbc.gridy = row;
        label.setFont(font);
        panel.add(label, gbc);
        gbc.gridx = 1;
        field.setFont(font);
        panel.add(field, gbc);
    }

    private void loadRooms() {
        tableModel.setRowCount(0);
        for (Object[] room : phongController.getAllRooms()) {
            tableModel.addRow(room);
        }
    }

    public static void main(String[] args) {
        new PhongView();
    }
}

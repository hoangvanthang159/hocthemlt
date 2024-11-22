//package view;
//
//import controller.KhachHangController;
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class KhachHangView extends JFrame {
//    private KhachHangController khachHangController;
//    private DefaultTableModel tableModel;
//
//    public KhachHangView() {
//        // Khởi tạo controller
//        khachHangController = new KhachHangController();
//
//        // Tạo cửa sổ giao diện
//        setTitle("Quản Lý Khách Hàng");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(1100, 800);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//
//        // Font chữ
//        Font fontTitle = new Font("Arial", Font.BOLD, 40);
//        Font fontButton = new Font("Arial", Font.PLAIN, 20);
//        Font fontText = new Font("Arial", Font.PLAIN, 16);
//
//        // Create title panel and "Back" button
//        JPanel backPanel = new JPanel(new BorderLayout());
//        backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding for components
//
//        JButton btnBack = new JButton("<= Quay lại");
//        btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
//        btnBack.setMargin(new Insets(5, 10, 5, 10));
//        btnBack.setFocusPainted(false);
//        btnBack.setBackground(Color.GRAY);
//        btnBack.setOpaque(true);
//
//        // Sự kiện Quai lại
//        btnBack.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                new Main();
//            }
//        });
//
//        backPanel.add(btnBack, BorderLayout.WEST);
//
//        JLabel jbTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG", JLabel.CENTER);
//        jbTitle.setFont(fontTitle);
//        jbTitle.setForeground(new Color(56, 120, 56));
//        backPanel.add(jbTitle, BorderLayout.CENTER);
//
//        add(backPanel, BorderLayout.NORTH);
//
//        // Bảng danh sách khách hàng
//        tableModel = new DefaultTableModel(new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "CMND", "Số Điện Thoại"}, 0);
//        JTable table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
//        add(scrollPane, BorderLayout.CENTER);
//
//        // Panel chức năng
//        JPanel formPanel = new JPanel(new GridBagLayout());
//        formPanel.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        JTextField jtfMaKhachHang = new JTextField(20);
//        JTextField jtfTenKhachHang = new JTextField(20);
//        JTextField jtfCMND = new JTextField(20);
//        JTextField jtfSoDienThoai = new JTextField(20);
//
//        addThanhPhan(formPanel, new JLabel("Mã Khách Hàng:"), jtfMaKhachHang, gbc, 0, fontText);
//        addThanhPhan(formPanel, new JLabel("Tên Khách Hàng:"), jtfTenKhachHang, gbc, 1, fontText);
//        addThanhPhan(formPanel, new JLabel("CMND:"), jtfCMND, gbc, 2, fontText);
//        addThanhPhan(formPanel, new JLabel("Số Điện Thoại:"), jtfSoDienThoai, gbc, 3, fontText);
//
//        add(formPanel, BorderLayout.WEST);
//
//        // Panel chứa nút chức năng
//        JPanel panelBtn = new JPanel(new GridLayout(1, 4, 10, 10));
//        panelBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        // Các nút chức năng
////        JButton btnAdd = taoNut("THÊM", Color.GREEN);
////        btnAdd.setFont(fontButton);
////        btnAdd.addActionListener(e -> {
////            String maKhachHang = jtfMaKhachHang.getText().trim();
////            String tenKhachHang = jtfTenKhachHang.getText().trim();
////            String cmnd = jtfCMND.getText().trim();
////            String soDienThoai = jtfSoDienThoai.getText().trim();
////
////            if (khachHangController.addKhachHang(maKhachHang, tenKhachHang, cmnd, soDienThoai)) {
////                JOptionPane.showMessageDialog(KhachHangView.this, "Thêm khách hàng thành công!");
////                loadKhachHang();
////            } else {
////                JOptionPane.showMessageDialog(KhachHangView.this, "Thêm khách hàng thất bại.");
////            }
////        });
//        JButton btnAdd = taoNut("THÊM", Color.GREEN, fontButton);
//        btnAdd.addActionListener(e -> {
//            String maKhachHang = jtfMaKhachHang.getText().trim();
//            String tenKhachHang = jtfTenKhachHang.getText().trim();
//            String cmnd = jtfCMND.getText().trim();
//            String soDienThoai = jtfSoDienThoai.getText().trim();
//
//            if (khachHangController.addKhachHang(maKhachHang, tenKhachHang, cmnd, soDienThoai)) {
//                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
//                loadKhachHang();
//            } else {
//                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại.");
//            }
//        });
//
//        JButton btnDelete = taoNut("XÓA", Color.RED, fontButton);
//
//        btnDelete.addActionListener(e -> {
//            String maKhachHang = jtfMaKhachHang.getText().trim();
//
//            if (khachHangController.deleteKhachHang(maKhachHang)) {
//                JOptionPane.showMessageDialog(KhachHangView.this, "Xóa khách hàng thành công!");
//                loadKhachHang();
//            } else {
//                JOptionPane.showMessageDialog(KhachHangView.this, "Xóa khách hàng thất bại.");
//            }
//        });
//
//        JButton btnUpdate = taoNut("SỬA", Color.CYAN, fontButton);
//
//        btnUpdate.addActionListener(e -> {
//            String maKhachHang = jtfMaKhachHang.getText().trim();
//            String tenKhachHang = jtfTenKhachHang.getText().trim();
//            String cmnd = jtfCMND.getText().trim();
//            String soDienThoai = jtfSoDienThoai.getText().trim();
//
//            if (khachHangController.updateKhachHang(maKhachHang, tenKhachHang, cmnd, soDienThoai)) {
//                JOptionPane.showMessageDialog(KhachHangView.this, "Sửa khách hàng thành công!");
//                loadKhachHang();
//            } else {
//                JOptionPane.showMessageDialog(KhachHangView.this, "Sửa khách hàng thất bại.");
//            }
//        });
//
//        JButton btnSearch = taoNut("TÌM", Color.ORANGE, fontButton);
//        btnSearch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String maKhachHang = jtfMaKhachHang.getText().trim();
//                String tenKhachHang = jtfTenKhachHang.getText();
//                String cmnd = jtfCMND.getText().trim();
//                String soDienThoai = jtfSoDienThoai.getText();
//                List<Object[]> found = null;
//
//                if (!maKhachHang.isEmpty()) {
//                    // Tìm theo mã phòng
//                    found = khachHangController.searchKhachHang("MaKhachHang", maKhachHang);
//                } else if (!tenKhachHang.isEmpty()) {
//                    try {
//                        found = khachHangController.searchKhachHang("TenKhachHang", tenKhachHang);
//                    } catch (NumberFormatException ex) {
//                        JOptionPane.showMessageDialog(KhachHangView.this, "Tên khách hàng không hợp lệ.");
//                        return;
//                    }
//                } else if (!cmnd.isEmpty()) {
//                    found = khachHangController.searchKhachHang("CMND", cmnd);
//                } else if (!soDienThoai.isEmpty()) {
//                    found = khachHangController.searchKhachHang("TinhTrang", soDienThoai);
//                }
//
//                if (found != null && !found.isEmpty()) {
//                    // Hiển thị kết quả tìm kiếm lên bảng
//                    tableModel.setRowCount(0);
//                    for (Object[] room : found) {
//                        tableModel.addRow(room);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(KhachHangView.this, "Không tìm thấy phòng phù hợp.");
//                }
//            }
//        });
//
//
//        panelBtn.add(btnAdd);
//        panelBtn.add(btnDelete);
//        panelBtn.add(btnUpdate);
//        panelBtn.add(btnSearch);
//        add(panelBtn, BorderLayout.SOUTH);
//
//        // Hiển thị giao diện
//        setVisible(true);
//        loadKhachHang();
//    }
//
//    private JButton taoNut(String text, Color color, Font font) {
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
//        field.setFont(font);
//        panel.add(field, gbc);
//    }
//
//    private void loadKhachHang() {
//        tableModel.setRowCount(0);
//        for (Object[] khachHang : khachHangController.getAllKhachHang()) {
//            tableModel.addRow(khachHang);
//        }
//    }
//
//    public static void main(String[] args) {
//        new KhachHangView();
//    }
//}
package view;

import controller.KhachHangController;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class KhachHangView extends JFrame {
    private KhachHangController khachHangController;
    private DefaultTableModel tableModel;

    public KhachHangView() {
        khachHangController = new KhachHangController();
        setTitle("Quản Lý Khách Hàng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Font fontTitle = new Font("Arial", Font.BOLD, 40);
        Font fontButton = new Font("Arial", Font.PLAIN, 20);
        Font fontText = new Font("Arial", Font.PLAIN, 16);
        Font fontTable = new Font("Arial", Font.BOLD, 14);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnBack = new JButton("<= Quay lại");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 14));
        btnBack.setBackground(Color.GRAY);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(e -> {
            dispose();
            new Main();
        });

        JLabel lblTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG", JLabel.CENTER);
        lblTitle.setFont(fontTitle);
        lblTitle.setForeground(new Color(56, 120, 56));

        titlePanel.add(btnBack, BorderLayout.WEST);
        titlePanel.add(lblTitle, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"Mã Khách Hàng", "Tên Khách Hàng", "CMND", "Số Điện Thoại"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Danh sách khách hàng");
        titledBorder1.setTitleFont(fontTable);
        titledBorder1.setTitleColor(Color.BLUE);
        scrollPane.setBorder(titledBorder1);
        add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridBagLayout());
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder("Thông tin khách hàng");
        titledBorder2.setTitleFont(fontTable);
        titledBorder2.setTitleColor(Color.BLUE);
        formPanel.setBorder(titledBorder2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField jtfMaKhachHang = new JTextField(15);
        JTextField jtfTenKhachHang = new JTextField(15);
        JTextField jtfCMND = new JTextField(15);
        JTextField jtfSoDienThoai = new JTextField(15);

        addComponent(formPanel, new JLabel("Mã Khách Hàng:"), jtfMaKhachHang, gbc, 0, fontText);
        addComponent(formPanel, new JLabel("Tên Khách Hàng:"), jtfTenKhachHang, gbc, 1, fontText);
        addComponent(formPanel, new JLabel("CMND:"), jtfCMND, gbc, 2, fontText);
        addComponent(formPanel, new JLabel("Số Điện Thoại:"), jtfSoDienThoai, gbc, 3, fontText);

        add(formPanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnAdd = createButton("THÊM", Color.GREEN, fontButton);
        btnAdd.addActionListener(e -> {
            String maKhachHang = jtfMaKhachHang.getText().trim();
            String tenKhachHang = jtfTenKhachHang.getText().trim();
            String cmnd = jtfCMND.getText().trim();
            String soDienThoai = jtfSoDienThoai.getText().trim();
            if (khachHangController.addKhachHang(maKhachHang, tenKhachHang, cmnd, soDienThoai)) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
                loadKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại.");
            }
        });

        JButton btnDelete = createButton("XÓA", Color.RED, fontButton);
        btnDelete.addActionListener(e -> {
            String maKhachHang = jtfMaKhachHang.getText().trim();
            if (maKhachHang.isEmpty()) {
                JOptionPane.showMessageDialog(KhachHangView.this, "Vui lòng nhập mã khách hàng cần xóa");
                return;
            }

            if  (khachHangController.khachHangInHoaDon(maKhachHang)) {
                JOptionPane.showMessageDialog(KhachHangView.this, "Khách hàng đã tồn tại trong hóa đơn, không thể xóa.");
                return;
            }

            if (khachHangController.deleteKhachHang(maKhachHang)) {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công!");
                loadKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thất bại.");
            }
        });

        JButton btnUpdate = createButton("SỬA", Color.CYAN, fontButton);
        btnUpdate.addActionListener(e -> {
            String maKhachHang = jtfMaKhachHang.getText().trim();
            String tenKhachHang = jtfTenKhachHang.getText().trim();
            String cmnd = jtfCMND.getText().trim();
            String soDienThoai = jtfSoDienThoai.getText().trim();
            if (khachHangController.updateKhachHang(maKhachHang, tenKhachHang, cmnd, soDienThoai)) {
                JOptionPane.showMessageDialog(this, "Sửa khách hàng thành công!");
                loadKhachHang();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại.");
            }
        });

        JButton btnSearch = createButton("TÌM", Color.ORANGE, fontButton);
        btnSearch.addActionListener(e -> {
            String maKhachHang = jtfMaKhachHang.getText().trim();
            String tenKhachHang = jtfTenKhachHang.getText();
            String cmnd = jtfCMND.getText().trim();
            String soDienThoai = jtfSoDienThoai.getText();
            List<Object[]> found = null;

            if (!maKhachHang.isEmpty()) {
                found = khachHangController.searchKhachHang("MaKhachHang", maKhachHang);
            } else if (!tenKhachHang.isEmpty()) {
                try {
                    found = khachHangController.searchKhachHang("TenKhachHang", tenKhachHang);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(KhachHangView.this, "Tên khách hàng không hợp lệ.");
                    return;
                }
            } else if (!cmnd.isEmpty()) {
                found = khachHangController.searchKhachHang("CMND", cmnd);
            } else if (!soDienThoai.isEmpty()) {
                found = khachHangController.searchKhachHang("TinhTrang", soDienThoai);
            }

            if (found != null && !found.isEmpty()) {
                // Hiển thị kết quả tìm kiếm lên bảng
                tableModel.setRowCount(0);
                for (Object[] khachHang : found) {
                    tableModel.addRow(khachHang);
                }
            } else {
                JOptionPane.showMessageDialog(KhachHangView.this, "Không tìm thấy phòng phù hợp.");
            }
        });

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnSearch);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        loadKhachHang();
    }

    private void addComponent(JPanel panel, JComponent label, JComponent field, GridBagConstraints gbc, int row, Font font) {
        gbc.gridx = 0;
        gbc.gridy = row;
        label.setFont(font);
        panel.add(label, gbc);
        gbc.gridx = 1;
        field.setFont(font);
        panel.add(field, gbc);
    }

    private JButton createButton(String text, Color color, Font font) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setFont(font);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        return button;
    }

    private void loadKhachHang() {
        tableModel.setRowCount(0);
        for (Object[] khachHang : khachHangController.getAllKhachHang()) {
            tableModel.addRow(khachHang);
        }
    }

    public static void main(String[] args) {
        new KhachHangView();
    }
}

package view;

import controller.HoaDonController;
import model.PhongModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HoaDonView extends JFrame {
    private HoaDonController hoaDonController;
    private DefaultTableModel tableModel;
    private PhongModel phongModel = new PhongModel();

    public HoaDonView() {
        hoaDonController = new HoaDonController();
        setTitle("Quản Lý Khách Hàng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Font fontTitle = new Font("Arial", Font.BOLD, 40);
        Font fontButton = new Font("Arial", Font.PLAIN, 20);
        Font fontText = new Font("Arial", Font.PLAIN, 16);
        Font fontTable = new Font("Arial", Font.BOLD, 14);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding for components

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

        JLabel jbTitle = new JLabel("QUẢN LÝ HÓA ĐƠN", JLabel.CENTER);
        jbTitle.setFont(fontTitle);
        jbTitle.setForeground(new Color(56, 120, 56));

        titlePanel.add(jbTitle, BorderLayout.CENTER);
        titlePanel.add(btnBack, BorderLayout.WEST);
        add(titlePanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{
                "Mã Hóa Đơn", "Mã Khách Hàng", "Mã Phòng", "Ngày Nhận Phòng", "Ngày Trả Phòng", "Số Giờ", "Tổng Tiền"
        }, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder("Danh sách hóa đơn");
        titledBorder1.setTitleFont(fontTable);
        titledBorder1.setTitleColor(Color.BLUE);
        scrollPane.setBorder(titledBorder1);
        add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridBagLayout());
        TitledBorder titledBorder2 =  BorderFactory.createTitledBorder("Thông tin khách hàng");
        titledBorder2.setTitleFont(fontTable);
        titledBorder2.setTitleColor(Color.BLUE);
        formPanel.setBorder(titledBorder2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField jtfMaHoaDon = new JTextField(15);
        JTextField jtfMaKhachHang = new JTextField(15);
        JTextField jtfMaPhong = new JTextField(15);
        JTextField jtfNgayNhanPhong = new JTextField(15);
        JTextField jtfNgayTraPhong = new JTextField(15);
        JTextField jtfSoGio = new JTextField(15);

        addThanhPhan(formPanel, new JLabel("Mã Hóa Đơn: "), jtfMaHoaDon, gbc, 0, fontText);
        addThanhPhan(formPanel, new JLabel("Mã Khách Hàng: "), jtfMaKhachHang, gbc, 1, fontText);
        addThanhPhan(formPanel, new JLabel("Mã Mã Phòng: "), jtfMaPhong, gbc, 2, fontText);
        addThanhPhan(formPanel, new JLabel("Ngày Nhận Phòng: "), jtfNgayNhanPhong, gbc, 3, fontText);
        addThanhPhan(formPanel, new JLabel("Ngày Trả Phòng: "), jtfNgayTraPhong, gbc, 4, fontText);
        addThanhPhan(formPanel, new JLabel("Số giờ"), jtfSoGio, gbc, 5, fontText);
        add(formPanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnAdd = taoNut("THÊM", Color.GREEN, fontButton);
        btnAdd.setFont(fontButton);
        btnAdd.addActionListener(e -> {
            try {
                String maHoaDon = jtfMaHoaDon.getText().trim();
                String maKhachHang = jtfMaKhachHang.getText().trim();
                String maPhong = jtfMaPhong.getText().trim();
                String ngayNhanStr = jtfNgayNhanPhong.getText().trim();
                String ngayTraStr = jtfNgayTraPhong.getText().trim();
                String soGioStr = jtfSoGio.getText().trim();

                // Kiểm tra dữ liệu đầu vào
                if (maHoaDon.isEmpty() || maKhachHang.isEmpty() || maPhong.isEmpty() ||
                        ngayNhanStr.isEmpty() || ngayTraStr.isEmpty() || soGioStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date ngayNhan = dateFormat.parse(ngayNhanStr);
                Date ngayTra = dateFormat.parse(ngayTraStr);
                int soGio = Integer.parseInt(soGioStr);
                double tongTien;
                double giaPhong = phongModel.getGiaPhong(maPhong);

                if (giaPhong == -1) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy giá phòng cho mã phòng này!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                tongTien = (soGio * giaPhong);
                tableModel.addRow(new Object[]{maHoaDon, maKhachHang, maPhong, ngayNhanStr, ngayTraStr, soGio, tongTien});

                if (hoaDonController.addHoaDon(maHoaDon, maKhachHang, maPhong, ngayNhan, ngayTra, soGio, (double)tongTien)) {
                    JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
                    loadHoaDon();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Ngày tháng không đúng định dạng (dd/MM/yyyy)!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số giờ phải là số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnDelete = taoNut("XÓA", Color.RED, fontButton);
        btnDelete.setFont(fontButton);
        btnDelete.addActionListener(e -> {
            String maHoaDon = jtfMaHoaDon.getText().trim();
            if (hoaDonController.deleteHoaDon(maHoaDon)) {
                JOptionPane.showMessageDialog(HoaDonView.this, "Xóa khách hàng thành công!");
                loadHoaDon();
            } else {
                JOptionPane.showMessageDialog(HoaDonView.this, "Xóa khách hàng thất bại.");
            }
        });

        JButton btnUpdate = taoNut("SỬA", Color.CYAN, fontButton);
        btnUpdate.setFont(fontButton);
        btnUpdate.addActionListener(e -> {
            try {
                String maHoaDon = jtfMaHoaDon.getText().trim();
                String maKhachHang = jtfMaKhachHang.getText().trim();
                String maPhong = jtfMaPhong.getText().trim();
                String ngayNhanPhongStr = jtfNgayNhanPhong.getText().trim();
                String ngayTraPhongStr = jtfNgayTraPhong.getText().trim();
                String soGioStr =  jtfSoGio.getText().trim();

                // Kiểm tra dữ liệu đầu vào
                if (maHoaDon.isEmpty() || maKhachHang.isEmpty() || maPhong.isEmpty() ||
                        ngayNhanPhongStr.isEmpty() || ngayTraPhongStr.isEmpty() || soGioStr.isEmpty()) {
                    JOptionPane.showMessageDialog(HoaDonView.this, "Vui lòng điền đầy đủ thông tin!");
                    return;
                }

                // Xử lý ngày tháng
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date ngayNhanPhong = dateFormat.parse(ngayNhanPhongStr);
                Date ngayTraPhong = dateFormat.parse(ngayTraPhongStr);

                int soGio;
                try {
                    soGio = Integer.parseInt(soGioStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(HoaDonView.this, "Tổng tiền phải là số nguyên hợp lệ!");
                    return;
                }

                if (hoaDonController.updateHoaDon(maHoaDon, maKhachHang, maPhong, ngayNhanPhong, ngayTraPhong, soGio)) {
                    JOptionPane.showMessageDialog(HoaDonView.this, "Sửa hóa đơn thành công!");
                    loadHoaDon();
                } else {
                    JOptionPane.showMessageDialog(HoaDonView.this, "Sửa hóa đơn thất bại.");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(HoaDonView.this, "Ngày tháng không đúng định dạng (dd/MM/yyyy)!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(HoaDonView.this, "Đã xảy ra lỗi: " + ex.getMessage());
            }
        });

        JButton btnSearch = taoNut("TÌM", Color.ORANGE, fontButton);
        btnSearch.setFont(fontButton);
        btnSearch.addActionListener(e -> {
            String maHoaDon = jtfMaHoaDon.getText().trim();
            String maKhachHang = jtfMaKhachHang.getText().trim();
            String maPhong = jtfMaPhong.getText().trim();
            String ngayNhanPhongStr = jtfNgayNhanPhong.getText().trim();
            String ngayTraPhongStr = jtfNgayTraPhong.getText().trim();
            String soGio = jtfSoGio.getText().trim();

            List<Object[]> found = null;

            if (!maKhachHang.isEmpty()) {
                found = hoaDonController.searchHoaDon("MaHoaDon", maHoaDon);
            } else if (!maKhachHang.isEmpty()) {
                try {
                    found = hoaDonController.searchHoaDon("MaKhachHang", maKhachHang);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(HoaDonView.this, "Mã khách hàng không hợp lệ.");
                    return;
                }
            } else if (!maPhong.isEmpty()) {
                found = hoaDonController.searchHoaDon("MaPhong", maPhong);
            } else if (!ngayNhanPhongStr.isEmpty()) {
                found = hoaDonController.searchHoaDon("NgayNhanPhong", ngayNhanPhongStr);
            } else if (!ngayNhanPhongStr.isEmpty()) {
                found = hoaDonController.searchHoaDon("NgayNhanPhong", ngayNhanPhongStr);
            } else if (!ngayTraPhongStr.isEmpty()) {
                found = hoaDonController.searchHoaDon("NgayTraPhong", ngayTraPhongStr);
            } else if (!soGio.isEmpty()) {
                found = hoaDonController.searchHoaDon("SoGio", soGio);
            }

            if (found != null && !found.isEmpty()) {
                // Hiển thị kết quả tìm kiếm lên bảng
                tableModel.setRowCount(0);
                for (Object[] room : found) {
                    tableModel.addRow(room);
                }
            } else {
                JOptionPane.showMessageDialog(HoaDonView.this, "Không tìm thấy hóa đơn nào phù hợp.");
            }
        });

        JButton btnPrint = taoNut("IN HÓA ĐƠN", Color.MAGENTA, fontButton);
        btnPrint.setFont(fontButton);
        btnPrint.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(HoaDonView.this, "Vui lòng chọn hóa đơn để in!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder hoaDon = new StringBuilder();
            hoaDon.append("=====================================\n");
            hoaDon.append("           HÓA ĐƠN THANH TOÁN        \n");
            hoaDon.append("=====================================\n");
            hoaDon.append(String.format("%-15s: %s\n", "Ngày lập", java.time.LocalDate.now())); // Ngày hiện tại
            hoaDon.append("-------------------------------------\n");

            for (int i = 0; i < table.getColumnCount(); i++) {
                String columnName = table.getColumnName(i);
                Object value = table.getValueAt(selectedRow, i);
                hoaDon.append(String.format("%-15s: %s\n", columnName, value)); // Căn trái với cột tên
            }
            hoaDon.append("=====================================\n");
            hoaDon.append("          Cảm ơn Quý khách!          \n");
            hoaDon.append("=====================================\n");

            inHoaDon(hoaDon.toString());
        });

        JPanel panelBtn = new JPanel(new GridLayout(1, 5, 10, 10));
        panelBtn.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        panelBtn.add(btnAdd);
        panelBtn.add(btnDelete);
        panelBtn.add(btnUpdate);
        panelBtn.add(btnSearch);
        panelBtn.add(btnPrint);
        add(panelBtn, BorderLayout.SOUTH);

        JPanel thongKePanel = createThongKePanel();
        add(thongKePanel, BorderLayout.EAST);

        setVisible(true);
        loadHoaDon();
    }

    private void inHoaDon(String invoiceContent) {
        JTextArea textArea = new JTextArea(invoiceContent);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));

        try {
            boolean complete = textArea.print();
            if (complete) {
                JOptionPane.showMessageDialog(this, "In hóa đơn thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "In hóa đơn bị hủy!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi in hóa đơn: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


    private JPanel createThongKePanel() {
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Thống kê doanh thu");
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 14));
        titledBorder.setTitleColor(Color.BLUE);
        statsPanel.setBorder(titledBorder);

        statsPanel.setPreferredSize(new Dimension(300, 450));  // Điều chỉnh kích thước panel
        Font fontText = new Font("Arial", Font.PLAIN, 16);

        JPanel dayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDay =new JLabel("Ngày (dd/MM//yyyy): ");
        JTextField jtfDay = new JTextField(10);
        JButton btnRevenueByDay = new JButton("Thống kê");
        JLabel lblRevenueByDay = new JLabel("Doanh thu: 0 VND");
        lblDay.setFont(fontText);
        jtfDay.setFont(fontText);
        btnRevenueByDay.setFocusPainted(false);
        btnRevenueByDay.setFont(fontText);
        lblRevenueByDay.setFont(fontText);
        lblRevenueByDay.setForeground(Color.RED);

        dayPanel.add(lblDay);
        dayPanel.add(jtfDay);
        dayPanel.add(btnRevenueByDay);
        dayPanel.add(lblRevenueByDay);

        JPanel monthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMonth = new JLabel("Tháng (MM/yyyy): ");
        JTextField jtfMonth = new JTextField(10);
        JButton btnRevenueByMonth = new JButton("Thống kê");
        JLabel lblRevenueByMonth = new JLabel("Doanh thu: 0 VND");
        lblMonth.setFont(fontText);
        jtfMonth.setFont(fontText);
        btnRevenueByMonth.setFocusPainted(false);
        btnRevenueByMonth.setFont(fontText);
        lblRevenueByMonth.setFont(fontText);
        lblRevenueByMonth.setForeground(Color.RED);

        monthPanel.add(lblMonth);
        monthPanel.add(jtfMonth);
        monthPanel.add(btnRevenueByMonth);
        monthPanel.add(lblRevenueByMonth);

        JPanel yearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblYear = new JLabel("Năm (yyyy): ");
        JTextField jtfYear = new JTextField(10);
        JButton btnRevenueByYear = new JButton("Thống kê");
        JLabel lblRevenueByYear = new JLabel("Doanh thu: 0 VND");
        lblYear.setFont(fontText);
        jtfYear.setFont(fontText);
        btnRevenueByYear.setFocusPainted(false);
        btnRevenueByYear.setFont(fontText);
        lblRevenueByYear.setFont(fontText);
        lblRevenueByYear.setForeground(Color.RED);
        yearPanel.add(lblYear);
        yearPanel.add(jtfYear);
        yearPanel.add(btnRevenueByYear);
        yearPanel.add(lblRevenueByYear);

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnTotalRevenue = new JButton("Tổng doanh thu");
        JLabel lblTotalRevenue = new JLabel("Tổng doanh thu: 0 VND");
        lblTotalRevenue.setFont(fontText);
        lblTotalRevenue.setForeground(Color.RED);

        btnTotalRevenue.setFont(fontText);
        btnTotalRevenue.setFocusPainted(false);
        totalPanel.add(btnTotalRevenue);
        totalPanel.add(lblTotalRevenue);

        statsPanel.add(dayPanel);
        statsPanel.add(monthPanel);
        statsPanel.add(yearPanel);
        statsPanel.add(totalPanel);

        btnRevenueByDay.addActionListener(e -> {
            String dayInput = jtfDay.getText().trim();
            if (!dayInput.matches("\\d{2}/\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Ngày không hợp lệ! Định dạng đúng: d/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] parts = dayInput.split("/");
            String day = parts[0];
            String month = parts[1];
            String year = parts[2];

            try {
                double revenue = hoaDonController.getRevenueByDay(day, month, year);
                lblRevenueByDay.setText("Doanh thu ngày "+ day + "/" + month + "/" + year + ": " + revenue + " VND");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi thống kê: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnRevenueByMonth.addActionListener(e -> {
            String monthInput = jtfMonth.getText().trim();
            if (!monthInput.matches("\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Tháng không hợp lệ! Định dạng đúng: MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] parts = monthInput.split("/");
            String month = parts[0];
            String year = parts[1];

            try {
                double revenue = hoaDonController.getRevenueByMonth(month, year);
                lblRevenueByMonth.setText("Doanh thu tháng " + month + "/" + year + ": " + revenue + " VND");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi thống kê: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Thống kê doanh thu theo năm
        btnRevenueByYear.addActionListener(e -> {
            String yearInput = jtfYear.getText().trim();
            if (!yearInput.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Năm không hợp lệ! Định dạng đúng: yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double revenue = hoaDonController.getRevenueByYear(yearInput);
                lblRevenueByYear.setText("Doanh thu năm " + yearInput + ": " + revenue + " VND");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi thống kê: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Hiển thị tổng doanh thu
        btnTotalRevenue.addActionListener(e -> {
            try {
                double totalRevenue = hoaDonController.getTotalRevenue();
                lblTotalRevenue.setText("Tổng doanh thu: " + totalRevenue + " VND");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi thống kê: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        return statsPanel;
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

    private void loadHoaDon() {
        tableModel.setRowCount(0);
        for (Object[] hoaDon : hoaDonController.getAllHoaDon()) {
            tableModel.addRow(hoaDon);
        }
    }

    public static void main(String[] args) {
        new HoaDonView();
    }
}


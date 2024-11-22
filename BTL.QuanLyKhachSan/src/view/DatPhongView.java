package view;

import controller.DatPhongController;
import model.DatPhongModel;
import model.HoaDonModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatPhongView {
    public DatPhongView() {
        // Tạo cửa sổ giao diện
        JFrame frame = new JFrame("Đặt Phòng");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Font chữ
        Font fontTitle = new Font("Arial", Font.BOLD, 30);
        Font fontLabel = new Font("Arial", Font.PLAIN, 18);

        // Tiêu đề
        JLabel lblTitle = new JLabel("Đặt Phòng", JLabel.CENTER);
        lblTitle.setFont(fontTitle);
        lblTitle.setForeground(new Color(56, 120, 56));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        frame.add(lblTitle, BorderLayout.NORTH);

        // Tạo panel chính để nhập thông tin
        JPanel mainPanel = new JPanel(new GridLayout(5, 2, 15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Các thành phần nhập liệu
        JLabel lblMaKH = new JLabel("Mã Khách Hàng:");
        lblMaKH.setFont(fontLabel);
        JTextField txtMaKH = new JTextField();

        JLabel lblMaPhong = new JLabel("Mã Phòng:");
        lblMaPhong.setFont(fontLabel);
        JTextField txtMaPhong = new JTextField();

        JLabel lblNgayDat = new JLabel("Ngày Đặt:");
        lblNgayDat.setFont(fontLabel);
        JTextField txtNgayDat = new JTextField();

        JLabel lblNgayTra = new JLabel("Ngày Trả:");
        lblNgayTra.setFont(fontLabel);
        JTextField txtNgayTra = new JTextField();

        JLabel lblSoNguoi = new JLabel("Số Người:");
        lblSoNguoi.setFont(fontLabel);
        JTextField txtSoNguoi = new JTextField();

        // Thêm các thành phần vào panel
        mainPanel.add(lblMaKH);
        mainPanel.add(txtMaKH);
        mainPanel.add(lblMaPhong);
        mainPanel.add(txtMaPhong);
        mainPanel.add(lblNgayDat);
        mainPanel.add(txtNgayDat);
        mainPanel.add(lblNgayTra);
        mainPanel.add(txtNgayTra);
        mainPanel.add(lblSoNguoi);
        mainPanel.add(txtSoNguoi);

        // Thêm panel vào frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Nút Đặt và Thoát
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnDat = new JButton("Đặt Phòng");
        JButton btnThoat = new JButton("Thoát");

        btnDat.setFont(fontLabel);
        btnThoat.setFont(fontLabel);

        buttonPanel.add(btnDat);
        buttonPanel.add(btnThoat);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Sự kiện Đặt Phòng
        btnDat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maKH = txtMaKH.getText().trim();
                String maPhong = txtMaPhong.getText().trim();
                String ngayDat = txtNgayDat.getText().trim();
                String ngayTra = txtNgayTra.getText().trim();
                String soNguoi = txtSoNguoi.getText().trim();

                // Kiểm tra dữ liệu nhập
                if (maKH.isEmpty() || maPhong.isEmpty() || ngayDat.isEmpty() || ngayTra.isEmpty() || soNguoi.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Thêm thông tin đặt phòng vào hóa đơn
                    DatPhongModel hoaDon = new DatPhongModel(maKH, maPhong, ngayDat, ngayTra, Integer.parseInt(soNguoi));
                    DatPhongController.themHoaDon(hoaDon); // Lưu hóa đơn vào danh sách hoặc DB

                    JOptionPane.showMessageDialog(frame, "Đặt phòng thành công! Hóa đơn đã được thêm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose(); // Đóng giao diện sau khi đặt phòng thành công
                }
            }
        });

        // Sự kiện Thoát
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Đóng cửa sổ Đặt Phòng
            }
        });

        // Hiển thị giao diện
        frame.setVisible(true);
    }
}

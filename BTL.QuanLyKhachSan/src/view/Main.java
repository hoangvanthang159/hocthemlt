package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public Main() {
        JFrame frame = new JFrame("Quản Lý Khách Sạn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1536, 864);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        Font fontTitle = new Font("Arial", Font.BOLD, 40);
        Font fontButton = new Font("Arial", Font.PLAIN, 20);

        JLabel jbTitle = new JLabel("QUẢN LÝ KHÁCH SẠN", JLabel.CENTER);
        jbTitle.setFont(fontTitle);
        jbTitle.setForeground(new Color(56, 120, 56));
        jbTitle.setBorder(BorderFactory.createEmptyBorder(50, 0, 26, 0));
        frame.add(jbTitle, BorderLayout.NORTH);

        JPanel jButtonPanel  = new JPanel();
        jButtonPanel.setLayout(new GridLayout(4, 1, 26, 26));
        jButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 150, 5, 150));

        JButton btnKhachHang = thietKeNut("Quản lý khách hàng");
        JButton btnPhong = thietKeNut("Quản lý phòng");
        JButton btnHoaDon = thietKeNut("Quản lý hóa đơn");
        JButton btnThoat = thietKeNut("Đăng xuất!");

        btnKhachHang.setFont(fontButton);
        btnPhong.setFont(fontButton);
        btnHoaDon.setFont(fontButton);
        btnThoat.setFont(fontButton);

        btnKhachHang.setFocusPainted(false);
        btnPhong.setFocusPainted(false);
        btnHoaDon.setFocusPainted(false);
        btnThoat.setFocusPainted(false);


        btnKhachHang.addActionListener(e -> {
            new KhachHangView();
        });

        btnPhong.addActionListener(e -> {
            new PhongView();
        });

        btnHoaDon.addActionListener(e -> {
           new HoaDonView();
        });

        btnThoat.addActionListener(e -> {
            int xacNhan = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn đăng xuất?", "Message", JOptionPane.YES_NO_OPTION);
            if (xacNhan == JOptionPane.YES_OPTION) {
                frame.dispose();
                new SignIn();
            }
        });

        jButtonPanel.add(btnKhachHang);
        jButtonPanel.add(btnPhong);
        jButtonPanel.add(btnHoaDon);
        jButtonPanel.add(btnThoat);

        frame.add(jButtonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Tạo giao diện các nút
    public static JButton thietKeNut (String text) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Tạo hiệu ứng gradient cho nút
                Color color1 = getModel().isPressed() ? Color.RED : (getModel().isRollover() ? Color.CYAN : Color.pink);
                Color color2 = getModel().isPressed() ? Color.orange : (getModel().isRollover() ? Color.GREEN : Color.pink);

                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Góc bo tròn

                super.paintComponent(g);
            }
        };

        btn.setFont(new Font("Arial", Font.PLAIN, 20));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
        return btn;
    }
}

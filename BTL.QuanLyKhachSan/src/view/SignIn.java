package view;

import javax.swing.*;
import java.awt.*;

public class SignIn {
    public static void main(String[] args) {
        // Tạo khung (frame)
        JFrame frame = new JFrame("Đăng nhập");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        //Tạo tiêu đề
        JLabel jbTitle = new JLabel("SIGN IN", JLabel.CENTER);
        jbTitle.setFont(new Font("Arial", Font.BOLD, 40));
        jbTitle.setForeground(new Color(56, 120, 56));
        jbTitle.setBorder(BorderFactory.createEmptyBorder(26, 0, 26, 0));
        frame.add(jbTitle, BorderLayout.NORTH);

        Font fontText = new Font("Arial", Font.PLAIN, 15);

        // Tạo panel chính để chứa các thành phần
        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        JLabel lblUsername = new JLabel("Tên người dùng:");
        lblUsername.setFont(fontText);
        JTextField txtUsername = new JTextField();
        txtUsername.setFont(fontText);

        JLabel lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setFont(fontText);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setFont(fontText);

        mainPanel.add(lblUsername);
        mainPanel.add(txtUsername);
        mainPanel.add(lblPassword);
        mainPanel.add(txtPassword);

        JButton btnLogin = new JButton("Đăng nhập");
        JButton btnExit = new JButton("Thoát");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnExit);

        btnLogin.setFocusPainted(false);
        btnExit.setFocusPainted(false);

        btnExit.setFont(fontText);
        btnLogin.setFont(fontText);

        JCheckBox chkShowPassword = new JCheckBox("Hiển thị mật khẩu");
        chkShowPassword.setFocusPainted(false);
        mainPanel.add(chkShowPassword);

        chkShowPassword.addActionListener(e -> {
            if (chkShowPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0); // Hiển thị mật khẩu
            } else {
                txtPassword.setEchoChar('*'); // Ẩn mật khẩu
            }
        });

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            if (username.equals("admin") || username.equals("ADMIN") && password.equals("12345")) {
                JOptionPane.showMessageDialog(frame, "Đăng nhập thành công!");
                new Main();
            } else {
                JOptionPane.showMessageDialog(frame, "Tên người dùng hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExit.addActionListener(e -> {
            int xacNhan = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn thoát?", "Message", JOptionPane.YES_NO_OPTION);
            if (xacNhan == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

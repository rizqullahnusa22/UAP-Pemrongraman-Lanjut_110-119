import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

public class ManajemenDataSiswa {
    private JFrame frame;
    private JPanel loginPanel;
    public JPanel mainMenuPanel;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JButton loginButton;
    public List<String[]> siswaData;

    public ManajemenDataSiswa() {
        frame = new JFrame("Manajemen Data Siswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new CardLayout());

        siswaData = new ArrayList<>();


        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        loginPanel.setBackground(new Color(236, 236, 236));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("MANAJEMEN DATA SISWA");
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        titleLabel.setForeground(new Color(0, 0, 0));

        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameLabel.setForeground(new Color(0, 0, 0));

        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(0, 0, 0));
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBackground(new Color(40, 159, 0));
        loginButton.setForeground(Color.WHITE);
        setButtonStyle(loginButton);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(titleLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        frame.add(loginPanel, "login");

        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        mainMenuPanel.setBackground(new Color(255, 255, 255));

        JButton tambahButton = new JButton("Tambah Siswa");
        JButton hapusButton = new JButton("Hapus Siswa");
        JButton updateButton = new JButton("Update Siswa");
        JButton tampilkanButton = new JButton("Tampilkan Data Siswa");
        JButton keluarButton = new JButton("Keluar");


        setButtonStyle(tambahButton, new Color(81, 153, 208, 255));
        setButtonStyle(hapusButton, new Color(81, 153, 208, 255));
        setButtonStyle(updateButton, new Color(81, 153, 208));
        setButtonStyle(tampilkanButton, new Color(121, 169, 72));
        setButtonStyle(keluarButton, new Color(208, 92, 92));


        tambahButton.addActionListener(this::tambahSiswa);
        hapusButton.addActionListener(this::hapusSiswa);
        updateButton.addActionListener(this::updateSiswa);
        tampilkanButton.addActionListener(this::tampilkanData);
        keluarButton.addActionListener(this::keluar);

        mainMenuPanel.add(tambahButton);
        mainMenuPanel.add(hapusButton);
        mainMenuPanel.add(updateButton);
        mainMenuPanel.add(tampilkanButton);
        mainMenuPanel.add(keluarButton);

        frame.add(mainMenuPanel, "mainMenu");

        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();


        loginButton.addActionListener(e -> {
            try {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if ("admin".equals(username) && "admin123".equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Login berhasil!");
                    cardLayout.show(frame.getContentPane(), "mainMenu");
                } else {
                    throw new IllegalArgumentException("Username atau password salah!");
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Login Gagal", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat login.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }

    private void setButtonStyle(JButton button) {
        setButtonStyle(button, button.getBackground());
    }

    private void setButtonStyle(JButton button, Color color) {
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(color);

        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                GradientPaint gradient = new GradientPaint(0, 0, color.darker(), 0, c.getHeight(), color.brighter());
                g2.setPaint(gradient);
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20); // Rounded corners
                super.paint(g, c);
                g2.dispose();
            }
        });


        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
    }



}

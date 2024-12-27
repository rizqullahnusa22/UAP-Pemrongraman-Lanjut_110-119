import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ManajemenDataSiswaTest {

    private ManajemenDataSiswa manajemenDataSiswa;

    @BeforeEach
    public void setUp() {

        manajemenDataSiswa = new ManajemenDataSiswa();
    }


    @Test
    public void testLoginValid() {
        manajemenDataSiswa.usernameField.setText("admin");
        manajemenDataSiswa.passwordField.setText("admin123");
        manajemenDataSiswa.loginButton.doClick();

        assertTrue(manajemenDataSiswa.mainMenuPanel.isVisible());
    }

    @Test
    public void testLoginInvalid() {

        manajemenDataSiswa.usernameField.setText("username");
        manajemenDataSiswa.passwordField.setText("wrongpassword");
        manajemenDataSiswa.loginButton.doClick();

        assertFalse(manajemenDataSiswa.mainMenuPanel.isVisible());
    }

    @Test
    public void testTambahSiswaValid() {
        manajemenDataSiswa.siswaData.clear();
        manajemenDataSiswa.usernameField.setText("admin");
        manajemenDataSiswa.passwordField.setText("admin123");

        manajemenDataSiswa.loginButton.doClick();


        manajemenDataSiswa.siswaData.add(new String[]{"12345", "Dicky Akbar", "12A", "09-01-2004", "Aktif"});

        List<String[]> siswaList = manajemenDataSiswa.siswaData;
        assertEquals(1, siswaList.size());
        assertEquals("12345", siswaList.get(0)[0]);
    }

    @Test
    public void testHapusSiswa() {

        manajemenDataSiswa.siswaData.clear();
        manajemenDataSiswa.siswaData.add(new String[]{"12345", "Dicky Akbar", "12A", "09-01-2004", "Aktif"});


        String nisToDelete = "12345";
        boolean found = manajemenDataSiswa.siswaData.removeIf(siswa -> siswa[0].equals(nisToDelete));
        assertTrue(found);
        assertEquals(0, manajemenDataSiswa.siswaData.size());
    }

    @Test
    public void testUpdateSiswa() {
        manajemenDataSiswa.siswaData.clear();
        manajemenDataSiswa.siswaData.add(new String[]{"12345", "Dicky Akbar", "12A", "09-01-2004", "Aktif"});

        // Simulasi pengubahan data siswa
        for (String[] siswa : manajemenDataSiswa.siswaData) {
            if (siswa[0].equals("12345")) {
                siswa[1] = "Dafa Nusa";
                siswa[2] = "12B";
                siswa[3] = "22-03-2005";
                siswa[4] = "Lulus";
            }
        }

        String[] updatedSiswa = manajemenDataSiswa.siswaData.get(0);
        assertEquals("Dafa Nusa", updatedSiswa[1]);
        assertEquals("12B", updatedSiswa[2]);
        assertEquals("22-03-2005", updatedSiswa[3]);
        assertEquals("Lulus", updatedSiswa[4]);
    }

    @Test
    public void testTampilkanDataSiswa() {

        manajemenDataSiswa.siswaData.clear();
        manajemenDataSiswa.siswaData.add(new String[]{"12345", "Dicky Akbar", "12A", "09-01-2004", "Aktif"});

        JFrame dataSiswaFrame = new JFrame("Data Siswa");
        String[] columnNames = {"NIS", "Nama", "Kelas", "Tanggal Lahir", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (String[] siswa : manajemenDataSiswa.siswaData) {
            tableModel.addRow(siswa);
        }

        JTable table = new JTable(tableModel);
        dataSiswaFrame.add(new JScrollPane(table));
        dataSiswaFrame.setVisible(true);

        assertEquals(1, table.getRowCount());
        assertEquals("12345", table.getValueAt(0, 0));
    }
}
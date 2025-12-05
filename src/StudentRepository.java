import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    // öğrenci ekleme
    public void ogrenciEkle(student ogrenci) {
        String sql = "INSERT INTO students(name, department) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(database.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ogrenci.getName());
            pstmt.setString(2, ogrenci.getDepartment());
            pstmt.executeUpdate();

            System.out.println("Öğrenci eklendi.");

        } catch (SQLException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    // öğrencileri listeleme
    public List<student> hepsiniGetir() {
        List<student> liste = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(database.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                liste.add(new student(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
            }
        } catch (SQLException e) {
            System.out.println("Hata: " + e.getMessage());
        }
        return liste;
    }
}

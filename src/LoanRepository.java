import java.sql.*;

public class LoanRepository {

    // ödünç verme (ekleme)
    public void oduncVer(int kitapId, int ogrenciId, String tarih) {
        String sql = "INSERT INTO loans(bookId, studentId, dateBorrowed) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(database.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, kitapId);
            pstmt.setInt(2, ogrenciId);
            pstmt.setString(3, tarih);
            pstmt.executeUpdate();

            System.out.println("Ödünç verildi.");

        } catch (SQLException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    // ödünçleri listeleme
    public void oduncListesi() {
        String sql = "SELECT * FROM loans";

        try (Connection conn = DriverManager.getConnection(database.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("--- ÖDÜNÇ LİSTESİ ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Kitap ID: " + rs.getInt("bookId") +
                        " | Öğrenci ID: " + rs.getInt("studentId") +
                        " | Tarih: " + rs.getString("dateBorrowed"));
            }
        } catch (SQLException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    // geri teslim alma (güncelleme - UPDATE işlemi)
    public void teslimAl(int kitapId, String donusTarihi) {
        // sadece teslim tarihi boş olanı bulup güncelliyoruz
        String sql = "UPDATE loans SET dateReturned = ? WHERE bookId = ? AND dateReturned IS NULL";

        try (Connection conn = DriverManager.getConnection(database.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, donusTarihi);
            pstmt.setInt(2, kitapId);
            pstmt.executeUpdate();

            System.out.println("Kitap teslim alındı.");

        } catch (SQLException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
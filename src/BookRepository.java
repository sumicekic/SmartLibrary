import java.sql.*; // sql araçları
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    // kitap ekleme işlemi
    public void kitapEkle(book kitap) {
        String sql = "INSERT INTO books(title, author, year) VALUES(?,?,?)";

        // Database.URL diyerek diğer taraftaki adresi kullanıyorum
        try (Connection conn = DriverManager.getConnection(database.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // soru işaretlerini dolduruyorum
            pstmt.setString(1, kitap.getTitle());
            pstmt.setString(2, kitap.getAuthor());
            pstmt.setInt(3, kitap.getYear());

            // kaydet tuşuna basıyorum gibi düşün
            pstmt.executeUpdate();
            System.out.println("Kitap eklendi.");

        } catch (SQLException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    // tüm kitapları getirme işlemi
    public List<book> hepsiniGetir() {
        List<book> liste = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DriverManager.getConnection(database.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // satır satır okuyup listeye ekliyorum
            while (rs.next()) {
                liste.add(new book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Hata: " + e.getMessage());
        }
        return liste;
    }
}


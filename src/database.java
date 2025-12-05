import java.sql.*; // sql araçlarını çağırıdm.

public class database {

    // veritabanı dosyamın adı
    public static final String URL = "jdbc:sqlite:library.db";

    public static void veritabaniBaslat() {

        // Bağlantıyı deneme ve hata bloğu
        try (Connection conn = DriverManager.getConnection(URL)) {

            System.out.println("Veritabanına bağlandım!");

            // komutları çalıştırmak için aracı
            Statement stmt = conn.createStatement();

            // kitaplar tablosu
            String sqlBook = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT," +
                    "author TEXT," +
                    "year INTEGER)";
            stmt.execute(sqlBook);

            // öğrenciler tablosu
            String sqlStudent = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "department TEXT)";
            stmt.execute(sqlStudent);

            // ödünç alma tablosu
            String sqlLoan = "CREATE TABLE IF NOT EXISTS loans (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "bookId INTEGER," +
                    "studentId INTEGER," +
                    "dateBorrowed TEXT," +
                    "dateReturned TEXT)";
            stmt.execute(sqlLoan);

            System.out.println("Tablolar kontrol edildi, her şey yolunda.");

        } catch (SQLException e) {
            // hata çıkarsa ekrana yazdırıyor
            System.out.println("Veritabanı hatası: " + e.getMessage());
        }
    }
}

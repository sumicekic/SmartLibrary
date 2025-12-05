public class loan {

    // ödünç alma değişkenleri
    private int id;
    private int bookId;
    private int studentId;
    private String dateBorrowed;
    private String dateReturned;

    // boş metot
    public loan() {}

    // dolu yapıcı metot
    public loan(int id, int bookId, int studentId, String dateBorrowed, String dateReturned) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.dateBorrowed = dateBorrowed;
        this.dateReturned = dateReturned;
    }

    // verileri almak için
    public int getBookId() { return bookId; }
    public int getStudentId() { return studentId; }
    public String getDateBorrowed() { return dateBorrowed; }
    public String getDateReturned() { return dateReturned; }

    // yazdırma formatı
    @Override
    public String toString() {
        return "İşlem: " + id + " | Kitap ID: " + bookId + " | Öğrenci ID: " + studentId;
    }
}
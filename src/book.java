public class book {

    // değişkenleri tanımladım
    private int id;
    private String title;
    private String author;
    private int year;

    // boş yapıcı metot
    public book() {}

    // veritabanından çekme metodu
    public book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // yeni kitap ekleme  metodu
    public book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // verileri okumak için metotlar
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }

    // yazıyı düzenleme
    @Override
    public String toString() {
        return id + " | " + title + " - " + author + " (" + year + ")";
    }
}
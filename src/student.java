public class student {

    // öğrenci bilgilerini tanımladım
    private int id;
    private String name;
    private String department;

    // boş yapıcı metot
    public student() {}

    // listelerken kullanacağım dolu metot
    public student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // yeni eklerken kullanacağım metot
    public student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // verileri çağırmak için
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    // ekrana yazdırma ayarı
    @Override
    public String toString() {
        return id + " | " + name + " (" + department + ")";
    }
}

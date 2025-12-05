 SmartLibrary 

Bu proje, Nesneye Dayalı Programlama- 2 dersi vize ödevi için hazırladığım, veritabanı destekli bir kütüphane yönetim uygulamasıdır.

Projenin temel amacı, Java ve SQLite kullanarak verileri geçici değil kalıcı olarak saklamak, yani program kapansa bile verilerin kaybolmamasını sağlamaktır.

Çalışma Prensibi Şöyledir:

1. Bağlantı Kurma (Veritabanı Başlatma):
Program açılır açılmaz "JDBC" dediğimiz sürücüyü kullanarak SQLite veritabanına bağlanıyor. Eğer bilgisayarda veritabanı dosyası yoksa, kodlar otomatik olarak `library.db` dosyasını oluşturuyor ve içine Kitap, Öğrenci, Ödünç tablolarını kuruyor.

2. Veriyi Dönüştürme (Nesne Yapısı):
Veritabanından gelen veriler tablo satırı (SQL) şeklinde geliyor. Ben bu verileri kodun içinde rahat yönetebilmek için oluşturduğum `Book`, `Student` ve `Loan` sınıflarına dönüştürdüm. Yani veritabanı satırlarını, programın anlayacağı Java nesnelerine çevirdim.

3. İşçi Sınıflar (Repository Mantığı):
Kodlar birbirine girmesin diye her işi ayırdım.
- Kitap işlerini `BookRepository` yapıyor.
- Öğrenci işlerini `StudentRepository` yapıyor.
- Ödünç işlerini `LoanRepository` yapıyor.
Bu sayede "Ekleme", "Listeleme" gibi komutlar ana dosyayı kirletmiyor. Ayrıca verileri eklerken güvenlik için `PreparedStatement` yapısını kullandım.

4. Menü Sistemi:
Kullanıcının rahat işlem yapabilmesi için bir menü yaptım. Burada `Switch-Case` yapısı kullandım. Yani kullanıcı 1'e basarsa kitap eklemeye, 2'ye basarsa listelemeye gidiyor. Sonsuz döngü (`while`) sayesinde kullanıcı "Çıkış" diyene kadar program kapanmıyor.

Programın Özellikleri:

- Program açılınca tablolar yoksa otomatik oluşturur.
- Yeni kitap ve öğrenci ekleyebilirsiniz.
- Hangi öğrenciye hangi kitabın verildiğini tarihle beraber kaydedebilirsiniz (Ödünç Sistemi).
- Ödünç verilen kitabı geri teslim alabilirsiniz (Veritabanında güncellenir).
- Hata olursa (mesela veritabanı dosyası kilitliyse) program patlamaz, hata mesajı verir (Try-Catch yapısı).

Kurulum ve Çalıştırma:

Projeyi IntelliJ IDEA Community sürümü ile açıp `Main` sınıfındaki Play (Başlat) tuşuna basmanız yeterlidir. Ekstra bir ayar yapmaya gerek yoktur.

Hazırlayan:
Sümeyye Çekiç - 20230108003 - BIP2

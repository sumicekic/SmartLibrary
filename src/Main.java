import java.util.Scanner; // kullanıcıdan veri almak için
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Önce veritabanı tablolarını kur (Kontak çevir)
        database.veritabaniBaslat();

        // İşçi sınıfları (Repository) hazırlıyorum
        BookRepository kitapIsleri = new BookRepository();
        StudentRepository ogrenciIsleri = new StudentRepository();
        LoanRepository oduncIsleri = new LoanRepository();

        // Kullanıcıdan veri almak için Scanner (Console.ReadLine gibi)
        Scanner tarayici = new Scanner(System.in);
        boolean devam = true;

        // Sonsuz döngü (Çıkış diyene kadar)
        while (devam) {
            System.out.println("\n===== SmartLibrary Sistemi =====");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Öğrenci Ekle");
            System.out.println("4. Öğrencileri Listele");
            System.out.println("5. Kitap Ödünç Ver");
            System.out.println("6. Ödünç Listesi");
            System.out.println("7. Kitap İade Al");
            System.out.println("8. Çıkış");
            System.out.print("Seçiminiz: ");

            // Sayı girişi alıyoruz
            int secim = tarayici.nextInt();
            tarayici.nextLine(); // Hata önleyici (alt satıra geçmesi için)

            switch (secim) {
                case 1:
                    System.out.print("Kitap Adı: ");
                    String baslik = tarayici.nextLine();
                    System.out.print("Yazar: ");
                    String yazar = tarayici.nextLine();
                    System.out.print("Basım Yılı: ");
                    int yil = tarayici.nextInt();

                    // Yeni kitap oluşturup repoya gönderiyoruz
                    kitapIsleri.kitapEkle(new book(baslik, yazar, yil));
                    break;

                case 2:
                    System.out.println("\n--- KİTAP LİSTESİ ---");
                    List<book> kitaplar = kitapIsleri.hepsiniGetir();
                    // Foreach döngüsü ile yazdırıyorum
                    for (book k : kitaplar) {
                        System.out.println(k.toString());
                    }
                    break;

                case 3:
                    System.out.print("Öğrenci Adı: ");
                    String ad = tarayici.nextLine();
                    System.out.print("Bölüm: ");
                    String bolum = tarayici.nextLine();

                    ogrenciIsleri.ogrenciEkle(new student(ad, bolum));
                    break;

                case 4:
                    System.out.println("\n--- ÖĞRENCİ LİSTESİ ---");
                    for (student s : ogrenciIsleri.hepsiniGetir()) {
                        System.out.println(s.toString());
                    }
                    break;

                case 5:
                    System.out.print("Kitap ID: ");
                    int kId = tarayici.nextInt();
                    System.out.print("Öğrenci ID: ");
                    int oId = tarayici.nextInt();
                    tarayici.nextLine(); // hata önleyici
                    System.out.print("Tarih (gg.aa.yyyy): ");
                    String tarih = tarayici.nextLine();

                    oduncIsleri.oduncVer(kId, oId, tarih);
                    break;

                case 6:
                    oduncIsleri.oduncListesi();
                    break;

                case 7:
                    System.out.print("İade Edilen Kitap ID: ");
                    int iadeId = tarayici.nextInt();
                    tarayici.nextLine();
                    System.out.print("İade Tarihi: ");
                    String iadeTarih = tarayici.nextLine();

                    oduncIsleri.teslimAl(iadeId, iadeTarih);
                    break;

                case 8:
                    devam = false; // döngüyü bitir
                    System.out.println("Sistemden çıkılıyor. İyi günler!");
                    break;

                default:
                    System.out.println("Yanlış seçim yaptınız, tekrar deneyin.");
            }
        }
    }
}
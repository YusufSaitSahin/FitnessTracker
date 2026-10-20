# Fitness Tracker App

Bu proje, JavaFX ve MySQL kullanılarak geliştirilmiş kapsamlı bir masaüstü antrenman takip uygulamasıdır. Kullanıcıların kendi antrenman programlarını oluşturmalarına, set/tekrar/ağırlık bazında gelişimlerini takip etmelerine ve hareketlerin doğru formlarını öğrenmelerine olanak tanır.

## Temel Özellikler

* **Antrenman Şablonları (Routines):** Kullanıcılar Push, Pull, Legs, Full Body gibi kendi antrenman bölmelerini (split) oluşturabilir ve her güne özel hareket atayabilir.

* **Aktif Antrenman Kaydı:** Antrenman esnasında her hareket için girilen set, tekrar ve ağırlık değerleri anlık olarak sisteme işlenir.

* **Geçmiş ve Gelişim Takibi (History):** Geçmiş tarihlerde yapılan antrenmanlar, kaldırılan toplam ağırlıklar ve antrenman süreleri detaylı bir şekilde incelenebilir.

* **Egzersiz Kütüphanesi:**

  * Veritabanında kayıtlı yüzlerce egzersizin açıklaması ve hedef kas grubu.

  * Veritabanını yormamak adına dosya sisteminden (`src/gifs/`) dinamik olarak yüklenen hareket animasyonları (Örn: `bench_press.gif`).

* **Kullanıcı Paneli (Dashboard):** Haftalık antrenman özeti ve aktif programların görüntülendiği ana ekran.

## Kullanılan Teknolojiler

* **Programlama Dili:** Java

* **Kullanıcı Arayüzü:** JavaFX (FXML & CSS kullanılarak özel tasarım)

* **Veritabanı:** MySQL

* **Bağlantı:** JDBC

* **Mimari Pattern:** MVC (Model-View-Controller)

## Veritabanı Yapısı

Uygulamanın veritabanı ilişkisel (relational) bir model üzerine kuruludur. Ana tablolar şunlardır:

* `exercises`: Hareket isimleri, kas grupları ve ipuçları.

* `routines`: Kullanıcının oluşturduğu antrenman şablonları.

* `workout_history`: Günlük yapılan antrenmanların tarih ve süre bilgisi.

* `workout_sets`: Hangi antrenmanda, hangi hareketin, kaç kilo ve kaç tekrar yapıldığını tutan detay tablosu.

## Kurulum Adımları

Projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

1. **Projeyi Klonlayın:**

   ```
   git clone https://github.com/YusufSaitSahin/FitnessTracker.git
   
   ```

2. **Veritabanı Kurulumu:**

   * Proje dizininde bulunan `database.sql` dosyasını MySQL (Workbench veya phpMyAdmin) üzerinden içe aktararak (import) tabloları otomatik olarak oluşturun.

   * `src/utils/DatabaseConnection.java` dosyası içindeki veritabanı url, kullanıcı adı ve şifre kısımlarını kendi yerel veritabanı bilgilerinize göre güncelleyin.

3. **Görsel İçerikler:**

   * Uygulamanın egzersizler sekmesinde GIF'lerin çalışabilmesi için, hareket animasyonlarını `.gif` formatında `src/gifs/` klasörüne ekleyin.

4. **Çalıştırma:**

   * Projeyi IDE'nizde (Eclipse/IntelliJ) açın ve `Main.java` üzerinden derleyip çalıştırın.
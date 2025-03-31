# API Test Otomasyon Projesi

Bu repo, çeşitli web servisleri için gerçekleştirilmiş API test otomasyon örneklerini içermektedir. Proje, Rest Assured kütüphanesi kullanılarak geliştirilmiş olup, test senaryoları TestNG framework'ü ile yönetilmektedir. Raporlama için Extent Reports entegre edilmiş, sürekli entegrasyon/sürekli teslimat (CI/CD) süreçleri için Jenkins ve GitHub Actions yapılandırılmıştır. Ayrıca, testlerin daha hızlı ve verimli çalışması için paralel test özelliği de uygulanmıştır.

## İçerik

Bu repo içerisinde aşağıdaki API'ler için test senaryoları bulunmaktadır:

* **jsonplaceholder.typicode.com:** Basit CRUD operasyonlarını ve farklı HTTP durum kodlarını test eden örnekler.
* **petstore.swagger.io:** Petstore API'si üzerinden "available" statüsündeki pet sayısını doğrulayan bir test senaryosu.
* **restcountries.com:** Belirli bir dil (Türkçe) üzerinden ülke bilgilerini (status kodu, içerik tipi, resmi isim, başkent, bölge, kıtalar) doğrulayan bir test senaryosu.
* **reqres.in:** Kullanıcı bilgilerini getirme ve farklı HTTP durum kodlarını test etme örnekleri.
* **restful-booker.herokuapp.com:** Rezervasyon bilgilerini getirme ve farklı HTTP durum kodlarını (örneğin 404 Not Found) test etme örnekleri.
* **fakerestapi.azurewebsites.net:** Aktivite bilgilerini getirme ve çeşitli alanları (status kodu, içerik tipi, aktivite sayısı, başlıklar, ID'ler) doğrulayan test senaryoları.
* **gorest.co.in:** Kullanıcı bilgilerini getirme ve belirli alanları (isim, ID, cinsiyet) doğrulayan test senaryoları.

Her bir test senaryosu, ilgili API endpoint'ine yapılan GET isteklerinin yanıtlarını belirli kriterlere göre (HTTP durum kodu, içerik tipi, JSON body içerikleri, header bilgileri vb.) doğrulamaktadır.

## Kullanılan Teknolojiler

* **Java:** Projenin geliştirme dili.
* **Rest Assured:** RESTful API'leri test etmek için kullanılan Java kütüphanesi.
* **TestNG:** Java için güçlü ve esnek bir test framework'ü.
* **Extent Reports:** Test sonuçlarını detaylı ve görsel olarak raporlamak için kullanılan popüler bir kütüphane.
* **Jenkins:** Sürekli entegrasyon ve sürekli teslimat (CI/CD) süreçlerini otomatikleştirmek için kullanılan açık kaynaklı bir araç.
* **GitHub Actions:** Doğrudan GitHub reposu içinde CI/CD iş akışlarını otomatikleştirmek için kullanılan bir platform.

## Öne Çıkan Özellikler

* **Kapsamlı API Testleri:** Birden fazla popüler ve farklı yapıdaki API için çeşitli test senaryoları içerir.
* **Kolay Anlaşılır Testler:** Test senaryoları, okunabilir ve anlaşılır bir şekilde yazılmıştır.
* **Detaylı Raporlama:** Extent Reports entegrasyonu sayesinde her bir test çalıştırması için detaylı ve görsel raporlar oluşturulmaktadır. Bu raporlar, test sonuçlarını analiz etmeyi kolaylaştırır.
* **Sürekli Entegrasyon (CI):** Jenkins ve GitHub Actions yapılandırmaları sayesinde, kod değişiklikleri otomatik olarak derlenir ve test edilir. Bu, geliştirme sürecinde hataların erken tespit edilmesine olanak tanır.
* **Paralel Test Çalıştırma:** TestNG'nin paralel test özelliği kullanılarak testlerin daha kısa sürede tamamlanması sağlanmıştır. Bu, özellikle büyük test suitlerinde zaman tasarrufu sağlar.

## Nasıl Çalıştırılır?

1.  Bu repoyu yerel makinenize klonlayın.
2.  Gerekli bağımlılıkları (Maven veya Gradle kullanıyorsanız) projenize dahil edin. Bu proje için gerekli bağımlılıklar genellikle `pom.xml` (Maven) veya `build.gradle` (Gradle) dosyalarında belirtilir.
3.  Testleri çalıştırmak için IDE'nizdeki TestNG runner'ını kullanabilir veya komut satırından Maven (`mvn test`) veya Gradle (`gradle test`) komutlarını çalıştırabilirsiniz.

## Raporlara Erişim

Testler başarıyla tamamlandıktan sonra, Extent Reports raporları genellikle `test-output` klasörü altında oluşturulur. Oluşturulan HTML dosyasını (örneğin `ExtentReport_20250331_220700.html` gibi) bir web tarayıcısı ile açarak detaylı test sonuçlarını inceleyebilirsiniz.

## Katkılar

Bu projeye katkıda bulunmak isterseniz, lütfen bir "pull request" gönderin veya "issue" oluşturarak geri bildirimlerinizi iletin.

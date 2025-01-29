# Migros Pet Shop Test Otomasyon Projesi

## Proje Özeti
Bu otomasyon projesi, Migros web sitesinin Pet Shop bölümündeki temel fonksiyonları test etmek için oluşturulmuştur. 
Test senaryosu aşağıdaki adımları içermektedir:
- Migros.com.tr ana sayfasına erişim
- Pet Shop kategorisine navigasyon
- Ürünlerin fiyata göre sıralanması ve doğrulanması

## Kullanılan Teknolojiler
- **Programlama Dili:** Java 11
- **Test Framework:** Cucumber (BDD)
- **Web Otomasyon:** Selenium WebDriver
- **Build Tool:** Maven
- **Test Runner:** JUnit
- **Raporlama:** Extent Reports
- **Version Control:** Git

## Özellikler
- BDD yaklaşımı ile yazılmış test senaryoları
- Page Object Model design pattern
- Cross-browser testing (Chrome, Firefox)
- Otomatik screenshot alma (test başarısız olduğunda)
- HTML formatında test raporları

## Test Çalıştırma
Testleri çalıştırmak için aşağıdaki Maven komutlarını kullanabilirsiniz:

```bash
# Chrome browser'da testleri çalıştırmak için (varsayılan)
mvn clean test

# Firefox browser'da testleri çalıştırmak için
mvn clean test -Dbrowser=firefox
```

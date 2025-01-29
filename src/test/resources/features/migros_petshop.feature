Feature: Migros Pet Shop Tests

  Scenario: Pet Shop ürünlerini fiyata göre sıralama
    Given Kullanıcı Migros anasayfasını açar
    When Kategoriler menüsünden Pet Shop seçilir
    Then Pet Shop sayfasının açıldığı doğrulanır
    When Ürünler düşük fiyata göre sıralanır
    Then Ürünlerin düşük fiyata göre sıralandığı doğrulanır 
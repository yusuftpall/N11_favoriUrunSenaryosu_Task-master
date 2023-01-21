@N11
Feature: N11 Favori Urun Senaryosu

    Scenario: kullanici N11 web sayfasına erisim saglamali ve bir urunu favorilere ekleyip silebilmeli
      Given kullanici "n11Url" anasayfasina gider
      And kullanici "n11Url" anasayfasinin acildigini kontrol eder
      Then kullanici siteye login olur
      And kullanici login oldugunu kontrol eder
      And kullanici arama kutusuna "Iphone" yazar ve arama yapar
      And kullanici arama sonuclarinin "Iphone" icerdigini kontrol eder
      Then kullanici arama sonuc sayfasindan ikinci sayfaya gider
      And kullanici ikinci sayfanin acildigini kontrol eder
      Then kullanici acilan sayfada ucuncu urunu favori listesine ekler
      And kullanici favori listem sayfasina gider
      And kullanici favori listem sayfasinin acildigini kontrol eder
      And kullanici ucuncu urunun favori listesine eklendigini kontrol eder
      Then kullanici eklenen urunu favori listesinden siler
      And kullanici silme isleminin gerceklestigini kontrol eder
      Then kullanici hesabim bolumunden cikis islemi yapar
      And kullanici cikis isleminin yapildigini kontrol eder


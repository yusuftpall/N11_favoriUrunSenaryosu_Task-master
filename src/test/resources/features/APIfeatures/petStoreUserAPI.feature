@APIpetstore
Feature: Kullanici petstore sayfasından user bolumunden API requestleri yapabilmeli

  Scenario: User Post Request
    Given Kullanici kayit etmek istedigi kullanicinin bilgilerini olusturur
    Then Kullanici API ile post request olusturarak yeni bir kullanici kayit eder
    And Kullanici API ile gelen cevabi kaydeder ve alinan cevap ile beklenen cevabi karsilastirir

  Scenario: User Get Request
    Given Kullanici get request icin expected data belirler
    Then Kullanici user bolumu API ile actual datayı get request ile kaydeder
    And Kullanici API ile gelen cevap ile beklenen cevabi karsilastirir

  Scenario: User Delete Request
    Given Kullanici delete request icin expected data belirler
    Then Kullanici API ile expected datayı delete yapar
    And Kullanici API ile gelen cevabi dogrular

  Scenario: User Delete Request negative
    Given Kullanici User bolumu negative delete request icin expected data belirler
    Then Kullanici User bolumu API ile negative delete yapar
    And Kullanici User bolumu API ile negative gelen cevabi dogrular
@APIpetstore
Feature: Kullanici petstore sayfasından pet bolumunden API requestleri yapabilmeli

  Scenario: Pet Post Request
    Given Kullanici kayit etmek istedigi pet bilgilerini olusturur
    Then Kullanici API ile post request olusturarak yeni bir pet kayit eder
    And Kullanici API ile gelen cevabi kaydeder, beklenen cevap ile karsilastirir

  Scenario: Pet Get Request
    Given Kullanici pet bolumu get request icin expected data belirler
    Then Kullanici API ile pet bolumu actual datayı get request ile kaydeder
    And Kullanici pet bolumu API ile gelen cevap ile beklenen cevabi karsilastirir

  Scenario: Pet Delete Request
    Given Kullanici pet bolumu delete request icin expected data belirler
    Then Kullanici pet bolumu API ile expected datayı delete yapar
    And Kullanici pet bolumu API ile gelen cevabi dogrular

  Scenario: Pet Delete Request negative
    Given Kullanici Pet bolumu negative delete request icin expected data belirler
    Then Kullanici Pet bolumu API ile negative delete yapar
    And Kullanici Pet bolumu API ile negative gelen cevabi dogrular
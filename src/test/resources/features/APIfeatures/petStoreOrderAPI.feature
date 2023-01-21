@APIpetstore
Feature: Kullanici petstore sayfasından store bolumunden API requestleri yapabilmeli

  Scenario: Store Post Request
    Given Kullanici kayit etmek istedigi store bilgilerini olusturur
    Then Kullanici API ile post request olusturarak yeni bir store order kayit eder
    And Kullanici API ile gelen cevabi kaydeder beklenen cevap ile karsilastirir

  Scenario: Store Get Request
    Given Kullanici store bolumu get request icin expected data belirler
    Then Kullanici API ile store bolumu actual datayı get request ile kaydeder
    And Kullanici store bolumu API ile gelen cevap ile beklenen cevabi karsilastirir

  Scenario: Store Delete Request
    Given Kullanici store bolumu delete request icin expected data belirler
    Then Kullanici store bolumu API ile expected datayı delete yapar
    And Kullanici store bolumu API ile gelen cevabi dogrular

  Scenario: Store Delete Request negative
    Given Kullanici store bolumu negative delete request icin expected data belirler
    Then Kullanici store bolumu API ile negative delete yapar
    And Kullanici store bolumu API ile negative gelen cevabi dogrular
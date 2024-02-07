Feature: US1002 kullanici JPH endpoint'ine Post request gonderir
  @Api
  Scenario: TC02 Kullanici Post request sonucu dönen response'i test eder.

    Given Kullanici "jPHBaseUrl" base URL'ini kullanir
    Then Path parametreleri icin "posts/80" kullanir
    And POST request icin "Senol","Merhaba",10 80 bilgileri ile request body olusturur
    And jPH server a POST request gonderir ve testleri yapmak icin response degerini kaydeder
    Then jPH respons'da status degerinin 200
    And jPH respons'da content type degerinin "application/json; charset=utf-8"
    And jPH respons daki "Connection" header degerinin "keep-alive"
    Then response attribute degerlerinin "Senol","Merhaba",10 80


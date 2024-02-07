Feature: Dummy Rest Api endpoint de Get request test yapar
  @Api3
  Scenario: TC01 3 numarali end pointe get Request gönderip testleri yapar

    Given Kullanici "dummyBaseUrl" base URL'ini kullanir
    Then Path parametreleri icin "employee/3" kullanir
    And "dummy" server a GET request gonderir ve testleri yapmak icin response degerini kaydeder
    Then "dummy" respons'da status degerinin 200
    And "dummy" respons'da content type degerinin "application/json; charset=utf-8"
    And "dummy" GET respons body'sinde "status" degerinin String "success"
    And "dummy" GET respons body'sinde "message" degerinin String "Successfully! Record has been fetched."
    Then "dummy" GET respons body'sinde "data" degerinin ve "profile_image" degerinin String ""
    Then "dummy" GET respons body'sinde "data" degerinin ve "employee_name" degerinin String ""
    Then "dummy" GET respons body'sinde "data" degerinin ve "employee_salary" degerinin Integer 86000
    Then "dummy" GET respons body'sinde "data" degerinin ve "employee_age" degerinin Integer 66
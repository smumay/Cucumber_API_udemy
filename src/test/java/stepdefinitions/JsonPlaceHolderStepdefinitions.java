package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class JsonPlaceHolderStepdefinitions {
    String endPoint="";
    JsonPath responseJP;
    JSONObject postRequestBody;
    Response response;

    @Given("Kullanici {string} base URL'ini kullanir")
    public void kullanici_base_url_ini_kullanir(String istenenBaseUrl) {
        endPoint = ConfigReader.getProperty(istenenBaseUrl);
    }
    @Then("Path parametreleri icin {string} kullanir")
    public void path_parametreleri_icin_kullanir(String pathParams) {
        endPoint= endPoint+"/"+pathParams;
    }
    @And("jPH server a GET request gonderir ve testleri yapmak icin response degerini kaydeder")
    public void jphServerAGETRequestGonderirVeTestleriYapmakIcinResponseDegeriniKaydeder() {
        System.out.println(endPoint);
        response= given().when().get(endPoint);

    }

    @And("{string} server a GET request gonderir ve testleri yapmak icin response degerini kaydeder")
    public void serverAGETRequestGonderirVeTestleriYapmakIcinResponseDegeriniKaydeder(String serverAttribute) {
        System.out.println(endPoint);
        response= given().when().get(endPoint);

    }
    @Then("jPH respons'da status degerinin {int}")
    public void jphResponsDaStatusDegerinin(int statusCode) {
        System.out.println(response.statusCode());
        Assert.assertEquals(statusCode,response.statusCode());
    }

    @And("jPH respons'da content type degerinin {string}")
    public void jphResponsDaContentTypeDegerinin(String contentType) {
        Assert.assertEquals(contentType,response.contentType());
    }


    @Then("jPH GET respons body'sinde {string} degerinin Integer {int}")
    public void jphGETResponsBodySindeDegerininInteger(String attribute, int value) {
        responseJP = response.jsonPath();
        Assert.assertEquals(value,responseJP.getInt(attribute));
    }

    @And("jPH GET respons body'sinde {string} degerinin String {string}")
    public void jphGETResponsBodySindeDegerininString(String attribute, String value) {
        responseJP = response.jsonPath();
        Assert.assertEquals(value,responseJP.getString(attribute));
    }


    @Then("POST request icin {string},{string},{int} {int} bilgileri ile request body olusturur")
    public void post_request_icin_bilgileri_ile_request_body_olusturur(String title, String body, Integer userId, Integer id) {
        postRequestBody =new JSONObject();
        postRequestBody.put("title",title);
        postRequestBody.put("body",body);
        postRequestBody.put("userId",userId);
        postRequestBody.put("id",id);
    }

    @And("jPH server a POST request gonderir ve testleri yapmak icin response degerini kaydeder")
    public void jphServerAPOSTRequestGonderirVeTestleriYapmakIcinResponseDegeriniKaydeder() {

        response = given()
                .when().body(postRequestBody.toString()).contentType(ContentType.JSON)
                .put(endPoint);
        response.prettyPrint();

    }

    @And("jPH respons daki {string} header degerinin {string}")
    public void jphResponsDakiHeaderDegerinin(String headerAttribute, String value) {
        assertEquals(value,response.header("Connection"));
    }


    @Then("response attribute degerlerinin {string},{string},{int} {int}")
    public void response_attribute_degerlerinin(String title, String body, Integer userId, Integer id) {


        responseJP = response.jsonPath();
        Assert.assertEquals(title,responseJP.getString("title"));
        Assert.assertEquals(body,responseJP.getString("body"));
        Assert.assertEquals(userId,(Integer)responseJP.getInt("userId"));
        Assert.assertEquals(id,(Integer)responseJP.getInt("id"));
    }

//*****************************************************************DUMMY**************
    @Then("{string} respons'da status degerinin {int}")
    public void respons_da_status_degerinin(String serverAttribute, Integer statusCode) {
        System.out.println(response.statusCode());
        Assert.assertEquals(statusCode,(Integer)response.statusCode());

    }

    @Then("{string} respons'da content type degerinin {string}")
    public void respons_da_content_type_degerinin(String serverAttribute, String contentType) {
        Assert.assertEquals(contentType,response.contentType());
    }

    @Then("{string} GET respons body'sinde {string} degerinin String {string}")
    public void get_respons_body_sinde_degerinin_string(String serverAttribute, String attribute, String value) {
                responseJP=response.jsonPath();
                Assert.assertEquals(value,responseJP.getString(attribute));

    }

    @Then("{string} GET respons body'sinde {string} degerinin ve {string} String {string}")
    public void get_respons_body_sinde_degerinin_ve_string(String serverAttribute, String data, String profilimage, String value) {
        responseJP=response.jsonPath();

    }

    @Then("{string} GET respons body'sinde {string} degerinin ve {string} Integer {int}")
    public void get_respons_body_sinde_degerinin_ve_integer(String string, String string2, String string3, Integer int1) {

    }

    @Then("{string} GET respons body'sinde {string} degerinin ve {string} degerinin String {string}")
    public void get_respons_body_sinde_degerinin_ve_degerinin_string(String string, String string2, String string3, String string4) {

    }
    @Then("{string} GET respons body'sinde {string} degerinin ve {string} degerinin Integer {int}")
    public void get_respons_body_sinde_degerinin_ve_degerinin_integer(String string, String string2, String string3, Integer int1) {

    }

}
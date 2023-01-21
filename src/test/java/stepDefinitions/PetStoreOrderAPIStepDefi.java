package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PetStorePojo;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class PetStoreOrderAPIStepDefi {
    static Faker faker;
    static Random rnd;
    public PetStorePojo expectedData;
    static RequestSpecification spec;
    String postData;
    Response response;
    int getData;
    int deleteData;
    @Given("Kullanici kayit etmek istedigi store bilgilerini olusturur")
    public void kullanici_kayit_etmek_istedigi_store_bilgilerini_olusturur() {
    spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
    postData = "{\n" +
            "  \"id\": 25,\n" +
            "  \"petId\": 1001,\n" +
            "  \"quantity\": 1,\n" +
            "  \"shipDate\": \"2022-08-31T12:02:34.145Z\",\n" +
            "  \"status\": \"placed\",\n" +
            "  \"complete\": true\n" +
            "}";
    }
    @Then("Kullanici API ile post request olusturarak yeni bir store order kayit eder")
    public void kullanici_api_ile_post_request_olusturarak_yeni_bir_store_order_kayit_eder() {
    spec.pathParams("first","store","second","order");
    response=given().spec(spec).contentType(ContentType.JSON).when().body(postData).post("/{first}/{second}");
    response.prettyPrint();
    }
    @Then("Kullanici API ile gelen cevabi kaydeder beklenen cevap ile karsilastirir")
    public void kullanici_api_ile_gelen_cevabi_kaydeder_beklenen_cevap_ile_karsilastirir() {
    response.then().statusCode(200);
    }
    @Given("Kullanici store bolumu get request icin expected data belirler")
    public void kullanici_store_bolumu_get_request_icin_expected_data_belirler() {
    getData=25;
    spec.pathParams("first","store","second","order","third",getData);
    }
    @Then("Kullanici API ile store bolumu actual datayı get request ile kaydeder")
    public void kullanici_api_ile_store_bolumu_actual_datayı_get_request_ile_kaydeder() {
    response=given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}/{third}");
    response.prettyPrint();
    }
    @Then("Kullanici store bolumu API ile gelen cevap ile beklenen cevabi karsilastirir")
    public void kullanici_store_bolumu_api_ile_gelen_cevap_ile_beklenen_cevabi_karsilastirir() {
    response.then().statusCode(200);
    }
    @Given("Kullanici store bolumu delete request icin expected data belirler")
    public void kullanici_store_bolumu_delete_request_icin_expected_data_belirler() {
    deleteData=25;
    spec.pathParams("first","store","second","order","third",deleteData);
    }
    @Then("Kullanici store bolumu API ile expected datayı delete yapar")
    public void kullanici_store_bolumu_api_ile_expected_datayı_delete_yapar() {
    response=given().spec(spec).header("api_key","ysftpl").contentType(ContentType.JSON).when().delete("/{first}/{second}/{third}");
    response.prettyPrint();
    }
    @Then("Kullanici store bolumu API ile gelen cevabi dogrular")
    public void kullanici_store_bolumu_api_ile_gelen_cevabi_dogrular() {
    response.then().statusCode(200);
    }

    @Given("Kullanici store bolumu negative delete request icin expected data belirler")
    public void kullaniciStoreBolumuNegativeDeleteRequestIcinExpectedDataBelirler() {
    deleteData=25;
    spec.pathParams("first","store","second","order","third",deleteData);
    }

    @Then("Kullanici store bolumu API ile negative delete yapar")
    public void kullaniciStoreBolumuAPIIleNegativeDeleteYapar() {
    response=given().spec(spec).header("api_key","ysftpl").contentType(ContentType.JSON).when().delete("/{first}/{second}/{third}");
    response.prettyPrint();
    }

    @And("Kullanici store bolumu API ile negative gelen cevabi dogrular")
    public void kullaniciStoreBolumuAPIIleNegativeGelenCevabiDogrular() {
    response.then().statusCode(404);
    }
}

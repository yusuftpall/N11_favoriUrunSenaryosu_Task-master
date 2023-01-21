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

public class PetStorePetAPIStepDefi {
    static Faker faker;
    static Random rnd;
    public PetStorePojo expectedData;
    static RequestSpecification spec;
    String postData;
    Response response;
    int getData;
    int deleteData;
    @Given("Kullanici kayit etmek istedigi pet bilgilerini olusturur")
    public void kullanici_kayit_etmek_istedigi_pet_bilgilerini_olusturur() {
    spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
    postData = "{\n" +
            "  \"id\": 25,\n" +
            "  \"category\": {\n" +
            "    \"id\": 1001,\n" +
            "    \"name\": \"Kangal\"\n" +
            "  },\n" +
            "  \"name\": \"Sivas\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"http://www.sivas.gov.tr/kurumlar/sivas.gov.tr/Sehir_Etiketleri/Kangal-Coban-Kopegi/img0.jpg\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 58,\n" +
            "      \"name\": \"Sivas\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
    }
    @Then("Kullanici API ile post request olusturarak yeni bir pet kayit eder")
    public void kullanici_api_ile_post_request_olusturarak_yeni_bir_pet_kayit_eder() {
    spec.pathParam("first","pet");
    response=given().spec(spec).contentType(ContentType.JSON).when().body(postData).post("/{first}");
    response.prettyPrint();
    }
    @Then("Kullanici API ile gelen cevabi kaydeder, beklenen cevap ile karsilastirir")
    public void kullanici_api_ile_gelen_cevabi_kaydeder_beklenen_cevap_ile_karsilastirir() {
    response.then().statusCode(200);
    }

    @Given("Kullanici pet bolumu get request icin expected data belirler")
    public void kullanici_pet_bolumu_get_request_icin_expected_data_belirler() {
    getData=25;
    spec.pathParams("first","pet","second",getData);
    }
    @Then("Kullanici API ile pet bolumu actual datayı get request ile kaydeder")
    public void kullanici_api_ile_pet_bolumu_actual_datayı_get_request_ile_kaydeder() {
    response=given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
    response.prettyPrint();
    }
    @Then("Kullanici pet bolumu API ile gelen cevap ile beklenen cevabi karsilastirir")
    public void kullanici_pet_bolumu_api_ile_gelen_cevap_ile_beklenen_cevabi_karsilastirir() {
    response.then().statusCode(200);
    }

    @Given("Kullanici pet bolumu delete request icin expected data belirler")
    public void kullanici_pet_bolumu_delete_request_icin_expected_data_belirler() {
    deleteData=25;
    spec.pathParams("first","pet","second",deleteData);
    }
    @Then("Kullanici pet bolumu API ile expected datayı delete yapar")
    public void kullanici_pet_bolumu_api_ile_expected_datayı_delete_yapar() {
    response=given().spec(spec).header("api_key","ysftpl").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }
    @Then("Kullanici pet bolumu API ile gelen cevabi dogrular")
    public void kullanici_pet_bolumu_api_ile_gelen_cevabi_dogrular() {
    response.then().statusCode(200);
    }

    @Given("Kullanici Pet bolumu negative delete request icin expected data belirler")
    public void kullaniciPetBolumuNegativeDeleteRequestIcinExpectedDataBelirler() {
    deleteData=25;
    spec.pathParams("first","pet","second",deleteData);
    }

    @Then("Kullanici Pet bolumu API ile negative delete yapar")
    public void kullaniciPetBolumuAPIIleNegativeDeleteYapar() {
    response=given().spec(spec).header("api_key","ysftpl").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }

    @And("Kullanici Pet bolumu API ile negative gelen cevabi dogrular")
    public void kullaniciPetBolumuAPIIleNegativeGelenCevabiDogrular() {
    response.then().statusCode(404);
    }
}

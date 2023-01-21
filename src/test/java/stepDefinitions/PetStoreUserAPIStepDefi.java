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

import java.util.*;

import static io.restassured.RestAssured.*;

public class PetStoreUserAPIStepDefi {
    static Faker faker;
    static Random rnd;
    //protected RequestSpecification spec;
    public PetStorePojo expectedData;
    static RequestSpecification spec;
    String postData;
    Response response;
    String getData;
    String deleteData;

    @Given("Kullanici kayit etmek istedigi kullanicinin bilgilerini olusturur")
    public void kullanici_kayit_etmek_istedigi_kullanicinin_bilgilerini_olusturur() {

        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
        postData = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"username\": \"ysftpl\",\n" +
                "    \"firstName\": \"Yusuf\",\n" +
                "    \"lastName\": \"TOPAL\",\n" +
                "    \"email\": \"ysftpall@gmail.com\",\n" +
                "    \"password\": \"Y123456789\",\n" +
                "    \"phone\": \"5055554789\",\n" +
                "    \"userStatus\": 1\n" +
                "  }\n" +
                "]";

    }
    @Given("Kullanici API ile post request olusturarak yeni bir kullanici kayit eder")
    public void kullanici_api_ile_post_request_olusturarak_yeni_bir_kullanici_kayit_eder() {
    spec.pathParams("first","user","second","createWithList");
    response=given().spec(spec).contentType(ContentType.JSON).when().body(postData).post("/{first}/{second}");
    response.prettyPrint();



    }
    @Then("Kullanici API ile gelen cevabi kaydeder ve alinan cevap ile beklenen cevabi karsilastirir")
    public void kullanici_api_ile_gelen_cevabi_kaydeder_ve_alinan_cevap_ile_beklenen_cevabi_karsilastirir() {
    response.then().statusCode(200);


    }

    @Given("Kullanici get request icin expected data belirler")
    public void kullaniciGetRequestIcinExpectedDataBelirler() {
    getData="ysftpl";
    spec.pathParams("first","user","second",getData);

    }

    @Then("Kullanici user bolumu API ile actual datayı get request ile kaydeder")
    public void kullaniciuserbolumuAPIIleActualDatayıGetRequestIleKaydeder() {
    response=given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
    response.prettyPrint();
    }

    @And("Kullanici API ile gelen cevap ile beklenen cevabi karsilastirir")
    public void kullaniciAPIIleGelenCevapileBeklenenCevabiKarsilastirir() {
    response.then().statusCode(200);

    }

    @Given("Kullanici delete request icin expected data belirler")
    public void kullaniciDeleteRequestIcinExpectedDataBelirler() {
    deleteData="ysftpl";
    spec.pathParams("first","user","second",deleteData);
    }

    @Then("Kullanici API ile expected datayı delete yapar")
    public void kullaniciAPIIleExpectedDatayıDeleteYapar() {
    response=given().spec(spec).header("api_key","ysftpl").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }

    @And("Kullanici API ile gelen cevabi dogrular")
    public void kullaniciAPIIleGelenCevabiDogrular() {
    response.then().statusCode(200);
    }

    @Given("Kullanici User bolumu negative delete request icin expected data belirler")
    public void kullaniciUserBolumuNegativeDeleteRequestIcinExpectedDataBelirler() {
    deleteData="ysftpl";
    spec.pathParams("first","user","second",deleteData);
    }

    @Then("Kullanici User bolumu API ile negative delete yapar")
    public void kullaniciUserBolumuAPIIleNegativeDeleteYapar() {
    response=given().spec(spec).header("api_key","ysftpl").contentType(ContentType.JSON).when().delete("/{first}/{second}");
    response.prettyPrint();
    }

    @And("Kullanici User bolumu API ile negative gelen cevabi dogrular")
    public void kullaniciUserBolumuAPIIleNegativeGelenCevabiDogrular() {
    response.then().statusCode(404);
    }
}

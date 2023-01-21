package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.N11Page;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.ReusableMethods.*;

public class N11StepDefi {
    N11Page n11=new N11Page();
    JavascriptExecutor js;
    String thirdItemText;


    @Given("kullanici {string} anasayfasina gider")
    public void kullanici_anasayfasina_gider(String string) {
    Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
    waitForClickablility(n11.cookies,10);
    n11.cookies.click();
    getScreenshot("1-N11Anasayfa");
    }
    @Given("kullanici {string} anasayfasinin acildigini kontrol eder")
    public void kullanici_anasayfasinin_acildigini_kontrol_eder(String url) {
    String expectedUrl=ConfigReader.getProperty(url);
    String actualUrl=Driver.getDriver().getCurrentUrl();
    Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Given("kullanici siteye login olur")
    public void kullanici_siteye_login_olur() {
    js= (JavascriptExecutor) Driver.getDriver();
    n11.signInButton.click();
    getScreenshot("2-signInButtonClick");
    waitForClickablility(n11.opportunityButton,15);
    n11.opportunityButton.click();
    n11.emailTextBox.sendKeys(ConfigReader.getProperty("n11UserEmail"));
    n11.passwordTextBox.sendKeys(ConfigReader.getProperty("n11UserPassword"));
    getScreenshot("3-userName&Password");
    js.executeScript("arguments[0].click();", n11.signInButton2);
    waitFor(3);
    getScreenshot("4-signInSuccessful");


    }
    @Given("kullanici login oldugunu kontrol eder")
    public void kullanici_login_oldugunu_kontrol_eder() {
    String expectedLogin="YT";
    String actualLogin=n11.loginText.getText();
    Assert.assertEquals(expectedLogin,actualLogin);
    }

    @Given("kullanici arama kutusuna {string} yazar ve arama yapar")
    public void kullanici_arama_kutusuna_yazar_ve_arama_yapar(String searchText) {
    n11.searchBox.sendKeys(searchText,Keys.ENTER);
    waitFor(3);
    getScreenshot("5-iphoneSearch");
    }

    @Given("kullanici arama sonuclarinin {string} icerdigini kontrol eder")
    public void kullanici_arama_sonuclarinin_icerdigini_kontrol_eder(String expectedSearcResult) {
    String actualResult=n11.searchResult.getText();
    Assert.assertTrue(actualResult.contains(expectedSearcResult));
    }

    @Then("kullanici arama sonuc sayfasindan ikinci sayfaya gider")
    public void kullanici_arama_sonuc_sayfasindan_ikinci_sayfaya_gider() {
    js= (JavascriptExecutor) Driver.getDriver();
    js.executeScript("arguments[0].click();", n11.secondPage);
    waitFor(3);
    getScreenshot("6-searchSecondPage");
    }

    @Then("kullanici ikinci sayfanin acildigini kontrol eder")
    public void kullanici_ikinci_sayfanin_acildigini_kontrol_eder() {
    String expectedSecondPage="active ";
    String actualSecondPage=n11.secondPage.getAttribute("class");
    Assert.assertEquals(expectedSecondPage,actualSecondPage);
    waitFor(3);

    }
    @Then("kullanici acilan sayfada ucuncu urunu favori listesine ekler")
    public void kullanici_acilan_sayfada_ucuncu_urunu_favori_listesine_ekler() {
    n11.thirdItemFavoriteButton.click();
    waitFor(3);
    getScreenshot("7-favoriteButtonClick");
    thirdItemText=n11.thirdItem.getText();
    }

    @Given("kullanici favori listem sayfasina gider")
    public void kullanici_favori_listem_sayfasina_gider() {
    hover(n11.loginText);
    waitFor(3);
    getScreenshot("8-myAccountMenu");
    n11.favoriteListButton.click();
    waitFor(3);
    getScreenshot("9-favoritePage");
    n11.favoriteListPage.click();
    waitFor(3);
    getScreenshot("10-myFavoritePage");
    }

    @Given("kullanici favori listem sayfasinin acildigini kontrol eder")
    public void kullanici_favori_listem_sayfasinin_acildigini_kontrol_eder() {
    String expectedFavoriteText="Favorilerim";
    String actualFavoriteText=n11.favoriteListControl.getText();
    Assert.assertEquals(expectedFavoriteText,actualFavoriteText);
    }

    @Given("kullanici ucuncu urunun favori listesine eklendigini kontrol eder")
    public void kullanici_ucuncu_urunun_favori_listesine_eklendigini_kontrol_eder() {
    String actualFavoriteItemText=n11.favoriteListItem.getAttribute("alt");
    Assert.assertEquals(thirdItemText,actualFavoriteItemText);
    waitFor(3);
    }

    @Then("kullanici eklenen urunu favori listesinden siler")
    public void kullanici_eklenen_urunu_favori_listesinden_siler() {
    n11.deleteButton.click();
    waitFor(3);
    getScreenshot("11-deleteButtonClick");
    }

    @Then("kullanici silme isleminin gerceklestigini kontrol eder")
    public void kullanici_silme_isleminin_gerceklestigini_kontrol_eder() {
    Assert.assertTrue(n11.deletedMessage.isDisplayed());
    n11.deletedMessageOkButton.click();
    waitFor(3);
    }

    @Then("kullanici hesabim bolumunden cikis islemi yapar")
    public void kullanici_hesabim_bolumunden_cikis_islemi_yapar() {
    hover(n11.loginText);
    waitFor(2);
    n11.logOutButton.click();
    waitFor(2);
    getScreenshot("12-logOutClick");
    }

    @Then("kullanici cikis isleminin yapildigini kontrol eder")
    public void kullanici_cikis_isleminin_yapildigini_kontrol_eder() {
    Assert.assertTrue(n11.signInButton2.isDisplayed());
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class N11Page {
    public N11Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (className="btnSignIn")
    public WebElement signInButton;
    @FindBy (xpath = "//input[@id='email']")
    public WebElement emailTextBox;
    @FindBy (xpath="//button[@class='dn-slide-deny-btn']")
    public WebElement opportunityButton;
    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextBox;
    @FindBy (xpath="//div[@id='loginButton']")
    public WebElement signInButton2;
    @FindBy (xpath = "//span[text()='Tümünü Kabul Et']")
    public WebElement cookies;
    @FindBy (xpath = "//a[@title='Hesabım']")
    public WebElement loginText;
    @FindBy (id="searchData")
    public WebElement searchBox;
    @FindBy (xpath = "//div[@class='resultText ']")
    public WebElement searchResult;
    @FindBy (xpath = "//a[@data-page='2']")
    public WebElement secondPage;
    @FindBy (xpath = "(//span[@title='Favorilere ekle'])[3]")
    public WebElement thirdItemFavoriteButton;

    @FindBy (xpath = "(//h3[@class='productName'])[3]")
    public WebElement thirdItem;

    @FindBy (xpath = "//a[@title='Favorilerim / Listelerim']")
    public WebElement favoriteListButton;

    @FindBy (xpath = "//span[@class='icon-base heart-favorites-black']")
    public WebElement favoriteListPage;

    @FindBy (xpath = "//*[text()='Favorilerim']")
    public WebElement favoriteListControl;

    @FindBy (xpath = "(//img[@width='215'])[1]")
    public WebElement favoriteListItem;

    @FindBy (xpath="//span[@class='deleteProFromFavorites']")
    public WebElement deleteButton;

    @FindBy (xpath = "//span[@class='message']")
    public WebElement deletedMessage;

    @FindBy (xpath = "//span[@class='btn btnBlack confirm']")
    public WebElement deletedMessageOkButton;


    @FindBy (xpath = "//a[@class='logoutBtn']")
    public WebElement logOutButton;


    @FindBy (xpath = "//h1[@class='a-spacing-small']")
    public WebElement signOutControl;

    @FindBy (xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement secondItemControl;




















}
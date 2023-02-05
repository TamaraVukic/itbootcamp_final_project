package pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilPage extends BasePage {
    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "phone")
    private WebElement inputPhone;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button")
    private WebElement deletePhone;
    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
    private WebElement deleteCity;

    @FindBy(id = "country")
    private WebElement inputCountry;

    @FindBy(id = "urlTwitter")
    private WebElement inputTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement inputGitHub;

    @FindBy(className = "btnSave")
    private WebElement btnSave;

    @FindBy(css = "#app > div.v-application--wrap > main > div > div.container.container--fluid > div > div > div:nth-child(4) > div > div > div > div > div.v-snack__content")
    private WebElement message;

    @FindBy(css = "#app > div.v-application--wrap > main > div > div.container.container--fluid > div > div > div:nth-child(4) > div > div > div > div > div.v-snack__content > button > span")
    private WebElement btnCloseMessage;

    public ProfilPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void clearFields() {
        inputName.click();
        inputName.sendKeys(Keys.CONTROL + "a");
        inputName.sendKeys(Keys.DELETE);

        deletePhone.click();

        deleteCity.click();

        inputCountry.sendKeys(Keys.CONTROL + "a");
        inputCountry.sendKeys(Keys.DELETE);
        inputTwitter.sendKeys(Keys.CONTROL + "a");
        inputTwitter.sendKeys(Keys.DELETE);
        inputGitHub.sendKeys(Keys.CONTROL + "a");
        inputGitHub.sendKeys(Keys.DELETE);


    }

    public WebElement getMessageElement() {
        return message;
    }

    public String getMessage() {
        return message.getText();
    }

    public String getName() {
        return inputName.getAttribute("value");
    }

    public String getPhone() {
        return inputPhone.getAttribute("value");
    }

    public String getCity() {
        return inputCity.getAttribute("value");
    }

    public String getCountry() {
        return inputCountry.getAttribute("value");
    }

    public String getTwitter() {
        return inputTwitter.getAttribute("value");
    }

    public String getGitHub() {
        return inputGitHub.getAttribute("value");
    }

    public void pickCity(String city) {
        inputCity.click();
        inputCity.sendKeys(Keys.ENTER, city, Keys.ENTER);
    }


    public void editProfile(String name, String phone, String city, String country, String twitter, String gitHub) {
        clearFields();
        inputName.sendKeys(name);
        inputPhone.sendKeys(phone);
        pickCity(city);
        inputCountry.sendKeys(country);
        inputTwitter.sendKeys(twitter);
        inputGitHub.sendKeys(gitHub);
        btnSave.click();
    }

    public void closeMessage() {
        btnCloseMessage.click();
    }

}

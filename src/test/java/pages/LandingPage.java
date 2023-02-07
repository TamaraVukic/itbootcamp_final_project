package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]/span")
    private WebElement signUpBtn;

    @FindBy(className = "btnLocaleActivation")
    private WebElement btnlocale;

    @FindBy(className = "btnEN")
    private WebElement btnEn;

    @FindBy(className = "btnES")
    private WebElement btnEs;

    @FindBy(className = "btnFR")
    private WebElement btnFr;

    @FindBy(className = "display-2")
    private WebElement header;

    public LandingPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void login() {
        loginBtn.click();
    }

    public void signUp() {
        signUpBtn.click();
    }

    public void locale() {
        btnlocale.click();
    }

    public void pickLanguage(Locale locale) {

        switch (locale) {
            case EN:
                btnEn.click();
                break;
            case ES:
                btnEs.click();
                break;
            case FR:
                btnFr.click();
                break;
        }
    }

    public String getHeader() {
        return header.getText();
    }

    public WebElement getBtnEs() {
        return btnEs;
    }

    public WebElement getBtnEn() {
        return btnEn;
    }

    public WebElement getBtnFr() {
        return btnFr;
    }
}

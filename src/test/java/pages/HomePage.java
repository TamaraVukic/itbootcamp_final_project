package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logoutBtn;

    @FindBy(className = "dlgVerifyAccount")
    private WebElement vDialog;

//    @FindBy(className = "v-card__title")
//    private WebElement vDialog;

    @FindBy(className = "btnClose")
    private WebElement btnClose;

    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public String getVdialog() {
        return vDialog.getText();
    }

    public WebElement getVdialogElement() {
        return vDialog;
    }

    public boolean logoutIsVisible() {
        return logoutBtn.isDisplayed();
    }

    public void logout() {
        logoutBtn.click();
    }

    public void closeDialog() {
        btnClose.click();
    }
}

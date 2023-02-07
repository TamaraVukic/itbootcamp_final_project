package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    @FindBy(css = "#app > div.v-application--wrap > div > header > div > div.v-toolbar__items > button.hidden-sm-and-down.btnLogout.v-btn.v-btn--text.theme--light.v-size--default")
    private WebElement logoutBtn;

    @FindBy(className = "dlgVerifyAccount")
    private WebElement vDialog;

    @FindBy(className = "btnClose")
    private WebElement btnClose;

    @FindBy(className = "btnAdmin")
    private WebElement adminBtn;

    @FindBy(className = "btnProfile")
    private WebElement profileBtn;

    @FindBy(className = "btnAdminCities")
    private WebElement cityBtn;

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

    public void selectCities() {
        adminBtn.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(cityBtn));
        cityBtn.click();
    }

    public void profile() {
        profileBtn.click();
        webDriverWait.until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/profile"));
    }
}

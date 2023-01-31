package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement btnLogin;

    @FindBy(className = "v-snack__content")
    private WebElement message;


    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public String getEmail() {
        return inputEmail.getAttribute("type");
    }

    public String getPassword() {
        return inputPassword.getAttribute("type");
    }

    public void loginConfirm() {
        btnLogin.click();
    }

    public String getMessage() {
        return message.getText();
    }

    public void fillEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void fillPassword(String password) {
        inputEmail.clear();
        inputPassword.sendKeys(password);
    }

    public void fillLoginForm (String email, String password){
       fillEmail(email);
       fillPassword(password);
       btnLogin.click();
    }

    public WebElement getMessageElement (){
        return message;
    }

}

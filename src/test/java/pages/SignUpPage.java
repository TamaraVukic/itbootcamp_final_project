package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "confirmPassword")
    private WebElement inputConfirmPassword;

    @FindBy(className = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement btnSignUp;

    @FindBy (xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement vDialog;

    @FindBy(className = "v-snack__content")
    private WebElement message;

    public SignUpPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public String getName() {
        return inputName.getAttribute("type");
    }

    public String getEmail() {
        return inputEmail.getAttribute("type");
    }

    public String getPassword() {
        return inputPassword.getAttribute("type");
    }

    public void signUp (){
        btnSignUp.click();
    }

    public String getMessage() {
        return message.getText();
    }

    public String getVdialog (){
        return vDialog.getText();
    }
}

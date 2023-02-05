package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpTests extends BaseTest {


    private SignUpPage signUpPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, webDriverWait);
        signUpPage = new SignUpPage(driver, webDriverWait);

    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.signUp();
    }


    @Test
    public void signUpRouteTest() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }


    @Test
    public void signUpInputTypesMatchTest() {
        Assert.assertEquals(signUpPage.getEmail(), "email");
        Assert.assertEquals(signUpPage.getPassword(), "password");
        Assert.assertEquals(signUpPage.getConfirmPassword(), "password");
    }

    @Test
    public void errorUserAlreadyExistsTest() {
        String existingName = "Test Test";
        signUpPage.fillSignUpForm(existingName, email, password, password);
        webDriverWait.until(ExpectedConditions.visibilityOf(signUpPage.getMessageElement()));

        Assert.assertTrue(signUpPage.getMessage().contains("E-mail already exists"));
        signUpRouteTest();
    }

    @Test
    public void validSignUp() {
        String fakerEmail = faker.internet().emailAddress();
        String fakerPassword = faker.internet().password();
        String fakerName = faker.name().name();

        signUpPage.fillSignUpForm(fakerName, fakerEmail, fakerPassword, fakerPassword);
        webDriverWait.until(ExpectedConditions.visibilityOf(homePage.getVdialogElement()));
        Assert.assertTrue(homePage.getVdialog().contains("IMPORTANT: Verify your account"));
        homePage.closeDialog();

    }
}

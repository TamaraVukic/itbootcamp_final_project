package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginLogoutTests extends BaseTest {

    private String fakerPassword;
    private LoginPage loginPage;


    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);
        homePage = new HomePage(driver, webDriverWait);
        fakerPassword = faker.internet().password();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.login();
    }

    @Test

    public void loginRouteTest() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void loginInputTypesMatchTest() {
        Assert.assertEquals(loginPage.getEmail(), "email");
        Assert.assertEquals(loginPage.getPassword(), "password");
    }

    @Test
    public void userDoesNotExistErrorTest() {
        String fakerEmail = faker.internet().emailAddress();
        loginPage.fillLoginForm(fakerEmail, fakerPassword);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginPage.getMessageElement()));
        Assert.assertTrue(loginPage.getMessage().contains("User does not exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void wrongPasswordError() {
        loginPage.fillLoginForm(EMAIL, fakerPassword);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginPage.getMessageElement()));
        Assert.assertTrue(loginPage.getMessage().contains("Wrong password"));
        loginRouteTest();
    }

    @Test
    public void validLoginTest() {
        loginPage.fillLoginForm(EMAIL, PASSWORD);
        webDriverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void logout() {
        loginPage.fillLoginForm(EMAIL, PASSWORD);
        webDriverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(homePage.logoutIsVisible());
        homePage.logout();

        driver.get(BASE_URL + "home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}

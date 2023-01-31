package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);
    }

    @BeforeMethod
    public void beforeMethod () {
        super.beforeMethod();
        homePage.login();
    }

    @Test

    public void loginRoute() {
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }


    public void inputTypesMatch (){

    }

}

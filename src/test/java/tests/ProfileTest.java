package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;


public class ProfileTest extends BaseTest {

    private LoginPage loginPage;
    private ProfilePage profilePage;
    private String city;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);
        homePage = new HomePage(driver, webDriverWait);
        profilePage = new ProfilePage(driver, webDriverWait);
        city = "New York";
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.login();
        loginPage.fillLoginForm(EMAIL, PASSWORD);
        homePage.profile();
    }

    @Test
    public void editProfileTest() {
        String randomName = faker.name().firstName();
        String randomPhone = faker.phoneNumber().cellPhone();
        String randomCountry = faker.country().name();
        String randomGitHub = "https://github.com/" + randomName.toLowerCase();
        String randomTwitter = "https://twitter.com/" + randomName.toLowerCase();
        profilePage.editProfile(randomName, randomPhone, city, randomCountry, randomTwitter, randomGitHub);

        webDriverWait.until(ExpectedConditions.visibilityOf(profilePage.getMessageElement()));
        Assert.assertTrue(profilePage.getMessage().contains("Profile saved successfuly"));
        profilePage.closeMessage();
        Assert.assertEquals(profilePage.getName(), randomName);
        Assert.assertEquals(profilePage.getPhone(), randomPhone);
        Assert.assertEquals(profilePage.getCity(), city);
        Assert.assertEquals(profilePage.getCountry(), randomCountry);
        Assert.assertEquals(profilePage.getTwitter(), randomTwitter);
        Assert.assertEquals(profilePage.getGitHub(), randomGitHub);
    }

}

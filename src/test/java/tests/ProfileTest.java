package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilPage;

import java.util.Locale;

public class ProfileTest extends BaseTest {

    private LoginPage loginPage;
    private ProfilPage profilPage;
    private String city;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);
        homePage = new HomePage(driver, webDriverWait);
        profilPage = new ProfilPage(driver, webDriverWait);
        city = "New York";

    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.login();
        loginPage.fillLoginForm(email, password);
        homePage.profile();
    }

    @Test
    public void editProfileTest() {
        String randomName = faker.name().firstName();
        String randomPhone = faker.phoneNumber().cellPhone();
        String randomCountry = faker.country().name();
        String randomGitHub = "https://github.com/" + randomName.toLowerCase();
        String randomTwitter = "https://twitter.com/" + randomName.toLowerCase();
        profilPage.editProfile(randomName, randomPhone, city, randomCountry, randomTwitter, randomGitHub);

        webDriverWait.until(ExpectedConditions.visibilityOf(profilPage.getMessageElement()));
        Assert.assertTrue(profilPage.getMessage().contains("Profile saved successfuly"));
        profilPage.closeMessage();
        Assert.assertEquals(profilPage.getName(), randomName);
        Assert.assertEquals(profilPage.getPhone(), randomPhone);
        Assert.assertEquals(profilPage.getCity(), city);
        Assert.assertEquals(profilPage.getCountry(), randomCountry);
        Assert.assertEquals(profilPage.getTwitter(), randomTwitter);
        Assert.assertEquals(profilPage.getGitHub(), randomGitHub);
    }

}

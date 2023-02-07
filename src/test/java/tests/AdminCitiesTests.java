package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest {

    private String city;
    private LoginPage loginPage;
    private AdminCitiesPage adminCitiesPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);
        homePage = new HomePage(driver, webDriverWait);
        adminCitiesPage = new AdminCitiesPage(driver, webDriverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        landingPage.login();
        loginPage.fillLoginForm(EMAIL, PASSWORD);
        homePage.selectCities();
        city = faker.address().cityName();
    }

    @Test
    public void adminRouteTest() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(adminCitiesPage.logoutIsVisible());
    }

    @Test
    public void createNewCityTest() {
        adminCitiesPage.addNewCity(city);
        Assert.assertTrue(adminCitiesPage.getMessage().contains("Saved successfully"));
    }

    @Test
    public void editCityTest() {
        adminCitiesPage.newCityEdit(city);
        Assert.assertTrue(adminCitiesPage.getMessage().contains("Saved successfully"));
    }

    @Test
    public void searchCityTest() {
        adminCitiesPage.newCityEdit(city);
        adminCitiesPage.searchCity(city);
        Assert.assertTrue(adminCitiesPage.getCreatedCity().contains(city));
    }

    @Test
    public void deleteCityTest() {
        adminCitiesPage.newCityEdit(city);
        adminCitiesPage.searchCity(city);
        Assert.assertTrue(adminCitiesPage.getCreatedCity().contains(city));
        adminCitiesPage.deleteCity();
        webDriverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getMessageElement()));
        Assert.assertTrue(adminCitiesPage.getMessage().contains("Deleted successfully"));
        adminCitiesPage.closeMessage();
    }

}

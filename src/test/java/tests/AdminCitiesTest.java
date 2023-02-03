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

public class AdminCitiesTest extends BaseTest {

    // private String city = "Pera";
    private String city = faker.address().cityName();
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
        loginPage.fillLoginForm(email, password);
        homePage.selectCities();
    }

    @Test(priority = 1)
    public void adminRouteTest() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(adminCitiesPage.logoutIsVisible());
    }

    @Test(priority = 2)
    public void createNewCityTest() {
        adminCitiesPage.addNewCity();
        adminCitiesPage.fillCityName(city);

        Assert.assertTrue(adminCitiesPage.getMessage().contains("Saved successfully"));
    }


    @Test(priority = 3)
    public void editCityTest() {

        adminCitiesPage.searchCity(city); //in case the test runs separately from other tests
        adminCitiesPage.editCity();
        Assert.assertTrue(adminCitiesPage.getMessage().contains("Saved successfully"));
    }

    @Test(priority = 4)
    public void searchCityTest() {
      //  adminCitiesPage.searchCity(city);

        Assert.assertTrue(adminCitiesPage.getCreatedCity().contains(city));
    }

    @Test(priority = 5)
    public void deleteCityTest() {
        searchCityTest();

        adminCitiesPage.deleteCity();

        webDriverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getMessageElement()));
        Assert.assertTrue(adminCitiesPage.getMessage().contains("Deleted successfully"));
        adminCitiesPage.closeMessage();
    }
}

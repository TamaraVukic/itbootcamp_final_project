package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LandingPage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    protected LandingPage landingPage;
    protected HomePage homePage;
    protected Faker faker;

    protected final String email = "admin@admin.com";  //Valid email and password
    protected final String password = "12345";

    protected final String baseUrl = "https://vue-demo.daniel-avellaneda.com/";


    // since the LandingPage is a starting point for every test class, it is initialized in @BeforeClass
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\ITBOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver, webDriverWait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //Excluding landing page, login page, and sign up page from the list of pages that should have Logout Button.
    //Only user that is logged in should be able to log out.
    //In order to perform all tests from a logged out state, this afterMethod logs the user out
    @AfterMethod
    public void afterMethod() {

        if (!driver.getCurrentUrl().equals(baseUrl) && !driver.getCurrentUrl().endsWith("/login") && !driver.getCurrentUrl().endsWith("/signup")) {
            WebElement logout = driver.findElement(By.cssSelector("#app > div.v-application--wrap > div > header > div > div.v-toolbar__items > button.hidden-sm-and-down.btnLogout.v-btn.v-btn--text.theme--light.v-size--default"));
            if (logout.isDisplayed() && logout.getText().equalsIgnoreCase("logout")) {
                logout.click();
            }
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

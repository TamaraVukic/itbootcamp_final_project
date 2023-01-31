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
    protected Faker faker = new Faker(); // da li je ovo ispravno

    protected final String email = "admin@admin.com";
    protected final String password = "12345";

    protected String fakerEmail = faker.internet().emailAddress();
    protected String fakerPassword = faker.internet().password();

    protected final String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\ITBOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver, webDriverWait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void afterMethod() {
        if (!driver.getCurrentUrl().equals(baseUrl) && !driver.getCurrentUrl().endsWith("/login")){
        System.out.println("ovde sam");
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        if (logout.isDisplayed() && logout.getText().equalsIgnoreCase("logout")) {
            System.out.println("hello");
            logout.click();
    }}

    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }

}

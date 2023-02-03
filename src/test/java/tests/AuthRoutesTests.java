package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void authRouteHomeTest() {
        driver.get(baseUrl + "home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void authRouteProfileTest() {
        driver.get(baseUrl + "profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void authRouteAdminCitiesTest() {
        driver.get(baseUrl + "admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void authRouteAdminUsersTest() {
        driver.get(baseUrl + "admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}

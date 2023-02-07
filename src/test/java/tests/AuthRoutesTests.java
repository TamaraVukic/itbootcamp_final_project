package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void authRouteHomeTest() {
        driver.get(BASE_URL + "home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void authRouteProfileTest() {
        driver.get(BASE_URL + "profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void authRouteAdminCitiesTest() {
        driver.get(BASE_URL + "admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void authRouteAdminUsersTest() {
        driver.get(BASE_URL + "admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}

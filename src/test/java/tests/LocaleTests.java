package tests;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locale;

public class LocaleTests extends BaseTest {

    @Test
    public void localeEnTest() {
        landingPage.locale();
        webDriverWait.until(ExpectedConditions.visibilityOf(landingPage.getBtnEn()));
        landingPage.pickLanguage(Locale.EN);
        Assert.assertTrue(landingPage.getHeader().contains("Landing"));

    }

    @Test
    public void localeEsTest() {
        landingPage.locale();
        webDriverWait.until(ExpectedConditions.visibilityOf(landingPage.getBtnEs()));
        landingPage.pickLanguage(Locale.ES);
        Assert.assertTrue(landingPage.getHeader().contains("Página de aterrizaje"));
    }

    @Test
    public void localeFrTest() {
        landingPage.locale();
        webDriverWait.until(ExpectedConditions.visibilityOf(landingPage.getBtnFr()));
        landingPage.pickLanguage(Locale.FR);
        Assert.assertTrue(landingPage.getHeader().contains("Page d'atterrissage"));
    }
}

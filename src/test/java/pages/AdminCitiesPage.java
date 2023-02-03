package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span")
    private WebElement logoutBtn;

    @FindBy(className = "btnNewItem")
    private WebElement btnAddNewCity;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(className = "btnSave")
    private WebElement btnSave;

    @FindBy(id = "search")
    private WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]/button")
    private WebElement btnCloseMessage;
    @FindBy (id = "edit")
    private WebElement btnEdit;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement createdCity;

    @FindBy (id = "delete")
    private WebElement btnDelete;

    @FindBy (className = "v-card")
    private WebElement deleteDialog;

    //xpath = "//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span"
    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span")
    private WebElement btnDeleteConfirm;

    public AdminCitiesPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }


    public boolean logoutIsVisible() {
        return logoutBtn.isDisplayed();
    }

    public void logout() {
        logoutBtn.click();
    }

    public void addNewCity() {
        btnAddNewCity.click();
    }

    public void fillCityName( String city) {
        inputName.sendKeys(city);
        btnSave.click();
    }

    public WebElement getMessageElement() {
        return message;
    }

    public String getMessage() {
        return message.getText();
    }

    public void closeMessage() {
        btnCloseMessage.click();
    }

    public WebElement getDeleteDialog (){
        return deleteDialog;
    }
    public void searchCity (String city){
      //  searchBar.clear();
        searchBar.sendKeys(city);
    }

    public void editCity (){
        btnEdit.click();
        inputName.sendKeys(" - edited");
        btnSave.click();
    }

    public String getCreatedCity (){
        return createdCity.getText();
    }

    public void deleteCity (){
        btnDelete.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(btnDeleteConfirm));
        btnDeleteConfirm.click();
    }

}



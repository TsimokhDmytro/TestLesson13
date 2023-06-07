package pages;

import helpers.HomePageHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class HomePage extends HomePageHelper {

    private String compx = "https://compx.ua/";

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Open COMPX")
    public HomePage openCompx() {
        openUrl(compx);
        return this;
    }
    @Step("Click btn user bar")
    public SignInPage clickBtnUserBar() {
        getBtnUserBar().click();
        return new SignInPage(driver);
    }
    @Step("Click btn drop down user menu")
    public HomePage clickBtnDropDownUserMenu() {
        getBtnDropDownUserMenu().click();
        return this;
    }
    @Step("Click btn log out")
    public void clickBtnLogOut() {
        getBtnLogOut().click();
    }
    @Step("Is displayed btn drop down user menu")
    public boolean isDisplayedBtnDropDownUserMenu() {
        return getBtnDropDownUserMenu().isDisplayed();
    }
    @Step("Is not displayed btn drop down user menu")
    public boolean isNotDisplayedBtnDropDownUserMenu() {
        try {
            waitElementToBeInvisibility(getBtnDropDownUserMenu());
            return !getBtnDropDownUserMenu().isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return true;
        }
    }
    @Step("Get text btn user bar")
    public String getTextBtnUserBar(){
        return getBtnUserBar().getText();
    }
}


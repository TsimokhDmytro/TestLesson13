package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClases.BasePage;

public class HomePageHelper extends BasePage {

    private String compx = "https://compx.ua/";
    private String btnUserBar = "//span[@class='userbar__button-text']";
    private String btnDropDownUserMenu = "//div[@class='userbar']//*[@class='icon icon--arrow-down-light']";
    private String listUserMenu = "//ul[@class='userbar__menu']//li";
    private String btnLogOut = "(//ul[@class='userbar__menu']//a)[4]";

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtnUserBar() {
       return findClickableElementBy(btnUserBar);
    }
    public WebElement getBtnDropDownUserMenu() {
        return findClickableElementBy(btnDropDownUserMenu);
    }
    public WebElement getBtnLogOut() {
        return findClickableElementBy(btnLogOut);
    }
}


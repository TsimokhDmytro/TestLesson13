package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClases.BasePage;

public class SignInPageHelper extends BasePage {

    private String signInBlock = "//section[@id='sign-in']//*[@data-content-id='j-popup-tab-auth']";

    private String fieldInputUserEmailSignIn = "//form[@id='login_form_id']//input[@name='user[email]']";
    private String fieldInputUserPasswordSignIn = "//form[@id='login_form_id']//input[@name='user[pass]']";
    private String btnSignIn = "//form[@id='login_form_id']//*[@class='btn __special']";
    private String messageErrorInvalidUserData = "//div[@class='session-message s-error']";
    private String btnCloseSignInBlock = "//section[@id='sign-in']//*[@class='popup-close']";
    private String tabSignUp = "(//section[@id='sign-in']//span[@class='login-tabs-txt'])[2]";


    public SignInPageHelper(WebDriver driver) {
        super(driver);
    }

    public WebElement getFieldInputUserEmailSignIn() {
        return findClickableElementBy(fieldInputUserEmailSignIn);
    }

    public WebElement getFieldInputUserPasswordSignIn() {
        return findClickableElementBy(fieldInputUserPasswordSignIn);
    }

    public WebElement getBtbSignIn() {
        return findClickableElementBy(btnSignIn);
    }

//    public WebElement getTabSignIn() {
//        return findClickableElementBy(tabSignIn);
//    }

    public WebElement getTabSignUp() {
        return findClickableElementBy(tabSignUp);
    }
    public WebElement getMessageErrorInvalidData() {
        return findVisibleElementBy(messageErrorInvalidUserData);
    }

    public WebElement getSignInBlock() {
        return findVisibleElementBy(signInBlock);
    }

    public WebElement getBtnCloseSignInBlock() {
        return findVisibleElementBy(btnCloseSignInBlock);
    }
}

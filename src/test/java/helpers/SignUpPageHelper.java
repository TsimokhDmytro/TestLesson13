package helpers;

import baseClases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageHelper extends BasePage {
    private String fieldInputUserNameSignUp = "//form[@id='signup-form']//input[@name='user[title]']";
    private String fieldInputUserEmailSignUp = "//form[@id='signup-form']//input[@name='user[email]']";
    private String fieldInputPasswordSignUp = "//form[@id='signup-form']//input[@name='user[pass]']";
    private String btnSignUp = "//form[@id='signup-form']//*[@class='btn __special']";
    private String signUpBlock = "//section[@id='sign-in']//*[@data-content-id='j-popup-tab-signup']";
    private String messageErrorInvalidUserEmailSignUp = "//div[@class='form-error-box errorBox-message']";
    private String btnCloseSignUpBlock = "//section[@id='sign-in']//*[@class='popup-close']";
    private String signUpSuccsesBlock = "//div[@id='modal-overlay']//div[@class='popup-block']";
    private String messageSuccessRegistration = "//div[@class='popup-header']//div[@class='popup-title']";
    private String btnCloseSignUpSuccsesBlock = "//div[@class='popup-confirm']//span[@class='btn-content']";


    protected SignUpPageHelper(WebDriver driver) {
        super(driver);
    }

    public WebElement getFieldInputUserNameSignUp() {
        return findClickableElementBy(fieldInputUserNameSignUp);
    }

    public WebElement getFieldInputUserEmailSignUp() {
        return findClickableElementBy(fieldInputUserEmailSignUp);
    }

    public WebElement getFieldInputUserPasswordSignUp() {
        return findClickableElementBy(fieldInputPasswordSignUp);
    }

    public WebElement getBtbSignUp() {
        return findClickableElementBy(btnSignUp);
    }

    public WebElement getSignUpBlock() {
        return findVisibleElementBy(signUpBlock);
    }

    public WebElement getSignUpSuccessBlock() {
        return findVisibleElementBy(signUpSuccsesBlock);
    }

    public WebElement getMessageRegistrationSuccess() {
        return findVisibleElementBy(messageSuccessRegistration);
    }

    public WebElement getBtnCloseSignUpBlock() {
        return findVisibleElementBy(btnCloseSignUpBlock);
    }

    public WebElement getBtnCloseSignUpSuccessBlock() {
        return findVisibleElementBy(btnCloseSignUpSuccsesBlock);
    }

    public WebElement getMessageErrorInvalidUserEmailSignUp() {
        return findVisibleElementBy(messageErrorInvalidUserEmailSignUp);
    }
}

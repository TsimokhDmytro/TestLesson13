package pages;

import helpers.SignInPageHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class SignInPage extends SignInPageHelper {

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    @Step("Input user email sign in")
    public SignInPage inputUserEmailSignIn(String email) {
        getFieldInputUserEmailSignIn().sendKeys(email);
        return this;
    }
    @Step("Input user password sign in")
    public SignInPage inputUserPasswordSignIn(String password) {
        getFieldInputUserPasswordSignIn().sendKeys(password);
        return this;
    }
    @Step("Click tab sign up")
    public SignUpPage clickTabSignUp() {
        getTabSignUp().click();
        return new SignUpPage(driver);
    }

//    public SignInPage clickTabSignIn() {
//        getTabSignIn().click();
//        return this;
//    }
@Step("Click button sign up")
    public HomePage clickBtbSignIn() {
        getBtbSignIn().click();
        return new HomePage(driver);
    }
    @Step("Click button close sign up")
    public HomePage clickBtnCloseSignInBlock() {
        getBtnCloseSignInBlock().click();
        return new HomePage(driver);
    }
    @Step("Is displayed sign in block")
    public boolean isDisplayedSignInBlock() {
        getSignInBlock().isDisplayed();
        return true;
    }
    @Step("Is not displayed sign in block")
    public boolean isNotDisplayedSignInBlock() {
        try {
            waitElementToBeInvisibility(getSignInBlock());
            return !getSignInBlock().isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return true;
        }
    }
    @Step("Get message error invalid user data")
    public String messageErrorInvalidUserData(){
        return getMessageErrorInvalidData().getText();
    }

    public boolean isDisplayedFieldInputPassword() {
        return getFieldInputUserPasswordSignIn().isDisplayed();
    }

    public boolean isDisplayedBtnSignIn() {
        return getBtbSignIn().isDisplayed();
    }

//    public boolean isDisplayedTabSignIn() {
//        return getTabSignIn().isDisplayed();
//    }

    public boolean isDisplayedTabRegistration() {
        return getTabSignUp().isDisplayed();
    }
}

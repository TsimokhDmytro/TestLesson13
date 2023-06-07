package pages;

import helpers.SignUpPageHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class SignUpPage extends SignUpPageHelper {
    public SignUpPage(WebDriver driver){
        super(driver);
    }
    @Step("Input user name sign up")
    public SignUpPage inputUserNameSignUp(String email) {
        getFieldInputUserNameSignUp().sendKeys(email);
        return this;
    }
    @Step("Input user email sign up")
    public SignUpPage inputUserEmailSignUp(String email) {
        getFieldInputUserEmailSignUp().sendKeys(email);
        return this;
    }
    @Step("Input user password sign up")
    public SignUpPage inputUserPasswordSignUp(String password) {
        getFieldInputUserPasswordSignUp().sendKeys(password);
        return this;
    }
    @Step("Click btb sign up")
    public HomePage clickBtbSignUp() {
        getBtbSignUp().click();
        return new HomePage(driver);
    }
    @Step("Is displayed sign up block")
    public boolean isDisplayedSignUpBlock() {
        return getSignUpBlock().isDisplayed();
    }
    @Step("Is displayed sign up success block")
    public boolean isDisplayedSignUpSuccessBlock() {
        return getSignUpSuccessBlock().isDisplayed();
    }
    @Step("Get message success registration")
    public String messageSuccessRegistration(){
        return getMessageRegistrationSuccess().getText();
    }
    @Step("Click btn close sign up block")
    public HomePage clickBtnCloseSignUpBlock() {
        getBtnCloseSignUpBlock().click();
        return new HomePage(driver);
    }
    @Step("Click btn close sign up success block")
    public HomePage clickBtnCloseSignUpSuccessBlock() {
        getBtnCloseSignUpSuccessBlock().click();
        return new HomePage(driver);
    }

    public boolean isDisplayedFieldInputEmail() {
        return getFieldInputUserEmailSignUp().isDisplayed();
    }
    @Step("Is not displayed sign up block")
    public boolean isNotDisplayedSignUpBlock() {
        try{
            waitElementToBeInvisibility(getSignUpBlock());
            return !getSignUpBlock().isDisplayed();
        }
        catch (NoSuchElementException | TimeoutException e){
            return true;
        }
    }
    @Step("Get message error invalid user email sign up")
    public String messageErrorInvalidUserEmailSignUp(){
        return getMessageErrorInvalidUserEmailSignUp().getText();
    }
}

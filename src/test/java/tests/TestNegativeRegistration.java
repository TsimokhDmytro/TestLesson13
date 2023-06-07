package tests;

import baseClases.TestInit;
import datas.InvalidCredentialRegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;

public class TestNegativeRegistration extends TestInit {

    private String expectedMessageInvalidUserEmail = "Некоректна адреса електронної пошти";

    @Test
    public void checkRegistrationWithInvalidEmail() {

        HomePage homePage = new HomePage(getDriver());

        SignInPage signInPage = new SignInPage(getDriver());

        SignUpPage signUpPage = new SignUpPage(getDriver());

        InvalidCredentialRegistrationData invalidRegistrationdata = new InvalidCredentialRegistrationData();

        homePage.openCompx()
                .clickBtnUserBar();

        Assert.assertTrue(signInPage.isDisplayedSignInBlock());

        signInPage.clickTabSignUp()
                .inputUserNameSignUp(invalidRegistrationdata.getUserName())
                .inputUserEmailSignUp(invalidRegistrationdata.getUserEmail())
                .inputUserPasswordSignUp(invalidRegistrationdata.getUserPassword());
                signUpPage.clickBtbSignUp();

        Assert.assertTrue(signUpPage.isDisplayedSignUpBlock());

        Assert.assertEquals(signUpPage.messageErrorInvalidUserEmailSignUp(), expectedMessageInvalidUserEmail);

        signUpPage.clickBtnCloseSignUpBlock();

        Assert.assertTrue(homePage.isNotDisplayedBtnDropDownUserMenu());
    }
}

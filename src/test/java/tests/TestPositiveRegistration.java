package tests;

import baseClases.TestInit;
import datas.ValidCredentialRegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;

public class TestPositiveRegistration extends TestInit {
    String expectedMessageSuccessRegistration = "Дякуємо за реєстрацію";

    @Test
    public void checkRegistration() {

        HomePage homePage = new HomePage(getDriver());

        ValidCredentialRegistrationData validRegistrationData = new ValidCredentialRegistrationData();

        SignInPage sigInPage = new SignInPage(getDriver());

        SignUpPage sigUpPage = new SignUpPage(getDriver());

        homePage.openCompx()
                .clickBtnUserBar();

        Assert.assertTrue(sigInPage.isDisplayedSignInBlock());

        sigInPage.clickTabSignUp()
        .inputUserNameSignUp(validRegistrationData.getUserName())
                .inputUserEmailSignUp(validRegistrationData.getUserEmail())
                .inputUserPasswordSignUp(validRegistrationData.getUserPassword())
                .clickBtbSignUp();

        Assert.assertTrue(sigUpPage.isDisplayedSignUpSuccessBlock());

        Assert.assertEquals(sigUpPage.messageSuccessRegistration(), expectedMessageSuccessRegistration);

        sigUpPage.clickBtnCloseSignUpSuccessBlock();

        Assert.assertTrue(sigUpPage.isNotDisplayedSignUpBlock());

        Assert.assertEquals(homePage.getTextBtnUserBar(), validRegistrationData.getUserName());

        Assert.assertTrue(homePage.isDisplayedBtnDropDownUserMenu());
    }
}

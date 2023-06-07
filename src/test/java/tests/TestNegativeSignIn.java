package tests;

import baseClases.TestInit;
import datas.InvalidCredentialSignInData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class TestNegativeSignIn extends TestInit {

    private String expectedMessageInvalidUserData = "Неправильна комбінація е-пошти та паролю";
    private String expectedTextBtnUserBar = "Вхід";

    @Test
    public void checkSignInWithInvalidUserEmail() {

        HomePage homePage = new HomePage(getDriver());

        SignInPage sigInPage = new SignInPage(getDriver());

        InvalidCredentialSignInData invalidSignInData = new InvalidCredentialSignInData();

        homePage.openCompx()
                .clickBtnUserBar();

        Assert.assertTrue(sigInPage.isDisplayedSignInBlock());

        sigInPage.inputUserEmailSignIn(invalidSignInData.getUserEmail())
                .inputUserPasswordSignIn(invalidSignInData.getUserPassword())
                .clickBtbSignIn();

        Assert.assertTrue(sigInPage.isDisplayedSignInBlock());

        Assert.assertEquals(sigInPage.messageErrorInvalidUserData(), expectedMessageInvalidUserData);

        sigInPage.clickBtnCloseSignInBlock();

        Assert.assertTrue(homePage.isNotDisplayedBtnDropDownUserMenu());

        Assert.assertEquals(homePage.getTextBtnUserBar(),expectedTextBtnUserBar);
    }
}

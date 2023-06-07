package tests;

import baseClases.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import datas.ValidCredentialSignInData;
import pages.HomePage;
import pages.SignInPage;

public class TestPositiveSignIn extends TestInit {


    @Test
    public void checkSignInWithValidData() {

        HomePage homePage = new HomePage(getDriver());

        ValidCredentialSignInData validSignInData = new ValidCredentialSignInData();

        SignInPage sigInPage = new SignInPage(getDriver());

        homePage.openCompx()
                .clickBtnUserBar();

        Assert.assertTrue(sigInPage.isDisplayedSignInBlock());

        sigInPage.inputUserEmailSignIn(validSignInData.getUserEmail())
                .inputUserPasswordSignIn(validSignInData.getUserPassword())
                .clickBtbSignIn();

        Assert.assertTrue(sigInPage.isNotDisplayedSignInBlock());

        Assert.assertTrue(homePage.isDisplayedBtnDropDownUserMenu());

        homePage.clickBtnDropDownUserMenu()
                .clickBtnLogOut();

        Assert.assertTrue(homePage.isNotDisplayedBtnDropDownUserMenu());

        homePage.clickBtnUserBar();

        Assert.assertTrue(sigInPage.isDisplayedSignInBlock());

        sigInPage.inputUserEmailSignIn(validSignInData.getUserEmail())
                .inputUserPasswordSignIn(validSignInData.getUserPassword())
                .clickBtbSignIn();

        Assert.assertTrue(sigInPage.isNotDisplayedSignInBlock());

        Assert.assertTrue(homePage.isDisplayedBtnDropDownUserMenu());
    }
}

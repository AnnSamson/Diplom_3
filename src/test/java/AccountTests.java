import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.AccountPage;
import pom.HomePage;
import pom.LoginPage;

import java.util.concurrent.TimeUnit;

public class AccountTests extends BaseTest {
    private LoginPage loginPage;

    @Before
    @Step("Login")
    public void login() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        loginPage = new LoginPage(driver);
        loginPage.login("test123444@test.ru", "testtest");
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Logout")
    public void logOutOfAccount() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickButtonGetOutOfAccount();
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isDisplayedTextEnter());
    }

    @Test
    @DisplayName("Transition from  account to Constructor across click to \"Constructor\"")
    public void transitionAcrossConstructor() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickHeaderConstructor();
        Assert.assertTrue(accountPage.isDisplayedTextAssembleBurger());
    }

    @Test
    @DisplayName("Transition from  account to Constructor across click to logo")
    public void transitionAcrossLogo() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogo();
        Assert.assertTrue(accountPage.isDisplayedTextAssembleBurger());
    }
}

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.*;


public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private final String email = "test123444@test.ru";
    private final String password = "testtest";

    @Test
    @Step("Open site and login")
    @DisplayName("Login across button Sign In")
    public void loginAcrossAccountPage() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonSignIn();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        homePage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isOpened());
    }

    @Test
    @Step("Open site and login")
    @DisplayName("Login across HomePage")
    public void loginAcrossHomePage() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonAccount();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        homePage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isOpened());
    }


    @Test
    @Step("Open site and login")
    @DisplayName("Login across RegistrationPage")
    public void loginAcrossRegistrationPage() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickButtonEnter();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        HomePage homePage = new HomePage(driver);
        homePage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isOpened());
    }

    @Test
    @Step("Open site and login")
    @DisplayName("Login across RecoveryPassword")
    public void loginAcrossRecoveryPassword() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.clickEnterPasswordRecoveryPage();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        HomePage homePage = new HomePage(driver);
        homePage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isOpened());
    }

    @After
    public void clearData() {
         loginPage = null;
    }
}

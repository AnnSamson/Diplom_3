import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.PasswordRecoveryPage;
import pom.RegistrationPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private final String email = "test123444@test.ru";
    private final String  password = "testtest";

    @Test
    @Step("Open site and login")
    @DisplayName("Login across button Sign In")
    public void loginAcrossAccountPage() {
        driver.get("https://stellarburgers.nomoreparties.site");
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonSignIn();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
    }

    @Test
    @Step("Open site and login")
    @DisplayName("Login across HomePage")
    public void loginAcrossHomePage() {
        driver.get("https://stellarburgers.nomoreparties.site");
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonAccount();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
    }


    @Test
    @Step("Open site and login")
    @DisplayName("Login across RegistrationPage")
    public void loginAcrossRegistrationPage(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickButtonEnter();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
    }

    @Test
    @Step("Open site and login")
    @DisplayName("Login across RecoveryPassword")
    public void loginAcrossRecoveryPassword(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.clickEnterPasswordRecoveryPage();

        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

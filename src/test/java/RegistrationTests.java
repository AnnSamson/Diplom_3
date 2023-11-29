import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pom.LoginPage;
import pom.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {
    static Faker faker = new Faker();

    @Test
    @DisplayName("Successful registration")
    public void testSuccessfulRegistration() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(6, 10);

        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isDisplayedTextEnter());
    }

    @Test
    @DisplayName("Unsuccessful registration - Incorrect Password")
    public void testUnsuccessfulRegistrationIncorrectPassword() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(3, 5);

        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
        Assert.assertTrue(registrationPage.isPasswordIncorrect());
    }
}


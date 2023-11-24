import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pom.LoginPage;
import pom.RegistrationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationTests extends BaseTest {
    static Faker faker = new Faker();
    private RegistrationPage registrationPage;
    private final String name;
    private final String email;
    private final String password;

    public RegistrationTests(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters(name = "name: {0}, email: {1}, password: {2}")
    public static Object[][] questionsAndAnswers() {
        return new Object[][]{
                {faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password(6,10)}, //успешная регистрация
                {faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password(3,5)}, //регистрация не произойдет - появится сообщение "Некорректный пароль" (пароль менее 6 символов)
        };
    }

    @Test
    @DisplayName("1 successfully and 1 unsuccessfully (password shorter than 6 symbols) registration")
    public void setData() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
        LoginPage loginPage = new LoginPage(driver);
        if (password.length() >= 6) {
            assertTrue(loginPage.isDisplayedTextEnter());
        } else {
            assertEquals("Некорректный пароль", driver.findElement(By.xpath(".//p[text()='Некорректный пароль']")).getText());
        }
    }
}

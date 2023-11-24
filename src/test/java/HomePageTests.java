import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pom.HomePage;

public class HomePageTests extends BaseTest{
    private HomePage homePage;

    @Before
    @Step("Open site")
    public void open(){
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @Step("Click section buns")
    @DisplayName("Testing sections constructor - buns")
    public void clickBunSection() {
        homePage = new HomePage(driver);
        homePage.clickSaucesSection(); //сначала кликая на другую вкладку
        homePage.clickBunSauces();
        homePage.activityCheckCurrentBunSection();
    }

    @Test
    @Step("Click section sauces")
    @DisplayName("Testing sections constructor - sauces")
    public void clickSaucesSection() {
        homePage = new HomePage(driver);
        homePage.clickSaucesSection();
        homePage.activityCheckCurrentSauceSection();
    }

    @Test
    @Step("Click section stuffing")
    @DisplayName("Testing sections constructor - stuffing")
    public void clickStuffingSection() {
        homePage = new HomePage(driver);
        homePage.clickStuffingSection();
        homePage.activityCheckStuffingBunSection();
    }
}

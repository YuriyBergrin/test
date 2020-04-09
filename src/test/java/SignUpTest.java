import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class SignUpTest {
    private static WebDriver driver;
    private static SignUpPage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        if (driver != null) {
            return;
        }
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            driver.quit();
            driver = null;
        }));
    }

    @After
    public void tearDown() {
//        driver.quit();
//        driver = null;
    }

    @Test
    public void typeInvalidYear() {
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeDay("1")
                .setMonth("April")
                .typeYear("85")
                .setShare(true);
        assertTrue(page.isErrorVisible("Please enter a valid year."));
        assertFalse(page.isErrorVisible("When were you born?"));
    }

    @Test
    public void typeInvalidEmail() {
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeEmail("test112324@test.com")
                .typeConfirmEmail("wrong@test.com")
                .typeName("yuriy")
                .clickSignUpButton();
        assertTrue(page.isErrorVisible("Email address doesn't match."));
    }

    @Test
    public void signUpWithEmptyPassword() {
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeEmail("test77712@test.ru")
                .typeConfirmEmail("test77712@test.ru")
                .typeName("Vasya")
                .clickSignUpButton();
        assertTrue(page.isErrorVisible("Enter a password to continue."));
    }

    @Test
    public void typeInvalidValues() {
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeEmail("1124324")
                .typeConfirmEmail("wrong@mail,com")
                .typeName("TestName")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        assertEquals(7, page.getErrors().size());
    }
}

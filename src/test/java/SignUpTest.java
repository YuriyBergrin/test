import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class SignUpTest {
    private  RemoteWebDriver driver;
    private  SignUpPage page;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void typeInvalidYear() {
        System.out.println("FIRST TEST");
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeDay("1")
                .setMonth("April")
                .typeYear("85")
                .setShare(true);
        assertTrue(page.isErrorVisible("Please enter a valid year."));
        assertFalse(page.isErrorVisible("When were you born?"));
        System.out.println("FIRST TEST");
    }

    @Test
    public void typeInvalidEmail() {
        System.out.println("SECOND TEST");
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeEmail("test112324@test.com")
                .typeConfirmEmail("wrong@test.com")
                .typeName("yuriy")
                .clickSignUpButton();
        assertTrue(page.isErrorVisible("Email address doesn't match."));
        System.out.println("SECOND TEST");
    }

    @Test
    public void signUpWithEmptyPassword() {
        System.out.println("THIRD TEST");
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeEmail("test77712@test.ru")
                .typeConfirmEmail("test77712@test.ru")
                .typeName("Vasya")
                .clickSignUpButton();
        assertTrue(page.isErrorVisible("Enter a password to continue."));
        System.out.println("THIRD TEST");
    }

    @Test
    public void typeInvalidValues() {
        System.out.println("FOURTH TEST");
        driver.get("https://www.spotify.com/us/signup/");
        page = new SignUpPage(driver);
        page.typeEmail("1124324")
                .typeConfirmEmail("wrong@mail,com")
                .typeName("TestName")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        assertEquals(7, page.getErrors().size());
        System.out.println("FOURTH TEST");
    }
}

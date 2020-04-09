
import Pages.SignUpPage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SignUpTest {

    private static SignUpPage page;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        baseUrl = "https://www.spotify.com/us/signup/";
        browser = "firefox";
    }

    @Before
    public void start() {
        page = new SignUpPage();
        page.open();
    }

    @Test
    public void typeInvalidYear() {
        page.typeDay("1")
                .setMonth("April")
                .typeYear("85")
                .setShare(true);
        page.getErrorByText("Please enter a valid year.").shouldBe(visible);
        page.getErrorByText("When were you born?").shouldNotBe(visible);
    }

    @Test
    public void typeInvalidEmail() {
        page = new SignUpPage();
        page.typeEmail("test112324@test.com")
                .typeConfirmEmail("wrong@test.com")
                .typeName("yuriy")
                .clickSignUpButton();
        page.getErrorByText("Email address doesn't match.").shouldBe(visible);
    }

    @Test
    public void signUpWithEmptyPassword() {
        page = new SignUpPage();
        page.typeEmail("test77712@test.ru")
                .typeConfirmEmail("test77712@test.ru")
                .typeName("Vasya")
                .clickSignUpButton();
        page.getErrorByText("Enter a password to continue.").shouldBe(visible);
    }

    @Test
    public void typeInvalidValues() {
        page = new SignUpPage();
        page.typeEmail("1124324")
                .typeConfirmEmail("wrong@mail,com")
                .typeName("TestName")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        page.getErrors().shouldHave(size(7));
    }
}

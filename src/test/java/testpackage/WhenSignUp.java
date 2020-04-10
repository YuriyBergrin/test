package testpackage;

import testpackage.pages.SignUpPage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import testpackage.steps.serenitysteps.SignUpSteps;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenSignUp {

    private static SignUpPage page;

    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void typeInvalidYear() {
        steps.open_sign_up_page();
        steps.type_day("1");
        steps.set_month("April");
        steps.type_year("85");
        steps.set_share(true);
        steps.should_see_error("Please enter a valid year.");
        steps.should_not_see_error("When were you born?");
    }

    @Test
    public void typeInvalidEmail() {
        steps.open_sign_up_page();
        steps.type_email("test112324@test.com");
        steps.type_confirmation_email("wrong@test.com");
        steps.type_name("yuriy");
        steps.click_sign_up_button();
        steps.should_see_error("Email address doesn't match.");
    }

    @Test
    public void signUpWithEmptyPassword() {
        steps.open_sign_up_page();
        steps.type_email("test112324@test.com");
        steps.type_confirmation_email("wrong@test.com");
        steps.type_name("yuriy");
        steps.click_sign_up_button();
        steps.should_see_error("Enter a password to continue.");
    }

    @Test
    public void typeInvalidValues() {
        steps.open_sign_up_page();
        steps.type_email("test112324@test.com");
        steps.type_confirmation_email("wrong@test.com");
        steps.type_name("yuriy");
        steps.set_sex("Male");
        steps.set_share(false);
        steps.click_sign_up_button();
        steps.should_see_errors_count(6);
    }
}

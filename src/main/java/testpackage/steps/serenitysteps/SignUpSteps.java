package testpackage.steps.serenitysteps;

import testpackage.pages.SignUpPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class SignUpSteps {
    SignUpPage page;

    @Step
    public void open_sign_up_page() {
        page.open();
    }

    @Step("User types [0]")
    public void type_email(String email) {
        page.typeEmail(email);
    }

    @Step
    public void type_confirmation_email(String email) {
        page.typeConfirmEmail(email);
    }

    @Step
    public void type_password(String password) {
        page.typePassword(password);
    }

    @Step
    public void type_name(String name) {
        page.typeName(name);
    }

    @Step
    public void set_month(String month) {
        page.setMonth(month);
    }

    @Step
    public void type_year(String year) {
        page.typeYear(year);
    }

    @Step
    public void type_day(String day) {
        page.typeDay(day);
    }

    @Step
    public void set_sex(String sex) {
        page.setSex(sex);
    }

    @Step
    public void set_share(boolean value) {
        page.setShare(value);
    }

    @Step
    public void click_sign_up_button() {
        page.clickSignUpButton();
    }

    @Step
    public void should_see_error(String message) {
        Assertions.assertThat(page.getErrorByText(message).isVisible());
    }

    @Step
    public void should_not_see_error(String message) {
        Assertions.assertThat(!page.getErrorByText(message).isVisible());
    }

    @Step
    public void should_see_errors_count(int count) {
        Assertions.assertThat(page.getErrors()).hasSize(count);
    }
}

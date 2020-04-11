package testpackage.steps.jbehavesteps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import testpackage.steps.serenitysteps.SignUpSteps;

public class SignUpPageSteps {
    @Steps
    SignUpSteps steps;

    @Given("I open signup page")
    public void openPage() {
        steps.open_sign_up_page();
    }

    @When("I type day \"$day\"")
    public void typeDay(String day) {
        steps.type_day(day);
    }

    @When("I set month \"$month\"")
    public void setMonth(String month) {
        steps.set_month(month);
    }

    @When("I type year \"$year\"")
    public void typeYear(String year) {
        steps.type_year(year);
    }

    @When("I check share")
    public void checkShare() {
        steps.set_share(true);
    }

    @When("I uncheck share")
    public void unCheckShare() {
        steps.set_share(false);
    }

    @When("I type email \"$email\"")
    public void typeEmail(String email) {
        steps.type_email(email);
    }

    @When("I type confirmation email \"$email\"")
    public void typeConfirmationEmail(String email) {
        steps.type_confirmation_email(email);
    }

    @When("I type name \"$name\"")
    public void typeName(String name) {
        steps.type_name(name);
    }

    @When("I click signup button")
    public void clickSignUp() {
        steps.click_sign_up_button();
    }

    @When("I set sex \"$sex\"")
    public void setSex(String sex) {
        steps.set_sex(sex);
    }

    @Then("I see error \"$message\"")
    public void shouldSeeErrorByText(String message) {
        steps.should_see_error(message);
    }

    @Then("I don`t see error \"$message\"")
    public void shouldNotSeeErrorByText(String message) {
        steps.should_not_see_error(message);
    }

    @Then("I see \"$count\" errors")
    public void shouldSeeCountOfErrors(int count) {
        steps.should_see_errors_count(count);
    }
}

package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://www.spotify.com/us/signup/")
public class SignUpPage extends PageObject {

    private By emailField = By.cssSelector("#register-email");
    private By confirmEmailField = By.cssSelector("#register-confirm-email");
    private By passwordField = By.cssSelector("#register-password");
    private By nameField = By.cssSelector("#register-displayname");
    private By monthDropDown = By.cssSelector("#register-dob-month");
    private String monthDropOption = "//select/option[text()='%s']";
    private By dayField = By.cssSelector("#register-dob-day");
    private By yearField = By.cssSelector("#register-dob-year");
    private String sexRadioButton = "//li[@id=\"li-gender\"]/label[normalize-space()='%s']/input";
    private By shareCheckBox = By.cssSelector("#register-thirdparty");
    private By registerButton = By.id("register-button-email-submit");
    private By errorLabel = xpath("//label[@class=\"has-error\" and text()!=\"\"]");
    private String errorByText = "//label[@class=\"has-error\" and text()=\"%s\"]";

    public SignUpPage typeEmail(String email) {
        find(emailField).type(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String confirmEmail) {
        find(confirmEmailField).type(confirmEmail);
        return this;
    }

    public SignUpPage typePassword(String password) {
        find(passwordField).type(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        find(nameField).type(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        find(monthDropDown).selectByValue(month);
        return this;
    }

    public SignUpPage typeDay(String day) {
        find(dayField).type(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        find(yearField).type(year);
        return this;
    }

    public SignUpPage setSex(String sex) {
        find(format(sexRadioButton, sex)).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        WebElementFacade checkbox = find(shareCheckBox);
        if (checkbox.isSelected() != value){
            checkbox.click();
        }
        return this;
    }

    public void clickSignUpButton() {
        find(registerButton).click();
    }

    public List<WebElementFacade> getErrors() {
        return findAll(errorLabel);
    }

    public WebElementFacade getErrorByNumber(int number) {
        return getErrors().get(number - 1);
    }

    public WebElementFacade getErrorByText(String text) {
        return $(xpath(format(errorByText, text)));
    }

}

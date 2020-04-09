import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SignUpPage {

    public SignUpPage open() {
        Selenide.open("/");
        return this;
    }

    private By emailField = By.cssSelector("#register-email");
    private By confirmEmailField = By.cssSelector("#register-confirm-email");
    private By passwordField = By.cssSelector("#register-password");
    private By nameField = By.cssSelector("#register-displayname");
    private By monthDropDown = By.cssSelector("#register-dob-month");
    private String monthDropOption = "//select/option[text()='%s']";
    private By dayField = By.cssSelector("#register-dob-day");
    private By yearField = By.cssSelector("#register-dob-year");
    private By sexRadioButton = By.cssSelector("#li-gender");
    private By shareCheckBox = By.cssSelector("#register-thirdparty");
    private By registerButton = By.id("register-button-email-submit");
    private By errorLabel = xpath("//label[@class=\"has-error\" and text()!=\"\"]");
    private String errorByText = "//label[@class=\"has-error\" and text()=\"%s\"]";

    public SignUpPage typeEmail(String email) {
        $(emailField).val(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String confirmEmail) {
        $(confirmEmailField).val(confirmEmail);
        return this;
    }

    public SignUpPage typePassword(String password) {
        $(passwordField).val(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        $(nameField).val(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        $(monthDropDown).selectOption(month);
        return this;
    }

    public SignUpPage typeDay(String day) {
        $(dayField).val(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        $(yearField).val(year);
        return this;
    }

    public SignUpPage setSex(String sex) {
        $(sexRadioButton).selectRadio(sex);
        return this;
    }

    public SignUpPage setShare(boolean value) {
        $(shareCheckBox).setSelected(value);
        return this;
    }

    public void clickSignUpButton() {
        $(registerButton).click();
    }

    public ElementsCollection getErrors() {
        return $$(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).text();
    }

    public SelenideElement getErrorByText(String text) {
        return $(xpath(format(errorByText, text)));
    }

}

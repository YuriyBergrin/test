import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

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
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String confirmEmail) {
        driver.findElement(confirmEmailField).sendKeys(confirmEmail);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        driver.findElement(monthDropDown).click();
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(xpath(format(monthDropOption, month)))).
                click();
        return this;
    }

    public SignUpPage typeDay(String day) {
        driver.findElement(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        driver.findElement(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String sex) {
        driver.findElement(xpath(format(sexRadioButton, sex))).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        WebElement checkBox = driver.findElement(shareCheckBox);
        if (!checkBox.isSelected() == value) {
            checkBox.click();
        }
        return this;
    }

    public void clickSignUpButton() {
        driver.findElement(registerButton).click();
    }

    public List<WebElement> getErrors() {
        return driver.findElements(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String text) {
        return driver.findElements(xpath(format(errorByText, text))).size() > 0 &&
                driver.findElements(xpath(format(errorByText, text))).get(0).isDisplayed();
    }

}

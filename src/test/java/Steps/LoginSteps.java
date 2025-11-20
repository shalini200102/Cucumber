package Steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class LoginSteps {

    WebDriver driver;

    @Given("user launches browser")
    public void user_launches_browser() {
        driver = DriverManager.getDriver();
    }

    @Given("user opens the application")
    public void user_opens_the_application() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("homepage should be displayed")
    public void homepage_should_be_displayed() {
        boolean visible = driver.findElement(By.className("title")).isDisplayed();

        if (!visible) {
            throw new AssertionError("Homepage not displayed");
        }

        DriverManager.quitDriver();
    }
}

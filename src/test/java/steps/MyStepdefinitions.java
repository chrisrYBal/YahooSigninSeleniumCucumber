package steps;

import engine.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.TRUE;

public class MyStepdefinitions {

    private WebDriver driver;
    public MyStepdefinitions (Driver driver){
        this.driver = driver.get();
    }

    @Given("I am on the Home page")
    public void iAmOnTheHomePage() throws InterruptedException {
        driver.manage();
        driver.get("https://yahoo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }

    @When("I click on {string} button on the Home page")
    public void iClickOnButtonOnTheHomePage(String Signin) throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();
        Thread.sleep(6000);
    }

    @Then("I should be on the Yahoo Sign in page")
    public void iShouldBeOnTheYahooSignInPage() {
        try {
            Boolean landingpage = driver.findElement(By.id("login-landing")).isDisplayed();
            if(landingpage.equals(TRUE)) {
                System.out.println("Background: Yahoo sign in page displayed successfully:" + "\n" );
            }else {
                System.out.println("Background: Yahoo sign in page displayed unsuccessfully:" + "\n" );
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @When("I enter invalid {string} data into the input box")
    public void iEnterInvalidDataIntoTheInputBox(String invUser) throws InterruptedException {
        driver.findElement(By.id("login-username")).sendKeys(invUser);
        Thread.sleep(2000);
    }

    @And("I click on {string} button to proceed")
    public void iClickOnButtonToProceed(String next) throws InterruptedException {
        driver.findElement(By.id(next)).click();
        Thread.sleep(2000);
    }

    @Then("the {string} error message on the username Sign in page for input {string} should be visible")
    public void theErrorMessageOnTheUsernameSignInPageForInputShouldBeVisible(String UserError, String text) {
        Boolean visible = driver.findElement(By.id("username-error")).isDisplayed();
        if(visible.equals(TRUE)){
            System.out.println("'" + UserError + "'" + " error message is displayed for " + text + " input.");
        }else{
            System.out.println("'" + UserError + "'" + " error message is missing for " + text + " input.");
        }

    }

    @When("I enter {string} into the username input box")
    public void iEnterIntoTheUsernameInputBox(String valUser) throws InterruptedException {
        driver.findElement(By.id("login-username")).sendKeys(valUser);
        Thread.sleep(2000);
    }

    @And("I enter {string} into the input box")
    public void iEnterIntoTheInputBox(String invPass) throws InterruptedException {
        driver.findElement(By.id("login-passwd")).sendKeys(invPass);
        Thread.sleep(2000);

    }

    @Then("the {string} error message on the password Sign in page for input {string} should be visible")
    public void theErrorMessageOnThePasswordSignInPageForInputShouldBeVisible(String ErrorPass, String text) {
        Boolean visible = driver.findElement(By.xpath("//p[@class='error-msg']")).isDisplayed();
        if(visible.equals(TRUE)){
            System.out.println("'" + ErrorPass + "'" + " error message is displayed for " + text + " input.");
        }else{
            System.out.println("'" + ErrorPass + "'" + " error message is missing for " + text + " input.");
        }
    }

    @When("I enter valid {string} data into the input box")
    public void iEnterValidDataIntoTheInputBox(String valUser) throws InterruptedException {
        driver.findElement(By.id("login-username")).sendKeys(valUser);
        Thread.sleep(2000);

    }

    @And("I enter {string} into the password input box")
    public void iEnterIntoThePasswordInputBox(String valPass) throws InterruptedException {
        driver.findElement(By.id("login-passwd")).sendKeys(valPass);
        Thread.sleep(2000);
    }

    @Then("I should be able to logged in")
    public void iShouldBeAbleToLoggedIn() throws InterruptedException {
        Boolean visible = driver.findElement(By.xpath("//span[contains(text(), 'RYAN CHRISTIAN')]")).isDisplayed();
        if(visible.equals(TRUE)){
            System.out.println("Yahoo account logged in successfully");
        }else{
            System.out.println("Yahoo account unable to logged in");
        }
        Thread.sleep(2000);
    }
}

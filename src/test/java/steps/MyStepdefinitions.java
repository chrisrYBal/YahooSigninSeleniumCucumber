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

    @Given("I redirect to yahoo home page")
    public void iRedirectToYahooHomePage() throws InterruptedException {
        driver.manage();
        driver.get("https://yahoo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }

    @When("I click sign in button")
    public void iClickSignInButton() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='_yb_1ana4']")).click();
        Thread.sleep(4000);
    }

    @Then("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() {
        try {
            Boolean landingpage = driver.findElement(By.id("login-landing")).isDisplayed();
            if(landingpage.equals(TRUE)) {
                System.out.println("Scenario1" + "\n" + "Yahoo sign in page displayed successfully:" + "\n" );
            }else {
                System.out.println("Scenario1" + "\n" + "Yahoo sign in page displayed unsuccessfully:" + "\n" );
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("I redirect to yahoo sign in page")
    public void iRedirectToYahooSignInPage() throws InterruptedException {
        driver.manage();
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }


    @When("I input invalid username")
    public void iInputInvalidUsername() throws InterruptedException {
        driver.findElement(By.id("login-username")).sendKeys("fortesting");
        Thread.sleep(2000);
    }

    @When("I click Next button")
    public void iClickNextButton() throws InterruptedException {
        driver.findElement(By.id("login-signin")).click();
        Thread.sleep(4000);
    }

    @Then("the username error message should be displayed")
    public void theUsernameErrorMessageShouldBeDisplayed() {
        try {
            String EM = "Sorry, we don't recognize this email.";
            String nonexistentEmailMessage = driver.findElement(By.id("username-error")).getText();
            if(nonexistentEmailMessage.equals(EM)) {
                System.out.println("Scenario2" + "\n" + "User Expected and Actual Error Message Matched:" + "\n" + nonexistentEmailMessage);
            }else {
                System.out.println("Scenario2" + "\n" + "User Expected and Actual Error Message Mismatched:" + nonexistentEmailMessage);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @When("I input valid username")
    public void iInputValidUsername() throws InterruptedException {
        driver.findElement(By.id("login-username")).sendKeys("chrisryanbaltazar");
        Thread.sleep(2000);
    }

    @Then("the input password page should be displayed")
    public void theInputPasswordPageShouldBeDisplayed() {
        try {
            Boolean pswrdlandingpage = driver.findElement(By.id("password-challenge")).isDisplayed();
            if(pswrdlandingpage.equals(TRUE)) {
                System.out.println("Scenario4" + "\n" + "Yahoo enter password page displayed successfully:" + "\n" );
            }else {
                System.out.println("Scenario4" + "\n" + "Yahoo enter password page displayed unsuccessfully:" + "\n" );
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @When("I input wrong password")
    public void iInputWrongPassword() throws InterruptedException {
        driver.findElement(By.id("login-passwd")).sendKeys("Ros");
        Thread.sleep(2000);
    }

    @And("I click password Next button")
    public void iClickPasswordNextButton() throws InterruptedException {
        driver.findElement(By.id("login-signin")).click();
        Thread.sleep(2000);
    }

    @Then("the password error message should be displayed")
    public void thePasswordErrorMessageShouldBeDisplayed() {
        try {
            String EM = "Invalid password. Please try again";
            String wrongPasswordMessage = driver.findElement(By.xpath("//p[@class='error-msg']")).getText();
            if(wrongPasswordMessage.equals(EM)) {
                System.out.println("Scenario3" + "\n" + "Password Expected and Actual Error Message Matched:" + "\n" + wrongPasswordMessage);
            }else {
                System.out.println("Scenario3" + "\n" + "Password Expected and Actual Error Message Mismatched:" + "\n" + wrongPasswordMessage);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I input correct password")
    public void iInputCorrectPassword() throws InterruptedException {
        driver.findElement(By.id("login-passwd")).sendKeys("Rosoideae");
        Thread.sleep(2000);
    }

    @Then("I navigated to my account")
    public void iNavigatedToMyAccount() {
        try {
            String eName = "RYAN CHRISTIAN";
            String aName = driver.findElement(By.id("ybarAccountMenuOpener")).getText();
            if(aName.equals(eName)) {
                System.out.println("Scenario4" + "\n" + "User signed in successfully" + "\n" + aName);
            }else {
                System.out.println("Scenario4" + "\n" + "User unable to sign in" + "\n" + aName);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

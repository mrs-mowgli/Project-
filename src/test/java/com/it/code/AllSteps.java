package com.it.code;

import com.it.pop.TestClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AllSteps extends TestClass {
    static JavascriptExecutor js;


    @Given("^User is on the homepage$")
    public void openHome(){
        driver = new FirefoxDriver();
        driver.get("http://40.76.27.113:8085/en/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor)driver;
        assertEquals("PrestShop",driver.getTitle());
    }

    @When("^User clicks on Art Category$")
    public void artCategory() {
        clickArt();

    }
    @And("^User clicks on Art Category Link$")
    public void artCategoryClick(){
        clickArt();
    }

    public void clickArt() {
        driver.findElement(By.xpath("//a[contains(text(),'Art')]")).click();
        String category ="ART";
        assertEquals(category,driver.findElement(By.xpath("//div[@id='left-column']/div/ul/li")).getText());

    }

    /*    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        driver = new ChromeDriver();
        driver.get("http://40.76.27.113:8085/en/");
        driver.manage().window().maximize();
    }*/

    @When("^user clicks on product$")
    public void user_clicks_on_product() {
        ClickElementXpath("//a[contains(text(),'Hummingbird printed t-shirt')]");

    }

    @And("^user clicks on Add to cart button$")
    public void user_clicks_on_add_to_cart_button() {
        ClickElementXpath("(//button[@type='submit'])[2]");
    }

    @Then("^Proceed to checkout option should be displayed$")
    public void Proceed_to_checkout_is_displayed() {
        assertTrue(driver.findElement(By.xpath("//div[@id='blockcart-modal']/div/div/div[2]/div/div/div/div[2]/h6")).isDisplayed());
        //driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/button/span/i")).click();

    }

    @Given("^user has a product in the cart$")
    public void user_has_a_product_in_the_cart() {
        String actualString = driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[3]/div/div/a/span[2]")).getText();
        assertTrue(actualString.contains("(1)"));

    }

    @When("^user clicks on the cart icon$")
    public void user_clicks_on_cart_the_icon() {
        driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[3]/div/div/a")).click();
    }

    @Then("^shopping cart page is displayed$")
    public void shopping_cart_page_is_displayed() {
        String url = driver.getCurrentUrl();
        String currentUrl = "http://40.76.27.113:8085/en/cart?action=show";
        assertEquals(url, currentUrl);

    }

    @Given("^user is shopping cart page$")
    public void user_is_personal_information_page() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")).click();

    }

    @And("^click on Proceed to checkout button$")
    public void click_on_Proceed_to_checkout_button() {
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[2]/div[1]/div[2]/div/a")).click();

    }

    @When("^fill data in mandatory fields$")
    public void fill_data_in_mandatory_fields() {
        driver.findElement(By.name("id_gender")).click();
        driver.findElement(By.name("firstname")).sendKeys("misa");
        driver.findElement(By.name("lastname")).sendKeys("tran");
        driver.findElement(By.name("email")).sendKeys("test10@test.com");
        driver.findElement(By.name("psgdpr")).click();
    }

    @When("^user clicks on Continue button$")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.name("continue")).click();
    }

    @When("^fill data in mandatory fields on address$")
    public void fill_data_in_mandatory_fields_on_address() {
        driver.findElement(By.name("address1")).sendKeys("home 123");
        driver.findElement(By.name("postcode")).sendKeys("123 45");
        driver.findElement(By.name("city")).sendKeys("malmo");
        driver.findElement(By.name("confirm-addresses")).click();
    }

    @When("^select shipping method$")
    public void select_shipping_method() {
   //     driver.findElement(By.name("delivery_option[19]")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
    }

    @When("^select payment method$")
    public void select_payment_method() {
        driver.findElement(By.id("payment-option-1")).click();
    }

    @When("^agree to the terms of service$")
    public void agree_to_the_terms_of_service() {
        driver.findElement(By.name("conditions_to_approve[terms-and-conditions]")).click();
    }

    @When("^user clicks on Order with an obligation to pay button$")
    public void user_clicks_on_order_with_an_obligation_to_pay_button() {
        driver.findElement(By.xpath("/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")).click();
    }

    @Then("^Your order is confirmed is displayed$")
    public void your_order_is_confirmed_is_displayed() {
        String actualString = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section[1]/div/div/div/h3")).getText();
        assertTrue(actualString.contains("Your order is confirmed"));

    }


}

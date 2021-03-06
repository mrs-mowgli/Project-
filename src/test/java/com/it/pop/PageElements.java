package com.it.pop;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PageElements extends BaseClass{
    public void ClickLinkItem(String menu)
    {
        driver.findElement(By.xpath("//a[contains(text(),'"+menu+"')]")).click();
    }

    public void CheckTitle(String title){
        assertEquals(title,driver.getTitle());
    }

    public void ClickElementXpath(String xpath){

        driver.findElement(By.xpath(xpath)).click();
    }

    public void ClickElementByCss(String css){
        driver.findElement(By.cssSelector(css)).click();
    }
    public void CheckUrl(String url){
        assertEquals(url,driver.getCurrentUrl());
    }
    public void ClickElementById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void EnterText(String locator,String text){//Make sure to use only xpath
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void CompareTextFilter(String value){
        assertEquals(value,driver.findElement(By.xpath("//section[@id='js-active-search-filters']/ul/li")).getText());
    }
    public void ClearFilter(){

        ClickElementXpath("//div[2]/div[2]/div/button");
    }

    public  void waitForClearAllButtn(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("//div[2]/div[2]/div/button")));
    }

    public  void waitToRemoveClearAll(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[2]/div[2]/div/button")));
    }
    public boolean waitForActiveFilter(String activeFilter){
        boolean actFilter = driver.findElement(By.xpath(activeFilter)).isDisplayed();
        return actFilter;
    }

    public static void sign_in(){
        driver.findElement(By.id(signin)).click();
    }
    public static void signup(){
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/a")).click();
    }
    public static void selectGender(){
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/section/form/section/div[1]/div[1]/label[2]/span/input")).click();
    }


    public void  data(String firstname, String lastname,String e_mail, String password,String dob) {
        driver.findElement(By.name(fNa)).sendKeys(firstname);
        driver.findElement(By.name(lNa)).sendKeys(lastname);
        driver.findElement(By.name(emelj)).sendKeys(e_mail);
        driver.findElement(By.name(pword)).sendKeys(password);
        driver.findElement(By.name(birthD)).sendKeys(dob);
    }

    public void termsOfA(){
        driver.findElement(By.name(terms)).click();
    }
    public void save(){
        driver.findElement(By.name(sav)).submit();
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }


    public void selectOptionShow()  {
        driver.findElement(By.cssSelector("#_desktop_language_selector > div > div > button > i")).click();

    }

    public void selectOptionSwedish(){
        js=(JavascriptExecutor) driver; ////*[@id="_desktop_language_selector"]/div/div/ul/li[2]
        driver.findElement(By.xpath("//*[@id=\"_desktop_language_selector\"]/div/div/ul/li[2]/a")).click();

    }

    public void selectOptionEnglish(){

        js=(JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[@id=\"_desktop_language_selector\"]/div/div/ul/li[1]")).click();

    }


}

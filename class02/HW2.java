package com.syntax.class02;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.Keys;

public class HW2 {

 /*navigate to fb.com
click on create new account
fill up all the textboxes
click on sign up button
close the pop up
close the browser*/


    ChromeDriver driver;
    String url = "https://www.fb.com";
    public void invokeBrowser() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(url);
    }

    String urlFromWebpage = driver.getCurrentUrl();

    if (urlFromWebpage.equals("https://www.facebook.com/")) {

        System.out.println("PASS");

    } else {

        System.out.println("FAIL");
    }

    public void signup() {

        webElement createAccountHeading = driver.findElement(By.xpath("//span[text()= 'Create an account']"));

        if (createAccountHeading.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.findElement(By.name("firstname")).sendKeys("Test");
        driver.findElement(By.name("lastname")).sendKeys("User");
        driver.findElement(by.name("name=\"reg_email__\")).sendKeys("Testuser@syntax.com");
        driver.findElement(by.name("name=\"reg_email_confirmation__\")).sendKeys("Testuser@syntax.com");
        driver.findElement(By.name("name=\"reg_password__")).sendKeys("TestPassword");

        webElement dataElement = driver.findElement(by.id("day"));
        webElement monthElement = driver.findElement(by.id("month"));
        webElement yearElement = driver.findElement(by.id("year"));

        select dateDropdown = new Select(dateElement);
        select monthDropdown = new Select(monthElement);
        select yearDropdown = new Select(yearElement);

        dateDropdown.selectByVisibleText("2");
        monthDropdown.selectByVisibleText("Dec");
        yearDropdown.selectByVisibleText("2022");
        driver.findElement(By.xpath("//input[@type= 'radio' and @value='1']")).click();
        //driver.findElement(By.name("websubmit")).click();
    }


    public static void main(String[] args) {

        FacebookSignup fs = new FacebookSignup();
        fs.invokeBrowser();
        fs.signup();

    }
}






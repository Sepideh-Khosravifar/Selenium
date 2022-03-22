package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HW1 {

    //navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
    //fill out the form
    //click on register
    //close the browser

    public static void main(String[] args) throws InterruptedException {

        //Set System Property
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        //Instantiate Objects and Variables
        WebDriver driver = new ChromeDriver();

        //Launch a Browser Session
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");

        //Find elements
        driver.findElement(By.name("username")).sendKeys("xyz.com");

        driver.findElement(By.name("password")).sendKeys("sepideh");

        driver.findElement(By.name("login")).click();

        Thread.sleep(2000);

       // driver.findElement(By.linkText("Forgot login")).click();

        driver.findElement(By.partialLinkText("Forgot")).click();

        driver.findElement(By.linkText("Register")).click();

        //Close the browser
        driver.quit();

    }
}


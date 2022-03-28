package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.id("customer.firstName")).sendKeys("xyzcom1234");

        driver.findElement(By.id("customer.lastName")).sendKeys("sepideh221234");

        driver.findElement(By.id("customer.address.street")).sendKeys("1559 Onyx Drive");

        driver.findElement(By.id("customer.address.city")).sendKeys("Desmoine");

        driver.findElement(By.id("customer.address.state")).sendKeys("IA");

        driver.findElement(By.id("customer.address.zipCode")).sendKeys("22102");

        driver.findElement(By.id("customer.ssn")).sendKeys("555558888");

        driver.findElement(By.id("customer.username")).sendKeys("abcdefghij");

        driver.findElement(By.id("customer.password")).sendKeys("a1b2c3d4e56789");

        driver.findElement(By.id("repeatedPassword")).sendKeys("a1b2c3d4e56789");

        WebElement RegisterButton = driver.findElement(By.className("button"));

        //click on the register
        RegisterButton.click();

        Thread.sleep(2000);

        //close the browser
        driver.quit();

    }
}


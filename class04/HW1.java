package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        WebElement username = driver.findElement(By.xpath("//input[contains(@id, 'Username')]"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
        password.sendKeys("Hum@nhrm123");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'LOGIN']"));

        loginButton.click();

        WebElement img = driver.findElement(By.id("branding"));

        System.out.println(img.isDisplayed());

        driver.quit();

    }
}


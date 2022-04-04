package com.syntax.SeleniumReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Review1 {
        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/text-box");

//        WebElement username = driver.findElement(By.id("userName"));
//        username.sendKeys("akbarakedabra");
//        username.clear();
//        username.sendKeys("fire");

            WebElement username = driver.findElement(By.xpath("//input[@id='userName']"));
            username.sendKeys("hellothere");

        }
    }

package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Go to https://syntaxprojects.com/javascript-alert-box-demo.php
//click on each button and handle the alert accordingly

public class HW {

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("https://syntaxprojects.com/javascript-alert-box-demo.php");


            WebElement alertBox = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
            alertBox.click();
            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            alert.accept();                     // handling simple alert

            WebElement confirmBox = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
            confirmBox.click();
            Thread.sleep(2000);
            alert.dismiss();                    // handling confirm alert

            WebElement promptBox = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
            promptBox.click();
            Thread.sleep(2000);
            alert.sendKeys("one, two, three");
            alert.accept();                     // handling prompt alert

            Thread.sleep(2000);
            driver.quit();
        }
   }


package com.syntax.class08;

//Go to https://syntaxprojects.com/javascript-alert-box-demo.php
//click on each button and handle the alert accordingly

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement alertBox = driver.findElement(By.xpath("//Button[@class ='btn btn-default']"));

        WebElement confirmBox = driver.findElement(By.xpath("//Button[@class ='btn btn-default btn-lg']"));

        WebElement promptBox = driver.findElement(By.xpath("//Button[@class ='']"));


    }
 }


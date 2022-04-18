package com.syntax.class07;

//Go to https://demoqa.com/browser-windows
//click on New Tab and print the text from new tab in the console
//click on New Window and print the text from new window in the console
//click on New Window Message and print the text from new message window in the console
//Verify (compare) the titles for each page
//Print out the title of the all pages

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW1 {       /****************USE FIREFOX************************/

    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String mainPageHandle = driver.getWindowHandle();

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        System.out.println(newTabButton.getText());

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
             System.out.println(newWindowButton.getText());

        Set<String> allWindowHandles = driver.getWindowHandles();
             System.out.println(allWindowHandles.size());

        Iterator<String> it = allWindowHandles.iterator();

        while (it.hasNext()) {
            String handle = it.next();

            if (!mainPageHandle.equals(handle)) {
                driver.switchTo().window(handle);

                String title = driver.getTitle();
                System.out.println(title);

                driver.close();
            }
        }
    }
}
package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Task1 {

    //Go to https://demoqa.com/browser-windows
    //click on New Tab and print the text from new tab in the console
    //click on New Window and print the text from new window in the console
    //click on New Window Message and print the text from new window in the console
    //Verify (compare) the titles for each page
    //Print out the title of the all pages

    public static String url ="https://demoqa.com/browser-windows";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        String mainWindowHandle = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.cssSelector("button#tabButton"));
        WebElement newWindowButton = driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement newWindowMessage =driver.findElement(By.xpath("//button[@id='messageWindowButton']"));

        newTabButton.click();
        newWindowButton.click();
        newWindowMessage.click();

        Set<String> windowsHandling = driver.getWindowHandles();

        Iterator <String> iterator = windowsHandling.iterator();

         while(iterator.hasNext()){
            String handle = iterator.next();

            driver.switchTo().window(handle);

            if(!handle.equals(mainWindowHandle)) {
                String text = driver.findElement(By.cssSelector("body")).getText();
                System.out.println(text);
            }

            String title = driver.getTitle();

            if(!title.isEmpty()) {
                System.out.println(title);
            }
        }

        driver.quit();

    }
}

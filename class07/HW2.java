package com.syntax.class07;

//navigate to http://www.uitestpractice.com/Students/Contact
//click on the link
//get text
//print out in the console

import javafx.scene.input.InputMethodTextRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class HW2 {

    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement thisIsaAjaxLinkButton = driver.findElement(By.xpath("//Link[text()='This is a Ajax link']"));
        thisIsaAjaxLinkButton.click();
        Thread.sleep(20000);

        WebElement text = driver.findElement(By.tagName("p"));
        System.out.println(text.getText());
        driver.quit();

    }
}


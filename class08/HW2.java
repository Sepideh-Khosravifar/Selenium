package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW2 {

/*go to https://the-internet.herokuapp.com/dynamic_controls
click on checkbox and click on remove
verify the text
click on enable verify the textbox is enabled
enter text and click disable
verify the textbox is disabled */

    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get(url);

        //click on checkbox and click on remove
        WebElement checkBox = driver.findElement(By.xpath("//input[@type ='checkbox']"));
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick = 'swapCheckbox()']"));

        //click on enable verify the textbox is enabled
        WebElement enableDisableButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()']"));
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        checkBox.click();
        removeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));
        WebElement message = driver.findElement(By.cssSelector("p#message"));

        if (message.getText().equals("It's gone!")) {

            System.out.println("It is working just fine.");

        } else {
            System.out.println("I don't know what's going on...");

            enableDisableButton.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

            if (textBox.isEnabled()) {
                System.out.println("Text enabled");
                textBox.sendKeys("Dolce Vita");
            }

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
            WebElement messageText = driver.findElement(By.xpath("//p[@id='message']"));

            if (messageText.getText().equals("It's disabled!")) {
                System.out.println("Textbox is disabled.");

            } else {
                System.out.println("I don't know");

            }

            driver.quit();
        }
    }
}
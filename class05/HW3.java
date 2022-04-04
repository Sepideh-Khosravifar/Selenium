package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

    public class HW3 {

        public static String url = "http://ebay.com";

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(url);

            WebElement categoriesDD = driver.findElement(By.xpath("//select[@id = 'gh-cat']"));
            Select select = new Select(categoriesDD);
            List<WebElement> options = select.getOptions();

            for (WebElement option : options) {

                String optionText = option.getText();
                System.out.println(optionText);
            }

            select.selectByValue("58058");
            WebElement search = driver.findElement(By.cssSelector("select[name'_sacat']"));
            search.click();
            Thread.sleep(1000);

            if (driver.getTitle().equals("select computers/tablets & networking")) {
                System.out.println("is correct");
            } else {
                System.out.println("is not correct");
            }

            driver.quit();

        }
    }


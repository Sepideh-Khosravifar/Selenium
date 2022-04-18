package com.syntax.class10;

//Go to aa.com/homePage.do
//select depart date
//select return date
//select destination
//click on search
//quit the browser

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class HW1 {

    public static String url = "http://www.aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement calendar = driver.findElement(By.xpath("//button[@class = 'ui-datepicker-trigger']"));
        calendar.click();

        WebElement nextButton = driver.findElement(By.xpath("//button[@class='ui-datepicker-next ui-corner-all']"));
        nextButton.click();

        WebElement dMonth = driver.findElement(By.className("ui-datepicker-month"));
        String dMonthText = dMonth.getText();

        while (!dMonthText.equals("August")) {
            nextButton.click();
            dMonthText = dMonth.getText();
        }

        List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class = 'ui-datepicker-calendar']/tr/td"));

        for (WebElement departDate : departDates) {

            if (departDate.getText().equals("20")) {
                departDate.click();
                break;
            }
        }

        WebElement rMonth = driver.findElement(By.className("ui-datepicker-month"));
        String rMonthText = rMonth.getText();

        while (!rMonthText.equals("October")) {
            nextButton.click();
            rMonthText = rMonth.getText();
        }
/*
        List<WebElement> returnDate = driver.findElements(By.xpath("//tbody[@class = 'data-handler=\"selectDay']/tr/td"));
        for (WebElement returnDate : returnDates) {
            String dateText = returnDate.getText();
            if (dateText.equals("4")) {
                returnDate.click();
                break;
            }
        }  */

        WebElement doneButton = driver.findElement(By.className("donebutton"));
        doneButton.click();


        //select destination
        WebElement searchButton = driver.findElement(By.name("destinationAirport"));
        searchButton.click();

        WebElement selectCountry = driver.findElement(By.id("    "));   // NEED TO BE FILLED OUT FROM DOM...
        searchButton.click();



      /* WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.vacationSubmit"));
        searchButton.click(); */

        driver.quit();

    }
}










package com.syntax.class09;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

    public class HW {

        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //Go to url
            driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

            driver.manage().timeouts().implicitlyWait(900, TimeUnit.SECONDS);

            //Type username & pwd and login
            WebElement username = driver.findElement(By.id("txtUsername"));
            username.sendKeys("Admin");
            WebElement password = driver.findElement(By.id("txtPassword"));
            password.sendKeys("Hum@nhrm123");
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            loginButton.click();

            //Click on "leave"
            WebElement leave = driver.findElement(By.id("menu_leave_viewLeaveModule"));
            leave.click();

            //Click on  "leave" button
            WebElement leaveList = driver.findElement(By.id("menu_leave_viewLeaveList"));
            leaveList.click();

            //choose from "From calendar"
            WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
            fromCalendar.click();

            WebElement departureMonth = driver.findElement(By.className("ui-datepicker-month"));
            Select select1 = new Select(departureMonth);
            select1.selectByVisibleText("Dec");

            List <WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
            for(WebElement fromDate : fromDates) {
                String dateText = fromDate.getText();
                if(dateText.equals("20")) {
                    fromDate.click();
                    break;
                }
            }

            //choose from "To calendar"
            WebElement toCalendar = driver.findElement(By.id("calToDate"));
            toCalendar.click();

            WebElement returnMonth = driver.findElement(By.className("ui-datepicker-month"));
            Select select2 = new Select(returnMonth);
            select2.selectByVisibleText("Jan");

            List <WebElement> todates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
            for(WebElement todate : todates) {
                if(todate.getText().equals("2")){
                    todate.click();
                    break;
                }
            }

            //click on the rejected checkbox
            WebElement rejectButton = driver.findElement(By.id("leaveList_chkSearchFilter_-1"));
            rejectButton.click();

            //click on cancelled checkbox
            WebElement cancelButton = driver.findElement(By.id("leaveList_chkSearchFilter_0"));
            cancelButton.click();

            //uncheck the Pending Approval checkbox
            WebElement pendingApproval = driver.findElement(By.id("leaveList_chkSearchFilter_1"));
            pendingApproval.click();

            //select "IT support" from DropDown
            WebElement itSupport = driver.findElement(By.id("leaveList_cmbSubunit"));
            Select select3 = new Select(itSupport);
            select3.selectByVisibleText("IT Support");

            //click search
            WebElement searchButton = driver.findElement(By.id("btnSearch"));
            searchButton.click();

            //quit the browser
            driver.quit();

        }
    }


package task_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Question_1 {

    //Declaring Driver Variable as Global to Access Throughout the Class
    WebDriver driver;

    @BeforeTest
    //Function to Start the Chrome Browser
    public void launchChrome() {

        //Creating an Instance for ChromeDriver
        driver = new ChromeDriver();

        //Declaring Implicit wait(5 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Maximizing the Window
        driver.manage().window().maximize();

        //Navigating to the Given URL
        driver.get("https://jqueryui.com/datepicker/");
    }

    @Test
    //Function to Print the Asked Date
    public void datePicker() {

        //Switching to Respective Frame
        driver.switchTo().frame(0);

        //Clicking the Date Textbox Field
        driver.findElement(By.id("datepicker")).click();

        //Clicking the Right Arrow Button to Switch to Next Month
        driver.findElement(By.xpath("//span[text()='Next']")).click();

        //Clicking the Given Date in the Month
        driver.findElement(By.xpath("//a[@data-date='22']")).click();

        //Storing the Date Which has Already Selected Using the GetAttribute Method
        String text = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");

        //Printing the Date in the Console
        System.out.println(text);
    }

    @AfterTest
    //Function to Close the Chrome Browser
    public void closeBrowser() {

        //Closing the Current Window of the Chrome Browser
        driver.close();

        //Closing the Chrome browser and Its Instance also
        driver.quit();
    }
}

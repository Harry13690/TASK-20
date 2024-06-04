package task_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Question_2 {

    //Declaring Driver Variable as Global to Access Throughout the Class
    WebDriver driver;

    @BeforeTest
    //Function to Start the Chrome Browser
    public void launchChrome() {

        //Creating an Instance for ChromeDriver
        driver = new ChromeDriver();

        //Declaring Implicit wait(5 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Maximizing the Window
        driver.manage().window().maximize();

        //Navigating to the Given URL
        driver.navigate().to("https://www.guvi.in");
    }

    @Test
    //Function to Registrating an Account And Login into Guvi
    public void loginGuvi() {

        //CLicking on "Sign Up" Button
        driver.findElement(By.xpath("(//a[text()='Sign up'])[1]")).click();

        //Inserting the Data in Username Field
        driver.findElement(By.id("name")).sendKeys("DemoSample");

        //Inserting the Data in Email Field
        driver.findElement(By.id("email")).sendKeys("demosample19@gmail.com");

        //Inserting the Data in Password Field
        driver.findElement(By.id("password")).sendKeys("Demo123");

        //Inserting the Data in Mobile Number Field
        driver.findElement(By.id("mobileNumber")).sendKeys("9957297493");

        //Clicking on "Sign up" Button to Register
        driver.findElement(By.xpath("(//a[text()='Sign Up'])[1]")).click();

        //Clicking on "Maybe Later" Button to Continue
        driver.findElement(By.id("laterBtn")).click();

        //Getting the Text from the Current Page
        String text = driver.findElement(By.xpath("//h1[contains(text(),'Done')]")).getText();

        //Verifying that the Registration Successfully or Not
        Assert.assertEquals(text, "Almost Done! Check Your Inbox!");

        //Refreshing the Page to Login
        driver.navigate().refresh();

        //Clicking on "Login" LinkText Button
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //Inserting Registered Data in Email Field
        driver.findElement(By.id("email")).sendKeys("hariprasathmgac@gmail.com");

        //Inserting Registered Data in Password Field
        driver.findElement(By.id("password")).sendKeys("Hari03zenyt@");

        //Clicking on "Login' Button
        driver.findElement(By.id("login-btn")).click();

        //Clicking on Profile at the Right-Top of the Page
        driver.findElement(By.xpath("//img[@class='gravatar']")).click();

        //Getting the Text from the Web page
        String text1 = driver.findElement(By.xpath("//small[contains(@class,'email-wrap')]")).getText();

        //Verifying that the User Logged in Successfully or Not
        Assert.assertEquals(text1, "hariprasathmgac@gmail.com");
    }

    @AfterTest
    //Function to Close the Chrome Browser
    public void closeBrowser() {

        //Closing the Current Window of the Chrome Browser
        driver.close();
    }
}

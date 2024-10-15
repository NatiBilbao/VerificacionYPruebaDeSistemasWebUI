package basico;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    WebDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("https://todo.ly/");

    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }

    @Test
    public void verifySomeThing() throws InterruptedException {
        Thread.sleep(5000);
    }
}

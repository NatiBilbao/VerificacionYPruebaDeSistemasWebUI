package tareas.tarea11.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFox implements IBrowser{
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        WebDriver firefox = new FirefoxDriver();
        firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        firefox.manage().window().maximize();
        return firefox;
    }
}

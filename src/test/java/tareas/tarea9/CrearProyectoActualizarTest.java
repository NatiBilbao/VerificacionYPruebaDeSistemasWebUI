package tareas.tarea9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CrearProyectoActualizarTest {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("http://todo.ly/");
    }
    @Test
    public void verifyLoginTest() throws InterruptedException {
        String project = "Natalia Bilbao";
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo ingresar a la sesion");

        // Crear Proyecto
        chrome.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(project);
        chrome.findElement(By.id("NewProjNameButton")).click();
        chrome.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        Thread.sleep(2000);
        Assertions.assertTrue((chrome.findElements(By.xpath("//td[@class='ProjItemContent'][text()='"+project+"']")).size()==1), "ERROR no se pudo crear un proyecto");

        //Actualizar Proyecto
        String updatedProject = "Natalia Bilbao Cano";

        chrome.findElement(By.xpath("//td[@class='ProjItemContent'][text()='"+project+"']")).click();
        Thread.sleep(2000);
        List<WebElement> findProject = chrome.findElements(
                By.xpath(String.format("//tr[td[@class='ProjItemContent' and text()='"+project+"']]")));
        WebElement lastProjectCreated = findProject.get(0);
        lastProjectCreated.click();
        lastProjectCreated.findElement(By.xpath(".//div[@class='ProjItemMenu']/img")).click();

        chrome.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]/li[@class='edit']")).click();
        chrome.findElement(By.id("ItemEditTextbox")).clear();
        chrome.findElement(By.id("ItemEditTextbox")).sendKeys(updatedProject);
        chrome.findElement(By.id("ItemEditSubmit")).click();

        Thread.sleep(2000);
        Assertions.assertTrue((chrome.findElements(By.xpath("//td[@class='ProjItemContent'][text()='"+updatedProject+"']")).size()==1), "ERROR no se pudo editar un proyecto");

        Thread.sleep(5000);
    }

    @AfterEach
    public void close(){
        chrome.quit();
    }
}

package tareas.tarea10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class EliminarProyectoTest {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.get("http://todo.ly/");
    }
    @Test
    public void createUpdateDeleteProject() throws InterruptedException {
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Assertions.assertTrue((chrome.findElements(By.xpath("//a[text()='Logout']")).size() == 1),
                "ERROR no se pudo iniciar sesion");

        String nameProject = "Bilbao Cano Natalia";

        chrome.findElement(By.xpath("//td[text()='Add New Project']")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        chrome.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(2000);

        String actualResult= chrome.findElement(By.id("CurrentProjectTitle")).getText();
        String expectedResult= nameProject;

        Assertions.assertEquals(expectedResult,actualResult,"ERROR el proyecto no se creo");

        //Eliminar Proyecto
        chrome.findElement(By.xpath("//li[last()]//td[text()='"+nameProject+"']")).click();
        chrome.findElement(By.xpath("//div[@style=\"display: block;\"]/img[@title='Options']")).click();
        chrome.findElement(By.id("ProjShareMenuDel")).click();
        chrome.switchTo().alert().accept();
        Thread.sleep(2000);

        Assertions.assertTrue(chrome.findElements(By.xpath("//li[last()]//td[text()='"+nameProject+"']")).size() <= 0,
                "ERROR el proyecto no fue eliminado");
    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }
}
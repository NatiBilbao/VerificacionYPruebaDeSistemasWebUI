package tareas.tarea11.pages;

import org.openqa.selenium.By;
import tareas.tarea11.controls.Button;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
}

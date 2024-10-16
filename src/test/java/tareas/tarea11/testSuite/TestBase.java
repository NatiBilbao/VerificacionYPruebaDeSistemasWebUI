package tareas.tarea11.testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tareas.tarea11.pages.LoginSection;
import tareas.tarea11.pages.MainPage;
import tareas.tarea11.pages.MenuSection;
import tareas.tarea11.session.Session;

public class TestBase {
    protected MainPage mainPage = new MainPage();
    protected LoginSection loginSection = new LoginSection();
    protected MenuSection menuSection = new MenuSection();

    @BeforeEach
    public void openBroswer() {
        Session.getSession().goTo("https://todo.ly/");
    }

    @AfterEach
    public void closeBroswer() {

        Session.getSession().closeBrowser();

    }
}

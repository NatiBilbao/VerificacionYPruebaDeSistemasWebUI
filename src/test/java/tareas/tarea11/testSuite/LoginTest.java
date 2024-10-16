package tareas.tarea11.testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase{
    @Test
    public void verifyLoginSuccessfully() {

        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("selenium123@123.com");
        loginSection.passwordTextBox.setText("12345");
        loginSection.loginButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR no se pudo iniciar sesión");

    }
}

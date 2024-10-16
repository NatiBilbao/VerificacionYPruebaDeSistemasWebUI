package session;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {
    // atributo del mismo tipo de la clase
    private static Session session = null;
    private WebDriver browser;
    // constructor privado
    private Session(){
        //todo -- read from property file
        browser = FactoryBrowser.make("chrome").create();
    }
    // metodo de acceso global publico
    public static Session getInstance(){
        if (session == null)
            session = new Session();
        return session;
    }

    public void closeSession(){
        browser.quit();
        session=null;
    }

    public WebDriver getBrowser() {
        return browser;
    }
}

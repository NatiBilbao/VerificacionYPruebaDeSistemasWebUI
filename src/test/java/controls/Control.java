package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class Control {
    protected By locator;
    protected WebElement control;

    public Control(By locator){
        this.locator = locator;
    }

    protected void findControl(){
        this.control = Session.getInstance().getBrowser().findElement(this.locator);
    }

    public void click(){
        this.findControl();
        this.control.click();
    }
    public boolean isControlDislayed(){
        try {
            this.findControl();
            return this.control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public String getText(){
        this.findControl();
        return control.getText();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ServicesPage extends MainPage{

    public ServicesPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//div[contains(@class, 't-title_xl')]/div");
    private By learnmore = By.xpath("//div[@field='descr']/following-sibling::a");

    public String headertext(){
        return driver.findElement(header).getText();
    }

    public String clicklink(){
        driver.findElement(learnmore).click();
        String act = null;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            act = driver.getCurrentUrl();
        }
        return act;
    }
}

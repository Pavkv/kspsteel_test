import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactsPage extends MainPage{

    public ContactsPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//div[contains(@class, 't-title_xl')]/div");
    private By contacts = By.xpath("//div[@class='t-text t-descr_sm']");

    public String headertext(){
        return driver.findElement(header).getText();
    }

    public String getcontacs(){
        return driver.findElement(contacts).getText();
    }
}

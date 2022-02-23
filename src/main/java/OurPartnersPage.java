import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class OurPartnersPage extends MainPage{

    public OurPartnersPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//div[contains(@class, 't-title_xl')]/div");

    public String headertext(){
        return driver.findElement(header).getText();
    }
}

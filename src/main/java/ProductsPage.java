import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage extends MainPage{

    public ProductsPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//div[@id='allrecords']/div[2]//div[contains(@class, 't-title')]/div");

    public String headertext(){
        return driver.findElement(header).getText();
    }
}

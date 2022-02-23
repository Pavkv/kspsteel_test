import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AboutUsPage extends MainPage{

    public AboutUsPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//div[contains(@class, 't-title_xl')]/div");
    private By headersertificates = By.xpath("(//div[contains(@class, 't-title_lg')]/div)[3]");
    private By arrowleft = By.xpath("//div[contains(@class, 'arrow-left')]");
    private By arrowright = By.xpath("//div[contains(@class, 'arrow-right')]");
    private By activesertificate = By.xpath("//div[contains(@class, 'bullet_active')]");

    public String headertext(){
        return driver.findElement(header).getText();
    }

    public String headersertificatestext(){
        return driver.findElement(headersertificates).getText();
    }

    private AboutUsPage clickleftarrow(int num){
        for (int i = 0; i < num; i++){
            driver.findElement(arrowleft).click();
        }
        return this;
    }

    private AboutUsPage clickrightarrow(int num){
        for (int i = 0; i < num; i++){
            driver.findElement(arrowright).click();
        }
        return this;
    }

    public String getactivesertificate(int num1, int num2){
        clickleftarrow(num1);
        clickrightarrow(num2);
        return driver.findElement(activesertificate).getAttribute("data-slide-bullet-for");
    }
}

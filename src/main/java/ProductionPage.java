import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductionPage extends MainPage{

    public ProductionPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//div[contains(@class, 't154__title t-title t-title_md')]/div");
    private By headersecond = By.xpath("(//div[contains(@class, 't-name_xl')]/div)[1]");
    private By arrowleft2 = By.xpath("(//div[contains(@class, 'arrow-left')])[1]");
    private By arrowright2 = By.xpath("(//div[contains(@class, 'arrow-right')])[1]");
    private By activepipe = By.xpath("(//div[contains(@class, 'bullet_active')])[1]");
    private By headerthird = By.xpath("(//div[contains(@class, 't-name_xl')]/div)[2]");
    private By arrowleft3 = By.xpath("(//div[contains(@class, 'arrow-left')])[2]");
    private By arrowright3 = By.xpath("(//div[contains(@class, 'arrow-right')])[2]");
    private By activeelectric = By.xpath("(//div[contains(@class, 'bullet_active')])[2]");

    public String headertext(){
        return driver.findElement(header).getText();
    }

    public String headersecondtext(){
        return driver.findElement(headersecond).getText();
    }

    public String headerthirdtext(){
        return driver.findElement(headerthird).getText();
    }

    private ProductionPage clickleftarrow(int num, By arrowleft){
        for (int i = 0; i < num; i++){
            driver.findElement(arrowleft).click();
        }
        return this;
    }

    private ProductionPage clickrightarrow(int num, By arrowright){
        for (int i = 0; i < num; i++){
            driver.findElement(arrowright).click();
        }
        return this;
    }

    public String getsecond(int num1, int num2){
        clickleftarrow(num1, arrowleft2);
        clickrightarrow(num2, arrowright2);
        return driver.findElement(activepipe).getAttribute("data-slide-bullet-for");
    }

    public String getthird(int num1, int num2){
        clickleftarrow(num1, arrowleft3);
        clickrightarrow(num2, arrowright3);
        return driver.findElement(activeelectric).getAttribute("data-slide-bullet-for");
    }
}

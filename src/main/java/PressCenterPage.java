import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PressCenterPage extends MainPage{
    public PressCenterPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//div[contains(@class, 't-title_xl')]/div");
    private By years = By.xpath("//div[contains(@class, 'title_xxs')]");

    public String headertext(){
        return driver.findElement(header).getText();
    }

    public List<List<String>> news(String year, int num){
        List<List<String>> cnews = new ArrayList<>();
        int len = driver.findElements(years).size();
        for (int i = 1; i <= len; i++){
            List<String> items = new ArrayList<>();
            WebElement first = driver.findElement(By.xpath("(//div[contains(@class, 'title_xxs')])[" + i + "]"));
            if (Objects.equals(first.getText(), year)){
                cnews.add(Collections.singletonList(first.getText()));
                for (int j = 1; j <= num; j++){
                    WebElement second = driver.findElement(By.xpath("(//div[contains(@class, 'title_xxs')])[" + i + "]" +
                            "/ancestor::div[contains(@class, 'r_anim')]/following-sibling::div[" + j + "]"));
                    if (Objects.equals(driver.findElement(By.xpath("(//div[contains(@class, 'title_xxs')])[" + (i + 1) + "]")), second)){
                        break;
                    }
                    cnews.add(Collections.singletonList(second.findElement(By.xpath("//div[contains(@class, 't-name_xl')]")).getText()));
                    cnews.add(Collections.singletonList(second.findElement(By.xpath("//div[contains(@class, 't-descr')]")).getText()));
                    cnews.add(Collections.singletonList(second.findElement(By.xpath("//div[contains(@class, 't-text')]")).getText()));
                }
                break;
            }
        }
        return cnews;
    }
}

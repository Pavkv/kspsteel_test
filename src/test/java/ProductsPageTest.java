import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ProductsPageTest {
    private WebDriver driver;
    private Actions action;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Pasha\\Selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://td-kspsteel.ru");
        mainPage = new MainPage(driver, action);
    }

    @Test
    public void getheadertextEn(){
        mainPage.chooselang("En");
        Assert.assertEquals("TUBING", mainPage.clickproducts(1, "en").headertext());
    }

    @Test
    public void getheadertextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("ТРУБЫ ОБЩЕГО НАЗНАЧЕНИЯ", mainPage.clickproducts(3, "ru").headertext());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

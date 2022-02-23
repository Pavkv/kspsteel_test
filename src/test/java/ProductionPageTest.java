import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class ProductionPageTest {
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
        Assert.assertEquals("PRODUCTION", mainPage.clickproduction("en").headertext());
    }

    @Test
    public void getheadertextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("ПРОИЗВОДСТВО", mainPage.clickproduction("ru").headertext());
    }

    @Test
    public void getheadersecondtextEn(){
        mainPage.chooselang("En");
        Assert.assertEquals("Pipe rolling", mainPage.clickproduction("en").headersecondtext());
    }

    @Test
    public void getheadersecondtextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("Трубопрокатное производство", mainPage.clickproduction("ru").headersecondtext());
    }

    @Test
    public void getsecond(){
        Assert.assertEquals("1", mainPage.clickproduction("ru").getsecond(1, 4));
    }

    @Test
    public void getheaderthirdtextEn(){
        mainPage.chooselang("En");
        Assert.assertEquals("Electric Furnace Steelmaking", mainPage.clickproduction("en").headerthirdtext());
    }

    @Test
    public void getheaderthirdtextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("Электросталеплавильное производство", mainPage.clickproduction("ru").headerthirdtext());
    }

    @Test
    public void getthird(){
        Assert.assertEquals("2", mainPage.clickproduction("ru").getthird(3, 4));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

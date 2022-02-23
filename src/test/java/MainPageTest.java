import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
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
        Assert.assertEquals("TRADING HOUSE KAZAKHSTAN MILL OF SEAMLESS STEEL PIPES KSP STEEL", mainPage.getheader());
    }

    @Test
    public void getheadertextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("ТОРГОВЫЙ ДОМ КАЗАХСТАНСКОГО ЗАВОДА ПО ПРОИЗВОДСТВУ\n" +
                "СТАЛЬНЫХ БЕСШОВНЫХ ТРУБ KSP STEEL", mainPage.getheader());
    }

    @Test
    public void getbuttonsnameEn(){
        mainPage.chooselang("En");
        Assert.assertEquals(Arrays.asList("About Us", "Products", "Services", "Production", "Press Center", "Our Partners", "Contacts"), mainPage.checklanguage());
    }

    @Test
    public void getbuttonsnameRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals(Arrays.asList("О компании", "Продукция", "Услуги", "Производство", "Пресс-центр", "Партнеры", "Контакты"), mainPage.checklanguage());
    }

    @Test
    public void clicklink(){
        Assert.assertEquals("https://www.instagram.com/td_kspsteel/", mainPage.clicklink("instagram"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

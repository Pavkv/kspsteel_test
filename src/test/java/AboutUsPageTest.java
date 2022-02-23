import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class AboutUsPageTest {
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
        Assert.assertEquals("ABOUT THE COMPANY", mainPage.clickaboutus("en").headertext());
    }

    @Test
    public void getheadertextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("О КОМПАНИИ", mainPage.clickaboutus("ru").headertext());
    }

    @Test
    public void getcertificateEn(){
        mainPage.chooselang("En");
        Assert.assertEquals("CERTIFICATES AND LICENSES", mainPage.clickaboutus("en").headersertificatestext());
    }

    @Test
    public void getcertificateRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("СЕРТИФИКАТЫ И ЛИЦЕНЗИИ", mainPage.clickaboutus("ru").headersertificatestext());
    }

    @Test
    public void getactivesertificate(){
        Assert.assertEquals("30", mainPage.clickaboutus("ru").getactivesertificate(2, 1));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

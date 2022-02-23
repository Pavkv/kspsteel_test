import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ContactsPageTest {
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
        Assert.assertEquals("CONTACT INFORMATION", mainPage.clickcontacts("en").headertext());
    }

    @Test
    public void getheadertextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("КОНТАКТНАЯ ИНФОРМАЦИЯ", mainPage.clickcontacts("ru").headertext());
    }

    @Test
    public void getcontactsEn(){
        mainPage.chooselang("En");
        Assert.assertEquals("+7 (495) 228-48-01\n" +
                "E-mail: info@td-kspsteel.ru\n" +
                "Address: 6 Novodanilovskaya Naberezhnaya, 117105, Moscow", mainPage.clickcontacts("en").getcontacs());
    }

    @Test
    public void getcontactsRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("+7 (495) 228-48-01\n" +
                "E-mail: info@td-kspsteel.ru\n" +
                "Адрес: 117105, г. Москва, Новоданиловская набережная, д. 6", mainPage.clickcontacts("ru").getcontacs());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

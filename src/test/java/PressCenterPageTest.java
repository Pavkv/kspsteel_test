import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class PressCenterPageTest {
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
        Assert.assertEquals("PRESS CENTER", mainPage.clickpresscenter("en").headertext());
    }

    @Test
    public void getheadertextRu(){
        mainPage.chooselang("Ru");
        Assert.assertEquals("ПРЕСС-ЦЕНТР", mainPage.clickpresscenter("ru").headertext());
    }

    @Test
    public void getnews(){
        mainPage.chooselang("En");
        Assert.assertEquals(Arrays.asList(Collections.singletonList("2020"), Collections.singletonList("Beautiful women!"),
                Collections.singletonList("March 7, 2020"), Collections.singletonList("Please accept our congratulations on International Women`s day!\n" +
                "\n" +
                "Your successes in professional activity and social life worth of respect, but for us the main thing is still your charm and femininity, the talent to fill any business with optimism.\n" +
                "\n" +
                "Let the coming spring be a time of change for the better for you.\n" +
                "\n" +
                "We wish you health and well-being! Be happy and loved!\n" +
                "\n" +
                "Sincerely yours,\n" +
                "The team of Trading House KSP Steel")), mainPage.clickpresscenter("en").news("2020", 1));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

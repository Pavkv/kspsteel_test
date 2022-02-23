import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MainPage {

    protected WebDriver driver;
    protected Actions action;

    public MainPage(WebDriver driver, Actions action){
        this.driver = driver;
        this.action = action;
    }

    //top buttons
    protected By kspsteel = By.xpath("//img[@alt='Company']/parent::a");
    private String aboutus = "//ul[contains(@class, 't228__list')]/li[1]/a[@href='";
    protected By products = By.xpath("//ul[contains(@class, 't228__list')]/li[2]");
    private String services = "//ul[contains(@class, 't228__list')]/li[3]/a[@href='";
    private String production = "//ul[contains(@class, 't228__list')]/li[4]/a[@href='";
    private String presscenter = "//ul[contains(@class, 't228__list')]/li[5]/a[@href='";
    private String ourpartners = "//ul[contains(@class, 't228__list')]/li[6]/a[@href='";
    private String contacts = "//ul[contains(@class, 't228__list')]/li[7]/a[@href='";
    protected By facebook = By.xpath("//div[@class='t228__right_social_links_item'][1]//a");
    protected By instagram = By.xpath("//div[@class='t228__right_social_links_item'][2]//a");
    protected By language = By.xpath("//div[@class='t228__right_langs_lang']/a");
    //

    private By header = By.xpath("//div[@field='tn_text_1470209944682']");

    public MainPage returntomain(){
        driver.findElement(kspsteel).click();
        return new MainPage(driver, action);
    }

    public AboutUsPage clickaboutus(String lang){
        if (Objects.equals(lang, "en")){
            driver.findElement(By.xpath(aboutus + "/" + lang + "/about/']")).click();
        } else {
            driver.findElement(By.xpath(aboutus + "/about/']")).click();
        }
        return new AboutUsPage(driver, action);
    }

    public ProductsPage clickproducts(int num, String lang){
        if (Objects.equals(lang, "en")){
            action.moveToElement(driver.findElement(By.xpath("(//ul[contains(@class, 't228__list')]/li[2])[2]")));
            action.moveToElement(driver.findElement(By.xpath("//a[contains(@class, 't-name_xs') and @href='/" + lang + "/product/" + num + "/']")));
        } else {
            action.moveToElement(driver.findElement(By.xpath("(//ul[contains(@class, 't228__list')]/li[2])[1]")));
            action.moveToElement(driver.findElement(By.xpath("//a[contains(@class, 't-name_xs') and @href='/product/" + num + "/']")));
        }
        action.click().build().perform();
        return new ProductsPage(driver, action);
    }

    public ServicesPage clickservices(String lang){
        if (Objects.equals(lang, "en")){
            driver.findElement(By.xpath(services + "/" + lang + "/services/']")).click();
        } else {
            driver.findElement(By.xpath(services + "/services/']")).click();
        }
        return new ServicesPage(driver, action);
    }

    public ProductionPage clickproduction(String lang){
        if (Objects.equals(lang, "en")){
            driver.findElement(By.xpath(production + "/" + lang + "/production/']")).click();
        } else {
            driver.findElement(By.xpath(production + "/production/']")).click();
        }
        return new ProductionPage(driver, action);
    }

    public PressCenterPage clickpresscenter(String lang){
        if (Objects.equals(lang, "en")){
            driver.findElement(By.xpath(presscenter + "/" + lang + "/press/']")).click();
        } else {
            driver.findElement(By.xpath(presscenter + "/press/']")).click();
        }
        return new PressCenterPage(driver, action);
    }

    public OurPartnersPage clickourpartners(String lang){
        if (Objects.equals(lang, "en")){
            driver.findElement(By.xpath(ourpartners + "/" + lang + "/partners/']")).click();
        } else {
            driver.findElement(By.xpath(ourpartners + "/partners/']")).click();
        }
        return new OurPartnersPage(driver, action);
    }

    public ContactsPage clickcontacts(String lang){
        if (Objects.equals(lang, "en")){
            driver.findElement(By.xpath(contacts + "/" + lang + "/contacts/']")).click();
        } else {
            driver.findElement(By.xpath(contacts + "/contacts/']")).click();
        }
        return new ContactsPage(driver, action);
    }

    public String getheader(){
        return driver.findElement(By.xpath("//div[@field='tn_text_1470209944682']")).getText() + " " +
        driver.findElement(By.xpath("//div[@field='tn_text_1470233923389']")).getText() + " " +
        driver.findElement(By.xpath("//div[@field='tn_text_1566912983197']")).getText();
    }

    public String clicklink(String name){
        if (Objects.equals(name, "facebook")) {
            driver.findElement(facebook).click();
        } else if (Objects.equals(name, "instagram")) {
            driver.findElement(instagram).click();
        }
        String act = null;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            act = driver.getCurrentUrl();
        }
        return act;
    }

    public List<String> checklanguage(){
        List<String> tbuttons = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            tbuttons.add(driver.findElement(By.xpath("//ul[contains(@class, 't228__list')]/li[" + i + "]/a")).getText());
        }
        return tbuttons;
    }

    public void chooselang(String lang){
        if (Objects.equals(currentlang(), lang)){
            driver.findElement(language).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        }
    }

    private String currentlang(){
        return driver.findElement(language).getText();
    }
}

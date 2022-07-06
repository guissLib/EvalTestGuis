package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import java.io.Console;
import java.security.IdentityScope;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    private WebDriver driver;

    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mercadolibre.com/");
        driver.manage().window().maximize();

        WebElement inputBO = driver.findElement(By.id("BO"));
        inputBO.click();

        WebElement cookie = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
        cookie.click();

        WebElement buscar = driver.findElement(By.name("as_word"));
        buscar.sendKeys("celular Iphone 13");

        WebElement iconoBuscar= driver.findElement(By.className("nav-search-btn"));
        iconoBuscar.click();

        /*-----Verificando 3 producto */

        String prod1="Apple iPhone 13 Pro Max 512gb";
        String prod2="Brand New iPhone 13 Available For Sell  :+1314470545";
        String prod3="iPhone 13 iPhone 13 Pro iPhone 13 Pro Max";


        WebElement producto1= driver.findElement(By.xpath("//*[@id=\"root-app\"]/div/div[2]/section/ol/li[1]/div/div/div[2]/div[1]/a/h2"));
        String x=producto1.getText();
        prod1=x;

        WebElement producto2= driver.findElement(By.xpath("//*[@id=\"root-app\"]/div/div[2]/section/ol/li[2]/div/div/div[2]/div[1]/a/h2"));
        String x2=producto2.getText();
        prod2=x2;

        WebElement producto3= driver.findElement(By.xpath("//*[@id=\"root-app\"]/div/div[2]/section/ol/li[3]/div/div/div[2]/div[1]/a/h2"));
        String x3=producto3.getText();
        prod3=x3;

        driver.quit();

    }
        public static void main(String[] args) throws InterruptedException {
            BaseTest baseTest = new BaseTest();
            baseTest.setUp();
        }
}

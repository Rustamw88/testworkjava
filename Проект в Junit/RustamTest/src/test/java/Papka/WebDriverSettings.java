package Papka;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
    public WebDriver webDriver;
    public WebDriverWait wait;

    @Before
    public void open() {
        // System.setProperty("webdriver.gecko.driver", "C:src/main/resources/drivers1/geckodriver.exe");//
        System.setProperty("webdriver.chrome.driver", "C:src/main/resources/drivers1/chromedriver.exe");
        webDriver = new ChromeDriver();
        // WebDriver webDriver = new FirefoxDriver();//
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.moedelo.org/");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        webDriver.findElement(By.id("login_auth")).click();

        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
    }

    @After
    public void close() {
        webDriver.quit();
    }
}

package gm.taltech.ee.selenium.common;

import gm.taltech.ee.page_object.DynamicControlsPage;
import gm.taltech.ee.page_object.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected DynamicControlsPage dynamicControlsPage;

    @BeforeClass
    public void set_up_driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void close_driver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

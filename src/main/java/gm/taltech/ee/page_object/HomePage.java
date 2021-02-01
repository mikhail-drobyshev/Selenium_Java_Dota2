package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By mainTitle = By.tagName("h1");
    private By statusCodesLink = By.linkText("Status Codes");
    private By dynamicControlsLink = By.linkText("Dynamic Controls");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open(){
        driver.get("https://the-internet.herokuapp.com/");
        return this;
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");
    }

    public DynamicControlsPage goToDynamicControlsPage() {
        driver.findElement(dynamicControlsLink).click();
        return new DynamicControlsPage(driver);
    }
    public StatusCodes goStatusCodesPage() {
        driver.findElement(statusCodesLink).click();
        return new StatusCodes(driver);
    }


}

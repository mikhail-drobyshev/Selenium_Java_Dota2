package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {

    private By mainTitle = By.cssSelector("h4:not(.subheader)");
    private By addRemoveButton =  By.xpath("//button[@onclick='swapCheckbox()']");
    private By enableDisableButton =  By.xpath("//button[@onclick='swapInput()']");
    private By checkBox = By.id("checkbox");
    private By inputBox = By.xpath("//input[@type='text']");

    private WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickAddRemove() {
        driver.findElement(addRemoveButton).click();
    }

    public void clickEnableDisable() {
        driver.findElement(enableDisableButton).click();
    }

    public void waitUntilButtonReady(String buttonText) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(text(),buttonText)]")));
    }

    public void waitUntilDisableButtonReady() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(text(),'Disable')]")));
    }

    public void waitUntilEnableButtonReady() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'][contains(text(),'Enable')]")));
    }

    public boolean isCheckboxVisible() {
        try {
            driver.findElement(checkBox);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isInputEnabled() {
        return driver.findElement(inputBox).isEnabled();
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Dynamic Controls");
    }
}
package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.regex.Pattern;

public class StatusCodes {
    private By mainTitle = By.tagName("h3");
    private By goBackToStatusCodesPage = By.cssSelector("p > a");
    private By link200 = By.linkText("200");
    private By link301 = By.linkText("301");
    private By link404 = By.linkText("404");
    private By link500 = By.linkText("500");
    private By textTag = By.tagName("p");
    private By urlFinder = By.partialLinkText("status_codes");
    private By targetAttribute = By.xpath("//a[@target='_blank'");
    private static final String sampleCode = "200";
    private List<By> statusCodes = Arrays.asList(By.linkText("200"), By.linkText("301"), By.linkText("404"), By.linkText("500"));
    private By buttonHere = By.linkText("here");


    private WebDriver driver;

    public StatusCodes(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Status Codes");
    }

    public String getSampleCode(){
        return sampleCode;
    }

    public void click_link_200(){
        driver.findElement(link200).click();
    }
    public void click_link_301() { driver.findElement(link301).click(); }
    public void click_link_404() { driver.findElement(link404).click(); }
    public void click_link_500() { driver.findElement(link500).click(); }

    public void returnToStatusCodesPage(){
        driver.findElement(goBackToStatusCodesPage).click();
    }

    public List<String> listOfCodes(String text){
        List<WebElement> myList=driver.findElements(By.tagName("ul"));
        List<String> codes = new ArrayList<String>();
        for (WebElement elem:myList
        ) {
            if (elem.getText() != text)
                codes.add(elem.getText());
        }
        return codes;
    }

    public boolean containsCodes(List<String> codes, String text){
        for (String elem:codes
        ) {
            if (text.contains(elem))
                return true;
        }
        return false;
    }

    public String get_current_url(){
        String strUrl = driver.getCurrentUrl();
        return strUrl;
    }

    public boolean checkResponseCode(Integer code) {
        String statusCode = driver.findElement(textTag).getText();
        if (Pattern.compile(String.valueOf(code)).matcher( statusCode ).find()){
            return true;
        }
        return false;
    }


}

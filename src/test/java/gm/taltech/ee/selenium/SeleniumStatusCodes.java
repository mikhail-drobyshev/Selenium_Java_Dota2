package gm.taltech.ee.selenium;

import gm.taltech.ee.page_object.DynamicControlsPage;
import gm.taltech.ee.page_object.StatusCodes;
import gm.taltech.ee.selenium.common.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class SeleniumStatusCodes extends SeleniumTest {

    @BeforeMethod
    public void open_driver() {
        homePage.open();
    }

    @Test
    public void can_go_to_home_page() {
        assertThat(homePage.isAt(), is(true));
    }


    @Test
    public void return_status_code_200() {
        StatusCodes StatusCodesPage = homePage.goStatusCodesPage();
        assertThat(StatusCodesPage.isAt(), is(true));
        List<String> codesList = StatusCodesPage.listOfCodes(StatusCodesPage.getSampleCode());
        StatusCodesPage.click_link_200();
        WebElement statusCode = driver.findElement(By.tagName("p"));

        Assert.assertTrue(statusCode.getText().contains(StatusCodesPage.getSampleCode()));
        Assert.assertFalse(StatusCodesPage.containsCodes(codesList,statusCode.getText()));
    }


    @Test
    public void url_shows_status_codes_200() {
        StatusCodes StatusCodesPage = homePage.goStatusCodesPage();
        assertThat(StatusCodesPage.isAt(), is(true));
        StatusCodesPage.click_link_200();
        assertThat(StatusCodesPage.get_current_url(), is("https://the-internet.herokuapp.com/status_codes/200"));
    }

    @Test
    public void retrun_to_the_main_page() {
        StatusCodes StatusCodesPage = homePage.goStatusCodesPage();
        assertThat(StatusCodesPage.isAt(), is(true));
        StatusCodesPage.click_link_200();
        StatusCodesPage.returnToStatusCodesPage();
        assertThat(StatusCodesPage.get_current_url(), is("https://the-internet.herokuapp.com/status_codes"));
    }

    @Test
    public void should_return_200_status_code() {
        StatusCodes StatusCodesPage = homePage.goStatusCodesPage();
        assertThat(StatusCodesPage.isAt(), is(true));
        StatusCodesPage.click_link_200();
        assertThat(StatusCodesPage.checkResponseCode(200), is(true));
        assertThat(StatusCodesPage.checkResponseCode(301), is(false));
        assertThat(StatusCodesPage.checkResponseCode(404), is(false));
        assertThat(StatusCodesPage.checkResponseCode(500), is(false));
    }

    @Test
    public void should_return_301_status_code() {
        StatusCodes StatusCodesPage = homePage.goStatusCodesPage();
        assertThat(StatusCodesPage.isAt(), is(true));
        StatusCodesPage.click_link_301();
        assertThat(StatusCodesPage.checkResponseCode(301), is(true));
        assertThat(StatusCodesPage.checkResponseCode(200), is(false));
        assertThat(StatusCodesPage.checkResponseCode(404), is(false));
        assertThat(StatusCodesPage.checkResponseCode(500), is(false));
    }

    @Test
    public void should_return_404_status_code() {
        StatusCodes StatusCodesPage = homePage.goStatusCodesPage();
        assertThat(StatusCodesPage.isAt(), is(true));
        StatusCodesPage.click_link_404();
        assertThat(StatusCodesPage.checkResponseCode(404), is(true));
        assertThat(StatusCodesPage.checkResponseCode(301), is(false));
        assertThat(StatusCodesPage.checkResponseCode(200), is(false));
        assertThat(StatusCodesPage.checkResponseCode(500), is(false));
    }

    @Test
    public void should_return_500_status_code() {
        StatusCodes StatusCodesPage = homePage.goStatusCodesPage();
        assertThat(StatusCodesPage.isAt(), is(true));
        StatusCodesPage.click_link_500();
        assertThat(StatusCodesPage.checkResponseCode(500), is(true));
        assertThat(StatusCodesPage.checkResponseCode(301), is(false));
        assertThat(StatusCodesPage.checkResponseCode(404), is(false));
        assertThat(StatusCodesPage.checkResponseCode(200), is(false));
    }



}
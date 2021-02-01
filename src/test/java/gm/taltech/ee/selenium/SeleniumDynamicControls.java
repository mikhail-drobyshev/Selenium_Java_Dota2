package gm.taltech.ee.selenium;

import gm.taltech.ee.page_object.StatusCodes;
import gm.taltech.ee.selenium.common.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumDynamicControls extends SeleniumTest {

    @Test
    public void can_go_to_home_page() {
        homePage.open();
        assertThat(homePage.isAt(), is(true));
    }

    @Test (dependsOnMethods = { "can_go_to_home_page" })
    public void can_go_to_dynamic_controls_page() {
        dynamicControlsPage = homePage.goToDynamicControlsPage();
        assertThat(dynamicControlsPage.isAt(), is(true));
    }

    @Test (priority=1, dependsOnMethods = { "can_go_to_dynamic_controls_page" })
    public void remove_checkbox() {
        assertThat(dynamicControlsPage.isCheckboxVisible(), is(true));
        dynamicControlsPage.clickAddRemove();
        dynamicControlsPage.waitUntilButtonReady("Add");
        assertThat(dynamicControlsPage.isCheckboxVisible(), is(false));
    }

    @Test (dependsOnMethods = { "can_go_to_dynamic_controls_page","remove_checkbox" })
    public void add_checkbox() {
        assertThat(dynamicControlsPage.isCheckboxVisible(), is(false));
        dynamicControlsPage.clickAddRemove();
        dynamicControlsPage.waitUntilButtonReady("Remove");
        assertThat(dynamicControlsPage.isCheckboxVisible(), is(true));
    }


    @Test (priority=2, dependsOnMethods = { "can_go_to_dynamic_controls_page" })
    public void enable_input() {
        assertThat(dynamicControlsPage.isInputEnabled(), is(false));
        dynamicControlsPage.clickEnableDisable();
        dynamicControlsPage.waitUntilDisableButtonReady();
        assertThat(dynamicControlsPage.isInputEnabled(), is(true));
    }

    @Test (dependsOnMethods = { "can_go_to_dynamic_controls_page","enable_input" })
    public void disable_input() {
        assertThat(dynamicControlsPage.isInputEnabled(), is(true));
        dynamicControlsPage.clickEnableDisable();
        dynamicControlsPage.waitUntilEnableButtonReady();
        assertThat(dynamicControlsPage.isInputEnabled(), is(false));
    }

}

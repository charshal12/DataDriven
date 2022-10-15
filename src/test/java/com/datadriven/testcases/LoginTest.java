package com.datadriven.testcases;

import com.datadriven.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginAsManager() throws InterruptedException{
        log.debug("Inside Login Test");

        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))),"Login Not Successful");
        log.debug("Login successfully executed!");
    }
}

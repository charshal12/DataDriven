package com.datadriven.testcases;

import com.datadriven.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

        @Test
        public void loginAsBankManager() throws InterruptedException {
                log.debug("Inside Login Test");
                driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
                //Thread.sleep(3000);
                Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Login Successful");
                log.debug("Login successfully executed!!");
               // Assert.fail("Login Not Successful!!");
                  }
}

package com.datadriven.testcases;

import com.datadriven.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {
    @Test(dataProvider="getData")
    public void addCustomer(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alerttext));
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }

    @DataProvider
    public Object[][] getData(){
        String sheetName = "addCustomer";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);
        Object[][] data = new Object[rows-1][cols];

        for (int rowNum =2; rowNum<=rows; rowNum++){
            for(int colNum=0; colNum<cols; colNum++){
                data[rowNum-2][colNum] = excel.getCellData(sheetName,colNum,rowNum);
            }
        }
        return data;
    }
}

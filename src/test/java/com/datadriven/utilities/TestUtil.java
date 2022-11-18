package com.datadriven.utilities;

import com.datadriven.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Today;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtil extends TestBase {

    public static String scrnShotPath;
    public static String scrnShotName;

    public static void captureScreenshot() throws IOException {
        Date d = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        scrnShotName="SS_"+d.toString().replace(":","_").replace(" ","_")+".jpg";
        FileUtils.copyFile(scrFile,new File(System.getProperty("user.dir")+
               "\\target\\surefire-reports\\html\\"+scrnShotName));
    }

}

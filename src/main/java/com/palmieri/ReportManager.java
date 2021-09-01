package com.palmieri;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.Properties;

public class ReportManager {
    private ExtentTest extentTest;
    private Properties prop;

    public ReportManager(ExtentTest extentTest, Properties prop) {
        this.extentTest = extentTest;
        this.prop = prop;
    }

    public ExtentTest getExtentTest() {
        return extentTest;
    }

    public void setExtentTest(ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public boolean screen() {
        extentTest.log(LogStatus.INFO, "INFO: ", extentTest.addBase64ScreenShot(Screen.getBase64MobileScreenshot()));
        return true;
    }

}

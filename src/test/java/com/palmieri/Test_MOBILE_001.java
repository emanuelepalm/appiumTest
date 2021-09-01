package com.palmieri;

import com.palmieri.ManagementDriver;
import com.palmieri.ReportManager;
import com.palmieri.Screen;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_MOBILE_001 {

    static private ManagementDriver managementDriver = null;
    static private AndroidDriver driver = null;
    static private Properties androidProp = null;
    static private String propname = "android";
    static private ExtentReports extentReports;
    static private ExtentTest extentTest;
    static private ReportManager repo;

    @BeforeAll
    static void beforeAll() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, " emulator-5554 ");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+ File.separator + "src"+ File.separator + "main"+ File.separator + "resources" + File.separator + "app.apk");
        ManagementDriver.startAppium(desiredCapabilities);
        driver = ManagementDriver.getAndroidDriver();
        extentReports = new ExtentReports(System.getProperty("user.dir") + File.separator + "report.html", false);
        extentReports.loadConfig(new File(System.getProperty("user.dir") + File.separator + "report_config.xml"));
    }


    @BeforeEach
    void beforeEach() {
    }

    @Test()
    @DisplayName("Login OK")
    void test_001()  {
        extentTest = extentReports.startTest("TEST");
        repo = new ReportManager(extentTest, null);
        if(repo.screen()) {
            System.out.println("appost");
        } else {
            System.out.println("NONONONO");
        }
    }


    @AfterEach
    void tearDown() {
        extentReports.endTest(extentTest);
    }

    @AfterAll
    static void tearDownAll() {
        managementDriver.stopDriver();
        extentReports.flush();
    }
}

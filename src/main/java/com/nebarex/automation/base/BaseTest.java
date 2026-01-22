package com.nebarex.automation.base;
import com.nebarex.automation.pages.DemoAppPage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"Weblink"})
    @BeforeClass
    public void setUp(String weblink) {
        driver = DriverFactory.createDriver();
        launchUrl(weblink);

    }
    @AfterMethod
    public void addScreenshot(){
        attachScreenshot();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



    public void launchUrl(String FormWeblink)
    {
        driver.get(FormWeblink);
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}

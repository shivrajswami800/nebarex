package com.nebarex.automation.pages;
import org.openqa.selenium.*;
public class TrackingFormPage {
    private WebDriver driver;

    private By submitBtn = By.id("submit");
    private By errorMsg = By.className("error-message");

    public TrackingFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submitEmptyForm() {
        driver.findElement(submitBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}

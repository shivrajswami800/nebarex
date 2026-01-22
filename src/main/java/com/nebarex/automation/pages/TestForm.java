package com.nebarex.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestForm
{
    private WebDriver driver;

    @FindBy(xpath="//input[@id='fullName']")
    private WebElement fullName;
    @FindBy(xpath="//input[@id='email']")
    private WebElement email;
    @FindBy(xpath="//input[@id='age']")
    private WebElement age;
    @FindBy(xpath="//select[@id='country']")
    private WebElement country;
    @FindBy(xpath="//input[@id='phone']")
    private WebElement phoneNumber;
    @FindBy(xpath="//button[@id='btnNext']")
    private WebElement nextButton;
    @FindBy(xpath="//input[@id='terms']")
    WebElement confirmCheck;
    @FindBy(xpath = "//button[@id='btnSubmit']")
    WebElement submitButton;
    @FindBy(xpath="//p[@id='successMessage']")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"page2Error\"]")
    WebElement failMessage;
    @FindBy(xpath = "//*[@id=\"btnReset\"]")
    WebElement startOver;

    public TestForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the elements
        /*driver.get("https://dev.nebarex.com/file/tracking/test-form");*/
    }

    public void enterEmail()
    {
        email.sendKeys("shivraj.swami@gmail.com");
    }
    public void enterAge()
    {
        age.sendKeys("24");
    }
    public void enterFullName()
    {
        fullName.sendKeys("Shivraj Swami");
    }
    public void enterPhoneNumber()
    {
        phoneNumber.sendKeys("8080755423");
    }

    public void selectCountry() throws InterruptedException {
        country.click();
        Thread.sleep(2000);
        Select select = new Select(country);
        select.selectByVisibleText("India");
    }
    public void clickOnNextButton()
    {
        nextButton.click();
    }
    public void clikConfirmCheck()
    {
        confirmCheck.click();
    }
    public void submitButton()
    {
        submitButton.click();
    }
    public String successMessage()
    {
        return successMessage.getText();
    }

    public String failMessage()
    {

        return failMessage.getText();
    }

    public void startOver(){
        startOver.click();
    }

}

package com.nebarex.automation.tests;

import com.nebarex.automation.base.BaseTest;
import com.nebarex.automation.pages.TestForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoFormTest extends BaseTest
{
    @Test
    public void validateUserForm() throws InterruptedException {
        TestForm testForm = new TestForm(driver);
        testForm.enterFullName();
        Thread.sleep(1000);
        testForm.enterEmail();
        Thread.sleep(1000);
        testForm.enterPhoneNumber();
        Thread.sleep(1000);
        testForm.enterAge();
        Thread.sleep(1000);
        testForm.selectCountry();
        testForm.clickOnNextButton();
        Thread.sleep(1000);
        testForm.clikConfirmCheck();
        Thread.sleep(1000);
        testForm.submitButton();
        Thread.sleep(1000);
        Assert.assertEquals(testForm.successMessage().trim(),
                "Your form has been submitted successfully."
                , "Message text not matching");
        testForm.startOver();




    }

    @Test
    public void validateUserFormWithouAcceptingTermsAndCondition() throws InterruptedException {
        TestForm testForm = new TestForm(driver);
        testForm.enterFullName();
        Thread.sleep(1000);
        testForm.enterEmail();
        Thread.sleep(1000);
        testForm.enterPhoneNumber();
        Thread.sleep(1000);
        testForm.enterAge();
        Thread.sleep(1000);
        testForm.selectCountry();
        testForm.clickOnNextButton();
        Thread.sleep(1000);
        testForm.submitButton();
        Thread.sleep(1000);
        Assert.assertEquals(testForm.failMessage().trim(),
                "You must accept Terms and Conditions to submit"
                , "Message text not matching");


    }

}

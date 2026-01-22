package com.nebarex.automation.tests;

import com.nebarex.automation.base.BaseTest;
import com.nebarex.automation.api.TrackingApiClient;
import com.nebarex.automation.pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackingE2ETest extends BaseTest {

    @Test
    @Story("Form Validation")
    @Severity(SeverityLevel.NORMAL)
    public void getListCards() throws InterruptedException {

        DemoAppPage apppage=new DemoAppPage(driver);

        // Assertion
        Assert.assertTrue(apppage.getCardCount()==TrackingApiClient.getCardCountFromApi(),
                "Card count mistmatch");


    }
    @Test
    @Story("Form Validation")
    @Severity(SeverityLevel.NORMAL)
    public void validatePlateNumber() throws InterruptedException {

        DemoAppPage apppage=new DemoAppPage(driver);

        ArrayList<String> appPlateNum = apppage.getPateNumber();
        ArrayList<String> apiPlateNum = TrackingApiClient.getTrackingInfo();
        Collections.sort(appPlateNum);
        Collections.sort(apiPlateNum);

        // Copy lists to avoid modifying originals
        List<String> missingInAPI = new ArrayList<>(appPlateNum);
        missingInAPI.removeAll(apiPlateNum);

        List<String> MissingInAPP = new ArrayList<>(apiPlateNum);
        MissingInAPP.removeAll(appPlateNum);

        // Print mismatches
        if (!missingInAPI.isEmpty()) {
            System.out.println("Missing in API: " + missingInAPI);
        }

        if (!MissingInAPP.isEmpty()) {
            System.out.println("Missing in Web: " + MissingInAPP);
        }

        // Assertion
        Assert.assertTrue(missingInAPI.isEmpty() && MissingInAPP.isEmpty(),
                "Plate numbers mismatch.\nMissing in API: " + missingInAPI +
                        "\nMissing in Web: " + MissingInAPP);


    }

    //Test is validating the List from API with UI(Driver Details)
    @Test
    public void validateDriverLists() throws InterruptedException {

        DemoAppPage apppage=new DemoAppPage(driver);

        ArrayList<String> appDriverName = apppage.getDriverName();
        ArrayList<String> apiDriverName = TrackingApiClient.getDriverNames();
        Collections.sort(appDriverName);
        Collections.sort(apiDriverName);

        System.out.println("----------->"+appDriverName);
        System.out.println("----------->"+apiDriverName);

        // Copy lists to avoid modifying originals
        List<String> missingInAPI = new ArrayList<>(appDriverName);
        missingInAPI.removeAll(apiDriverName);

        List<String> extraInAPI = new ArrayList<>(apiDriverName);
        extraInAPI.removeAll(appDriverName);

        // Print mismatches
        if (!missingInAPI.isEmpty()) {
            System.out.println("Missing in API - But available on APP: " + missingInAPI);
        }

        if (!extraInAPI.isEmpty()) {
            System.out.println("Missing in APP - But in API: " + extraInAPI);
        }

        // Assertion
        Assert.assertTrue(missingInAPI.isEmpty() && extraInAPI.isEmpty(),
                "Driver Names mismatch.\nMissing in API: " + missingInAPI +
                        "\nExtra in API: " + extraInAPI);

    }


    //Test to validate the Latitude list
    @Test
    public void validateLatitudeLists() throws InterruptedException {

        DemoAppPage apppage=new DemoAppPage(driver);

        ArrayList<String> appLatitude = apppage.getLatitude();
        ArrayList<String> apiLatitude = TrackingApiClient.getLatitude();
        Collections.sort(appLatitude);
        Collections.sort(apiLatitude);

        System.out.println("From APP ----------->"+appLatitude);
        System.out.println("From API ----------->"+apiLatitude);

        // Copy lists to avoid modifying originals
        List<String> missingInAPI = new ArrayList<>(appLatitude);
        missingInAPI.removeAll(apiLatitude);

        List<String> extraInAPI = new ArrayList<>(apiLatitude);
        extraInAPI.removeAll(appLatitude);

        // Print mismatches
        if (!missingInAPI.isEmpty()) {
            System.out.println("Missing in API - But available on App: " + missingInAPI);
        }

        if (!extraInAPI.isEmpty()) {
            System.out.println("Missing in APP - But in API: " + extraInAPI);
        }

        // Assertion
        Assert.assertTrue(missingInAPI.isEmpty() && extraInAPI.isEmpty(),
                "Driver Names mismatch.\nMissing in API: " + missingInAPI +
                        "\nMissing in Web: " + extraInAPI);
    }


    //Test to validate the Longitude List
    @Test
    public void validateLongitudeLists() throws InterruptedException {
        DemoAppPage apppage=new DemoAppPage(driver);

        ArrayList<Double> appLongitude = apppage.getLongitude();
        ArrayList<Double> apiLongitude = TrackingApiClient.getLongitude();
        Collections.sort(appLongitude);
        Collections.sort(apiLongitude);

        System.out.println("From APP ----------->"+appLongitude);
        System.out.println("From API ----------->"+apiLongitude);

        // Copy lists to avoid modifying originals
        ArrayList<Double> missingInAPI = new ArrayList<>(appLongitude);
        missingInAPI.removeAll(apiLongitude);

        ArrayList<Double> extraInAPI = new ArrayList<>(apiLongitude);
        extraInAPI.removeAll(appLongitude);

        // Print mismatches
        if (!missingInAPI.isEmpty()) {
            System.out.println("Missing in API - But available on UI: " + missingInAPI);
        }

        if (!extraInAPI.isEmpty()) {
            System.out.println("Missing in UI - But in API: " + extraInAPI);
        }

        // Assertion
        Assert.assertTrue(missingInAPI.isEmpty() && extraInAPI.isEmpty(),
                "Driver Names mismatch.\nMissing in API: " + missingInAPI +
                        "\nMissing in Web: " + extraInAPI);

    }

    //Validate the Location List test
    @Test
    public void validateLocationList() throws InterruptedException {
        DemoAppPage apppage=new DemoAppPage(driver);

        ArrayList<String> appLocation = apppage.getLocations();
        ArrayList<String> apiLocation = TrackingApiClient.getLocation();
        Collections.sort(appLocation);
        Collections.sort(apiLocation);

        // Copy lists to avoid modifying originals
        List<String> missingInAPI = new ArrayList<>(appLocation);
        missingInAPI.removeAll(apiLocation);

        List<String> extraInAPI = new ArrayList<>(apiLocation);
        extraInAPI.removeAll(appLocation);

        // Print mismatches
        if (!missingInAPI.isEmpty()) {
            System.out.println("Missing in API: " + missingInAPI);
        }

        if (!extraInAPI.isEmpty()) {
            System.out.println("Extra in API: " + extraInAPI);
        }

        // Assertion
        Assert.assertTrue(missingInAPI.isEmpty() && extraInAPI.isEmpty(),
                "Location value is mismatch.\nMissing in API: " + missingInAPI +
                        "\nExtra in API: " + extraInAPI);

    }

    //Validate the LastUpdated time Test
    @Test
    public void validateLastUpdatedTimesList() throws InterruptedException {
        DemoAppPage apppage=new DemoAppPage(driver);

        ArrayList<String> appLastUpdated = apppage.getLastUpdated();
        ArrayList<String> apiLastUpdated = TrackingApiClient.getLastUpdatedTimes();
        Collections.sort(appLastUpdated);
        Collections.sort(apiLastUpdated);

        // Copy lists to avoid modifying originals
        List<String> missingInAPI = new ArrayList<>(appLastUpdated);
        missingInAPI.removeAll(apiLastUpdated);

        List<String> extraInAPI = new ArrayList<>(apiLastUpdated);
        extraInAPI.removeAll(appLastUpdated);

        // Print mismatches
        if (!missingInAPI.isEmpty()) {
            System.out.println("Missing in API: " + missingInAPI);
        }

        if (!extraInAPI.isEmpty()) {
            System.out.println("Extra in API: " + extraInAPI);
        }

        // Assertion
        Assert.assertTrue(missingInAPI.isEmpty() && extraInAPI.isEmpty(),
                "Time Stamp mismatch.\nMissing in API: " + missingInAPI +
                        "\nMissing in Web: " + extraInAPI);


    }

/*    @Test
    public void driverListTest() throws InterruptedException {
        DemoAppPage apppage=new DemoAppPage(driver);
        apppage.getDriverName();
    }*/








}

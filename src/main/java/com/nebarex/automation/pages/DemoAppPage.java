package com.nebarex.automation.pages;
import com.nebarex.automation.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoAppPage extends BaseTest {
    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"listContainer\"]/div")
    private List<WebElement> listContainer;
    @FindBy(id ="loadBtn")
    public static WebElement locationTrackingButton;


    ArrayList<String> plateNos = new ArrayList();
    ArrayList<String> driverNames = new ArrayList();
    ArrayList<String> latitudes = new ArrayList();
    ArrayList<Double> longitudes = new ArrayList();
    ArrayList<String> locations = new ArrayList();
    ArrayList<String> lastupdated = new ArrayList();

    public DemoAppPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the elements
    }

    public void clickTrakcer(){
        DemoAppPage.locationTrackingButton.click();
    }
    public int getCardCount() throws InterruptedException {
        clickTrakcer();
        Thread.sleep(2000);
        return listContainer.size();

    }
    public ArrayList<String> getPateNumber() throws InterruptedException {

        Thread.sleep(2000);
        //driver.findElements(By.id(""));
        /*String plateNo = listContainer.get(i).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div/div/div/b"))
                .get(i).getText();
        System.out.println(plateNo);*/

        for(int i =0; i<listContainer.size();i++){

        String plateNumber = listContainer.get(i).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div/div/div/b"))
                .get(i).getText();
            plateNos.add(plateNumber);

        }
        System.out.println(plateNos.size());
        System.out.println("Plate No:" + plateNos);
        return plateNos;

    }

    public ArrayList<String> getDriverName() throws InterruptedException {

        Thread.sleep(2000);
        //driver.findElements(By.id(""));
        /*String plateNo = listContainer.get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div"))
                .get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div/div/div/b")).get(0).getText();
        System.out.println(plateNo);*/
        for(int i =0; i<listContainer.size();i++){

            String plateNo = listContainer.get(i).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div/div/div[2]"))
                    .get(i).getText();
            driverNames.add(plateNo);

        }
        System.out.println(driverNames);
        return driverNames;
    }

    public ArrayList<String> getLatitude() throws InterruptedException {

        Thread.sleep(2000);
        //driver.findElements(By.id(""));
        /*String plateNo = listContainer.get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div"))
                .get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div/div/div/b")).get(0).getText();
        System.out.println(plateNo);*/
        for(int i =0; i<listContainer.size();i++){

            String latitude = listContainer.get(i).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div[2]/div[1]/span[2]"))
                    .get(i).getText();
            latitudes.add(latitude);

        }
        System.out.println(latitudes);
        return latitudes;
    }

    public ArrayList<Double> getLongitude() throws InterruptedException {

        Thread.sleep(2000);
        for(int i =0; i<listContainer.size();i++){

            String longitude = listContainer.get(i).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div[2]/div[2]/span[2]"))
                    .get(i).getText();
            longitudes.add(Double.valueOf(longitude));

        }
        System.out.println(longitudes);
        return longitudes;
    }

    public ArrayList<String> getLocations() throws InterruptedException {

        Thread.sleep(2000);
        //driver.findElements(By.id(""));
        /*String plateNo = listContainer.get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div"))
                .get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div/div/div/b")).get(0).getText();
        System.out.println(plateNo);*/
        for(int i =0; i<listContainer.size();i++){

            String location = listContainer.get(i).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div[2]/div[3]/span[2]"))
                    .get(i).getText();
            locations.add(String.valueOf(location));

        }
        System.out.println(locations);
        return locations;
    }

    public ArrayList<String> getLastUpdated() throws InterruptedException {

        Thread.sleep(2000);
        //driver.findElements(By.id(""));
        /*String plateNo = listContainer.get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div"))
                .get(0).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div/div/div/b")).get(0).getText();
        System.out.println(plateNo);*/
        for(int i =0; i<listContainer.size();i++){

            String lastupdate = listContainer.get(i).findElements(By.xpath("//*[@id=\"listContainer\"]/div/div[2]/div[4]/span[2]"))
                    .get(i).getText();
            lastupdated.add(lastupdate.replaceAll("T.*",""));

        }
        System.out.println(lastupdated);
        return lastupdated;
    }

}



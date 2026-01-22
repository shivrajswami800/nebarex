package com.nebarex.automation.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;


import static io.restassured.RestAssured.given;

public class TrackingApiClient {

    //Declaring the collection variables for all the fields
    static ArrayList<String> plateNumbers = new ArrayList<>();
    static ArrayList<String> driverNames = new ArrayList<>();
    static ArrayList<String> latitudes = new ArrayList<>();
    static ArrayList<Double> longitudes = new ArrayList<>();
    static ArrayList<String> locations = new ArrayList<>();
    static ArrayList<String> lastUpdatedTimes = new ArrayList<>();
    static JSONArray jsonArray = new JSONArray();

    //Base Url
    private static final String URL =
            "https://dev.nebarex.com/file/tracking/tracking-info";

    public static int getCardCountFromApi(){
        Response response = RestAssured
                .given()
                .header("x-api-key", "A9fK3P2Qx7MZ8JrC5LwH6BvTnE4DYSd")
                .get(URL);

        System.out.println("The Status Code is->   "+response.getStatusCode());
        System.out.println("The Status Code Line is->"+response.getStatusLine());
        //System.out.println(response.asPrettyString());

        // Convert response to JSONArray
        jsonArray = new JSONArray(response.asString());
        return jsonArray.length();
    }

    //List Which will return all the plate numbers PlateNumbers
    public static ArrayList<String> getTrackingInfo()
    {

        // Loop through each object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject vehicle = jsonArray.getJSONObject(i);
            String plateNo = vehicle.getString("plateNo");
            // Store in variables (lists)
            plateNumbers.add(plateNo);
        }

        return plateNumbers;
    }

    //List will return all the DriverNames
    public static ArrayList<String> getDriverNames()
    {
        Response response = RestAssured
                .given()
                .header("x-api-key", "A9fK3P2Qx7MZ8JrC5LwH6BvTnE4DYSd")
                .get(URL);

        System.out.println("The Status Code is->   "+response.getStatusCode());
        System.out.println("The Status Code Line is->"+response.getStatusLine());

        // Convert response to JSONArray
        JSONArray jsonArray = new JSONArray(response.asString());




        // Loop through each object
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject vehicle = jsonArray.getJSONObject(i);
            String driverName = vehicle.getString("driverName");
            driverNames.add(vehicle.optString("driverName"));


        }


        return driverNames;
    }

    //This will return all the list of Latitude
    public static ArrayList<String> getLatitude()
    {

        // Collections to store data
        // Loop through each object
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject vehicle = jsonArray.getJSONObject(i);
            double lat = vehicle.getDouble("lat");
            // Store in variables (lists)
              latitudes.add(String.valueOf(lat));

        }
        return latitudes;
    }

    //This will return the List of Longitude
    public static ArrayList<Double> getLongitude()
    {

        // Collections to store data
        // Loop through each object
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject vehicle = jsonArray.getJSONObject(i);
            double lng = vehicle.getDouble("lng");
            longitudes.add(lng);
        }
        return longitudes;
    }

    //This will return the List of Longitude
    public static ArrayList<String> getLocation()
    {

        // Loop through each object
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject vehicle = jsonArray.getJSONObject(i);
            String location = vehicle.getString("location");
            locations.add(location);
        }


        return locations;
    }

    //This will return the List of Longitude
    public static ArrayList<String> getLastUpdatedTimes()
    {
        // Collections to store data
        // Loop through each object
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject vehicle = jsonArray.getJSONObject(i);
            String lastUpdated = vehicle.getString("lastUpdated");
            // Store in variables (lists)
            lastUpdatedTimes.add(lastUpdated.replaceAll("T.*",""));

        }


        return (ArrayList<String>) lastUpdatedTimes;
    }



}

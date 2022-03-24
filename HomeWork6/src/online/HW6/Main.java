package online.HW6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private final static String WeatherURL =  "http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021";
    private final static String API_KEY = "?apikey=ТУТ_НУЖНО_ВСТАВИТЬ_КЛЮЧ_API";

    public static void main(String[] args) {

        try {
            URL weatherUrl = new URL(WeatherURL+API_KEY);
            HttpURLConnection urlConnection = (HttpURLConnection) weatherUrl.openConnection();
            if (urlConnection.getResponseCode() == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    StringBuilder responseContent = new StringBuilder();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    System.out.println(responseContent);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

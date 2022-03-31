import com.sun.deploy.util.ArrayUtil;
import netscape.javascript.JSObject;
import javax.json.Json;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static String WeatherURL =  "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212";
    private final static String API_KEY = "?apikey=4uT3CCtP3oRbsLmC8Uvz4WZF5hmcaCun";
    private final static String IS_METRIC = "&metric=true";

    public static void main(String[] args) {
        String forecastJson = load5DayForecastOrNull();

        if (forecastJson != null) {
            StringReader forecastJsonReader = new StringReader(forecastJson);
            JsonReader jsonReader = Json.createReader(forecastJsonReader);
            JSObject weatherResponseJson = jsonReader.readObject();
            WeatherResponse weatherResponse = new WeatherResponse(weatherResponseJson);
            System.out.println(weatherResponse);


            RepositoryService.createTable();

            for (DailyForecast dailyForecast : weatherResponse.getDailyForecasts()) {
                RepositoryService.putWeatherIntoDb(dailyForecast);
            }

            List<DailyForecast> dailyForecasts = RepositoryService.loadDailyForecasts();
            System.out.println(dailyForecasts);
        } else {
            System.out.println("Не удалось прочитать данные с сервера.");
        }
    }

    public static String load5DayForecastOrNull() {
        try {
            URL weatherUrl = new URL(WeatherURL+API_KEY + IS_METRIC);
            HttpURLConnection urlConnection = (HttpURLConnection) weatherUrl.openConnection();
            if (urlConnection.getResponseCode() == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    StringBuilder responseContent = new StringBuilder();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    return responseContent.toString();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}


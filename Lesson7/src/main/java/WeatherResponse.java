import netscape.javascript.JSObject;
import  java.util.Arrays;
import javax.json.JsonArray;


public class WeatherResponse {
    private final Weather_for_the_Week[] weather_for_the_week;

    public WeatherResponse (JSObject jsonObject) {
        JsonArray jsonWeather_for_the_WeekArray;
        jsonWeather_for_the_WeekArray = jsonObject.getJsonArray("Weather_for_the_Week");
        weather_for_the_week = new Weather_for_the_Week [jsonWeather_for_the_WeekArray.size()];
        for (int forecast = 0; forecast < weather_for_the_week.length; forecast++) {
            JSObject jsonForecast = jsonWeather_for_the_WeekArray.getJSObject (forecast);
            Weather_for_the_Week weather_for_the_weeks = new Weather_for_the_Week(jsonForecast);
            weather_for_the_week[forecast] = weather_for_the_weeks;
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Погода на 5 дней в СПБ: \n");
        for (Weather_for_the_Week weather_for_the_week : weather_for_the_week) {
            stringBuilder.append(weather_for_the_week.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}

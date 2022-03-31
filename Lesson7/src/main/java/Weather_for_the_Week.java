import netscape.javascript.JSObject;

public class Weather_for_the_Week {
    private final String date;
    private final double minimumTemperature;
    private final double maximumTemperature;
    private final String dayTextDescription;
    private final String nightTextDescription;

    public Weather_for_the_Week(JSObject jsonObject) {
        date = jsonObject.getString("Date");

        minimumTemperature = jsonObject
                .getJSObject("Temperature")
                .getJSObject("Minimum")
                .getJSObject("Value")
                .doubleValeu();
        maximumTemperature = jsonObject
                .getJSObject("Temperature")
                .getJSObject("Maximum")
                .getJSObject("Value")
                .doubleValeu();

        dayTextDescription = jsonObject
                .getJObject("Day")
                .getSrting("IconPhrase");
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("В городе СПБ");
        stringBuilder.append("на дату " + date + "\n");
        stringBuilder.append("ОЖИДАЕТСЯ: \n");
        stringBuilder.append("днём: " + dayTextDescription + "\n");
        stringBuilder.append("ночью: " + nightTextDescription + "\n");
        stringBuilder.append("ТЕМПЕРАТУРА: \n");
        stringBuilder.append("минимальная: " + minimumTemperature + " C\n");
        stringBuilder.append("максимальная: " + maximumTemperature + " C\n");

        return stringBuilder.toString();
    }
}

package learn.battle.environment;

public enum Weather {

    SUNNY("Sunny", 1),
    RAINING("Raining", 0),
    OVERCAST("Overcast", 2),
    DOWNPOUR("Downpour", 3),
    HAILING("Hailing", 4),
    SNOWING("Snowing", 5);


    private int weatherNum;
    private String weatherType;

    Weather(String weatherType, int weatherNum){
        this.weatherNum = weatherNum;
    }

    public int getWeatherNum() {
        return weatherNum;
    }

    public void setWeatherNum(int weatherNum) {
        this.weatherNum = weatherNum;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public static Weather weatherNumToType(int weatherNum){
        switch(weatherNum){
            case 0:
                return Weather.RAINING;
            case 1:
                return Weather.SUNNY;
            case 2:
                return Weather.OVERCAST;
            case 3:
                return Weather.DOWNPOUR;
            case 4:
                return Weather.HAILING;
            case 5:
                return Weather.SNOWING;
            default:
                return null;

        }
    }
}

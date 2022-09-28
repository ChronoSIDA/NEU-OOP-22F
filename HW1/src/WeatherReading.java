public class WeatherReading {

    private int airTempC;
    private int dewPointC;
    private int windSpeed;
    private int totalRain;


    public WeatherReading(int airTempC, int dewPointC, int windSpeed, int totalRain){
        this.airTempC = airTempC;
        this.dewPointC = dewPointC;
        this.windSpeed = windSpeed;
        this.totalRain = totalRain;

        if ( this.dewPointC > this.airTempC || this.windSpeed < 0 || this.totalRain < 0 ){
            throw new IllegalArgumentException("Both totalRain and windSpeed should be non-negative, " +
                    "and the dew points should not higher than temperature!");
        }
    }

    /**
     * Get the temperature
     *
     * @return the temperature
     */

    public int getTemperature(){
        return this.airTempC;
    }

    /**
     * Get the dew point in celsius
     *
     * @return the dew point
     */
    public int getDewPoint(){
//        try {
//            if(this.dewPointC > this.airTempC){
//                throw new IllegalArgumentException("The Dew Point cannot be grater than the temperature");
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println(e);
//        }
        return this.dewPointC;
    }

    /**
     * Get the wind speed
     *
     * @return wind speed
     */
    public int getWindSpeed() {
//        try {
//            if(this.windSpeed < 0){
//                throw new IllegalArgumentException("Given wind Speed is a negative value");
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println(e);
//        }
        return this.windSpeed;
    }

    /**
     * Get the total rain
     *
     * @return the total rain
     */
    public int getTotalRain(){
//        try {
//            if(this.totalRain < 0){
//                throw new IllegalArgumentException("Given total rain is a negative value");
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println(e);
//        }
        return this.totalRain;
    }


    /**
     * Get the humidity
     *
     * @return the humidity
     */
    public int getRelativeHumidity(){
        int humidity;

        // R = 5 * (D - T) + 100

        humidity = 5 * (this.dewPointC - this.airTempC) + 100;
        if (humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException("Humidity should be in range 0 - 100");
        }
        return humidity;
    }

    /**
     * Get the head index
     *
     * @return the head index
     */
    public double getHeatIndex(){
        double heatIndex;
        double c1, c2, c3, c4, c5, c6, c7, c8, c9;
        c1 = -8.78469475556;
        c2 = 1.61139411;
        c3 = 2.33854883889;
        c4 = -0.14611605; c5 = -0.012308094;
        c6 = -0.0164248277778;
        c7 = 0.002211732;
        c8 = 0.00072546;
        c9 = -0.000003582;
        int airTempC = this.getTemperature();
        int humidityPer = this.getRelativeHumidity();
        heatIndex = c1 + (c2 * airTempC) + (c3 * humidityPer)
                + (c4 * airTempC * humidityPer)
                + (c5 * Math.pow(airTempC, 2))
                + (c6 * Math.pow(humidityPer, 2))
                + (c7 * Math.pow(airTempC, 2) * humidityPer)
                + (c8 * airTempC * Math.pow(humidityPer, 2))
                + (c9 * Math.pow(airTempC, 2) * Math.pow(humidityPer, 2));
        return heatIndex;
    }

    /**
     * Get the wind chill
     *
     * @return the wind chill
     */
    public double getWindChill(){
        double windChill;
        double airTempF = 1.8 * this.getTemperature() + 32;
        int windSpeed = this.getWindSpeed();

        windChill = 35.74 + 0.6215 * airTempF - 35.75 * Math.pow(windSpeed, 0.16) +
                0.4275 * airTempF * Math.pow(windSpeed, 0.16);
        return windChill;
    }

    @Override
    public String toString() {
        return  "Reading: T = " + this.getTemperature() +
                ", D = " + this.getDewPoint() +
                ", v = " + this.getWindSpeed() +
                ", rain = " + this.getTotalRain();
    }
}

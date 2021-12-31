package com.itbulls.learnit.javacore.oop.solid.d.solution;

import java.util.Arrays;

public class WeatherAggregator {
    private static WeatherSource[] weatherSources;
 
    public WeatherAggregator(WeatherSource[] weatherSources) {
        this.weatherSources = weatherSources;
    }
 
    public double getTemperature() {
        return Arrays.stream(weatherSources)
            .mapToDouble(WeatherSource::getTemperatureCelcius)
            .average()
            .getAsDouble();
    }

    public static void main (String... args){
        weatherSources = new WeatherSource[]{ new AccuweatherApi(), new BbcWeatherApi()};
        WeatherAggregator aggregator = new WeatherAggregator(weatherSources);
        System.out.println(aggregator.getTemperature());

    }
}

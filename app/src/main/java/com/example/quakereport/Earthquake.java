package com.example.quakereport;

public class Earthquake {
    private double mag;
    private String place;
    private String date;
    private long timeinmilliseconds;
    private String url;

    public Earthquake(double mag, String place, long timeinmilliseconds , String url) {

        this.mag = mag;
        this.place = place;
        this.timeinmilliseconds = timeinmilliseconds;
        this.url = url;
    }


    public double getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }

    public long getTimeinmilliseconds() {
        return timeinmilliseconds;
    }

    public String getUrl() {
        return url;
    }
}

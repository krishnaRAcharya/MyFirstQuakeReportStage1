package com.example.android.quakereport;

public final class customEarthQuake {

    private double magnitude;
    private String name;
    private String number1;
    private String number2;
    private String location1;
    private String location2;
    private  String url;

    public customEarthQuake(double magnitude, String location1,String location2, String number1,String number2,String url) {
        this.magnitude = magnitude;
        this.name = name;
        this.number1=number1;
        this.number2=number2;
        this.location1=location1;
        this.url=url;
        this.location2=location2;
    }

    public double getMagnitude() {
        return magnitude;
    }


    public String getnumber1() {
        return number1;
    }
    public String getnumber2(){
        return  number2;
    }

    public String getLocation1() {
        return location1;
    }

    public String getLocation2() {
        return location2;
    }

    public String getUrl() {
        return url;
    }
}

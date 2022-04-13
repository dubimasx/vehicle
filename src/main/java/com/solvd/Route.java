package com.solvd;

public class Route {
    private Station initialStation;
    private Station finalStation;
    private int distance;




    public Route(Station initialStation, Station finalStation, int distance) {
        this.initialStation = initialStation;
        this.finalStation = finalStation;
        this.distance = distance;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Station getInitialStation() {
        return initialStation;
    }

    public void setInitialStation(Station initialStation) {
        this.initialStation = initialStation;
    }

    public Station getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(Station finalStation) {
        this.finalStation = finalStation;
    }

}
